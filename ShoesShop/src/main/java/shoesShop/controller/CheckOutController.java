package shoesShop.controller;
import java.util.Collection;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import shoesShop.dao.BillDao;
import shoesShop.dao.CartDao;
import shoesShop.dao.ProductDao;
import shoesShop.entities.Bill;
import shoesShop.entities.Bill_Detail;
import shoesShop.entities.Cart;
import shoesShop.entities.Product;
import shoesShop.entities.User;

@Controller
@RequestMapping("/checkout")
public class CheckOutController {
	@Autowired
	private BillDao billDao;
	@Autowired
	private CartDao cartDao;
	@Autowired
	private ProductDao productDao;
	
	@GetMapping("/view")
	public String view(Model model,HttpSession session) {
		model.addAttribute("totalAmount", cartDao.getCount());
		User userInfo = (User)session.getAttribute("user");
		model.addAttribute("bill",new Bill());
		model.addAttribute("userInfo",userInfo);
		if(userInfo == null) {
			return "redirect:/account/view-login";
		}else {
			if(cartDao.getCount()>0) {
				model.addAttribute("userInfo",userInfo);	
				return "user/checkout";
			}else {
				return "redirect:/home";
			}
			
		}
		
	}
	
	@PostMapping("/createBill")
	public String checkout(Model model,HttpSession session,@Validated @ModelAttribute("bill") Bill bill) {	
			
		User userInfo = (User) session.getAttribute("user");
		bill.setTotal_Price(cartDao.totalPrice());
		bill.setCreate_Date(new java.util.Date());
		bill.setRecipientName(bill.getRecipientName());
		bill.setDeliAddress(bill.getDeliAddress());
		bill.setPhone(bill.getPhone());
		bill.setNote(bill.getNote());
		bill.setUser(userInfo);
		bill.setStatus(1);
		billDao.createBill(bill);		
		
		Collection<Cart> cart = cartDao.getAllCart();	
		for(Cart c: cart) {
			Bill_Detail bill_Detail = new Bill_Detail();
			bill_Detail.setProduct(productDao.getProductsById(c.getId_Product()));
			bill_Detail.setAmount(c.getAmount());
			bill_Detail.setSize_Product(null);
			bill_Detail.setSum_Price(c.getPrice()*c.getAmount());
			bill_Detail.setBill(bill);	
			billDao.addBillDetail(bill_Detail);	
			
			Product p = productDao.getProductsById(c.getId_Product());
			if(p.getAmount()>c.getAmount()) {
				p.setAmount(p.getAmount()-c.getAmount());
				productDao.updateProduct(p);
			}else {
				return "redirect:/shopping-cart/view";
			}
			
			
			
			
		}
		
		
		cartDao.ClearCart();
		return "redirect:/account/order-history";
	}
	
	
	
}

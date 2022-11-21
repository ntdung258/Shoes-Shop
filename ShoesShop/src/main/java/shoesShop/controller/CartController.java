package shoesShop.controller;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import shoesShop.dao.CartDao;
import shoesShop.dao.ProductDao;
import shoesShop.entities.Cart;
import shoesShop.entities.Product;

@Controller
@RequestMapping("/shopping-cart")
public class CartController {
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private ProductDao productDao;
	
	@GetMapping("/view")
	public String shoppingCart (Model model) {
		model.addAttribute("cart_Item", cartDao.getAllCart());
		model.addAttribute("totalPrice", cartDao.totalPrice());
		model.addAttribute("totalAmount", cartDao.getCount());
		return "user/shopping-cart";
	}
	
	@GetMapping("/add/{id_Product}")
	public String addCart (@PathVariable Integer id_Product, final HttpServletRequest request) {
		if(productDao.getProductsById(id_Product).getAmount()<=0) {
			return "redirec:/home";
		}else {
			Product product = productDao.getProductsById(id_Product);
			if(product != null) {
				Cart cart = new Cart();
				cart.setId_Product(product.getId());
				cart.setName(product.getName());
				cart.setPrice(product.getPrice());
				cart.setAmount(1);
				cart.setLink(product.getLinkImg());
				cartDao.add(cart);	
			}
			return "redirect:"+request.getHeader("Referer");
		}
			
		
	}
	
	@GetMapping("/clear")
	public String clearCart() {
		cartDao.ClearCart();
		return "redirect:/shopping-cart/view";
	}
	
	@GetMapping("/update/{id_Product}/{amount}")
	public String updateCart(@PathVariable Integer id_Product,@PathVariable Integer amount) {
		cartDao.update(id_Product, amount);
		if(amount<=0) {
			cartDao.delete(id_Product);
		}
		return "redirect:/shopping-cart/view";
	}
	
	
	
	
}

package shoesShop.controller;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import shoesShop.dao.BillDao;
import shoesShop.dao.CartDao;
import shoesShop.dao.UserDao;
import shoesShop.entities.Bill;
import shoesShop.entities.Bill_Detail;
import shoesShop.entities.User;

@Controller
@RequestMapping("/account")
public class AccountController {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private BillDao billDao;
	
	@GetMapping("/view-register")
	public String register (Model model) {
		model.addAttribute("userregister",new User());
		model.addAttribute("totalAmount", cartDao.getCount());
		
		return "user/register";
	}
	
	@GetMapping("/view-login")
	public String loginr (Model model) {
		model.addAttribute("u",new User());
		model.addAttribute("totalAmount", cartDao.getCount());
		
		return "user/login";
	}
	

	@PostMapping("/register")
	public String register (Model model,@Validated @ModelAttribute("userregister") User user,BindingResult result) {
		
		if(result.hasErrors()) {
			return "user/register";
		}
		
		User u = userDao.getUserByUserName(user.getUserName());
		if(u!= null) {
			model.addAttribute("errUserName", "Username already exists");
			return "user/register";
		}else {
			user.setCreate_Date(new java.util.Date());
			user.setStatus(1);
			user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
			boolean bl = userDao.addUser(user);		
			if(bl) {
				model.addAttribute("succsess", "Register succsess !");

				return "user/register";
			}else {
				model.addAttribute("error", "Register failed!");
				model.addAttribute("user", user);
				
				return "user/register";
			}
		}	
		
	}
	
	@PostMapping("/login")
	public String login (Model model,@ModelAttribute("u") User u,HttpSession session) {
		User userLogin = userDao.getUserByUserName(u.getUserName());
		if(userLogin == null) {
			model.addAttribute("errUserName", "User name does not exist");
			return "user/login";
		}else {
			if( BCrypt.checkpw(u.getPassword(),userLogin.getPassword())) {
				session.setAttribute("user",userLogin);
				return "redirect:/home";
				
			}else {
				model.addAttribute("errPassword", "Incorrect password");
				return "user/login";
			}
		}	
		
	}
	
	@GetMapping("/logout")
	public String logout (final HttpServletRequest request,HttpSession session) {
		session.removeAttribute("user");
		return "redirect:"+request.getHeader("Referer");
		
	}
	
	
	@GetMapping("/order-history")
	public String orderHistory (Model model,HttpSession session) {
		User userInfo = (User) session.getAttribute("user");
		List<Bill> listBill = billDao.getIdBill(userInfo.getId());
		model.addAttribute("listBill",listBill);
		return "user/order-history";
		
	}
	
	@GetMapping("/detail/{id}")
	public String detailHistory (Model model,@PathVariable("id") Integer id_bill) {
		List<Bill_Detail> listBD = billDao.getBillDetail(id_bill);
		model.addAttribute("listBD",listBD);
		
		return "user/order-history-detail";
		
	}
}

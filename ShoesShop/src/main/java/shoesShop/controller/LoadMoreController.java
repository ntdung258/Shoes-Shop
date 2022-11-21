package shoesShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import shoesShop.dao.ProductDao;
import shoesShop.entities.Product;

@Controller
@RequestMapping(value =  "/ajax" )
public class LoadMoreController {
	@Autowired
	private ProductDao productDao;
	
	@GetMapping(value =  "/load-more" )
	public String loadMore(Model model) {
		List<Product> products = productDao.getProductsTop4();
		model.addAttribute("products", products);
		
		return "/layouts/user/load-more-product";
	}
}

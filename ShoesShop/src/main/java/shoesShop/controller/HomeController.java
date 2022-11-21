package shoesShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import shoesShop.dao.BannerDao;
import shoesShop.dao.CartDao;
import shoesShop.dao.ProductDao;
import shoesShop.dao.TypeDao;
import shoesShop.entities.Banner;
import shoesShop.entities.Product;
import shoesShop.entities.Type;

@Controller
public class HomeController {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private BannerDao bannerDao;
	@Autowired
	private TypeDao typeDao;
	
	@Autowired
	private CartDao cartDao;
	
	@RequestMapping(value = { "/", "/home" })
	public String home(Model model) {
		List<Product> products = productDao.getProductsTop4();
		model.addAttribute("listProduct", products);
		
		List<Banner> banners = bannerDao.getBanners();
		model.addAttribute("listBanner", banners);
		
		List<Type> types = typeDao.getTypes();
		model.addAttribute("listType", types);
		
		model.addAttribute("totalAmount", cartDao.getCount());
		return "user/index";
	}
}

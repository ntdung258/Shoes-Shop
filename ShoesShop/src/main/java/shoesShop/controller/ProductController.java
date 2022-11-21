package shoesShop.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import shoesShop.dao.BannerDao;
import shoesShop.dao.CartDao;
import shoesShop.dao.ProductDao;
import shoesShop.dao.TypeDao;
import shoesShop.entities.Banner;
import shoesShop.entities.Product;
import shoesShop.entities.Type;

@Controller
@RequestMapping(value =  "/product" )
public class ProductController {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private BannerDao bannerDao;
	@Autowired
	private TypeDao typeDao;
	
	@Autowired
	private CartDao cartDao;
	
	@GetMapping(value =  "/view-product/{id_Type}" )
	public String home(Model model,@PathVariable Integer id_Type) {
		List<Product> products = productDao.getProductsByType(id_Type);
		model.addAttribute("listProduct", products);
		
		List<Banner> banners = bannerDao.getBanners();
		model.addAttribute("listBanner", banners);
		
		List<Type> types = typeDao.getTypes();
		model.addAttribute("listType", types);
		
		model.addAttribute("totalAmount", cartDao.getCount());
		return "user/product";
	}
	

}

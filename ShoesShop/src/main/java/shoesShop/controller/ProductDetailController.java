package shoesShop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import shoesShop.dao.CartDao;
import shoesShop.dao.ImageDao;
import shoesShop.dao.ProductDao;
import shoesShop.entities.Image_Product_Detail;
import shoesShop.entities.Product;


@Controller
public class ProductDetailController {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ImageDao imageDao;
	
	@Autowired
	private CartDao cartDao;
	
	@RequestMapping(value =  "/product-detail/{id_Product}" )
	public String productDetail(Model model,@PathVariable Integer id_Product) {
		Product product = productDao.getProductsById(id_Product);
		model.addAttribute("product", product);
		
		List<Image_Product_Detail> images = imageDao.getImageByIdProduct(id_Product);
		model.addAttribute("listImages", images);
		
		List<Product> color_Product = productDao.getColorProductsByCode(product.getCode());
		model.addAttribute("listColor", color_Product);
		
		List<Product> productByType = productDao.getProductsByType(product.getType().getId());
		model.addAttribute("listProductByType", productByType);
		
		model.addAttribute("totalAmount", cartDao.getCount());
		
		
		return "user/product-detail";
	}
	
	
}

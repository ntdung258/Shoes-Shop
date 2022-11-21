package shoesShop.controller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import shoesShop.dao.ColorDao;
import shoesShop.dao.ProductDao;
import shoesShop.dao.TypeDao;
import shoesShop.entities.Product;


@Controller
@RequestMapping(value = "/admin" )
public class AdminController {
	@Autowired
	private ProductDao productDao;
	@Autowired
	private TypeDao typeDao;
	@Autowired
	private ColorDao colorDao;
	
	@GetMapping(value = {"/view" })
	public String home(Model model) {
		
		return "admin/index";
	}
	
	@GetMapping(value =  "/view-product" )
	public String pageProduct(Model model,@RequestParam(required = false) Map<String,String> param) {
		Integer page = Integer.parseInt(param.getOrDefault("page", "1"));
		List<Product> list = productDao.getProductsByPage(page);
		
		model.addAttribute("listProduct", list);
		model.addAttribute("count", productDao.countProduct());
		return "admin/product/viewProduct";
	}
	
	@GetMapping(value =  "/view-add-product" )
	public String viewAddProduct(Model model) {
		model.addAttribute("pro", new Product());
		model.addAttribute("listType",typeDao.getTypes() );
		model.addAttribute("listColor",colorDao.getColorsProduct() );
		
		return "admin/product/insertProduct";
	}
	
	@PostMapping(value =  "/add-product" )
	public String addProduct(Model model,@Validated @ModelAttribute("pro") Product product,BindingResult result, 
			HttpServletRequest request,
			@RequestParam("imageSource")MultipartFile imgData,
			@RequestParam Integer type,
			@RequestParam Integer color_Product) {
//		if(result.hasErrors()) {	
//			model.addAttribute("listType",typeDao.getTypes() );
//			model.addAttribute("listColor",colorDao.getColorsProduct());
//			return "admin/product/insertProduct";
//		}
		
		
		
		
		
		Product p = new Product();
		p.setName(product.getName());
		p.setCode(product.getCode());
		p.setPrice(product.getPrice());
		p.setAmount(product.getAmount());
		p.setCreate_Date(new java.util.Date());
		p.setType(typeDao.getTypeById(type));
		p.setColor_Product(colorDao.getColorProductById(color_Product));
		p.setIsDelete(true);
		
		String path = request.getServletContext().getRealPath("/assets/images/product/");
		File f = new File(path);
		
		File destination = new File(f.getAbsolutePath()+"/"+imgData.getOriginalFilename());
		if(!destination.exists()) {
			try {
				Files.write(destination.toPath(), imgData.getBytes(), StandardOpenOption.CREATE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		p.setLinkImg(imgData.getOriginalFilename());
		
		boolean bl = productDao.addNewProduct(p);
		if(bl) {
			return "redirect:/admin/view-product";
		}else {
			model.addAttribute("error", "Add failed!");
			model.addAttribute("product", product);
			return "admin/product/insertProduct";
		}

	}
	
	
	@GetMapping(value =  "/delete-product/{id}" )
	public String deleteProduct(Model model,@PathVariable("id") Integer id) {
		Product p = productDao.getProductsById(id);
		p.setIsDelete(false);
		boolean bl = productDao.updateProduct(p);
		if(bl) {
			return "redirect:/admin/view-product";
		}else {
			model.addAttribute("error", "Delete failed!");
			return "redirect:/admin/view-product";
		}

	}
	
	@GetMapping(value =  "/view-update-product/{id}" )
	public String viewUpdateProduct(Model model,@PathVariable("id") Integer id) {
		model.addAttribute("product", productDao.getProductsById(id));
		model.addAttribute("listType",typeDao.getTypes() );
		model.addAttribute("listColor",colorDao.getColorsProduct() );
		return "admin/product/updateProduct";
	}
	
	@PostMapping(value =  "/update-product" )
	public String updateProduct(Model model,@Validated @ModelAttribute("product") Product product,BindingResult result, 
			HttpServletRequest request,
			@RequestParam("imageSource")MultipartFile imgData,
			@RequestParam Integer type,
			@RequestParam Integer color_Product) {
		
		Product p = new Product();
		p.setId(product.getId());
		p.setName(product.getName());
		p.setCode(product.getCode());
		p.setPrice(product.getPrice());
		p.setAmount(product.getAmount());
		p.setCreate_Date(new java.util.Date());
		p.setType(typeDao.getTypeById(type));
		p.setColor_Product(colorDao.getColorProductById(color_Product));
		p.setIsDelete(true);
		
		String path = request.getServletContext().getRealPath("/assets/images/product/");
		File f = new File(path);
		
		File destination = new File(f.getAbsolutePath()+"/"+imgData.getOriginalFilename());
		if(!destination.exists()) {
			try {
				Files.write(destination.toPath(), imgData.getBytes(), StandardOpenOption.CREATE);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		p.setLinkImg(imgData.getOriginalFilename());
		
		boolean bl = productDao.updateProduct(p);
		if(bl) {
			return "redirect:/admin/view-product";
		}else {
			model.addAttribute("error", "Update failed!");
			model.addAttribute("product", product);
			return "admin/product/updateProduct";
		}

	}
}

package shoesShop.dao;
import java.util.List;
import shoesShop.entities.Product;

public interface ProductDao {
	public List<Product> getProducts();
	public List<Product> getProductsByType(Integer id_Type);
	public Product getProductsById(Integer id_Product);
	public List<Product> getColorProductsByCode(String code);
	
	
	public List<Product> getProductsByPage(Integer page);
	public Integer countProduct();
	
	public boolean addNewProduct(Product product);
	public boolean updateProduct(Product product);
	
	public List<Product> getProductsTop4();
	
}

package shoesShop.dao;

import java.util.Collection;
import shoesShop.entities.Cart;

public interface CartDao {
	public void add(Cart item);
	public void delete(Integer id_Product);
	public Cart update (Integer id_Product,Integer amount);
	public void ClearCart();
	public Collection<Cart> getAllCart();
	public int getCount();
	public Double totalPrice();
}

package shoesShop.dao.impl;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Repository;
import shoesShop.dao.CartDao;
import shoesShop.entities.Cart;

@Repository
public class CartDaoImpl implements CartDao{
	Map<Integer,Cart> maps = new HashMap<>();
	
	@Override
	public void add(Cart item) {
		Cart cart = maps.get(item.getId_Product());
		if(cart==null) {
			maps.put(item.getId_Product(), item);
		}else {
			cart.setAmount(cart.getAmount()+1);
		}
	}
	
	@Override
	public void delete(Integer id_Product) {
		maps.remove(id_Product);
	}
	
	@Override
	public Cart update (Integer id_Product,Integer amount) {
		Cart cart = maps.get(id_Product);
		cart.setAmount(amount);
		
		return cart;
	}
	
	@Override
	public void ClearCart() {
		maps.clear();
	}
	
	@Override
	public Collection<Cart> getAllCart(){
		return maps.values();
	}
	
	@Override
	public int getCount() {
		return maps.values().stream().mapToInt(item ->item.getAmount()).sum();
	}
	
	@Override
	public Double totalPrice() {
		return maps.values().stream().mapToDouble(item ->item.getAmount()*item.getPrice()).sum();
	}
		
}

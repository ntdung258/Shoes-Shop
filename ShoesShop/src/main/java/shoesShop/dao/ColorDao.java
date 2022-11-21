package shoesShop.dao;

import java.util.List;

import shoesShop.entities.Color_Product;


public interface ColorDao {
	public List<Color_Product> getColorsProduct();
	public Color_Product getColorProductById(Integer id);
}

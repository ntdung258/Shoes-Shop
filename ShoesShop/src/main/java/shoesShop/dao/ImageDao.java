package shoesShop.dao;

import java.util.List;

import shoesShop.entities.Image_Product_Detail;

public interface ImageDao {
	public List<Image_Product_Detail> getImageByIdProduct(Integer id_Product);
}

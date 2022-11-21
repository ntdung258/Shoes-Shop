package shoesShop.dao;

import java.util.List;

import shoesShop.entities.Type;

public interface TypeDao {
	public List<Type> getTypes();
	public Type getTypeById(Integer id);
}

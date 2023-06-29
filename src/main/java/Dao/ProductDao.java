package Dao;

import java.util.List;

import Entity.ProductEntity;

public interface ProductDao {
	
	List<ProductEntity> findAll();
	
	List<ProductEntity> findAllPaging(int pageNumber, int pageSize);
	
	ProductEntity create(ProductEntity entity);
	
	ProductEntity update(ProductEntity entity);
	ProductEntity delete(ProductEntity entity);
	
	ProductEntity findById(int id);
	Long countProduct();
	List<ProductEntity> ramdomProduct();
	List<ProductEntity> searchProduct(String keyword);
}

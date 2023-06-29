package Services;

import java.util.List;

import Entity.ProductEntity;

public interface ProductServices {
	List<ProductEntity> findAll();
	List<ProductEntity> findAllPaging(int pageNumber, int pageSize);
	ProductEntity create(ProductEntity entity);
	ProductEntity update(ProductEntity entity);
	ProductEntity delete(int id);
	Long countProduct();
	ProductEntity findById(int id);
	List<ProductEntity> ramdomProduct();
	List<ProductEntity> searchProduct(String keyword);
}

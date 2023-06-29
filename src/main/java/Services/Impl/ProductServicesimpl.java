package Services.Impl;

import java.util.List;

import Dao.ProductDao;
import Dao.Impl.ProductDaoImpl;
import Entity.ProductEntity;
import Services.ProductServices;

public class ProductServicesimpl implements ProductServices{

	ProductDao dao = new ProductDaoImpl();
	@Override
	public List<ProductEntity> findAll() {
		return dao.findAll();
	}
	@Override
	public ProductEntity create(ProductEntity entity) {
		return dao.create(entity);
	}
	@Override
	public ProductEntity findById(int id) {
		return dao.findById(id);
	}
	@Override
	public ProductEntity update(ProductEntity entity) {
		return dao.update(entity);
	}
	@Override
	public ProductEntity delete(int id) {
		ProductEntity pr = dao.findById(id);
		pr.setIsActive(Boolean.FALSE);
		return pr;
	}
	@Override
	public List<ProductEntity> findAllPaging(int pageNumber, int pageSize) {
		return dao.findAllPaging(pageNumber, pageSize);
	}
	@Override
	public List<ProductEntity> ramdomProduct() {
		return dao.ramdomProduct();
	}
	@Override
	public List<ProductEntity> searchProduct(String keyword) {
		return dao.searchProduct(keyword);
	}
	@Override
	public Long countProduct() {
		return dao.countProduct();
	}

}

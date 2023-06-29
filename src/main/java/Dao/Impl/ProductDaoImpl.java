package Dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Controller.JpaUtil;
import Dao.AbstractDao;
import Dao.ProductDao;
import Entity.ProductEntity;

public class ProductDaoImpl extends AbstractDao<ProductEntity> implements ProductDao{
	EntityManager entity = JpaUtil.getEntityManager();
	@Override
	public List<ProductEntity> findAll() {
		return super.findAll(ProductEntity.class, true);
	}
	
	@Override
	public ProductEntity create(ProductEntity entity) {
		return super.create(entity);
	}

	@Override
	public ProductEntity update(ProductEntity entity) {
		return super.update(entity);
	}
	@Override
	public ProductEntity delete(ProductEntity entity) {
		return super.update(entity);
	}
	@Override
	public ProductEntity findById(int id) {
		return super.findById(ProductEntity.class, id);
	}

	@Override
	public List<ProductEntity> findAllPaging(int pageNumber, int pageSize) {
		return super.findAll(ProductEntity.class, true, pageNumber, pageSize);
	}

	@Override
	public List<ProductEntity> ramdomProduct() {
//		String sql = "SELECT p FROM ProductEntity p ORDER BY RANDOM()";
//		TypedQuery<ProductEntity> query = entity.createQuery(sql, ProductEntity.class);
//		query.setFirstResult(0);
//		query.setMaxResults(3);
//		List<ProductEntity> list = query.getResultList();
		return super.findRamdom(ProductEntity.class, true, 0, 4);
	}

	@Override
	public List<ProductEntity> searchProduct(String keyword) {
		String sql = "SELECT p FROM ProductEntity p WHERE p.title LIKE ?0 AND p.isActive = 1";
		TypedQuery<ProductEntity> query = entity.createQuery(sql,ProductEntity.class);
		query.setParameter(0,"%" + keyword + "%");
		List<ProductEntity> list = query.getResultList();
		return list;
	}

	@Override
	public Long countProduct() {
		String sql = "SELECT COUNT(p) FROM ProductEntity p WHERE p.isActive = 1";
		TypedQuery<Long> query = entity.createQuery(sql,Long.class);
		Long count = query.getSingleResult();
		return count;
	}
}

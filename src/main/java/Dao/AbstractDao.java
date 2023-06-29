package Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Controller.JpaUtil;
import Entity.ProductEntity;

public class AbstractDao<T> {
	 public static final EntityManager entity = JpaUtil.getEntityManager();
	 
	 @SuppressWarnings("deprecation")
	 @Override
	protected void finalize() throws Throwable {
		entity.close();
		super.finalize();
	}
	 
	 public T findById(Class<T> classs, int id) {
		 return entity.find(classs, id);
	 }
	 
	 public List<T> findAll(Class<T> classs, boolean existIsActive){
		 String entityName  = classs.getSimpleName(); // Lấy tên class truyền vào 
		 StringBuilder sql = new StringBuilder();
		 sql.append("SELECT o FROM ").append(entityName).append(" o");
		 if(existIsActive = true) {//Kiểm tra xem Table có isActive hay không
			 sql.append(" ORDER BY isActive DESC");
		 }
		 TypedQuery<T> query = entity.createQuery(sql.toString(),classs);
		 return query.getResultList();
	 }
	 
	 
	 //Phân Trang
	 public List<T> findAll(Class<T> classs, boolean existIsActive, int pageNumber, int pageSize){
		 String entityName  = classs.getSimpleName(); // Lấy tên class truyền vào 
		 StringBuilder sql = new StringBuilder();
		 sql.append("SELECT a FROM ").append(entityName).append(" a");
		 if(existIsActive = true) {//Kiểm tra xem Table có isActive hay không
			 sql.append(" WHERE a.isActive = 1");
		 }
		 TypedQuery<T> query = entity.createQuery(sql.toString(),classs);
		 query.setFirstResult((pageNumber - 1) * pageSize); // Vị  trí đầu tiên của phân trang
		 query.setMaxResults(pageSize); // Số Phân Tử Trong Trang
		 return query.getResultList();
	 }
	 
	 public List<T> findRamdom(Class<T> classs, boolean existIsActive, int pageNumber, int pageSize){
		 String entityName  = classs.getSimpleName(); // Lấy tên class truyền vào 
		 StringBuilder sql = new StringBuilder();
		 sql.append("SELECT a FROM ").append(entityName).append(" a").append(" ORDER BY RANDOM()");
//		 if(existIsActive = true) {//Kiểm tra xem Table có isActive hay không
//			 sql.append(" WHERE isActive = 1");
//		 }
		 TypedQuery<T> query = entity.createQuery(sql.toString(),classs);
		 query.setFirstResult((pageNumber - 1) * pageSize); // Vị  trí đầu tiên của phân trang
		 query.setMaxResults(pageSize); // Số Phân Tử Trong Trang
		 return query.getResultList();
	 }
	 
	 // Tìm 1 Phần Tử
	 
	 public T findOne(Class<T> classs, String sql, Object ... params) {
		 TypedQuery<T> query = entity.createQuery(sql, classs);
		 for(int i = 0; i < params.length; i++) {
			 query.setParameter(i, params[i]);
		 }
		 List<T> result = query.getResultList();
		 //Kiểm tra xem có hay không
		 if(result.isEmpty()) {
			 return null;
		 }
		 //Có sẽ trả về
		 return result.get(0);
 	 }
	 
	 
	 public List<T> findMany(Class<T> classs, String sql, Object ... params) {
		 TypedQuery<T> query = entity.createQuery(sql, classs);
		 for(int i = 0; i < params.length; i++) {
			 query.setParameter(i, params[i]);
		 }
		 return query.getResultList();
 	 }
	 
	 public T create(T entityClass) {
		 	try {
				entity.getTransaction().begin();
				entity.persist(entityClass);
				entity.getTransaction().commit();
				System.out.println("Create Succeed");
				return entityClass;
			} catch (Exception e) {
				entity.getTransaction().rollback();
				System.out.println("Cannot insert entity" + entity.getClass().getSimpleName());
				throw new RuntimeException();
			}
	 }
	 
	 public T update(T entityClass) {
		 	try {
				entity.getTransaction().begin();
				entity.merge(entityClass);
				entity.getTransaction().commit();
				System.out.println("Update Succeed");
				return entityClass;
			} catch (Exception e) {
				entity.getTransaction().rollback();
				System.out.println("Cannot Update entity" + entity.getClass().getSimpleName());
				throw new RuntimeException();
			}
	 }
	 
	 public T delete(T entityClass) {
		 	try {
				entity.getTransaction().begin();
				entity.persist(entityClass);
				entity.getTransaction().commit();
				System.out.println("Delete Succeed");
				return entityClass;
			} catch (Exception e) {
				entity.getTransaction().rollback();
				System.out.println("Cannot Delete entity" + entity.getClass().getSimpleName());
				throw new RuntimeException();
			}
	 }

	 
}

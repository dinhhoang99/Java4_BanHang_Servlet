package Dao.Impl;

import java.util.List;

import javax.persistence.EntityManager;

import Controller.JpaUtil;
import Dao.AbstractDao;
import Dao.UserDao;
import Entity.UserEntity;
import Services.Impl.UserServicesImpl;

public class UserDaoImpl extends AbstractDao<UserEntity> implements UserDao{

	EntityManager em = JpaUtil.getEntityManager();
	@Override
	public List<UserEntity> findAll() {
	    return super.findAll(UserEntity.class, true);
	}

	public static void main(String[] args) {
		UserDaoImpl user = new UserDaoImpl();
		user.findAll().forEach(x -> System.out.println(x));
	}

	@Override
	public UserEntity findById(int id) {
		return super.findById(UserEntity.class, id);
	}

	@Override
	public UserEntity findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity findByUserName(String userName) {
		String sql = "SELECT o FROM UserEntity o WHERE o.username = ?0 AND o.isActive = 1";
		return super.findOne(UserEntity.class, userName);
	}

	@Override
	public UserEntity findByUserNameAndPassword(String userName, String passWord) {
		String sql = "SELECT o FROM UserEntity o WHERE o.username = ?0 AND o.password = ?1 AND o.isActive = 1";
		return super.findOne(UserEntity.class, sql, userName,passWord);
	}

	@Override
	public UserEntity create(UserEntity entity) {
		return super.create(entity);
	}

	@Override
	public UserEntity update(UserEntity entity) {
		return super.update(entity);
	}

	@Override
	public UserEntity delete(UserEntity entity) {
		return super.update(entity);
	}

	@Override
	public UserEntity findByEmailAndPassword(String email, String passWord) {
		String sql = "SELECT o FROM UserEntity o WHERE o.email = ?0 AND o.password = ?1 AND o.isActive = 1";
		return super.findOne(UserEntity.class, sql, email,passWord);
	}

	@Override
	public UserEntity findByUserNameAndEmail(String username, String email) {
		String sql = "SELECT o FROM UserEntity o Where o.username = ?0 OR o.email = ?1 AND o.isActive = 1";
		return super.findOne(UserEntity.class, sql, username,email);
	}
}

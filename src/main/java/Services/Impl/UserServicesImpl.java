package Services.Impl;

import java.util.List;

import Dao.UserDao;
import Dao.Impl.UserDaoImpl;
import Entity.UserEntity;
import Services.UserServices;

public class UserServicesImpl implements UserServices{
	private UserDao dao = new UserDaoImpl();

	@Override
	public List<UserEntity> findAll() {
		return dao.findAll();
	}
	
	public static void main(String[] args) {
		UserServicesImpl user = new UserServicesImpl();
		user.findAll().forEach(x -> System.out.println(x));
	}

	@Override
	public UserEntity findById(int id) {
		return dao.findById(id);
	}

	@Override
	public UserEntity findByEmail(String email) {
		return dao.findByEmail(email);
	}

	@Override
	public UserEntity findByUserName(String userName) {
		return dao.findByUserName(userName);
	}

	@Override
	public UserEntity login(String userName, String passWord) {
		return dao.findByUserNameAndPassword(userName, passWord);
	}

	@Override
	public UserEntity resetPassword(String userName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserEntity create(String fullname,String username, String password, String email) {
		UserEntity user = new UserEntity();
		user.setFullname(fullname);
		user.setUsername(username);
		user.setPassword(password);
		user.setImages("abc/none-avatar");
		user.setEmail(email);
		user.setIsAdmin(Boolean.FALSE);
		user.setIsActive(Boolean.TRUE);
		return dao.create(user);
	}

	@Override
	public UserEntity update(UserEntity entity) {
		return dao.update(entity);
	}

	@Override
	public UserEntity delete(int id) {
		UserEntity user = dao.findById(id);
		user.setIsActive(Boolean.FALSE);
		return dao.update(user);
	}

	@Override
	public UserEntity loginByEmailAndPassword(String email, String passWord) {
		return dao.findByEmailAndPassword(email, passWord);
	}

	@Override
	public UserEntity findByUserNameAndEmail(String username, String email) {
		return dao.findByUserNameAndEmail(username, email);
	}
	
}

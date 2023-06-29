package Controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {
private static EntityManagerFactory factory;
	
	static public EntityManager getEntityManager() {
		
		if(factory==null || !factory.isOpen()) {
			factory = Persistence.createEntityManagerFactory("ASMJava4");
		}
		System.out.println("Connect");
		return factory.createEntityManager();
	}
	
	static public void closeConnect() {
		
		if(factory!=null && factory.isOpen()) {
			factory.close();
		}
	}
	public static void main(String[] args) {
	}
}

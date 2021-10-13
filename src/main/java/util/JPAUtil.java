package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("task-manager-PU");

	public static EntityManager getEntityManager() {
		return managerFactory.createEntityManager();
	}
}

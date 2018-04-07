//Krishna Sindhuri Vemuri G01024066 SWE_645_HW4
//This class has the entity manager and is used to store data

package SWE645_VEMURI_HW4;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class StoreData {

	public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("student");
	EntityManager em;

	public static EntityManager getEntityManager() {
		EntityManager entityManager = emf.createEntityManager();
		return entityManager;
	}

	public StoreData() {
		super();
	}
	public static void surveyData(Student student) {

		EntityManager etm = getEntityManager();
		etm.getTransaction().begin();
		etm.persist(student);
		etm.getTransaction().commit();
		etm.close();

	}

}

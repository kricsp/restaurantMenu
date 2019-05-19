import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class LunchMenu {
	private static final String PERSISTENCE_UNIT_NAME1 = "TestPersistence";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME1);
    EntityManager em = factory.createEntityManager();
	
	public void add(Dish dish) {
		
       
        em.getTransaction().begin();
        em.persist(dish);
        em.getTransaction().commit();
        em.close();
	}
	public void delete(Dish dish) {
		em.getTransaction().begin();
        em.persist(dish);
        em.getTransaction().commit();
        em.close();
	};
	public void voidchangePrice() {};
	public void changeDescription() {};
	public void swapDish() {};
	public List<Dish> getDish() {
		
			em.getTransaction().begin();
	        Query q = em.createQuery("select d from Dish d where d.time='lunch'");
	        List<Dish> dishList = q.getResultList();
	        em.close();
	        return dishList;
	}

}

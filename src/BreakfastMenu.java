import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class BreakfastMenu {
	private static final String PERSISTENCE_UNIT_NAME1 = "TestPersistence";
	private static EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME1);
    EntityManager em = factory.createEntityManager();
	
	public void add(Dish dish) {
		
       
        em.getTransaction().begin();
        em.persist(dish);
        em.getTransaction().commit();
        em.close();
	}
	public Integer delete(Dish dish) {
		int count=0;
		em.getTransaction().begin();
        Query q = em.createQuery("DELETE FROM Dish d where d.name='"+dish.getName()+"' and d.time='"+dish.getTime()+"'");
        count=q.executeUpdate();
        em.getTransaction().commit();
        em.close();
        return count;
	};
	public void voidchangePrice() {};
	public void changeDescription() {};
	public void swapDish() {};
	public List<Dish> getDish() {
		
			em.getTransaction().begin();
	        Query q = em.createQuery("select d from Dish d where d.time='breakfast'");
	        List<Dish> dishList = q.getResultList();
	        em.close();
	        return dishList;
	};
}

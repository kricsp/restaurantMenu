import javax.persistence.*;

public class Test {
    private static final String PERSISTENCE_UNIT_NAME = "TestPersistence";
      private static EntityManagerFactory factory;
      public static void main(String[] args) {
    	//  factory = Persistence.createEntityManagerFactory("TestPersistence");
        factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();
        // read the existing entries and write to console
        //Query q = em.createQuery("select e from Employee e");
        
        
        Dish dish= new Dish();
        dish.setName("Rajma");
        dish.setDescription("Indian Kidney Beans");
        dish.setAddon("Chutney");
        dish.setPrice(50);
        dish.setQuantity("Small, Medium");
        em.getTransaction().begin();
        em.persist(dish);
        em.getTransaction().commit();
        em.close();
      }
      
    }
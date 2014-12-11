package spike;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class HolaJPA {
    public static void main(String[] args) {
        EntityManager em =
                Persistence.createEntityManagerFactory("tictactoe").createEntityManager();
        Entidad e2 = new Entidad(2, "dos", "es un dos");
        // Create
        em.getTransaction().begin();
        em.persist(new Entidad(1, "uno", "es un uno"));
        em.persist(e2);
        em.getTransaction().commit();
        // Read
        System.out.println(em.find(Entidad.class, 1));
        // Update
        em.getTransaction().begin();
        em.merge(new Entidad(1, "uno", "uno cambiado con update"));
        em.getTransaction().commit();
        // Update2
        em.getTransaction().begin();
        e2.setName("Nuevo");
        em.getTransaction().commit();
        // Delete
        em.getTransaction().begin();
        em.remove(e2);
        em.getTransaction().commit();
    }
}
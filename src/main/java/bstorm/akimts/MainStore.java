package bstorm.akimts;

import bstorm.akimts.entity.Store;
import bstorm.akimts.entity.StoreId;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainStore {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("relationJPA");
        EntityManager manager = emf.createEntityManager();

        Store s = manager.find(Store.class, new StoreId("carrefour", "namur"));
        System.out.println(s.getId().getNom());
        System.out.println(s.getId().getAdresse());
        System.out.println(s.getScore());

        manager.close();
        emf.close();
    }
}

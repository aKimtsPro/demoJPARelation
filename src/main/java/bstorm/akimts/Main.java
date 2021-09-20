package bstorm.akimts;

import bstorm.akimts.entity.*;
import org.w3c.dom.ls.LSOutput;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("relationJPA");
        EntityManager manager = emf.createEntityManager();

        manager.getTransaction().begin();

//        Personne p = new Personne(0, "alain", "dubois", LocalDate.now());
//        Voiture v = new Voiture(0, "VrimVroom", "BipBoop", 150, p);
//
//        manager.persist(p);
//        manager.persist(v);

//        Voiture v = manager.find(Voiture.class, 2);
//        System.out.println( v.getProprietaire().getPrenom() + " " + v.getProprietaire().getNom());

//        Personne p = manager.find(Personne.class, 2);
//        Voiture v = new Voiture(0, "VrimVroom", "Blam", 80, p);
//        manager.persist(v);
//
//        p.getPropriete()
//                .forEach((prop) -> System.out.println(prop.getMarque() + " " + prop.getModele()));
//
//        Store s = new Store(new StoreId("carrefour", "namur"), 3);
//        manager.persist(s);

//        Voiture v = new Voiture(0, "VrimVroom", "Blam2", 887, null);
//        List<Voiture> list = List.of(v);
//        Personne p = new Personne(0, "alain", "dubois", LocalDate.now(), list, null);
//        v.setProprietaire(p);
//
//        manager.persist(p);
//        manager.persist(v);

//        Personne p = Personne.builder()
//                .prenom("alain")
//                .nom("dubois")
//                .dateNaiss(LocalDate.now())
//                .build();
//
//        Location l = Location.builder()
//                .adresse("1 rue des locations, 1111 VilleCity")
//                .coutLocation(550)
//                .coutCharge(100)
//                .build();
//
//        manager.persist(p);
//        manager.persist(l);
//
//        l.setLocataires(List.of(p));

        Compte c = Compte.builder()
                .isbn("BE00 0000 0000 0001")
                .nomBanque("BanK")
                .build();

        Personne p = Personne.builder()
                .prenom("aline")
                .nom("dubosquet")
                .dateNaiss(LocalDate.now())
                .build();

        c.setProprietaire(p);

        manager.persist(c);

//        manager.persist(p);

//        p.setCompte(c);
//
//        Compte c = manager.find(Compte.class,"BE00 0000 0000 0001");
//        System.out.println("utilisation du getter");
//        System.out.println(c.getProprietaire().getPrenom());

        manager.getTransaction().commit();

        manager.close();
        emf.close();

    }
}

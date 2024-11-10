package fr.digi.m062024;

import fr.digi.bo.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ParseException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("multi-couches");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        PetStore petstore1 = new PetStore("AnimauxRigolo","JeanMichel");
        Animal animal1 = new Fish(new SimpleDateFormat("yyyyMMdd").parse("20241110"),"Brun",petstore1,FishLivEnv.SEA_WATER);
        Animal animal2 = new Fish(new SimpleDateFormat("yyyyMMdd").parse("20241110"),"Bleu à point rouge",petstore1, FishLivEnv.FRESH_WATER);
        Animal animal3 = new Cat(new SimpleDateFormat("yyyyMMdd").parse("20241110"),"Blanc à tête noire",petstore1,"ChipID? Ok");
        PetStore petstore2 = new PetStore("PETSHOP","Marie Curie");
        PetStore petstore3 = new PetStore("HIHIHIJAIPASDIDEE","Hoss Matthieu");
        petstore2.addAnimal(animal2);
        petstore3.addAnimal(animal3);
        petstore3.addAnimal(animal1);

        em.persist(petstore1);
        em.persist(petstore2);
        em.persist(petstore3);

        Adress adresse1 = new Adress("8","Rue de la paix","69000","Lyon");
        Adress adresse2 = new Adress("24","Rue de la liberté","31000","Toulouse");
        Adress adresse3 = new Adress("35","Rue du quai","63000","Clermont-Ferrand");
        petstore1.setAdress(adresse1);
        petstore2.setAdress(adresse2);
        petstore3.setAdress(adresse3);


        Product produit1 = new Product("123456","Produit menager",ProdType.CLEANING,23.54);
        Product produit2 = new Product("456789","Nourriture",ProdType.FOOD,19.69);
        Product produit3 = new Product("147852","Accessoire",ProdType.ACCESSORY,88.59);

        em.persist(adresse1);
        em.persist(adresse2);
        em.persist(adresse3);
        em.persist(produit1);
        em.persist(produit2);
        em.persist(produit3);

        transaction.commit();
        em.close();
        emf.close();

    }
}

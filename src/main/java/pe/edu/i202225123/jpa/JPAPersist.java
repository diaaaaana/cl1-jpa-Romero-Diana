package pe.edu.i202225123.jpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202225123.entidad.City;
import pe.edu.i202225123.entidad.Country;
import pe.edu.i202225123.entidad.Countrylanguage;

import java.util.Arrays;


public class JPAPersist {

    public static void main(String[] args) {

        EntityManagerFactory emf= Persistence.createEntityManagerFactory("examen");
        EntityManager em=emf.createEntityManager();

        try {
            // Crear un país imaginario
            Country fictionalCountry = new Country();
            fictionalCountry.setCode("IMA");
            fictionalCountry.setName("Imaginaria");
            fictionalCountry.setContinent("Asia");
            fictionalCountry.setRegion("Región Imaginaria");
            fictionalCountry.setPopulation(1_000_000);
            fictionalCountry.setSurfaceArea(50000.0);
            fictionalCountry.setLocalName("Imaginario");
            fictionalCountry.setGovernmentForm("Monarquía");
            fictionalCountry.setIndepYear(null);
            fictionalCountry.setCode2("IM");

            // Crear 3 ciudades para el país
            City city1 = new City();
            city1.setName("Ciudad Ficticia 1");
            city1.setDistrict("Kabol1");
            city1.setPopulation(500_000);
            city1.setCountry(fictionalCountry);

            City city2 = new City();
            city2.setName("Ciudad Ficticia 2");
            city2.setDistrict("Kabol2");
            city2.setPopulation(300_000);
            city2.setCountry(fictionalCountry);

            City city3 = new City();
            city3.setName("Ciudad Ficticia 3");
            city3.setDistrict("Kabol3");
            city3.setPopulation(200_000);
            city3.setCountry(fictionalCountry);

            // Crear 2 lenguajes nativos
            Countrylanguage language1 = new Countrylanguage();
            language1.setLanguage("Ficticio");
            language1.setIsOfficial("T");
            language1.setPercentage(5.5);
            language1.setCountry(fictionalCountry);

            Countrylanguage language2 = new Countrylanguage();
            language2.setLanguage("Ficticioo");
            language2.setIsOfficial("F");
            language2.setPercentage(7.0);
            language2.setCountry(fictionalCountry);

            // Asociar las ciudades y los lenguajes al país
            fictionalCountry.setCitys(Arrays.asList(city1, city2, city3));
            fictionalCountry.setLanguages(Arrays.asList(language1, language2));
            //guarda en pais
            em.getTransaction().begin();
            em.persist(fictionalCountry);
            em.getTransaction().commit();

            System.out.println("País nuevo, ciudades y lenguajes registrados exitosamente.");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }

}

package org.example.repository;

import org.example.model.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    public List<Car> getAll() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("carmanagment-em");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        String query = "select c from Car c";
        List<Car> resultList = entityManager.createQuery(query)
                                     .getResultList();

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return resultList;
    }

    public void insert(Car car) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("carmanagment-em");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(car);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    public Car getById(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("carmanagment-em");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Car car = entityManager.find(Car.class, id);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();

        return car;
    }

    public void update(Car car) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("carmanagment-em");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.merge(car);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }

    public void delete(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("carmanagment-em");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Car car = entityManager.find(Car.class, id);
        entityManager.remove(car);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}

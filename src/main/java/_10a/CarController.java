package _10a;


import _10a.Car_;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Stateless
public class CarController {

    Logger log = LoggerFactory.getLogger(getClass());

    @PersistenceContext
    EntityManager entityManager;


    public List<Car> findAll(){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
        Root<Car> carRoot = criteriaQuery.from(Car.class);
//        entityManager.unwrap(Session.class)
//                .enableFilter("activeCar")
//                .setParameter("available",true);

        return entityManager.createQuery(criteriaQuery.select(carRoot)).getResultList();
    }

    public Car findById(Long id) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Car> criteriaQuery = criteriaBuilder.createQuery(Car.class);
        Root<Car> carRoot = criteriaQuery.from(Car.class);
        return entityManager.createQuery(criteriaQuery.select(carRoot).where(criteriaBuilder.equal(carRoot.get(Car_.carId), id))).getSingleResult();
    }

}

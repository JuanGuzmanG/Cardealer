package jjgg.persistence;

import jjgg.logic.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class AutoController {
    private EntityManagerFactory emf;
    private EntityManager em;

    //----constructor
    public AutoController() {
        emf = Persistence.createEntityManagerFactory("CarControllerPU");
        em = emf.createEntityManager();
    }

    //----create
    public void createcar(Car car){
        try{
            em.getTransaction().begin();
            em.persist(car);
            em.getTransaction().commit();
        } catch(Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    //----delete
    public void deletecar(Car car){
        try{
            em.getTransaction().begin();
            Car c = em.find(Car.class, car.getId());
            if(c != null){
                em.remove(c);
            }
            em.getTransaction().commit();
        } catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    //----updateCar
    public void updatecar(Car car){
        try{
            em.getTransaction().begin();
            em.merge(car);
            em.getTransaction().commit();
        } catch (Exception e){
            if(em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        }
    }

    //----getCarById
    public Car getCarById(Long id){
        return em.find(Car.class,id);
    }

    //----getCarByModel
    public Car getCarbyModel(String model) {
        try {
            Query query = em.createQuery("SELECT c FROM Car c WHERE c.model = :model", Car.class);
            query.setParameter("model", model);
            return (Car) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
            return null; // Devuelve null si no se encuentra un resultado
        }
    }

    //----getallcars
    public List<Car> getAllCars(){
        return getAllCars(true,-1,-1);
    }
    public List<Car> getAllCars(boolean showAll, int min, int max){
        EntityManager em = emf.createEntityManager();
        try{
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Car.class));
            Query q = em.createQuery(cq);
            if(!showAll){
                q.setFirstResult(min);
                q.setMaxResults(max);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }
}

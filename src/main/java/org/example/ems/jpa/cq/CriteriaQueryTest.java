package org.example.ems.jpa.cq;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.example.ems.model.Employee;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CriteriaQueryTest {
    @PersistenceContext
    private EntityManager em;


    public List<Employee> getSimpleQuery(String firstName){
//      builder is to write detail query like equal
        CriteriaBuilder builder = em.getCriteriaBuilder();
//      this is all data have it .
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
//         select * from employee table and root is row column level
        Root<Employee> root = criteria.from(Employee.class);
//        where clause
        Predicate firstNamePred = builder.like(root.get("firstName"), "%" + firstName + "%");
        criteria.where(firstNamePred);
//        last form
        TypedQuery<Employee> query = em.createQuery(criteria);

        return query.getResultList();
    }

    public  List<Employee> getAllEmployee() {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        criteria.select(root);
        TypedQuery<Employee> query = em.createQuery(criteria);
        return query.getResultList();
    }

    public  Employee findById(Long id) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Employee> criteria = builder.createQuery(Employee.class);
        Root<Employee> root = criteria.from(Employee.class);
        criteria.where(builder.equal(root.get("id"), id));
        TypedQuery<Employee> query = em.createQuery(criteria);
        return query.getSingleResult();

    }
}

package com.tpe.repository;

import com.tpe.domain.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.Access;
import java.util.List;
import java.util.Optional;

//@Component
@Repository
public class StudentRepositoryImpl implements StudentRepository{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> getAll() {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        List<Student> listOfStudents = session.createQuery("FROM Student", Student.class).getResultList();

        tx.commit();
        session.close();
        return listOfStudents;
    }

    @Override
    public Optional<Student> findById(Long id) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.get(Student.class, id);

        Optional<Student> opt =null;
        opt = Optional.ofNullable(student); //if id exists in DB, it will return the obj,
        // else it will return empty obj

        tx.commit();
        session.close();
        return opt;
    }

    @Override
    public void save(Student student) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.saveOrUpdate(student); //if obj is already there it will update, else it will create the obj

        tx.commit();
        session.close();
    }

    @Override
    public void update(Student student) {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.update(student);

        tx.commit();
        session.close();
    }

    @Override
    public void delete(Long id) {

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        Student student = session.load(Student.class, id);

        session.delete(student);

        tx.commit();
        session.close();

    }
}

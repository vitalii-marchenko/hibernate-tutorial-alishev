package org.example;

import org.example.model.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        Configuration configuration = new Configuration().addAnnotatedClass(Person.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

//            Person person1 = new Person("Test1", 30);
//            Person person2 = new Person("Test2", 40);
//            Person person3 = new Person("Test3", 50);
//
//            // Save entities
//            session.persist(person1);
//            session.persist(person2);
//            session.persist(person3);
//
//            // Update Entity
//            Person personToUpdate = session.get(Person.class, 2);
//            personToUpdate.setName("New Name");
//
//            // Delete Entity
//            Person personToDelete = session.get(Person.class, 3);
//            session.remove(personToDelete);

            session.createQuery("update Person set name='Test' where age < 30").executeUpdate();
            session.createQuery("delete from Person where age < 30").executeUpdate();

            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}

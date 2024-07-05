package org.example;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;


/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration = new Configuration();
        configuration.configure();
        SessionFactory factory = configuration.buildSessionFactory();
        System.out.println( "Hello World!" );

//      Creating Student
        Student s1 = new Student(1, "Krishna", "Varanasi");

        // create session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(s1);

        Student student = (Student)session.get(Student.class, 1);
        System.out.println(student);
        tx.commit();
        session.close();
        factory.close();
    }
}

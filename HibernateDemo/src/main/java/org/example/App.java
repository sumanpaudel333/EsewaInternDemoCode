package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class App 
{
    public static void main( String[] args ) throws IOException {
        System.out.println( "Hello World!" );
        Configuration configuration=new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory=configuration.buildSessionFactory();
        // creating student object
        Student student=new Student();
        student.setName("suman");
        student.setsId(100);
        student.setAddress("kathmandu");
        System.out.println(student);
        //creating address
        Address address=new Address();
        address.setCity("Kathmandu");
        address.setCurrentDate(new Date());
        address.setStreet("Baneshwor");
        FileInputStream fis=new FileInputStream("C:\\Users\\suman\\eclipse-workspace\\EsewaProject\\HibernateDemo\\src\\main\\resources\\cricket_purities.png");
        byte[] img=new byte[fis.available()];
        address.setImage(img);
        Session session=sessionFactory.openSession();
        Transaction transaction=session.beginTransaction();
        session.save(student);
        session.save(address);
        transaction.commit();
        session.close();
    }
}

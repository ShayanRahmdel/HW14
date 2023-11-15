package org.example.q2;

import org.example.q2.connection.SessionFactoryProvider;
import org.example.q2.entity.Person;
import org.example.q2.entity.Rank;
import org.example.q2.entity.Student;
import org.example.q2.entity.Teacher;
import org.example.q2.util.AppContext;
import org.example.q2.util.Menu;
import org.hibernate.Session;

import java.util.Calendar;
import java.util.Date;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
//        Calendar calendar = Calendar.getInstance();
//
//        // Set the desired date components
//        calendar.set(Calendar.YEAR, 1996);
//        calendar.set(Calendar.MONTH, Calendar.APRIL);  // Note: Months start from 0 (January is 0)
//        calendar.set(Calendar.DAY_OF_MONTH, 10);
//
//
        try {
            session.beginTransaction();
            Menu menu = new Menu();
            menu.mainMenu();
            session.getTransaction().commit();
            session.close();
        }catch (Exception e){
            e.printStackTrace();
            session.getTransaction().rollback();
        }


//        Person person = new Person("ali","mosavi");
//
//        AppContext.getPersonService().update(1L,person);

    }
}
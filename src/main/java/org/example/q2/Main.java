package org.example.q2;

import org.example.q2.connection.SessionFactoryProvider;
import org.hibernate.Session;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();

    }
}
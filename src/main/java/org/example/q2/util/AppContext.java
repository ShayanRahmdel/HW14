package org.example.q2.util;

import org.example.q2.connection.SessionFactoryProvider;
import org.example.q2.repository.PersonRepository;
import org.example.q2.repository.impl.PersonRepositoryImpl;
import org.hibernate.Session;

public class AppContext {
        private static Session SISSION;
        private static final PersonRepository PERSON_REPOSITORY;

    static {
        SISSION = SessionFactoryProvider.getSessionFactory().openSession();
        PERSON_REPOSITORY = new PersonRepositoryImpl(SISSION);
    }
}

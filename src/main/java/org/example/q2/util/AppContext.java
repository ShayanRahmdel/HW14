package org.example.q2.util;

import org.example.q2.connection.SessionFactoryProvider;
import org.example.q2.repository.PersonRepository;
import org.example.q2.repository.impl.PersonRepositoryImpl;
import org.example.q2.service.PersonService;
import org.example.q2.service.impl.PersonServiceImpl;
import org.hibernate.Session;

public class AppContext {
        private static Session SISSION;
        private static final PersonRepository PERSON_REPOSITORY;

        private static final PersonService PERSON_SERVICE;

    static {
        SISSION = SessionFactoryProvider.getSessionFactory().openSession();
        PERSON_REPOSITORY = new PersonRepositoryImpl(SISSION);
        PERSON_SERVICE = new PersonServiceImpl(PERSON_REPOSITORY);
    }

    public static PersonService getPersonService(){
        return PERSON_SERVICE;
    }

}

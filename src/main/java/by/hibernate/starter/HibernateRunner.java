package by.hibernate.starter;

import by.hibernate.starter.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.time.LocalDate;


public class HibernateRunner {
    public static void main(String[] args) {
        Configuration configuration = new Configuration();
        configuration.configure();

        try (SessionFactory sessionFactory = configuration.buildSessionFactory();
             Session session = sessionFactory.openSession();) {
            session.beginTransaction();
            session.save(User.builder()
                    .username("KDA")
                    .firstname("Kuzko")
                    .lastname("Denis")
                    .birthDate(LocalDate.of(2000, 10, 11))
                    .age(24)
                    .build());

            session.getTransaction().commit();
        }

    }
}

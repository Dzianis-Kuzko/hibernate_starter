package by.hibernate.starter;

import by.hibernate.starter.entity.Birthday;
import by.hibernate.starter.entity.Role;
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

            User user = User.builder()
                    .username("KDA2")
                    .firstname("Kuzko")
                    .lastname("Denis")
                    .birthDate(new Birthday(LocalDate.of(2000, 10, 11)))
                    .role(Role.ADMIN)
                    .build();

            session.save(user);

            session.getTransaction().commit();
        }

    }
}

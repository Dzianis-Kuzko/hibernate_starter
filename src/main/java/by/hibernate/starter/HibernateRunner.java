package by.hibernate.starter;

import by.hibernate.starter.entity.Birthday;
import by.hibernate.starter.entity.PersonalInfo;
import by.hibernate.starter.entity.Role;
import by.hibernate.starter.entity.User;
import by.hibernate.starter.util.HibernateUtil;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.time.LocalDate;

@Slf4j
public class HibernateRunner {
    // можно использовать annotation @Slf4j
    //private static final Logger log = LoggerFactory.getLogger(HibernateRunner.class);

    public static void main(String[] args) {

        User user = User.builder()
                .username("KDA2")
                .personalInfo(PersonalInfo.builder()
                        .firstname("Kuzko")
                        .lastname("Denis")
                        .birthDate(new Birthday(LocalDate.of(2000, 10, 11))).
                        build())
                .role(Role.ADMIN)
                .build();

        log.info("User object in transient state: {} ", user);

        try (SessionFactory sessionFactory = HibernateUtil.buildSessionFactory();
             Session session = sessionFactory.openSession();) {
            session.beginTransaction();

            session.save(user);


            session.getTransaction().commit();
        } catch (Exception e) {
            log.error("Exception ", e);
        }

    }
}

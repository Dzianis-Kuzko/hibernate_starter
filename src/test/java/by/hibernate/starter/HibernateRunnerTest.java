package by.hibernate.starter;

import by.hibernate.starter.entity.User;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

class HibernateRunnerTest {

    @Test
    public void testHibernateApi() throws SQLException, IllegalAccessException {
        User user = User.builder()
                .username("KDA1")
                .firstname("Kuzko")
                .lastname("Denis")
                .birthDate(LocalDate.of(2000, 10, 11))
                .age(24)
                .build();
        String sql = """
                insert into
                %s
                (%s)
                values
                (%s)
                """;

        String tableName = Optional.ofNullable(user.getClass().getAnnotation(Table.class))
                .map(table -> table.schema() + "." + table.name())
                .orElse(user.getClass().getName());

        Field[] fields = user.getClass().getDeclaredFields();
        String columNames = Arrays.stream(fields)
                .map(field -> Optional.ofNullable(field.getAnnotation(Column.class))
                        .map(Column::name)
                        .orElse(field.getName())
                ).collect(Collectors.joining(", "));

        String columValues = Arrays.stream(fields)
                .map(field -> "?")
                .collect(Collectors.joining(", "));

        String formattedSql = sql.formatted(tableName, columNames, columValues);
        System.out.println("Generated SQL: " + formattedSql);

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5543/hibernate", "postgres", "postgres");
        PreparedStatement preparedStatement = connection.prepareStatement(sql.formatted(tableName, columNames, columValues));

        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            Object value = fields[i].get(user);
            preparedStatement.setObject(i + 1, value);
            System.out.println("Setting parameter " + (i + 1) + " to value: " + value);

            // preparedStatement.setObject(i + 1, fields[i].get(user));

        }
        System.out.println(preparedStatement);
        preparedStatement.executeUpdate();
        preparedStatement.close();
        connection.close();
    }

}
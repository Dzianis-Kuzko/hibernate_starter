package by.hibernate.starter.record;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class TestBook {
    public static void main(String[] args) {
        Book book = new Book("Core java", 324.32);
        String name = book.name();
        Double price = book.price();
        System.out.println(name + " " + price);

        Field [] fields = book.getClass().getDeclaredFields();
        for(Field f: fields){
            System.out.println(f);
        }
        System.out.println("----------------");
        Method [] methods = book.getClass().getDeclaredMethods();
        for (Method m : methods){
            System.out.println(m);
        }

        System.out.println("----------------");
        System.out.println(Book.class.getName());



    }

}

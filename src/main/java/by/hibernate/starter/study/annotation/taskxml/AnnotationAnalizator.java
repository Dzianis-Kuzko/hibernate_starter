package by.hibernate.starter.study.annotation.taskxml;

import java.lang.reflect.Method;

public class AnnotationAnalizator {
    public void analiz(Class<?> clazz){
        Method[] methods = clazz.getMethods();

        for (Method m : methods){
            if (m.isAnnotationPresent(XMLAttribute.class)){
                XMLAttribute xmlAttribute = m.getAnnotation(XMLAttribute.class);
                System.out.println(xmlAttribute.name());
            }
            if (m.isAnnotationPresent(XMLElement.class)){
                XMLElement xmlElement = m.getAnnotation(XMLElement.class);
                System.out.println(xmlElement.name());
            }
        }
    }
}

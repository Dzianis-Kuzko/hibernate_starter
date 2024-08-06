package by.hibernate.starter.study.annotation.taskxml;

public class Book {
    private String name;
    private String author;

    @XMLElement(name = "book")
    public String getName() {
        return name;
    }

    @XMLElement(name = "book")
    public void setName(String name) {
        this.name = name;
    }

    @XMLAttribute(name = "author")

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static void main(String[] args) {
        AnnotationAnalizator annotationAnalizator = new AnnotationAnalizator() ;
        annotationAnalizator.analiz(Book.class);
    }
}

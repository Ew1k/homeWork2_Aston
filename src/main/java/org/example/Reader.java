package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class Reader {

    public static List<Student> readStudents(String filepath)
        throws IOException {
        List<Student> students = new ArrayList<>();

        for (String line : Files.readAllLines(Path.of(filepath))) {
            String[] studentData = line.split("\\|");
            String studentName = studentData[0];
            List<Book> books = new ArrayList<>();

                for (int i = 1; i < studentData.length; i++){
                    String[] bookData = studentData[i].split(";");

                    Book book = new Book(bookData[0],bookData[1],Integer.parseInt(bookData[2]),Integer.parseInt(bookData[3]));

                    books.add(book);
                }

            students.add(new Student(studentName,books));
        }
        return students;

    }
}


package org.example;

import java.io.IOException;
import java.util.List;
//*import java.util.function.Consumer;
public class Main {

    public static void main(String[] args) throws IOException {

        List<Student> students = Reader.readStudents(
                "src/main/resources/students.txt"
        );

        students.stream()

                .peek(System.out::println)  //Вывод каждого студента и его список книг
                .flatMap(student -> student.getBooks().stream()) // получаем все книги
                .distinct()             // Удаляем повторяющиеся элементы
                .sorted()               //соритруем по убыванию
                .filter(book -> book.getYear() > 2000)   //Отфильтровать книги, оставив только те, которые были выпущены после 2000 года
                .limit(3)           //Ограничить стрим на 3 элементах
                .map(Book::getYear)         //Получить из книг годы выпуска
                .findFirst()


                .ifPresentOrElse(
                        year -> System.out.println(
                                "\nГод выпуска найденной книги: " + year
                        ),
                        () -> System.out.println(
                                "Подходящие книги отсутствуют"
                        )
                );
    }



}

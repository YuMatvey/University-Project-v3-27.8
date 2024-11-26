package org.example;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Пример: список студентов и университетов
        List<Student> students = List.of(
                new Student("Максим Максимов", "Инженерия", 89.5),
                new Student("Джон Смит", "Инженерия", 92.0),
                new Student("Виктория Барсук", "Юриспруденция", 78.3)
        );

        List<University> universities = List.of(
                new University("Московский Политех", "Инженерия"),
                new University("Юринститут САФУ", "Юриспруденция")
        );

        // Генерация статистики
        List<Statistics> statistics = StatisticsUtils.generateStatistics(students, universities);

        // Запись в Excel
        XlsWriter.writeStatisticsToFile(statistics, "statistics.xlsx");
    }
}

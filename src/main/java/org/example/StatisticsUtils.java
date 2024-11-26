package org.example;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class StatisticsUtils {

    public static List<Statistics> generateStatistics(List<Student> students, List<University> universities) {
        // Группировка университетов по профилям
        Map<String, List<University>> universitiesByProfile = universities.stream()
                .collect(Collectors.groupingBy(University::getProfile));

        // Генерация статистики
        return universitiesByProfile.entrySet().stream().map(entry -> {
            String profile = entry.getKey();
            List<University> profileUniversities = entry.getValue();

            List<String> universityNames = profileUniversities.stream()
                    .map(University::getName)
                    .collect(Collectors.toList());

            int universityCount = profileUniversities.size();

            List<Student> profileStudents = students.stream()
                    .filter(s -> profile.equals(s.getProfile()))
                    .collect(Collectors.toList());

            int studentCount = profileStudents.size();

            OptionalDouble averageScore = profileStudents.stream()
                    .mapToDouble(Student::getScore)
                    .average();

            double roundedAverage = averageScore.isPresent() ?
                    BigDecimal.valueOf(averageScore.getAsDouble()).setScale(2, RoundingMode.HALF_UP).doubleValue() :
                    0.0;

            return new Statistics(profile, roundedAverage, studentCount, universityCount, universityNames);
        }).collect(Collectors.toList());
    }
}

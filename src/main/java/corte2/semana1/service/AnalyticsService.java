package corte2.semana1.service;

import corte2.semana1.model.Student;
import corte2.semana1.model.Grade;

import java.util.*;
import java.util.stream.Collectors;

public class AnalyticsService {

    // 0
    public List<Student> getOrangeTeam(List<Student> students) {
        return students.stream()
                .filter(s -> "NARANJA".equalsIgnoreCase(s.getTeam()))
                .toList();
    }

    // 1
    public List<String> getSortedNames(List<Student> students) {
        return students.stream()
                .map(Student::getName)
                .sorted()
                .toList();
    }

    // 2
    public double getGlobalAverage(List<Student> students) {
        return students.stream()
                .flatMap(s -> s.getGrades().stream())
                .mapToDouble(Grade::getScore)
                .average()
                .orElse(0.0);
    }

    // 3
    public Map<String, Double> getAverageBySubject(Student student) {
        return student.getGrades().stream()
                .collect(Collectors.groupingBy(
                        Grade::getSubject,
                        Collectors.averagingDouble(Grade::getScore)
                ));
    }

    // 4
    public Optional<Student> getTopStudent(List<Student> students) {
        return students.stream()
                .max(Comparator.comparingDouble(
                        s -> s.getGrades().stream()
                                .mapToDouble(Grade::getScore)
                                .average()
                                .orElse(0.0)
                ));
    }

    // 5
    public Map<String, Long> getFailedByTeam(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(
                        Student::getTeam,
                        Collectors.flatMapping(
                                s -> s.getGrades().stream(),
                                Collectors.filtering(
                                        g -> !g.isPassed(),
                                        Collectors.counting()
                                )
                        )
                ));
    }

    // 6
    public List<Student> top3ByPassedSubjects(List<Student> students) {
        return students.stream()
                .sorted(Comparator.comparingLong(
                        (Student s) -> s.getGrades().stream()
                                .filter(Grade::isPassed)
                                .count()
                ).reversed())
                .limit(3)
                .toList();
    }

    // 7
    public Map<String, List<Student>> groupByPerformance(List<Student> students) {
        return students.stream()
                .collect(Collectors.groupingBy(s -> {
                    double avg = s.getGrades().stream()
                            .mapToDouble(Grade::getScore)
                            .average()
                            .orElse(0.0);

                    if (avg >= 4.5) return "ALTO RENDIMIENTO";
                    if (avg >= 3.5) return "REGULAR";
                    return "RIESGO";
                }));
    }

    // 8
    public Optional<String> mostFailedSubject(List<Student> students) {
        return students.stream()
                .flatMap(s -> s.getGrades().stream())
                .filter(g -> !g.isPassed())
                .collect(Collectors.groupingBy(
                        Grade::getSubject,
                        Collectors.counting()
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    // 9
    public LinkedHashMap<String, Double> orangeApprovedAvgBySubject(List<Student> students) {
        return students.stream()
                .filter(s -> "NARANJA".equalsIgnoreCase(s.getTeam()))
                .flatMap(s -> s.getGrades().stream())
                .filter(Grade::isPassed)
                .collect(Collectors.groupingBy(
                        Grade::getSubject,
                        Collectors.averagingDouble(Grade::getScore)
                ))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (a, b) -> a,
                        LinkedHashMap::new
                ));
    }
}

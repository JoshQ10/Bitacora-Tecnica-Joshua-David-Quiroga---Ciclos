package corte2.semana1.model;

import java.util.List;

public class Student {
    private String id;
    private String name;
    private String team;
    private List<Grade> grades;

    public Student(String id, String name, String team, List<Grade> grades) {
        this.id = id;
        this.name = name;
        this.team = team;
        this.grades = grades;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getTeam() { return team; }
    public List<Grade> getGrades() { return grades; }
}

package corte2.semana1.model;

import java.time.LocalDate;

public class Grade {
    private String subject;
    private double score;
    private LocalDate date;
    private boolean passed;

    public Grade(String subject, double score, LocalDate date, boolean passed) {
        this.subject = subject;
        this.score = score;
        this.date = date;
        this.passed = passed;
    }

    public String getSubject() { return subject; }
    public double getScore() { return score; }
    public LocalDate getDate() { return date; }
    public boolean isPassed() { return passed; }
}

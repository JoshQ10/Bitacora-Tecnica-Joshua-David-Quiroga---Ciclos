package edu.dosw.bitacora.tecnica.Bitacora_Tecnica.semana1;

import corte2.semana1.model.Student;
import corte2.semana1.model.Grade;
import corte2.semana1.service.AnalyticsService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnalyticsServiceTest {

    AnalyticsService service = new AnalyticsService();

    private List<Student> mockData() {
        return List.of(
                new Student("1", "Juan", "NARANJA", List.of(
                        new Grade("DOSW", 4.5, LocalDate.now(), true),
                        new Grade("BD", 3.0, LocalDate.now(), false)
                )),
                new Student("2", "Ana", "AZUL", List.of(
                        new Grade("DOSW", 5.0, LocalDate.now(), true)
                ))
        );
    }

    @Test
    void testGetOrangeTeam() {
        assertEquals(1, service.getOrangeTeam(mockData()).size());
    }

    @Test
    void testGlobalAverage() {
        assertTrue(service.getGlobalAverage(mockData()) > 0);
    }

    @Test
    void testTopStudent() {
        assertTrue(service.getTopStudent(mockData()).isPresent());
    }

    @Test
    void testMostFailedSubject() {
        assertEquals("BD", service.mostFailedSubject(mockData()).orElse(""));
    }
}

package ec.edu.udla.calidad.estudiantes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class StudentFormatterTest {
    private final StudentFormatter formatter = new StudentFormatter();

    @Test
    void formatsSingleStudent() {
        Student student = new Student("John Doe", 85.5);

        assertEquals("Student: John Doe, Grade: 85.5", formatter.format(student));
    }

    @Test
    void formatsAllStudentsUsingLineSeparator() {
        List<Student> students = List.of(
                new Student("John Doe", 85.5),
                new Student("Jane Doe", 91.0));

        String expected = "Student: John Doe, Grade: 85.5"
                + System.lineSeparator()
                + "Student: Jane Doe, Grade: 91.0";

        assertEquals(expected, formatter.formatAll(students));
    }

    @Test
    void formatsEmptyStudentListAsEmptyText() {
        assertEquals("", formatter.formatAll(List.of()));
    }
}

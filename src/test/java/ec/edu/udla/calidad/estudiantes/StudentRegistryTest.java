package ec.edu.udla.calidad.estudiantes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StudentRegistryTest {
    private StudentRegistry registry;

    @BeforeEach
    void setUp() {
        registry = new StudentRegistry(new StudentValidator());
    }

    @Test
    void registersValidStudent() {
        Student student = registry.registerStudent("Ana Perez", 95.0);

        assertEquals("Ana Perez", student.getName());
        assertEquals(95.0, student.getGrade());
        assertEquals(1, registry.listStudents().size());
    }

    @Test
    void trimsStudentNameBeforeRegistering() {
        Student student = registry.registerStudent("  Maria Lopez  ", 88.5);

        assertEquals("Maria Lopez", student.getName());
    }

    @Test
    void rejectsNullStudentName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> registry.registerStudent(null, 90.0));

        assertEquals("Student name must not be blank.", exception.getMessage());
    }

    @Test
    void rejectsBlankStudentName() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> registry.registerStudent("   ", 90.0));

        assertEquals("Student name must not be blank.", exception.getMessage());
    }

    @Test
    void rejectsGradeBelowMinimum() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> registry.registerStudent("Luis Arias", -1.0));

        assertEquals("Grade must be between 0.0 and 100.0.", exception.getMessage());
    }

    @Test
    void rejectsGradeAboveMaximum() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> registry.registerStudent("Luis Arias", 100.1));

        assertEquals("Grade must be between 0.0 and 100.0.", exception.getMessage());
    }

    @Test
    void allowsBoundaryGrades() {
        registry.registerStudent("Minimum Grade", 0.0);
        registry.registerStudent("Maximum Grade", 100.0);

        assertEquals(2, registry.listStudents().size());
    }

    @Test
    void exposesStudentsAsReadOnlyList() {
        registry.registerStudent("Ana Perez", 95.0);
        List<Student> students = registry.listStudents();

        assertThrows(UnsupportedOperationException.class, () -> students.add(new Student("Other", 70.0)));
        assertEquals(1, registry.listStudents().size());
    }

    @Test
    void startsWithEmptyStudentList() {
        assertTrue(registry.listStudents().isEmpty());
    }
}

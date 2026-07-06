package ec.edu.udla.calidad.estudiantes;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class StudentValidatorTest {
    private final StudentValidator validator = new StudentValidator();

    @Test
    void acceptsValidStudentData() {
        assertDoesNotThrow(() -> validator.validate("Carlos Ruiz", 76.5));
    }

    @Test
    void rejectsEmptyName() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("", 80.0));
    }

    @Test
    void rejectsNegativeGrade() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("Carlos Ruiz", -0.1));
    }

    @Test
    void rejectsGradeGreaterThanOneHundred() {
        assertThrows(IllegalArgumentException.class, () -> validator.validate("Carlos Ruiz", 100.5));
    }
}

package ec.edu.udla.calidad.estudiantes;

public final class StudentValidator {
    public static final double MINIMUM_GRADE = 0.0;
    public static final double MAXIMUM_GRADE = 100.0;

    public void validate(final String studentName, final double grade) {
        validateName(studentName);
        validateGrade(grade);
    }

    private void validateName(final String studentName) {
        if (studentName == null || studentName.isBlank()) {
            throw new IllegalArgumentException("Student name must not be blank.");
        }
    }

    private void validateGrade(final double grade) {
        if (grade < MINIMUM_GRADE || grade > MAXIMUM_GRADE) {
            throw new IllegalArgumentException("Grade must be between 0.0 and 100.0.");
        }
    }
}

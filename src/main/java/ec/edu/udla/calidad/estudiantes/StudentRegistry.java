package ec.edu.udla.calidad.estudiantes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class StudentRegistry {
    private final List<Student> students = new ArrayList<>();
    private final StudentValidator validator;

    public StudentRegistry(final StudentValidator validator) {
        this.validator = validator;
    }

    public Student registerStudent(final String studentName, final double grade) {
        validator.validate(studentName, grade);
        final Student student = new Student(studentName.trim(), grade);
        students.add(student);
        return student;
    }

    public List<Student> listStudents() {
        return Collections.unmodifiableList(students);
    }
}

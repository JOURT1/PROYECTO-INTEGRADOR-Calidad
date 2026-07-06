package ec.edu.udla.calidad.estudiantes;

import java.util.Objects;

public final class Student {
    private final String name;
    private final double grade;

    public Student(final String name, final double grade) {
        this.name = Objects.requireNonNull(name, "name must not be null");
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public double getGrade() {
        return grade;
    }
}

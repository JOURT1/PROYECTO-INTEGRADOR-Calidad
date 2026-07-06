package ec.edu.udla.calidad.estudiantes;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public final class StudentFormatter {
    public String format(final Student student) {
        return String.format(Locale.US, "Student: %s, Grade: %.1f", student.getName(), student.getGrade());
    }

    public String formatAll(final List<Student> students) {
        return students.stream()
                .map(this::format)
                .collect(Collectors.joining(System.lineSeparator()));
    }
}

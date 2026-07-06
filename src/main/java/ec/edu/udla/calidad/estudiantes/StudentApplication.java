package ec.edu.udla.calidad.estudiantes;

public final class StudentApplication {
    private StudentApplication() {
    }

    public static void main(final String[] args) {
        final StudentRegistry registry = new StudentRegistry(new StudentValidator());
        final StudentFormatter formatter = new StudentFormatter();

        registry.registerStudent("John Doe", 85.5);

        System.out.println(formatter.formatAll(registry.listStudents()));
    }
}

package Student;

import java.util.*;

public class FourthExercise {
    Collection<Student> students = Arrays.asList(
            new Student("Дмитрий", 17, Sex.MAN),
            new Student("Максим", 20, Sex.MAN),
            new Student("Екатерина", 20, Sex.WOMAN),
            new Student("Михаил", 28, Sex.MAN)
    );

    public void checkDraftEligibility() {
        List<Student> draftEligibleStudents = new ArrayList<>();
        for (Student student : students) {
            int age = student.getAge();
            if (student.getGender() == Sex.MAN && age >= 18 && age <= 27) {
                draftEligibleStudents.add(student);
            }
        }
        System.out.println("Студенты, подлежащие призыву: " + draftEligibleStudents);
    }

    public void calculateAverageAgeOfMaleStudents() {
        OptionalDouble averageAge = students.stream()
                .filter(student -> student.getGender() == Sex.MAN)
                .mapToInt(Student::getAge)
                .average();
        System.out.println("Средний возраст студентов мужского пола: " + (averageAge.isPresent() ? averageAge.getAsDouble() : 0));
    }

    private enum Sex {
        MAN,
        WOMAN
    }

    private static class Student {
        private final String name;
        private final Integer age;
        private final Sex gender;

        public Student(String name, Integer age, Sex gender) {
            this.name = name;
            this.age = age;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        public Sex getGender() {
            return gender;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, age, gender);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student student = (Student) o;
            return Objects.equals(name, student.name) &&
                    Objects.equals(age, student.age) &&
                    Objects.equals(gender, student.gender);
        }

        @Override
        public String toString() {
            return "{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    ", gender=" + gender +
                    '}';
        }
    }
}

package Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        FourthExercise fourthExercise = new FourthExercise();
        fourthExercise.calculateAverageAgeOfMaleStudents();
        fourthExercise.checkDraftEligibility();
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> logins = new ArrayList<>();


        while (true) {
            System.out.print("Введите логин (или нажмите Enter для завершения): ");
            String login = scanner.nextLine();
            if (login.isEmpty()) {
                break;
            }
            logins.add(login);
        }

        logins.stream()
                .filter(login -> login.startsWith("f"))
                .forEach(System.out::println);
    }

}


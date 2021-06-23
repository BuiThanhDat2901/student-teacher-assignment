package assignment.t2012e.view;

import java.util.Scanner;

public class OptionMenu {
    Scanner scanner = new Scanner(System.in);
    public StudentMenu studentMenu = new StudentMenu();
    public TeacherMenu teacherMenu = new TeacherMenu();

    public void OptionMenu() {
        boolean isHighSchool = true;
        while (isHighSchool) {
        System.out.println("Manager Teacher and Student");
        System.out.println("------------------------------");
        System.out.println("1. Teacher Manager");
        System.out.println("2. Student Manager");
        System.out.println("0. Exit");
        System.out.println("-------------------------------");
        System.out.println("Please choose 0-2:");
            System.out.printf("Your choice is: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    teacherMenu.generateTeacherMenu();
                    break;
                case 2:
                    studentMenu.generateStudentMenu();
                    break;
                case 0:
                    System.out.println("Bye bye!!");
                    isHighSchool = false;
                    break;
                default:
                    System.out.println("Please choose again.");
                    break;

            }
        }
    }
}

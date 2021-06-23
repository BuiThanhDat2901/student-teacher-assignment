package assignment.t2012e.view;

import assignment.t2012e.controller.StudentController;
import java.util.Scanner;

public class StudentMenu {
    private StudentController studentController = new StudentController();
    private Scanner scanner = new Scanner(System.in);

    public void generateStudentMenu() {
        boolean is = true;
        while (is) {
            System.out.printf("Student Manager\n");
            System.out.printf("--------------------\n");
            System.out.printf("1. Create new student.\n");
            System.out.printf("2. Show list student.\n");
            System.out.printf("3. Search student.\n");
            System.out.printf("4. Update student.\n");
            System.out.printf("5. Delete student.\n");
            System.out.printf("0. Exit Program.\n");
            System.out.printf("--------------------\n");
            System.out.printf("Please enter your choice (0-5): \n");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    studentController.create();
                    break;
                case 2:
                    studentController.showList();
                    break;
                case 3:
                    studentController.search();
                    break;
                case 4:
                    studentController.update();
                    break;
                case 5:
                    studentController.delete();
                    break;
                case 0:
                    System.out.printf("Exit program, bye bye!");
                    is = false;
                    break;
                default:
                    System.out.printf("Please choose again");
                    break;
            }
            scanner.nextLine();
        }
    }
}

package assignment.t2012e.view;

import assignment.t2012e.controller.TeacherController;
import java.util.Scanner;

public class TeacherMenu {
    private TeacherController teacherController = new TeacherController();
    private Scanner scanner = new Scanner(System.in);

    public void generateTeacherMenu() {
        boolean is = true;
        while (is) {
            System.out.printf("Teacher Manager\n");
            System.out.printf("--------------------\n");
            System.out.printf("1. Create new Teacher.\n");
            System.out.printf("2. Show list Teacher.\n");
            System.out.printf("3. Search Teacher.\n");
            System.out.printf("4. Update Teacher.\n");
            System.out.printf("5. Delete Teacher.\n");
            System.out.printf("0. Exit Program.\n");
            System.out.printf("--------------------\n");
            System.out.printf("Please enter your choice (0-5): \n");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    teacherController.create();
                    break;
                case 2:
                    teacherController.showList();
                    break;
                case 3:
                    teacherController.search();
                    break;
                case 4:
                    teacherController.update();
                    break;
                case 5:
                    teacherController.delete();
                    break;
                case 0:
                    System.out.println("Good bye!");
                    is = false;
                    break;
                default:
                    System.out.println("Please choose again");
                    break;
            }
            scanner.nextLine();
        }
    }
}
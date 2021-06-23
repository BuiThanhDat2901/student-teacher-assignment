package assignment.t2012e.controller;

import assignment.t2012e.entity.Teacher;
import assignment.t2012e.model.TeacherModel;
import java.util.ArrayList;
import java.util.Scanner;

public class TeacherController {
    public TeacherModel teacherModel = new TeacherModel();
    public Scanner scanner = new Scanner(System.in);

    public void create() {
        Teacher teacher = new Teacher();
        System.out.printf("Please enter teacher id: ");
        String id = scanner.nextLine();
        teacher.setRollNumber(id);

        System.out.printf("Please enter teacher full name: ");
        String fullName = scanner.nextLine();
        teacher.setFullName(fullName);

        System.out.printf("Please enter teacher email: ");
        String email = scanner.nextLine();
        teacher.setEmail(email);

        System.out.printf("Please enter teacher phone: ");
        String phone = scanner.nextLine();
        teacher.setPhone(phone);

        boolean isCreat = teacherModel.save(teacher);
        if (isCreat) {
            System.out.println("Success!");
        } else {
            System.out.println("False!");
        }
    }

    public void showList() {
        ArrayList<Teacher> list = teacherModel.findAll();
        System.out.printf("%10s%10s%10s | %10s%15s%10s | %5s%20s%5s | %5s%10s%5s |",
                "", "id", "",
                "", "FullName", "",
                "", "Email", "",
                "", "Phone", "");
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------");
        int n = list.size();
        for (int i = 0; i < n; i++) {
            System.out.println(list.get(i).toString());
        }
    }

    public void search() {
        System.out.println("Please enter teacher id: ");
        String maSV = scanner.nextLine();
        Teacher teacher = teacherModel.findById(maSV);
        if (teacher == null){
            System.out.println("false");
        } else {
            System.out.printf("%10s%10s%10s | %10s%15s%10s | %5s%20s%5s | %5s%10s%5s |",
                    "", "id", "",
                    "", "FullName", "",
                    "", "Email", "",
                    "", "Phone", "");
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------");

            System.out.println(teacher.toString());
        }
    }

    public void delete() {
        System.out.println("Please enter teacher id to delete:");
        String id = scanner.nextLine();
        boolean isDelete = teacherModel.delete(id);
        if(isDelete){
            System.out.println("Teacher deleted");
        } else {
            System.out.println("False");

        }
    }

    public void update() {
        System.out.println("Please enter teacher id to update:");
        String id = scanner.nextLine();
        Teacher teacher = new Teacher();
        boolean isUpdate = teacherModel.update(id, teacher);
        if(isUpdate){
            System.out.println("Are you sure update teacher?");
            System.out.println("Please choose:");
            System.out.println("1: yes, 2: no");
            boolean isChoice = true;
            while (isChoice) {
                System.out.printf("Your choice is: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Please enter teacher full name:");
                        String fullName = scanner.nextLine();
                        teacher.setFullName(fullName);

                        System.out.println("Please enter teacher email:");
                        String email = scanner.nextLine();
                        teacher.setEmail(email);

                        System.out.println("Please enter teacher iphone:");
                        String phone = scanner.nextLine();
                        teacher.setPhone(phone);

                        teacherModel.update(id,teacher);
                        System.out.println("Teacher updated");
                        isChoice = false;
                        break;
                    case 2:
                        isChoice = false;
                        break;
                    default:
                        System.out.println("Please choose again");
                        break;
                }
            }
        } else {
            System.out.println("false");
        }
    }
}
package assignment.t2012e.controller;

import assignment.t2012e.entity.Student;
import assignment.t2012e.model.StudentModel;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentController {
    private StudentModel studentModel = new StudentModel();
    private Scanner scanner = new Scanner(System.in);

    public void create() {
        Student student = new Student();
        System.out.printf("Please enter student rollNumber: ");
        String rollNumber = scanner.nextLine();
        student.setRollNumber(rollNumber);

        System.out.printf("Please enter student fullName: ");
        String fullName = scanner.nextLine();
        student.setFullName(fullName);

        System.out.printf("Please enter student email: ");
        String email = scanner.nextLine();
        student.setEmail(email);

        System.out.printf("Please enter student phone: ");
        String phone = scanner.nextLine();
        student.setPhone(phone);

        boolean isCreat = studentModel.save(student);
        if (isCreat) {
            System.out.println("Success!");
        } else {
            System.out.println("False!");
        }
    }

    public void showList() {
        ArrayList<Student> list = studentModel.findAll();
        System.out.printf("%10s%10s%10s | %10s%15s%10s | %5s%20s%5s | %5s%10s%5s |",
                "", "rollNumber", "",
                "", "fullName", "",
                "", "email", "",
                "", "phone", "");
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------");
        int n = list.size();
        for (int i = 0; i < n; i++) {
            System.out.println(list.get(i).toString());
        }
    }

    public void search() {
        System.out.println("Please enter student rollNumber: ");
        String maSV = scanner.nextLine();
        Student student = studentModel.findById(maSV);
        if (student == null){
            System.out.println("False!");
        } else {
            System.out.printf("%10s%10s%10s | %10s%15s%10s | %5s%20s%5s | %5s%10s%5s |",
                    "", "rollNumber", "",
                    "", "fullName", "",
                    "", "email", "",
                    "", "phone", "");
            System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------------");

            System.out.println(student.toString());
        }
    }

    public void delete() {
        System.out.println("Please enter student roll number to delete:");
        String id = scanner.nextLine();
        boolean isDelete = studentModel.delete(id);
        if(isDelete){
            System.out.println("Student deleted");
        } else {
            System.out.println("False");

        }
    }

    public void update() {
        System.out.println("Please enter student roll number to update");
        String id = scanner.nextLine();
        Student student = new Student();
        boolean isUpdate = studentModel.update(id, student);
        if(isUpdate){
            System.out.println("Are you sure update student?");
            System.out.println("Please choose:");
            System.out.println("1: yes, 2: no");
            boolean isChoice = true;
            while (isChoice) {
                System.out.printf("Your choice is: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                switch (choice) {
                    case 1:
                        System.out.println("Please enter student fullname:");
                        String fullName = scanner.nextLine();
                        student.setFullName(fullName);

                        System.out.println("Please enter student email:");
                        String email = scanner.nextLine();
                        student.setEmail(email);

                        System.out.println("Please enter student phone:");
                        String phone = scanner.nextLine();
                        student.setPhone(phone);

                        studentModel.update(id,student);
                        System.out.println("Student updated");
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
            System.out.println("False");
        }
    }
}
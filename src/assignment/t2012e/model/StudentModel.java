package assignment.t2012e.model;

import assignment.t2012e.entity.Student;

import java.util.ArrayList;

public class StudentModel {
    private ArrayList<Student> list = new ArrayList<>();
    public boolean save(Student obj){
        list.add(obj);
        return true;
    }

    public ArrayList<Student> findAll(){
        return list;
    }

    public Student findById(String id){
        Student obj = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)){
                return obj = list.get(i);
            }
        }
        return obj;
    }

    public boolean update(String id, Student updateObj){
        Student existingStudent = findById(id);
        if (existingStudent == null){
            return false;
        }
        existingStudent.setFullName(updateObj.getFullName());
        existingStudent.setPhone(updateObj.getPhone());
        existingStudent.setEmail(updateObj.getEmail());
        return true;
    }

    public boolean delete(String id){
        Student deleteStudent = findById(id);
        if (deleteStudent == null){
            return false;
        }
        list.remove(deleteStudent);
        return true;
    }
}
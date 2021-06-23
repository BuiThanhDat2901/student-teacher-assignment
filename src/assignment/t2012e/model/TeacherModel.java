package assignment.t2012e.model;

import assignment.t2012e.entity.Teacher;

import java.util.ArrayList;

public class TeacherModel {
    private ArrayList<Teacher> list = new ArrayList<>();
    public boolean save(Teacher obj){
        list.add(obj);
        return true;
    }

    public ArrayList<Teacher> findAll(){
        return list;
    }

    public Teacher findById(String id){
        Teacher obj = null;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getRollNumber().equals(id)){
                return obj = list.get(i);
            }
        }
        return obj;
    }

    public boolean update(String id, Teacher updateObj){
        Teacher existingTeacher = findById(id);
        if (existingTeacher == null){
            return false;
        }
        existingTeacher.setFullName(updateObj.getFullName());
        existingTeacher.setPhone(updateObj.getPhone());
        existingTeacher.setEmail(updateObj.getEmail());
        return true;
    }

    public boolean delete(String id){
        Teacher deleteTeacher = findById(id);
        if (deleteTeacher == null){
            return false;
        }
        list.remove(deleteTeacher);
        return true;
    }
}
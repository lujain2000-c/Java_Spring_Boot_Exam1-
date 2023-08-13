package com.example.exam.Service;

import com.example.exam.Model.Student;
import com.example.exam.Model.Teacher;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class TeacherService {
    ArrayList<Teacher> teachers = new ArrayList<>();


    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void addTeacher(Teacher newTeacher){
        teachers.add(newTeacher);
    }

    public boolean updateTeacher(String teacherId, Teacher teacher){
        for (int i = 0; i < teachers.size(); i++){
            if(teachers.get(i).getId().equals(teacherId)){
                teachers.set(i,teacher);
                return true;
            }
        }

        return false;
    }

    public boolean deleteTeacher(String teacherId){

        for (int i = 0; i < teachers.size(); i++){
            if(teachers.get(i).getId().equals(teacherId)){
                teachers.remove(teachers.get(i));
                return true;
            }
        }

        return false;
    }

    public Teacher searchTeacher(String teacherName){

        for (int i = 0; i < teachers.size(); i++){
            if(teachers.get(i).getId().equals(teacherName)){
                return teachers.get(i);
            }
        }
        return null;
    }
}

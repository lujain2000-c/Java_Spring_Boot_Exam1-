package com.example.exam.Service;

import com.example.exam.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentService {

    ArrayList<Student> students = new ArrayList<>();


    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student newStudent){
        students.add(newStudent);
    }

    public boolean updateStudent(String studentId, Student student){
       for (int i = 0; i < students.size(); i++){
           if(students.get(i).getId().equals(studentId)){
               students.set(i,student);
               return true;
           }
       }

       return false;
    }

    public boolean deleteStudent(String studentId){

        for (int i = 0; i < students.size(); i++){
            if(students.get(i).getId().equals(studentId)){
                students.remove(students.get(i));
                return true;
            }
        }

        return false;
    }

    public Student searchStudent(String studentName){

        for (int i = 0; i < students.size(); i++){
            if(students.get(i).getId().equals(studentName)){
                return students.get(i);
            }
        }
        return null;
    }
}

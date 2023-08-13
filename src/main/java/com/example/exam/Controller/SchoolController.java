package com.example.exam.Controller;

import com.example.exam.ApiResponse.ApiResponse;
import com.example.exam.Model.Student;
import com.example.exam.Model.Teacher;
import com.example.exam.Service.StudentService;
import com.example.exam.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/school")
@RequiredArgsConstructor
public class SchoolController {

    private final StudentService studentService;
    private final TeacherService teacherService;


    @GetMapping("/getstudents")
    public ArrayList<Student> getAllStudents() {
        return studentService.getStudents();
    }

    @PostMapping("/addstudent")
    public ResponseEntity addStudent(@RequestBody @Valid Student newStudent, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        studentService.addStudent(newStudent);
        return ResponseEntity.status(200).body(new ApiResponse("student added"));
    }

    @PutMapping("/updatestudent/{studentId}")
    public ResponseEntity updateStudent(@PathVariable String studentId, @RequestBody @Valid Student student, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = studentService.updateStudent(studentId, student);

        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("student updated"));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse("student not updated"));
        }
    }

    @DeleteMapping("/deletestudent/{studentId}")
    public ResponseEntity deleteStudent(@PathVariable String studentId) {

        boolean isDelete = studentService.deleteStudent(studentId);
        if (isDelete) {
            return ResponseEntity.status(200).body(new ApiResponse("student deleted"));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse("not found"));
        }
    }


    @GetMapping("/getstudent/{studentId}")
    public ResponseEntity searchStudent(@PathVariable String studentId ) {
        Student student = studentService.searchStudent(studentId);
        if(student != null){
            return ResponseEntity.status(200).body(student);
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }


    //Teacher

    @GetMapping("/getteachers")
    public ArrayList<Teacher> getAllTeachers() {
        return teacherService.getTeachers();
    }

    @PostMapping("/addteacher")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher newTeacher, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }

        teacherService.addTeacher(newTeacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added"));
    }

    @PutMapping("/update/{teacherId}")
    public ResponseEntity updateTeacher(@PathVariable String teacherId, @RequestBody @Valid Teacher teacher, Errors errors) {

        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        boolean isUpdated = teacherService.updateTeacher(teacherId, teacher);

        if (isUpdated) {
            return ResponseEntity.status(200).body(new ApiResponse("teacher updated"));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse("teacher not updated"));
        }
    }

    @DeleteMapping("/deleteteacher/{teacherId}")
    public ResponseEntity deleteTeacher(@PathVariable String teacherId) {

        boolean isDelete = teacherService.deleteTeacher(teacherId);
        if (isDelete) {
            return ResponseEntity.status(200).body(new ApiResponse("teacher deleted"));
        } else {
            return ResponseEntity.status(400).body(new ApiResponse("not found"));
        }
    }

    @GetMapping("/getteacher/{teacherId}")
    public ResponseEntity searchTeacher(@PathVariable String teacherId ) {
        Teacher teacher = teacherService.searchTeacher(teacherId);
        if(teacher != null){
            return ResponseEntity.status(200).body(teacher);
        }
        return ResponseEntity.status(400).body(new ApiResponse("not found"));
    }


}

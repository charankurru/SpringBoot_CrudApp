package crud.expo.controllers;

import crud.expo.models.Student;
import crud.expo.models.StudentProfile;
import crud.expo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private  StudentService studentService;

    @PostMapping("/addStudent")
    public ResponseEntity<Student> addItem(@RequestBody Student student){
        return new ResponseEntity<>(this.studentService.addStudent(student), HttpStatus.OK);
    }

    @PostMapping("/addStudentProfile")
    public ResponseEntity<String> addItem(@RequestBody StudentProfile student){
        this.studentService.addStudentProfile(student);
        return new ResponseEntity<>("Student Added Successfully !!", HttpStatus.OK);
    }



    @GetMapping("/GetStudentData")
    public ResponseEntity<List<Student>>getStudent(){
        return new ResponseEntity<>(this.studentService.getStudent(),HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteStudentById/{student_id}")
    public  ResponseEntity<String>deleteStudent(@PathVariable("student_id") int id){
        System.out.println(id);
        this.studentService.deleteStudent(id);
        return new ResponseEntity<>("Student deleted Successfully",HttpStatus.OK);
    }


}

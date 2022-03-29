package crud.expo.services;

import crud.expo.Repository.StudentProfileRepo;
import crud.expo.Repository.StudentRepo;
import crud.expo.models.Student;
import crud.expo.models.StudentProfile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepo studentRepo;
    private final StudentProfileRepo studentProfileRepo;

    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    public void addStudentProfile(StudentProfile student) {
        this.studentProfileRepo.save(student);
    }

    public List<Student> getStudent() {
        return (List<Student>) studentRepo.findAll();
    }

    public void deleteStudent(int id) {
        studentRepo.deleteById(id);
    }


}

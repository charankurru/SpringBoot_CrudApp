package crud.expo.controllers;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import crud.expo.models.Student;
import crud.expo.models.StudentProfile;
import crud.expo.services.StudentService;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(StudentController.class)
class StudentControllerTest {
    @Autowired
    private StudentController studentController;

   @Autowired
   private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;


    @Test
    void testGetStudent() throws Exception {
        when(this.studentService.getStudent()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/GetStudentData");
        mockMvc
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testGetStudent2() throws Exception {
        when(this.studentService.getStudent()).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/GetStudentData");
        getResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(getResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content().string("[]"));
    }

    @Test
    void testAddItem() throws Exception {
        Student student = new Student();
        student.setName("Name");
        student.setStudentId(123);
        student.setStudentProfile(new StudentProfile());

        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setBranch("janedoe/featurebranch");
        studentProfile.setCollege("College");
        studentProfile.setMobileNumber(10);
        studentProfile.setProfileId(123);
        studentProfile.setRollId("42");
        studentProfile.setStudent(student);

        Student student1 = new Student();
        student1.setName("Name");
        student1.setStudentId(123);
        student1.setStudentProfile(studentProfile);

        StudentProfile studentProfile1 = new StudentProfile();
        studentProfile1.setBranch("janedoe/featurebranch");
        studentProfile1.setCollege("College");
        studentProfile1.setMobileNumber(10);
        studentProfile1.setProfileId(123);
        studentProfile1.setRollId("42");
        studentProfile1.setStudent(student1);

        Student student2 = new Student();
        student2.setName("Name");
        student2.setStudentId(123);
        student2.setStudentProfile(studentProfile1);
        when(this.studentService.addStudent((Student) any())).thenReturn(student2);

        Student student3 = new Student();
        student3.setName("Name");
        student3.setStudentId(123);
        student3.setStudentProfile(new StudentProfile());

        StudentProfile studentProfile2 = new StudentProfile();
        studentProfile2.setBranch("janedoe/featurebranch");
        studentProfile2.setCollege("College");
        studentProfile2.setMobileNumber(10);
        studentProfile2.setProfileId(123);
        studentProfile2.setRollId("42");
        studentProfile2.setStudent(student3);

        Student student4 = new Student();
        student4.setName("Name");
        student4.setStudentId(123);
        student4.setStudentProfile(studentProfile2);

        StudentProfile studentProfile3 = new StudentProfile();
        studentProfile3.setBranch("janedoe/featurebranch");
        studentProfile3.setCollege("College");
        studentProfile3.setMobileNumber(10);
        studentProfile3.setProfileId(123);
        studentProfile3.setRollId("42");
        studentProfile3.setStudent(student4);

        Student student5 = new Student();
        student5.setName("Name");
        student5.setStudentId(123);
        student5.setStudentProfile(studentProfile3);
        String content = (new ObjectMapper()).writeValueAsString(student5);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addStudent")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
                .andExpect(MockMvcResultMatchers.content()
                        .string(
                                "{\"studentId\":123,\"name\":\"Name\",\"studentProfile\":{\"profileId\":123,\"rollId\":\"42\",\"branch\":\"janedoe"
                                        + "/featurebranch\",\"college\":\"College\",\"mobileNumber\":10}}"));
    }

    @Test
    void testDeleteStudent() throws Exception {
        doNothing().when(this.studentService).deleteStudent(anyInt());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.delete("/deleteStudentById/{student_id}", 1);
        MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Student deleted Successfully"));
    }

    @Test
    void testDeleteStudent2() throws Exception {
        doNothing().when(this.studentService).deleteStudent(anyInt());
        MockHttpServletRequestBuilder deleteResult = MockMvcRequestBuilders.delete("/deleteStudentById/{student_id}", 1);
        deleteResult.contentType("https://example.org/example");
        MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(deleteResult)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Student deleted Successfully"));
    }

    @Test
    void testAddItem2() throws Exception {
        doNothing().when(this.studentService).addStudentProfile((StudentProfile) any());

        StudentProfile studentProfile = new StudentProfile();
        studentProfile.setBranch("janedoe/featurebranch");
        studentProfile.setCollege("College");
        studentProfile.setMobileNumber(10);
        studentProfile.setProfileId(123);
        studentProfile.setRollId("42");
        studentProfile.setStudent(new Student());

        Student student = new Student();
        student.setName("Name");
        student.setStudentId(123);
        student.setStudentProfile(studentProfile);

        StudentProfile studentProfile1 = new StudentProfile();
        studentProfile1.setBranch("janedoe/featurebranch");
        studentProfile1.setCollege("College");
        studentProfile1.setMobileNumber(10);
        studentProfile1.setProfileId(123);
        studentProfile1.setRollId("42");
        studentProfile1.setStudent(student);

        Student student1 = new Student();
        student1.setName("Name");
        student1.setStudentId(123);
        student1.setStudentProfile(studentProfile1);

        StudentProfile studentProfile2 = new StudentProfile();
        studentProfile2.setBranch("janedoe/featurebranch");
        studentProfile2.setCollege("College");
        studentProfile2.setMobileNumber(10);
        studentProfile2.setProfileId(123);
        studentProfile2.setRollId("42");
        studentProfile2.setStudent(student1);
        String content = (new ObjectMapper()).writeValueAsString(studentProfile2);
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/addStudentProfile")
                .contentType(MediaType.APPLICATION_JSON)
                .content(content);
        MockMvcBuilders.standaloneSetup(this.studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
                .andExpect(MockMvcResultMatchers.content().string("Student Added Successfully !!"));
    }
}


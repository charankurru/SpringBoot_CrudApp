package crud.expo.controllers;
import crud.expo.dto.CustomerProductResponse;
import crud.expo.models.Employee;
import crud.expo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/adduser")
    public ResponseEntity<String> addUser(@RequestBody Employee employee) {
        this.employeeService.addUser(employee);
        return new ResponseEntity<>("User Added Successfully !!", HttpStatus.OK);
    }

    @GetMapping("/getemployee")
    public ResponseEntity<List<Employee>> getdata() {
        return new ResponseEntity<>(employeeService.getdata(), HttpStatus.OK);
    }

    @PutMapping("/updateEmployee")
    //@RequestMapping(method = RequestMethod.PUT, value = "/updateEmployee")
    public ResponseEntity<Employee> update(@RequestBody Employee employee) {
        Employee updatedemp = employeeService.update(employee);
        return new ResponseEntity<>(updatedemp, HttpStatus.OK);
    }

    @DeleteMapping("/deleteEmployee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.delete(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
    }

    @GetMapping("/getCustomerProducts")
    public ResponseEntity<List<CustomerProductResponse>>getCPData(){
        return new ResponseEntity<>(employeeService.getCPData(),HttpStatus.OK );
    }

}

package crud.expo.controllers;
import crud.expo.dto.CustomerProductResponse;
import crud.expo.dto.EmployeeApiResult;
import crud.expo.dto.StatusResponse;
import crud.expo.models.Employee;
import crud.expo.models.TestDummy;
import crud.expo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public ResponseEntity<StatusResponse> addUser(@RequestBody Employee employee) {
        Employee resEmployee = this.employeeService.addUser(employee);
        if(resEmployee != null)
        {
            StatusResponse statusResponse = new StatusResponse();
            statusResponse.setStatusCode(HttpStatus.OK.value());
            statusResponse.setStatusDescription("Employee Added Successfully");
            return new ResponseEntity<>(statusResponse, HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/getAllEmployees")
    public ResponseEntity<List<Employee>> getdata() {
        return new ResponseEntity<>(employeeService.getdata(), HttpStatus.OK);
    }

    @GetMapping("/getEmployeeById/{id}")
    public ResponseEntity<Employee>getEmployee(@PathVariable("id") Integer id){
        Optional<Employee> employee = employeeService.getEmployee(id);
        return employee.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> ResponseEntity.noContent().build());
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

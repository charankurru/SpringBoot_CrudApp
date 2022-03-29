package crud.expo.services;

import crud.expo.Repository.EmployeeRepo;
import crud.expo.Repository.TestDummyRepo;
import crud.expo.dto.CustomerProductResponse;
import crud.expo.models.Employee;
import crud.expo.models.TestDummy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;


    public Employee addUser(Employee employ) {
            return this.employeeRepo.save(employ);
    }

    public List<Employee> getdata() {
        List<Employee> lst = new ArrayList<>();
        employeeRepo.findAll().forEach(lst::add);
        return lst;
    }

    public Employee update(Employee employee) {
        return employeeRepo.save(employee);
    }

    public void delete(Integer name) {
        employeeRepo.deleteById(name);
    }

    public List<CustomerProductResponse> getCPData() {
        return employeeRepo.getCustomerWithProducts();
    }


    public Optional<Employee> getEmployee(Integer id) {
        return employeeRepo.findById(id);
    }


}


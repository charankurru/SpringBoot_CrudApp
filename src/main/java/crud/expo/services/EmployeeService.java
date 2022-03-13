package crud.expo.services;

import crud.expo.Repository.EmployeeRepo;
import crud.expo.dto.CustomerProductResponse;
import crud.expo.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public void addUser(Employee employ) {
        employeeRepo.save(employ);
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

    public List<CustomerProductResponse>getCPData(){
        return employeeRepo.getCustomerWithProducts();
    }

}


package crud.expo.services;

import crud.expo.Repository.CartRepo;
import crud.expo.Repository.EmployeeRepo;
import crud.expo.Repository.ItemRepo;
import crud.expo.Repository.StudentRepo;
import crud.expo.dto.CustomerProductResponse;
import crud.expo.models.Cart;
import crud.expo.models.Employee;
import crud.expo.models.Item;
import crud.expo.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;
    @Autowired
    private ItemRepo itemRepo;
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private StudentRepo studentRepo;

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


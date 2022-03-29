package crud.expo.dto;

import crud.expo.models.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeApiResult {
    private StatusResponse statusResponse;
    private Employee employee;
}

package cl.demo.service;

import cl.demo.controller.model.EmployeeModel;
import cl.demo.entities.Department;
import cl.demo.entities.Employee;
import cl.demo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee saveEmployee(EmployeeModel employeeModel) {
        Employee employee = Employee.builder()
                .name(employeeModel.getName())
                .lastName(employeeModel.getLastName())
                .email(employeeModel.getEmail())
                .age(employeeModel.getAge())
                .phone(employeeModel.getPhone())
                .height(employeeModel.getHeight())
                .married(employeeModel.isMarried())
                .dateOfBirth(employeeModel.getDateOfBirth())
                .department(Department.builder()
                        .city(employeeModel.getDepartmentModel().getCity())
                        .name(employeeModel.getDepartmentModel().getName())
                        .build())
                .build();
        return this.employeeRepository.save(employee);
    }
}

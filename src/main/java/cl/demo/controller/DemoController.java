package cl.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cl.demo.controller.model.EmployeeModel;
import cl.demo.entities.Employee;
import cl.demo.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@RestController
public class DemoController {

    private final EmployeeService employeeService;

    // Endpoint para guardar un nuevo empleado
    @PostMapping("/save")
    public ResponseEntity<Employee> saveEmployee(@RequestBody @Valid EmployeeModel employeeModel) {
        // La anotación @Valid garantiza que el objeto EmployeeModel sea validado según las reglas de validación definidas en la clase
        // Si la validación falla, se lanzará una excepción MethodArgumentNotValidException, que será manejada globalmente por el GlobalExceptionHandler

        // Llama al servicio para guardar el empleado y obtiene la respuesta
        Employee savedEmployee = this.employeeService.saveEmployee(employeeModel);

        // Devuelve una respuesta con el empleado guardado y el código de estado 201 Created
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }
}

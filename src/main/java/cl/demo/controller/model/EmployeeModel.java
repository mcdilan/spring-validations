package cl.demo.controller.model;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeModel {

	@NotNull(message = "El nombre no puede ser nulo")
    private String name;
	
	@NotNull(message = "El apellido no puede ser nulo")
    private String lastName;

    @Email
    @NotBlank
    @NotNull(message = "El correo electrónico no puede ser nulo")
    private String email;

    @NotNull(message = "El teléfono no puede ser nulo")
    private Long phone;

    @NotNull(message = "La edad no puede ser nula")
    private byte age;

    @Digits(integer = 1, fraction = 2, message = "El número recibido no es válido")
    @NotNull(message = "La altura no puede ser nula")
    private double height;

    @NotNull(message = "El estado civil no puede ser nulo")
    private boolean married;

    @Past(message = "La fecha debe ser anterior a la fecha actual")
    private LocalDate dateOfBirth;

    @Valid
    private DepartmentModel departmentModel;
}

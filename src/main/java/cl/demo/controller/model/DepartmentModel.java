package cl.demo.controller.model;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Validated
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentModel {
    
	@NotNull
	@Size(max = 10, message = "El nombre no debe superar los 10 caracteres")
    private String name;

    @NotNull
    private String city;
    
}

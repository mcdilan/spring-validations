package cl.demo.exception;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

	// Maneja excepciones de validación de argumentos
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleInvalidArguments(MethodArgumentNotValidException exception) {
        // Crea un mapa para almacenar los errores de validación
        Map<String, String> errors = new HashMap<>();

        // Itera sobre los errores de validación en los campos
        exception.getBindingResult().getFieldErrors().forEach(error -> {
            // Para cada error, agrega una entrada al mapa con el nombre del campo y el mensaje de error
            errors.put(error.getField(), error.getDefaultMessage());
        });

        // Devuelve el mapa de errores
        return errors;
    }
} 



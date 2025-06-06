package mx.unam.aragon.ico.is.celularesapi.excepciones;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;

@RestControllerAdvice
public class ManejadorGlobalDeErrores {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    private ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ResponseEntity.ok("El valor no es valido");
    }
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<HashMap<String,String>> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {
        HashMap<String,String> errors = new HashMap<>();
        errors.put("timestamp", LocalDateTime.now().toString());
        errors.put("mensaje", "error al validar el argumento");
        errors.put("codigo", "2001");
        return new ResponseEntity<>(errors, HttpStatus.OK);
    }

}

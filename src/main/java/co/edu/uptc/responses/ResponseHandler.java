package co.edu.uptc.responses;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

public class ResponseHandler {
    public static ResponseEntity<Object> generateResponse(String message, HttpStatus httpStatus, Object response){
        Map<String, Object> map = new HashMap<>();
        map.put("message",message);
        map.put("status",httpStatus);
        map.put("data",response);

        return new ResponseEntity<>( map,httpStatus );
    }
}

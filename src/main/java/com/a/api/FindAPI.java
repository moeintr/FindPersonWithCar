package com.a.api;

import com.a.common.wrapper.ErrorHandler;
import com.a.model.domain.Person;
import com.a.model.service.FindService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/find")
@Scope("singleton")
public class FindAPI {
    private final FindService findService;

    public FindAPI(FindService findService) {
        this.findService = findService;
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map> onException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ErrorHandler.getError(e));
    }
    @GetMapping("/findAllPersonWithCars")
    public ResponseEntity<Object> findAllPersonWithCars() {
        return new ResponseEntity<>(findService.findAllPersonWithCars(), HttpStatus.OK);
    }
    @GetMapping("/findPersonWithCarsByPersonId")
    public ResponseEntity<Object> findPersonWithCarsByPersonId(@ModelAttribute Person person) {
        return new ResponseEntity<>(findService.findPersonWithCarsByPersonId(person), HttpStatus.OK);
    }
}

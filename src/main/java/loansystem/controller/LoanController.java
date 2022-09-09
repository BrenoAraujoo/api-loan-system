package loansystem.controller;

import loansystem.entities.Loan;
import loansystem.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/loan")
public class LoanController {

    @Autowired
    LoanService service;

    @GetMapping
    public ResponseEntity<List<Loan>> findAll(){
        return ResponseEntity.ok().body(service.findAll());
    }
}

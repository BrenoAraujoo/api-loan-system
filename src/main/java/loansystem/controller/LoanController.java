package loansystem.controller;

import loansystem.entities.Loan;
import loansystem.services.LoanService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<Loan> findById(@PathVariable(value = "id") Long id){
        Loan loan  = service.findById(id);
        return  ResponseEntity.ok().body(loan);
    }

    @PostMapping
    public ResponseEntity<Loan> save(@RequestBody Loan loan){
        service.save(loan);
        return ResponseEntity.status(HttpStatus.CREATED).body(loan);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id")Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Loan> put(@RequestBody Loan loan){
            service.update(loan);
            return ResponseEntity.ok().body(loan);

    }


}

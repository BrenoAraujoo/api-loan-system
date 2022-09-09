package loansystem.controller;

import loansystem.entities.Installment;
import loansystem.services.InstallmentService;
import loansystem.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/installment")
public class InstallmentController {

    @Autowired
    InstallmentService installmentService;

    @Autowired
    LoanService loanService;

    @GetMapping
    public ResponseEntity<List<Installment>> findAll(){
        return ResponseEntity.ok().body(installmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Installment> findById(@PathVariable(value = "id") Long id){
        Installment installment  = installmentService.findById(id);
        return  ResponseEntity.ok().body(installment);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Installment installment){

        installmentService.save(installment);
        return ResponseEntity.status(HttpStatus.CREATED).body(installment);
    }


    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable(value = "id")Long id){
        installmentService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Installment> put(@RequestBody Installment loan){
            installmentService.update(loan);
            return ResponseEntity.ok().body(loan);

    }


}

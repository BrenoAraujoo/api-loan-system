package loansystem.services;

import loansystem.entities.Loan;
import loansystem.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    LoanRepository repository;

    public List<Loan> findAll(){
        return
              repository.findAll();
    }

}

package loansystem.services;

import loansystem.entities.Loan;
import loansystem.exceptions.RequiredObjectIsNullException;
import loansystem.exceptions.ResourceNotFoundException;
import loansystem.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    LoanRepository repository;

    public List<Loan> findAll() {
        return
                repository.findAll();
    }

    public Loan findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Loan not found: " + id));
    }

    public Loan save(Loan loan) {
        if (loan == null) throw new RequiredObjectIsNullException();
        return repository.save(loan);
    }

    public void delete(Long id) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this id!"));
        repository.delete(entity);
    }

    public Loan update(Loan loan) {
        if (loan == null) throw new RequiredObjectIsNullException();
        repository.findById(loan.getId());
        return  repository.save(loan);
    }

}

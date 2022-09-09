package loansystem.services;

import loansystem.entities.Installment;
import loansystem.repositories.InstallmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InstallmentService {

    @Autowired
    InstallmentRepository repository;

    public List<Installment> findAll(){
        return
              repository.findAll();
    }
}

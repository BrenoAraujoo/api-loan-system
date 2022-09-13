package loansystem.services;

import loansystem.entities.Installment;
import loansystem.entities.dto.InstallmentDTO;
import loansystem.exceptions.ResourceNotFoundException;
import loansystem.repositories.InstallmentRepository;
import loansystem.repositories.LoanRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InstallmentService {

    @Autowired
    InstallmentRepository installmentRepository;

    @Autowired
    LoanRepository loanRepository;

    @Autowired
    ModelMapper modelMapper;

    public List<InstallmentDTO> findAll(){
        return installmentRepository.findAll()
                .stream()
                .map(this::toInstallmentDTO)
                .collect(Collectors.toList());
    }

    public Installment findById(Long id){
        return installmentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Instalment not found " + id));
    }

    public Installment save(Installment installment){
        if(installment == null) throw new ResourceNotFoundException("Loan not found: ");
        return installmentRepository.save(installment);
    }

    public List<Installment> saveAll(List<Installment> list){
        return installmentRepository.saveAll(list);
    }

    public void delete(Long id){

        var entity = installmentRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Installment not found: " + id));
        installmentRepository.delete(entity);

    }

    public Installment update(Installment installment) {
       if(installment == null) throw new ResourceNotFoundException("Installment not found: ");
        installmentRepository.findById(installment.getId());
        return installmentRepository.save(installment);

    }

    private InstallmentDTO toInstallmentDTO(Installment installment){
        return modelMapper.map(installment,InstallmentDTO.class);
    }
}

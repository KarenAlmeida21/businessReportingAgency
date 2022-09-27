package com.api.businessReportingAgency.manager;

import com.api.businessReportingAgency.employee.RegistrationAlreadyDone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ManagerService {
    @Autowired
    ManagerRepository managerRepository;



    public Manager saveManager(Manager manager) {
        if (managerRepository.existsByCpf(manager.getCpf())) {
            throw new RegistrationAlreadyDone("Registration Already Done");
        }
        managerRepository.save(manager);
        return manager;
    }


    public void deleteManager(Long id) {
        Optional<Manager> manager = managerRepository.findById(id);
        if (manager.isEmpty()) {
            throw new ManagerNotFound("ID NOT FOUND");
        }
        managerRepository.deleteById(id);
    }


    public Manager displayByCpf(String cpf) {
        Optional<Manager> manager = managerRepository.findByCpf(cpf);
        if (manager.isEmpty()) {
            throw new ManagerNotFound("CPF NOT FOUND");
        }
        return manager.get();
    }

    public Manager updateManager(String cpf, EntryManagerDto managerNew) {
        Manager manager = displayByCpf(cpf);
        manager.setCpf(managerNew.getCpf());
        manager.setName(managerNew.getName());
        manager.setSetor(managerNew.getSetor());
        return managerRepository.save(manager);
    }

}

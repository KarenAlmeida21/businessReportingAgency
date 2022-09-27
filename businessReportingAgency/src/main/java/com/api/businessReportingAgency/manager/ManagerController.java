package com.api.businessReportingAgency.manager;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ManagerService managerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void fileManager(@RequestBody @Valid EntryManagerDto entryManagerDto) {
        Manager newManager = modelMapper.map(entryManagerDto, Manager.class);
        modelMapper.map(managerService.saveManager(newManager), EntryManagerDto.class);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteManager(@PathVariable Long id) {
        managerService.deleteManager(id);
    }


    @GetMapping("/{cpf}")
    public OutManagerDto displayByCpf(@PathVariable String cpf) {
        Manager manager = managerService.displayByCpf(cpf);
        return modelMapper.map(manager, OutManagerDto.class);
    }

    @PutMapping("update/{cpf}")
    public EntryManagerDto UpdateEmployee(@PathVariable String cpf,
                                          @RequestBody EntryManagerDto entryEmployeeDto) {
        Manager manager = managerService.updateManager(cpf, entryEmployeeDto);
        return modelMapper.map(manager, EntryManagerDto.class);
    }

}

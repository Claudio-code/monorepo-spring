package com.devsuperior.hrworker.resources;

import com.devsuperior.hrworker.dto.WorkerDTO;
import com.devsuperior.hrworker.services.WorkerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping(value = "/workers")
public class WorkerResource {
    private WorkerService workerService;

    @GetMapping
    public List<WorkerDTO> findAll() {
        return workerService.findAll();
    }

    @GetMapping(value="/{id}")
    public WorkerDTO findById(@PathVariable Long id) {
        return workerService.findById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody WorkerDTO workerDTO) {
        workerService.create(workerDTO);
    }
}

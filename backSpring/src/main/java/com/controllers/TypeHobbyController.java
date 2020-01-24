package com.controllers;

import com.models.TypeHobby.TypeHobbyDTO;
import com.services.TypeHobbyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

@Slf4j
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/typeHobby")
public class TypeHobbyController {
    private final TypeHobbyService typeHobbyService;

    @PostMapping
    public void save(@RequestBody TypeHobbyDTO typeHobbyDTO) {
        typeHobbyService.save(typeHobbyDTO);
        log.info("save {} at {}", typeHobbyDTO, Calendar.getInstance().getTime());
    }

    @GetMapping("{id}")
    public TypeHobbyDTO getTypeHobbyById(@PathVariable Long id) {
        log.info("get TypeHobby by id: {} at {}", id, Calendar.getInstance().getTime());
        return typeHobbyService.getTypeHobbyById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody TypeHobbyDTO typeHobbyDTO) {
        typeHobbyService.update(id, typeHobbyDTO);
        log.info("update {} at {}", typeHobbyDTO, Calendar.getInstance().getTime());
    }

    @GetMapping("/all")
    public List<TypeHobbyDTO> getAllTypeHobby() {
        log.info("get all Hobbies at {}", Calendar.getInstance().getTime());
        return typeHobbyService.getAllTypeHobbies();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) throws IOException {
        log.info("delete TypeHobby by Id {} at {}", id, Calendar.getInstance().getTime());
        typeHobbyService.delete(id);
    }
}

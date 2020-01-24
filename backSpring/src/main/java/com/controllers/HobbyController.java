package com.controllers;

import com.models.Hobby.HobbyDTO;
import com.models.TypeHobby.TypeHobby;
import com.repositorys.TypeHobbyRepository;
import com.services.HobbyService;
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
@RequestMapping("/api/hobby")
public class HobbyController {

    private final HobbyService hobbyService;
    private final TypeHobbyRepository typeHobbyRepository;

    @PostMapping("/typeHobby{typeHobbyId}")
    public void save(@PathVariable Long typeHobbyId, @RequestBody HobbyDTO hobbyDTO) {
        TypeHobby typeHobby = typeHobbyRepository.findById(typeHobbyId).get();
        hobbyDTO.setTh_id(typeHobby);
        hobbyService.save(hobbyDTO);
        log.info("save {} at {}", hobbyDTO, Calendar.getInstance().getTime());
    }

    @GetMapping("{id}")
    public HobbyDTO getHobbyById(@PathVariable Long id) {
        log.info("get Hobby by id: {} at {}", id, Calendar.getInstance().getTime());
        return hobbyService.getHobbyById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody HobbyDTO hobbyDTO) {
        hobbyService.update(id, hobbyDTO);
        log.info("update {} at {}", hobbyDTO, Calendar.getInstance().getTime());
    }

    @GetMapping("/all")
    public List<HobbyDTO> getAllHobby() {
        log.info("get all Hobbys at {}", Calendar.getInstance().getTime());
        return hobbyService.getAllHobbys();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) throws IOException {
        log.info("delete Hobby by Id {} at {}", id, Calendar.getInstance().getTime());
        hobbyService.delete(id);
    }
}

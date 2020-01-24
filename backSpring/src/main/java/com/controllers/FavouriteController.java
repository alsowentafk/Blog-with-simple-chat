package com.controllers;

import com.models.Favourite.FavouriteDTO;
import com.models.TypeHobby.TypeHobby;
import com.models.User.User;
import com.repositorys.TypeHobbyRepository;
import com.repositorys.UserRepository;
import com.services.FavouriteService;
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
@RequestMapping("/api/favourite")
public class FavouriteController {
    private final FavouriteService favouriteService;
    private final UserRepository userRepository;
    private final TypeHobbyRepository typeHobbyRepository;

    @PostMapping("/userId{userId}typeHobby{typeHobbyId}")
    public void save(@PathVariable Long userId, @PathVariable Long typeHobbyId,
                     @RequestBody FavouriteDTO favouriteDTO) {
        User user = userRepository.findById(userId).get();
        TypeHobby typeHobby = typeHobbyRepository.findById(typeHobbyId).get();
        favouriteDTO.setTh_id(typeHobby);
        favouriteDTO.setUser_id(user);
        favouriteService.save(favouriteDTO);
        log.info("save {} at {}", favouriteDTO, Calendar.getInstance().getTime());
    }

    @GetMapping("{id}")
    public FavouriteDTO getFavouriteById(@PathVariable Long id) {
        log.info("get Favourite by id: {} at {}", id, Calendar.getInstance().getTime());
        return favouriteService.getFavouriteById(id);
    }

    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody FavouriteDTO favouriteDTO) {
        favouriteService.update(id, favouriteDTO);
        log.info("update {} at {}", favouriteDTO, Calendar.getInstance().getTime());
    }

    @GetMapping("/all")
    public List<FavouriteDTO> getAllFavourite() {
        log.info("get all Hobbies at {}", Calendar.getInstance().getTime());
        return favouriteService.getAllFavourites();
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) throws IOException {
        log.info("delete Favourite by Id {} at {}", id, Calendar.getInstance().getTime());
        favouriteService.delete(id);
    }
}

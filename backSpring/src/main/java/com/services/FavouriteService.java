package com.services;

import com.models.Favourite.FavouriteDTO;
import com.repositorys.FavouriteRepository;
import com.transoformers.FavouriteFavouriteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavouriteService {
    @Autowired
    private FavouriteRepository repository;

    @Autowired
    private FavouriteFavouriteDTO converter;

    public FavouriteDTO getFavouriteById(long id) {
        return converter.ConvertToFavouriteDTO(repository.findById(id).get());
    }

    public void save(FavouriteDTO favouriteODT) {
        repository.save(converter.ConvertToFavourite(favouriteODT));
    }

    public void update(Long id, FavouriteDTO favouriteDTO) {
        FavouriteDTO temp = converter.ConvertToFavouriteDTO(repository.findById(id).get());
        temp.setId(favouriteDTO.getId());
        temp.setTh_id(favouriteDTO.getTh_id());
        temp.setUser_id(favouriteDTO.getUser_id());
        repository.save(converter.ConvertToFavourite(temp));
    }

    public List<FavouriteDTO> getAllFavourites() {
        List<FavouriteDTO> favouriteDTOList = new ArrayList<>();
        repository.findAll().forEach(a -> favouriteDTOList.add(this.converter.ConvertToFavouriteDTO(a)));
        return favouriteDTOList;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}

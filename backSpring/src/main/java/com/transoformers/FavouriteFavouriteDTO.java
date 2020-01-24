package com.transoformers;

import com.models.Favourite.Favourite;
import com.models.Favourite.FavouriteDTO;
import org.springframework.stereotype.Service;

@Service
public class FavouriteFavouriteDTO {
    public Favourite ConvertToFavourite(FavouriteDTO favouriteDTO) {
        Favourite favourite = new Favourite();
        favourite.setId(favouriteDTO.getId());
        favourite.setTh_id(favouriteDTO.getTh_id());
        favourite.setUser_id(favouriteDTO.getUser_id());
        return favourite;
    }

    public FavouriteDTO ConvertToFavouriteDTO(Favourite favourite) {
        FavouriteDTO favouriteDTO = new FavouriteDTO();
        favouriteDTO.setId(favourite.getId());
        favouriteDTO.setTh_id(favourite.getTh_id());
        favouriteDTO.setUser_id(favourite.getUser_id());
        return favouriteDTO;
    }
}

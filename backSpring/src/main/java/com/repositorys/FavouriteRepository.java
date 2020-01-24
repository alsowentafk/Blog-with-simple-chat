package com.repositorys;

import com.models.Favourite.Favourite;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepository extends CrudRepository<Favourite, Long> {
}

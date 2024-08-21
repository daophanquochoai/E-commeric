package com.doctorhoai.favourite_service.repository;

import com.doctorhoai.favourite_service.entity.Favourite;
import com.doctorhoai.favourite_service.entity.id.FavouriteId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepository extends JpaRepository<Favourite, FavouriteId> {
}

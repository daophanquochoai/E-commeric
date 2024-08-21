package com.doctorhoai.favourite_service.service;

import com.doctorhoai.favourite_service.dto.FavouriteDto;
import com.doctorhoai.favourite_service.entity.id.FavouriteId;

import java.util.List;

public interface FavouriteService {
    List<FavouriteDto> findAll();
    FavouriteDto findById( final FavouriteId favouriteId);
    FavouriteDto save( final FavouriteDto favouriteDto);
    FavouriteDto update( final FavouriteDto favouriteDto);
    void deleteById( final FavouriteId favouriteId);
}

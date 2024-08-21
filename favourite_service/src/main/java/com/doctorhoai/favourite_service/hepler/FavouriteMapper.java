package com.doctorhoai.favourite_service.hepler;

import com.doctorhoai.favourite_service.dto.FavouriteDto;
import com.doctorhoai.favourite_service.dto.ProductDto;
import com.doctorhoai.favourite_service.dto.UserDto;
import com.doctorhoai.favourite_service.entity.Favourite;

public class FavouriteMapper {
    public static FavouriteDto mapToFavouriteDto(final Favourite favourite){
        return FavouriteDto.builder()
                .userId(favourite.getUserId())
                .productId(favourite.getProductId())
                .likeDate(favourite.getLikeDate())
                .userDto(
                        UserDto.builder()
                                .userId(favourite.getUserId())
                                .build()
                )
                .productDto(
                        ProductDto.builder()
                                .productId(favourite.getProductId())
                                .build()
                )
                .build();
    }

    public static Favourite mapToFavourite( final FavouriteDto favouriteDto ){
        return Favourite.builder()
                .userId(favouriteDto.getUserId())
                .productId(favouriteDto.getProductId())
                .likeDate(favouriteDto.getLikeDate())
                .build();
    }
}

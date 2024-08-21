package com.doctorhoai.favourite_service.service.imp;

import com.doctorhoai.favourite_service.dto.FavouriteDto;
import com.doctorhoai.favourite_service.entity.id.FavouriteId;
import com.doctorhoai.favourite_service.exception.FavouriteNotFound;
import com.doctorhoai.favourite_service.hepler.FavouriteMapper;
import com.doctorhoai.favourite_service.repository.FavouriteRepository;
import com.doctorhoai.favourite_service.service.FavouriteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavouriteServiceImpl implements FavouriteService {
    private final FavouriteRepository repository;

    @Override
    public List<FavouriteDto> findAll() {
        return repository.findAll().stream().map(
                FavouriteMapper::mapToFavouriteDto
        ).collect(Collectors.toList());
    }

    @Override
    public FavouriteDto findById(FavouriteId favouriteId) {
        return FavouriteMapper.mapToFavouriteDto(repository.findById(favouriteId).orElseThrow(
                () -> new FavouriteNotFound("Favourite not found with Id : " + favouriteId.toString())
        ));
    }

    @Override
    public FavouriteDto save(FavouriteDto favouriteDto) {
        return FavouriteMapper.mapToFavouriteDto(repository.save(FavouriteMapper.mapToFavourite(favouriteDto)));
    }

    @Override
    public FavouriteDto update(FavouriteDto favouriteDto) {
        return FavouriteMapper.mapToFavouriteDto(repository.save(FavouriteMapper.mapToFavourite(favouriteDto)));
    }

    @Override
    public void deleteById(final FavouriteId favouriteId) {
        repository.findById(favouriteId).orElseThrow(
                () -> new FavouriteNotFound("Favourite not found with Id : " + favouriteId.toString())
        );
        repository.deleteById(favouriteId);
    }
}

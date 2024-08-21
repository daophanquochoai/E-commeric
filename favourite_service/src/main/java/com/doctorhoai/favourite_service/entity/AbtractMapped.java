package com.doctorhoai.favourite_service.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@NoArgsConstructor( access = AccessLevel.PROTECTED)
@AllArgsConstructor( access = AccessLevel.PROTECTED)
@Data
public class AbtractMapped implements Serializable {
    private static final Long serialVersionUID = 1L;
    @CreatedDate
    private Instant createAt;
    @LastModifiedDate
    private Instant updateAt;
}

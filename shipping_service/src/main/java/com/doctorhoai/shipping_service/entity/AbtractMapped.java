package com.doctorhoai.shipping_service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.MappedSuperclass;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@Data
@NoArgsConstructor( access = AccessLevel.PROTECTED)
@AllArgsConstructor( access = AccessLevel.PROTECTED)
@MappedSuperclass
public class AbtractMapped {
    private static final Long serialVersionUID = 1L;
    @CreatedDate
    @JsonFormat( shape = JsonFormat.Shape.STRING)
    private Instant createAt;
    @LastModifiedDate
    @JsonFormat( shape = JsonFormat.Shape.STRING)
    private Instant updateAt;
}

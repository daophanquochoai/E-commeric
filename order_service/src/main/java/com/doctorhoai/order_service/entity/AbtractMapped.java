package com.doctorhoai.order_service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

@MappedSuperclass
@AllArgsConstructor( access = AccessLevel.PROTECTED)
@NoArgsConstructor( access = AccessLevel.PROTECTED)
@Data
public class AbtractMapped {
    private static final long serialUID = 1L;
    @CreatedDate
    @JsonFormat( shape = JsonFormat.Shape.STRING)
    private Instant createAt;
    @LastModifiedDate
    @JsonFormat( shape = JsonFormat.Shape.STRING)
    private Instant updateAt;

    @PrePersist
    public void setCreateAt(){
        setCreateAt(Instant.now());
    }

    @PreUpdate
    public void setUpdateAt(){
        setUpdateAt(Instant.now());
    }
}

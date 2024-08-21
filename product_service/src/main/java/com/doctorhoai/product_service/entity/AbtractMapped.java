package com.doctorhoai.product_service.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
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
import java.time.LocalDateTime;

@MappedSuperclass
@Data
@NoArgsConstructor( access = AccessLevel.PROTECTED)
@AllArgsConstructor( access = AccessLevel.PROTECTED)
public class AbtractMapped {
    private static final Long serialVersionUID = 1L;

    @CreatedDate
    @JsonFormat( shape = JsonFormat.Shape.STRING)
    @Column( name = "create_at")
    private Instant createAt;
    @LastModifiedDate
    @JsonFormat( shape =  JsonFormat.Shape.STRING)
    @Column( name = "update_at")
    private Instant updateat;

    @PrePersist
    public void beforePersist(){
        setCreateAt(Instant.now());
    }

    @PreUpdate
    public void beforeUpdate(){
        setUpdateat(Instant.now());
    }
}

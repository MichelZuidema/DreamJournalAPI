package com.dreamjournal.backendapi.entity.base;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@JsonIgnoreProperties(
        value = {"createdAt", "updatedAt"},
        allowGetters = true
)
@Getter @Setter
public abstract class BaseEntity implements Serializable {
    @CreatedDate
    @Column(name = "created_at")
    private Instant createdAt = new Date().toInstant();

    @LastModifiedDate
    @Column(name = "updated_at")
    private Instant updatedAt = new Date().toInstant();

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }
}

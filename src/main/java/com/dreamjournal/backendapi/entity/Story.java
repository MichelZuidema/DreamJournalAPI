package com.dreamjournal.backendapi.entity;

import com.dreamjournal.backendapi.entity.base.BaseEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
@Table(name = "story")
public class Story extends BaseEntity {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank
    @Column(name = "content")
    @Size(max = 255)
    private String content;

    @Column(name = "secure")
    private Boolean secure;

    @Column(name = "password")
    @Size(max = 100)
    private String password;

    @Column(name = "deleted")
    private Boolean deleted;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "createdBy")
    private User createdBy;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story story = (Story) o;
        return Objects.equals(id, story.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return this.content;
    }
}

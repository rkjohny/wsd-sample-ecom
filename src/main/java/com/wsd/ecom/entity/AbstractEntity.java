package com.wsd.ecom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Setter
@Getter
@MappedSuperclass
@EntityListeners(AbstractEntity.class)
public abstract class AbstractEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    protected Long id;

    @Enumerated(EnumType.STRING)
    protected Status status = Status.V;

    @Transient
    public boolean isNew() {
        return getId() == null || getId() == 0L;
    }


    public AbstractEntity id(Long id) {
        this.id = id;
        return this;
    }

    public AbstractEntity status(Status status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AbstractEntity that = (AbstractEntity) o;

        if (!Objects.equals(id, that.id)) return false;
        return status == that.status;
    }
}

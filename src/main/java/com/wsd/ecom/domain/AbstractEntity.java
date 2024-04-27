package com.wsd.ecom.domain;

import com.wsd.ecom.domain.util.Status;
import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.Objects;

@MappedSuperclass
@EntityListeners(AbstractEntity.class)
public abstract class AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    protected Long id;

    @Enumerated(EnumType.STRING)
    protected Status status = Status.V;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Transient
    public boolean isNew() {
        return getId() == null || getId() == 0L;
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

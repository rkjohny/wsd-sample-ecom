package com.wsd.ecom.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;


@Setter
@Getter
@MappedSuperclass
public abstract class AbstractSyncableEntity extends AbstractEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Version
    @Column(name = "sync_version")
    protected Long syncVersion = 0L;
}

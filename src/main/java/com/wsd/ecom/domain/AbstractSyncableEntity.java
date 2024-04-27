package com.wsd.ecom.domain;

import jakarta.persistence.*;

import java.io.Serializable;


@MappedSuperclass
public abstract class AbstractSyncableEntity extends AbstractEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Version
    @Column(name = "sync_version")
    protected Long syncVersion = 0L;

    public Long getSyncVersion() {
        return syncVersion;
    }

    public void setSyncVersion(Long syncVersion) {
        this.syncVersion = syncVersion;
    }

    @Transient
    public boolean isNew() {
        return getSyncVersion() == null || getSyncVersion() == 0L;
    }
}

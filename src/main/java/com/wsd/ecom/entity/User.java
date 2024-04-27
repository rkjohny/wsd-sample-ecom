package com.wsd.ecom.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wsd.ecom.config.Constants;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.ColumnDefault;

@Setter
@Getter
@Entity
@Table(name = "t_user", indexes = {
        @Index(columnList = "created_by"),
        @Index(columnList = "last_modified_by"),
        @Index(columnList = "created_date"),
        @Index(columnList = "last_modified_date")
})
@MappedSuperclass
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User extends AbstractAuditingEntity {
    @NotNull
    @Column(name="login", length = Constants.MAX_LOGIN_LENGTH, nullable = false, unique = true)
    @ColumnDefault("''")
    private String login;

    @Email
    @NotNull
    @Size(min = 3, max = Constants.MAX_EMAIL_LENGTH)
    @Column(name = "email", length = Constants.MAX_EMAIL_LENGTH, columnDefinition = "CHARACTER VARYING (100) COLLATE \"C\"", unique = true)
    @ColumnDefault("''")
    private String email;

    @Size(max = Constants.MAX_FIRSTNAME_LASTNAME_LENGTH)
    @Column(name = "first_name", length = Constants.MAX_FIRSTNAME_LASTNAME_LENGTH)
    @ColumnDefault("''")
    private String firstName;

    @Size(max = Constants.MAX_FIRSTNAME_LASTNAME_LENGTH)
    @Column(name = "last_name", length = Constants.MAX_FIRSTNAME_LASTNAME_LENGTH)
    @ColumnDefault("''")
    private String lastName;

    @JsonIgnore
    @Column(name = "password_hash", length = 200)
    private String password;

    @Column(name = "is_disabled")
    private Boolean disabled = Boolean.FALSE;


    // Do not log password
    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", disabled=" + disabled +
                '}';
    }
}

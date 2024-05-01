package com.wsd.ecom.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wsd.ecom.config.Constants;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

/**
 * A user.
 */
@Getter
@Setter
@Entity
@Table(name = "t_user")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class User extends AbstractAuditingEntity implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull
    @Pattern(regexp = Constants.LOGIN_REGEX)
    @Size(min = 4, max = Constants.MAX_LOGIN_LENGTH)
    @Column(unique = true, nullable = false)
    private String login;

    //@JsonIgnore comment it for test purpose
    @NotNull
    @Size(min = 4, max = Constants.MAX_PASSWORD_LENGTH)
    @Column(name = "password_hash", nullable = false)
    private String password;

    @Size(max = Constants.MAX_FIRSTNAME_LASTNAME_LENGTH)
    @Column(name = "first_name")
    private String firstName;

    @Size(max = Constants.MAX_FIRSTNAME_LASTNAME_LENGTH)
    @Column(name = "last_name")
    private String lastName;

    @Email
    @Size(min = 5, max = Constants.MAX_EMAIL_LENGTH)
    @Column(name = "email", unique = true)
    private String email;

    @NotNull
    @Column(nullable = false)
    private boolean activated = false;

    public User login(String login) {
        this.login = login;
        return this;
    }

    public User password(String password) {
        this.password = password;
        return this;
    }

    public User firstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public User lastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User email(String email) {
        this.email = email;
        return this;
    }

    public User activated(boolean activated) {
        this.activated = activated;
        return this;
    }
}

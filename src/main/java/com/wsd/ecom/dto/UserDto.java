package com.wsd.ecom.dto;

import com.wsd.ecom.entity.User;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Data
@NoArgsConstructor
@ToString
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String login;
    private String email;
    private String firstName;
    private String lastName;
    private Boolean activated;

    public UserDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.activated = user.isActivated();
    }
}

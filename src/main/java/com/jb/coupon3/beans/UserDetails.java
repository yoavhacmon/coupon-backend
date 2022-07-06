package com.jb.coupon3.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author Yoav Hacmon, Guy Endvelt, Niv Pablo and Gery Glazer
 * 05.2022
 */

@Component
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
/**
 * this class is used to concentrate the specific fields of the client information in the creation of a new token
 * {@link com.jb.coupon3.service.LoginService}
 */
public class UserDetails {
    @Enumerated (value = EnumType.STRING)
    private ClientType clientType;
    private String email;
    private String pass;
}

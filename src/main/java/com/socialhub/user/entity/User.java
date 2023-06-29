package com.socialhub.user.entity;


import com.socialhub.common.enums.Role;
import com.socialhub.common.utility.ActiveInactiveStatusUtil;
import com.socialhub.user.dto.user.CreateUserRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(schema = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;


    @Column(name = "email" , nullable = false,unique = true)
    private String email;

    @Column(name = "phone" , nullable = false,unique = true)
    private String phone;

    @Column(name = "password" , nullable = false)
    private  String password;

    @CreationTimestamp
    private LocalDateTime createdAt;

    private Integer status;

    private String role;

    private String gender;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<UserImage> images;

    public User(CreateUserRequestDto requestDto,List<UserImage> userImages) {
        this.email=requestDto.getEmail();
        this.phone= requestDto.getPhone();
        this.status= ActiveInactiveStatusUtil.getACTIVE();
        this.role= Role.USER.getValue();
        this.password=requestDto.getPassword();
        this.gender= requestDto.getGender();
        this.images=userImages;
        this.firstName=requestDto.getFirstName();
        this.lastName=requestDto.getLastName();
    }



}

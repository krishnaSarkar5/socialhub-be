package com.socialhub.user.entity;

import com.socialhub.common.utility.ActiveInactiveStatusUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class UserImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String image;

    @CreationTimestamp
    private LocalDateTime createdAt;


    private Integer status;


    public UserImage(String image){
        this.image=image;
        this.status= ActiveInactiveStatusUtil.getACTIVE();
    }
}

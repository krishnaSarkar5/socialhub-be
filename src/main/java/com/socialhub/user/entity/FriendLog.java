package com.socialhub.user.entity;


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
@Builder
@Entity
@Table(name = "friend_log")
public class FriendLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User requestedBy;

    @ManyToOne
    private User requestedTo;


    private Integer action;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @CreationTimestamp
    private LocalDateTime updatedAt;


    private Integer status;

    public FriendLog(FriendLog friendLog) {
        this.requestedBy = friendLog.requestedBy;
        this.requestedTo = friendLog.requestedTo;
        this.action = friendLog.action;
        this.createdAt = friendLog.createdAt;
        this.updatedAt = friendLog.updatedAt;
        this.status = friendLog.status;
    }
}

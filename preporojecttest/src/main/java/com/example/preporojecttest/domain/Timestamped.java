package com.example.preporojecttest.domain;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

///***it is never good to leave room for duplicates.
///***Timestamped will stamp the time of the activities taken.

@MappedSuperclass //when other class inherits Timestamped, it will automatically take it as a column
@EntityListeners(AuditingEntityListener.class) //it listens to the entity and log create/update time
public abstract class Timestamped {
    @CreatedDate // created time
    private LocalDateTime createdAt;

    @LastModifiedDate //Last updated time
    private LocalDateTime modifiedAt;
}

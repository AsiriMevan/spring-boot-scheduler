package com.mevan.spring.scheduler.model;

import lombok.Data;
import lombok.Generated;

import javax.persistence.Entity;
import javax.persistence.Id;


@Data
@Entity
public class User {
    @Id
    @Generated
    private Integer id;
    private String name;
}
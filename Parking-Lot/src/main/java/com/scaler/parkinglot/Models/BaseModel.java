package com.scaler.parkinglot.Models;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;
@SuperBuilder
@Getter
@Setter
public abstract class BaseModel {

    private Long id;
    private Date createdAt;
    private Date updatedAt;

}

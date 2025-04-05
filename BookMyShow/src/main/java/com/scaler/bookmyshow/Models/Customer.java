package com.scaler.bookmyshow.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer extends BaseModel{

    private String fullName;
    private String email;
    private String phoneNumber;
    private String city;

    @OneToOne
    private User user;
}

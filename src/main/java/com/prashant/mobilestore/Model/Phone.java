package com.prashant.mobilestore.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Phone {

    @Id
    private Long id;
    private String brand;
    private String phone;
    private String picture;

    @Embedded
    private Release release;

    private String sim;
    private String resolution;

    @Embedded
    private Hardware hardware;

}

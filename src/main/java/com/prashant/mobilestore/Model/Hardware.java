package com.prashant.mobilestore.Model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class Hardware {

    private String audioJack;
    private String gps;
    private String battery;
}

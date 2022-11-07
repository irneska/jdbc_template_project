package com.irynapistun.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Musician {
    private Integer id;
    private String firstName;
    private String lastName;
    private Integer albumId;
}

package com.irynapistun.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Album {
    private Integer id;
    private String name;
    private Integer yearOfPublishing;
    private Integer musicalLabelId;
}

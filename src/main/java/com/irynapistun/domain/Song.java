package com.irynapistun.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Song {
    private Integer id;
    private Double duration;
    private String name;
    private Integer albumId;
    private Integer genreId;
}

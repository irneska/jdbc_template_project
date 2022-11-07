package com.irynapistun.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Playlist {
    private Integer id;
    private Integer numberOfSongs;
}

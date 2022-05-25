package com.Fuinco.Fuinco.Monitoring.entities;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Token {
    private Long userId;
    private String token;
    private String lastUpdate;

}

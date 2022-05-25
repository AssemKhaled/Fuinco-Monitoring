package com.Fuinco.Fuinco.Monitoring.entities;

import javax.persistence.*;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tc_points")
public class Points extends Attributes{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "latitude")
    private Double latitude;

    @Column(name = "longitude")
    private Double longitude;

    @Column(name = "delete_date")
    private String delete_date;

    @Column(name = "photo")
    private String photo;

    @Column(name = "userId")
    private Long userId;

}

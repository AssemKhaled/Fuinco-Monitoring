package com.Fuinco.Fuinco.Monitoring.entities;

import lombok.*;

import javax.persistence.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tc_user_client_geofence")
public class userClientGeofence {

    @Column(name = "userid")
    private Long userid;

    @Column(name = "geofenceid")
    private Long geofenceid;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

}

package com.Fuinco.Fuinco.Monitoring.entities;

import lombok.*;

import javax.persistence.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tc_user_client_device")
public class userClientDevice {
    @Column(name = "userid")
    private Long userid;

    @Column(name = "deviceid")
    private Long deviceid;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

}

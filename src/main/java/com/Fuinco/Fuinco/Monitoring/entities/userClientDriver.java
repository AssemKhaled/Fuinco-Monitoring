package com.Fuinco.Fuinco.Monitoring.entities;

import lombok.*;

import javax.persistence.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tc_user_client_driver")
public class userClientDriver {
    @Column(name = "userid")
    private Long userid;

    @Column(name = "driverid")
    private Long driverid;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

}

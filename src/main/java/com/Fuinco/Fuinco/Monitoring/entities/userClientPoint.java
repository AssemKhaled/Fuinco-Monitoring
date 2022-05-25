package com.Fuinco.Fuinco.Monitoring.entities;

import lombok.*;

import javax.persistence.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tc_user_client_point")
public class userClientPoint {
    @Column(name = "userid")
    private Long userid;

    @Column(name = "pointid")
    private Long pointid;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

}

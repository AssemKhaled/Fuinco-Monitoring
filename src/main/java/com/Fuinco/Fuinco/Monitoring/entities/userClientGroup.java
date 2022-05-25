package com.Fuinco.Fuinco.Monitoring.entities;

import lombok.AllArgsConstructor;
import lombok.*;

import javax.persistence.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tc_user_client_group")
public class userClientGroup {

    @Column(name = "userid")
    private Long userid;

    @Column(name = "groupid")
    private Long groupid;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
}

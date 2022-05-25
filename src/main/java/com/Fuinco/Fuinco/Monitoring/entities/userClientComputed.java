package com.Fuinco.Fuinco.Monitoring.entities;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tc_user_client_computed")
public class userClientComputed {
    @Column(name = "userid")
    private Long userid;

    @Column(name = "computedid")
    private Long computedid;

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

}

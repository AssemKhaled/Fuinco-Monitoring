package com.Fuinco.Fuinco.Monitoring.entities;

import lombok.*;

import javax.persistence.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name ="tc_users_tokens")
public class UserTokens {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "userid")
    private Long userid;

    @Column(name = "tokenid")
    private String tokenid;
}

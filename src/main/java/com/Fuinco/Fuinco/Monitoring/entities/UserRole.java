package com.Fuinco.Fuinco.Monitoring.entities;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tc_user_roles")
public class UserRole extends Attributes{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId")
    private Long roleId;

    @Column(name = "name")
    private String name;

    @Column(name = "permissions" , length = 100000)
    private String permissions ;

    @Column(name = "delete_date")
    private String delete_date;

    @Column(name = "userId")
    private Long userId;


}

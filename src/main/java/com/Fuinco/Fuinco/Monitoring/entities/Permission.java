package com.Fuinco.Fuinco.Monitoring.entities;

import javax.persistence.*;

import lombok.*;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tc_permissions")
public class Permission extends Attributes{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "functionality")
    private String functionality ;

    @Column(name = "delete_date")
    private String delete_date;

    @Column(name = "features")
    private String features;

}

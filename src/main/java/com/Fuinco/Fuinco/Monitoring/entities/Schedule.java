package com.Fuinco.Fuinco.Monitoring.entities;

import javax.persistence.*;
import lombok.*;
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tc_schedule")
public class Schedule extends Attributes{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "task")
    private String task;

    @Column(name = "expression")
    private String expression ;

    @Column(name = "delete_date")
    private String delete_date;

    @Column(name = "date")
    private String date;

    @Column(name = "date_type")
    private String date_type;

    @Column(name = "email")
    private String email;

    @Column(name = "userId")
    private Long userId;

}

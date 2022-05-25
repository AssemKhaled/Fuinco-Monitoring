package com.Fuinco.Fuinco.Monitoring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "tc_notifications")
public class Notification extends Attributes{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "type")
    private String type;

    @Column(name = "always")
    private boolean always;

    @Column(name = "calendarid")
    private Long calendarid;

    @Column(name = "notificators")
    private String notificators;

    @Column(name = "delete_date")
    private String delete_date;
    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "tc_user_notification",
            joinColumns = { @JoinColumn(name = "notificationid") },
            inverseJoinColumns = { @JoinColumn(name = "userid") }
    )
    private Set<User> userNotification = new HashSet<>();
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "notificationGroup")
    private Set<Group> groups = new HashSet<>();
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "notificationDevice")
    private Set<Device> devices = new HashSet<>();

}

package com.Fuinco.Fuinco.Monitoring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "tc_groups")
public class Group extends Attributes{
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "groupid")
    private Long groupid;

    @Column(name = "is_deleted")
    private String is_deleted=null;

    @Column(name = "type")
    private String type;
    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "tc_user_group",
            joinColumns = { @JoinColumn(name = "groupid") },
            inverseJoinColumns = { @JoinColumn(name = "userid") }
    )
    private Set<User> userGroup = new HashSet<>();

    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "tc_group_driver",
            joinColumns = { @JoinColumn(name = "groupid") },
            inverseJoinColumns = { @JoinColumn(name = "driverid") }
    )
    private Set<Driver> driverGroup = new HashSet<>();
    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "tc_group_geofence",
            joinColumns = { @JoinColumn(name = "groupid") },
            inverseJoinColumns = { @JoinColumn(name = "geofenceid") }
    )
    private Set<Geofence> geofenceGroup = new HashSet<>();
    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "tc_group_device",
            joinColumns = { @JoinColumn(name = "groupid") },
            inverseJoinColumns = { @JoinColumn(name = "deviceid") }
    )
    private Set<Device> deviceGroup = new HashSet<>();
    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "tc_group_notification",
            joinColumns = { @JoinColumn(name = "groupid") },
            inverseJoinColumns = { @JoinColumn(name = "notificationid") }
    )
    private Set<Notification> notificationGroup = new HashSet<>();
    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "tc_group_attribute",
            joinColumns = { @JoinColumn(name = "groupid") },
            inverseJoinColumns = { @JoinColumn(name = "attributeid") }
    )
    private Set<Attribute> attributeGroup = new HashSet<>();

}

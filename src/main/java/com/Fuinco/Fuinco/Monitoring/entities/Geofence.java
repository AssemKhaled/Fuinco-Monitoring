package com.Fuinco.Fuinco.Monitoring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "tc_geofences")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Geofence extends Attributes{
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "area")
    private String area;

    @Column(name = "type")
    private String type;

    @Column(name = "calendarid")
    private Integer calendarid=null;

    @Column(name = "is_deleted")
    private Integer is_deleted=null;

    @Column(name = "delete_date")
    private String delete_date=null;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "geofence"
    )
    private Set<Device> device = new HashSet<>();
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "tc_user_geofence",joinColumns = { @JoinColumn(name = "geofenceid") },
            inverseJoinColumns = { @JoinColumn(name = "userid") })
    private Set<User> userGeofence = new HashSet<>();
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "geofenceGroup")
    private Set<Group> groups = new HashSet<>();

}

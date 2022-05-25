package com.Fuinco.Fuinco.Monitoring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Builder
@Table(name = "tc_attributes")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

public class Attribute extends Attributes{

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "type")
    private String type;

    @Column(name = "attribute")
    private String attribute;

    @Column(name = "expression")
    private String expression;

    @Column(name = "delete_date")
    private String delete_date;
    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "tc_user_attribute",
            joinColumns = { @JoinColumn(name = "attributeid") },
            inverseJoinColumns = { @JoinColumn(name = "userid") }
    )
    private Set<User> userAttribute = new HashSet<>();
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "attributeGroup")
    private Set<Group> groups = new HashSet<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "attributeDevice")
    private Set<Device> devices = new HashSet<>();
}

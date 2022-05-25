package com.Fuinco.Fuinco.Monitoring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name ="tc_devices")
public class Device extends Attributes {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Override
    public String toString() {
        return "Device{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", uniqueid='" + uniqueid + '\'' +
                ", lastupdate='" + lastupdate + '\'' +
                ", positionid='" + positionid + '\'' +
                ", position_id='" + position_id + '\'' +
                ", phone='" + phone + '\'' +
                ", model='" + model + '\'' +
                ", plate_num='" + plate_num + '\'' +
                ", right_letter='" + right_letter + '\'' +
                ", middle_letter='" + middle_letter + '\'' +
                ", left_letter='" + left_letter + '\'' +
                ", plate_type=" + plate_type +
                ", reference_key='" + reference_key + '\'' +
                ", is_deleted=" + is_deleted +
                ", deleteDate='" + deleteDate + '\'' +
                ", init_sensor=" + init_sensor +
                ", init_sensor2=" + init_sensor2 +
                ", car_weight=" + car_weight +
                ", reject_reason='" + reject_reason + '\'' +
                ", sequence_number='" + sequence_number + '\'' +
                ", is_valid=" + is_valid +
                ", expired=" + expired +
                ", calibrationData='" + calibrationData + '\'' +
                ", fuel='" + fuel + '\'' +
                ", sensorSettings='" + sensorSettings + '\'' +
                ", lineData='" + lineData + '\'' +
                ", create_date='" + create_date + '\'' +
                ", lastWeight=" + lastWeight +
                ", owner_name='" + owner_name + '\'' +
                ", username='" + username + '\'' +
                ", owner_id='" + owner_id + '\'' +
                ", brand='" + brand + '\'' +
                ", made_year='" + made_year + '\'' +
                ", color='" + color + '\'' +
                ", license_exp='" + license_exp + '\'' +
                ", date_type=" + date_type +
                ", photo='" + photo + '\'' +
                ", icon='" + icon + '\'' +
                ", protocol='" + protocol + '\'' +
                ", port='" + port + '\'' +
                ", device_type='" + device_type + '\'' +
                ", regestration_to_elm_date=" + regestration_to_elm_date +
                ", representative='" + representative + '\'' +
                ", delete_from_elm='" + delete_from_elm + '\'' +
                ", delete_from_elm_date=" + delete_from_elm_date +
                ", update_date_in_elm=" + update_date_in_elm +
                ", simcardNumber='" + simcardNumber + '\'' +
                ", user_id=" + user_id +
                ", lastHum=" + lastHum +
                ", lastTemp=" + lastTemp +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", activity='" + activity + '\'' +
                ", groupid=" + groupid +
                ", contact='" + contact + '\'' +
                ", category='" + category + '\'' +
                ", disabled=" + disabled +
                ", numberOfSeats=" + numberOfSeats +
                ", taxiprofileId=" + taxiprofileId +
                ", driver_last_location_id='" + driver_last_location_id + '\'' +
                ", driver_reference_key='" + driver_reference_key + '\'' +
                ", driver_panic_button=" + driver_panic_button +
                ", passenger_panic_button=" + passenger_panic_button +
                ", slope=" + slope +
                ", factor=" + factor +
                ", driverId=" + driverId +
                ", activate_to_elm=" + activate_to_elm +
                ", user=" + user +
                ", driver=" + driver +
                ", geofence=" + geofence +
                ", groups=" + groups +
                ", notificationDevice=" + notificationDevice +
                ", attributeDevice=" + attributeDevice +
                '}';
    }

    @Column(name = "uniqueid")
    private String uniqueid;

    @Column(name = "lastupdate")
    private String lastupdate;

    @Column(name = "positionid")
    private String positionid;

    @Column(name = "position_id")
    private String position_id;

    @Column(name = "phone")
    private String phone;

    @Column(name = "model")
    private String model;

    @Column(name = "plate_num")
    private String plate_num;

    @Column(name = "right_letter")
    private String right_letter;

    @Column(name = "middle_letter")
    private String middle_letter;

    @Column(name = "left_letter")
    private String left_letter;

    @Column(name = "plate_type")
    private Integer plate_type;

    @Column(name = "reference_key")
    private String reference_key;

    @Column(name = "is_deleted")
    private Integer is_deleted=null;

    @Column(name = "delete_date")
    private String deleteDate =null;

    @Column(name = "init_sensor")
    private Integer init_sensor;

    @Column(name = "init_sensor2")
    private Integer init_sensor2;

    @Column(name = "car_weight")
    private Integer car_weight;

    @Column(name = "reject_reason")
    private String reject_reason;

    @Column(name = "sequence_number")
    private String sequence_number;

    @Column(name = "is_valid")
    private Integer is_valid;

    @Column(name = "expired")
    private Integer expired;

    @Column(name = "calibrationData",length=1080)
    private String calibrationData;

    @Column(name = "fuel",length=1080)
    private String fuel;

    @Column(name = "sensorSettings",length=1080)
    private String sensorSettings;

    @Column(name = "lineData")
    private String lineData;

    @Column(name = "create_date")
    private String create_date;

    @Column(name = "lastWeight")
    private Integer lastWeight;

    @Column(name = "owner_name")
    private String owner_name;

    @Column(name = "username")
    private String username;

    @Column(name = "owner_id")
    private String owner_id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "made_year")
    private String made_year;

    @Column(name = "color")
    private String color;

    @Column(name = "license_exp")
    private String license_exp;

    @Column(name = "date_type")
    private Integer date_type;

    @Column(name = "photo")
    private String photo;

    @Column(name = "icon")
    private String icon;

    @Column(name = "protocol")
    private String protocol;

    @Column(name = "port")
    private String port;

    @Column(name = "device_type")
    private String device_type;

    @Column(name = "regestration_to_elm_date")
    private Date regestration_to_elm_date;

    @Column(name = "representative")
    private String representative;

    @Column(name = "delete_from_elm")
    private String delete_from_elm;

    @Column(name = "delete_from_elm_date")
    private Date delete_from_elm_date;

    @Column(name = "update_date_in_elm")
    private Date update_date_in_elm;

    @Column(name = "simcardNumber")
    private String simcardNumber;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "lastHum")
    private Double lastHum = 0.0;

    @Column(name = "lastTemp")
    private Double lastTemp = 0.0;

    @Column(name = "start_date")
    private Date start_date;

    @Column(name = "end_date")
    private Date end_date;

    @Column(name = "activity")
    private String activity;

    @Column(name = "groupid")
    private Integer groupid;

    @Column(name = "contact")
    private String contact;

    @Column(name = "category")
    private String category;

    @Column(name = "disabled")
    private Integer disabled = 0;

    @Column(name = "numberOfSeats")
    private Integer numberOfSeats;

    @Column(name = "taxiprofileId")
    private Integer taxiprofileId;

    @Column(name = "driver_last_location_id")
    private String driver_last_location_id;

    @Column(name = "driver_reference_key")
    private String driver_reference_key;

    @Column(name = "driver_panic_button")
    private Integer driver_panic_button;

    @Column(name = "passenger_panic_button")
    private Integer passenger_panic_button;

    @Column(name = "slope")
    private Double slope = 0.0;

    @Column(name = "factor")
    private Double factor = 0.0;

    @Column(name = "driverId")
    private Long driverId;


    @Transient
    private Boolean activate_to_elm;
    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "tc_user_device",
            joinColumns = { @JoinColumn(name = "deviceid") },
            inverseJoinColumns = { @JoinColumn(name = "userid") }
    )

    private Set<User> user = new HashSet<>();
    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "tc_device_driver",
            joinColumns = { @JoinColumn(name = "deviceid") },
            inverseJoinColumns = { @JoinColumn(name = "driverid") }
    )

    private Set<Driver> driver = new HashSet<>();
    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "tc_device_geofence",
            joinColumns = {@JoinColumn (name = "deviceid")},
            inverseJoinColumns = {@JoinColumn(name = "geofenceid")}
    )
    private Set<Geofence> geofence = new HashSet<>();



    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "deviceGroup")
    private Set<Group> groups = new HashSet<>();




    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "tc_device_notification",
            joinColumns = { @JoinColumn(name = "deviceid") },
            inverseJoinColumns = { @JoinColumn(name = "notificationid") }
    )
    private Set<Notification> notificationDevice= new HashSet<>();





    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "tc_device_attribute",
            joinColumns = { @JoinColumn(name = "deviceid") },
            inverseJoinColumns = { @JoinColumn(name = "attributeid") }
    )
    private Set<Attribute> attributeDevice= new HashSet<>();




}

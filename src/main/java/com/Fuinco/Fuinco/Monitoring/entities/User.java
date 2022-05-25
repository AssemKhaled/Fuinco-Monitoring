package com.Fuinco.Fuinco.Monitoring.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="tc_users")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class User extends Attributes implements UserDetails {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column (name = "hashedpassword")
    private String password;

    @Column(name = "phone")
    private String phone;

    @Column(name = "commercial_num")
    private String commercial_num;

    @Column(name = "identity_num")
    private String identity_num;

    @Column(name = "company_num")
    private String company_num;

    @Column(name = "manager_name")
    private String manager_name;

    @Column(name = "manager_phone")
    private String manager_phone;

    @Column(name = "manager_mobile")
    private String manager_mobile;

    @Column(name = "commercial_reg")
    private String commercial_reg;

    @Column(name = "dateOfBirth")
    private String dateOfBirth;

    @Column(name = "dateType",columnDefinition = "int default 0")
    private Integer dateType;

    @Column(name = "reference_key")
    private String reference_key;

    @Column(name = "is_deleted")
    private Integer is_deleted=null;

    @Column(name = "company_phone")
    private String company_phone;

    @Column(name = "delete_date")
    private String delete_date;

    @Column(name = "photo")
    private String photo;

    @Column(name = "reject_reason")
    private String reject_reason;

    @Column(name = "Iscompany")
    private Integer IsCompany;

    @Column(name = "roleId")
    private Long roleId;

    @Column(name = "accountType",columnDefinition = "int default 0")
    private Integer accountType;

    @Column(name = "parents")
    private String parents;

    @Column(name = "create_date")
    private String create_date;

    @Column(name = "exp_date")
    private String exp_date;

    @Column(name = "regestration_to_elm_date")
    private Date regestration_to_elm_date;

    @Column(name = "delete_from_elm_date")
    private Date delete_from_elm_date;

    @Column(name = "update_date_in_elm")
    private Date update_date_in_elm;

    @Column(name = "extensionNumber")
    private String extensionNumber;

    @Column(name = "devicetype")
    private String devicetype;

    @Column(name = "app_token")
    private String app_token;

    @Column(name = "birth_date")
    private Date birth_date;
//
//    @Column(name = "date_type")
//    private Integer date_type;

    @JsonIgnore
    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "user"
    )
    private Set<Device> devices = new HashSet<>();

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    @JoinTable(
            name = "tc_user_user",
            joinColumns = { @JoinColumn(name = "manageduserid") },
            inverseJoinColumns = { @JoinColumn(name = "userid") }
    )
    private Set<User> usersOfUser = new HashSet<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "userDriver")
    private Set<Driver> drivers = new HashSet<>();

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "userGeofence")
    private Set<Geofence> geofences = new HashSet<>();






    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "userGroup")
    private Set<Group> groups = new HashSet<>();




    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "userNotification")
    private Set<Notification> notifications = new HashSet<>();


    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE},
            mappedBy = "userAttribute")
    private Set<Attribute> attribute = new HashSet<>();


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}

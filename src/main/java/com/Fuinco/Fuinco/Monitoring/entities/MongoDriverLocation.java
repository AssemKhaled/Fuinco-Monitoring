package com.Fuinco.Fuinco.Monitoring.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.Date;
import lombok.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "driver_location")
public class MongoDriverLocation {
    @Id
    @JsonIgnore
    private ObjectId _id;

    @Field("id")
    private Long id;

    @Field("driver_id")
    private Long driverId;

    @Field("driver_lat")
    private String driverLat;

    @Field("driver_long")
    private String driverLong;

    @Field("trip_id")
    private String tripId;

    @Field("location_time")
    private String locationTime;

    @Field("server_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date serverTime;

    @Field("speed")
    private Double speed;

    @Field("address")
    private String address;

    @Field("vehicle_status")
    private String vehicleStatus;

    @Field("driverEmergencyButtonStatus")
    private Boolean driverEmergencyButtonStatus;

    @Field("passengerEmergencyButtonStatus")
    private Boolean passengerEmergencyButtonStatus;

    @Field("current_trip_cost")
    private Double currentTripCost;

    @Field("distance")
    private Double distance;

    @Field("duration")
    private String duration;

    @Field("distance_cost")
    private Double distanceCost;

    @Field("waiting_cost")
    private Double waitingCost;

    @Field("number_of_passengers")
    private Integer numberOfPassengers;


    @Field("driver_name")
    private String driverName;

}

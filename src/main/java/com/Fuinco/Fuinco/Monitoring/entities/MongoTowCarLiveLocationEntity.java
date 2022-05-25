package com.Fuinco.Fuinco.Monitoring.entities;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Document(collection = "tow_car_live_location")
public class MongoTowCarLiveLocationEntity {

    @Id
    private ObjectId _id;

    private String referenceKey;

    private String driverReferenceKey;

    private Double latitude;

    private Double longitude;

    private Double velocity;

    private Double weight;

    private String locationTime;

    private String vehicleStatus;

    private String address;

    private String roleCode;

}

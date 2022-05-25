package com.Fuinco.Fuinco.Monitoring.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "tc_positions")
public class MongoPositions {
    @Id
    @JsonIgnore
    private ObjectId _id;

    private String protocol;

    private Long deviceid;

    private Date servertime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date devicetime;

    private Date fixtime;

    private Boolean valid;

    private Double latitude;

    private Double longitude;

    private Double altitude;

    private Double speed;

    private Double course;

    private String address;

    private Object attributes;

    private Double accuracy;

    private String network;

    private String deviceName;

    private String deviceReferenceKey;

    private String driverReferenceKey;

    private String driverName;

    private Long driverid;

    private Double weight;

}

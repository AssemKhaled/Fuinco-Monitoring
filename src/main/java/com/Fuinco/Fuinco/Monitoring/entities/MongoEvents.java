package com.Fuinco.Fuinco.Monitoring.entities;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;

import javax.persistence.Id;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "tc_events")
public class MongoEvents {
    @Id
    private ObjectId _id;

    private String type;

    private Date servertime;

    private Long deviceid;

    private String positionid;

    private Long geofenceid;

    private Object attributes;

    private Long maintinanceid;

    private String deviceName;

    private Long driverid;

    private String driverName;

    private Long userId;

}

package com.Fuinco.Fuinco.Monitoring.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Document(collection = "tc_activities")


public class MongoActivities {

    @Id
    @JsonIgnore
    private ObjectId _id;

    @Field("driver_id")
    private Integer driverId;

    @Field("company_id")
    private Long companyId;

    @Field("activity_type")
    private String activityType;

    @Field("attributes")
    private Object attributes;

    @Field("activity_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date activityTime;
}

package com.Fuinco.Fuinco.Monitoring.entities;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceWorkingHours {
    private String deviceTime;
    private String positionId;
    private Object attributes;
    private Long deviceId;
    private String deviceName;
    private String hours;
    private String startTime;
    private String endTime;
}

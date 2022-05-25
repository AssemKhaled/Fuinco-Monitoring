package com.Fuinco.Fuinco.Monitoring.entities;

import lombok.*;
import org.springframework.stereotype.Service;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BillingsList {
    private Long deviceNumbers;
    private String workingDate;
    private String ownerName;
}

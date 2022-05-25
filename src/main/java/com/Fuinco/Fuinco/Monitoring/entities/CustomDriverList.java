package com.Fuinco.Fuinco.Monitoring.entities;
import lombok.*;
import org.springframework.stereotype.Service;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomDriverList {
    private Long id;
    private String name;
    private String uniqueid;
    private String attributes;
    private String mobile_num;
    private String birth_date;
    private String email;
    private String reference_key;
    private String is_deleted;
    private String delete_date;
    private String reject_reason;
    private String date_type;
    private String is_valid;
    private String photo;
    private String companyName;
    private String create_date_elm;
    private String update_date_elm;
    private String delete_date_elm;


}

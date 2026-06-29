package com.example.ems.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeSummaryDTO {

    private Long id;
    private String name;
    private String department;

}

package com.capstone.fmsevent.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardResponseDTO {

    private Long totalEvents;
    private Integer livesImpacted;
    private Long totalVolunteers;
    private Integer totalParticipants;
}

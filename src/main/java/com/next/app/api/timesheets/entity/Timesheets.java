package com.next.app.api.timesheets.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "timesheets")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Timesheets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timesheetId;

    @Column(nullable = false)
    private Long employeeId;

    @Column
    private LocalDate workDate;

    @Column
    private int hoursWorked;

    //    public Long getTimesheetId() {
//        return timesheetId;
//    }
//
//    public void setTimesheetId(Long timesheetId) {
//        this.timesheetId = timesheetId;
//    }
//
//    public Long getEmployeeId() {
//        return employeeId;
//    }
//
//    public void setEmployeeId(Long employeeId) {
//        this.employeeId = employeeId;
//    }

}

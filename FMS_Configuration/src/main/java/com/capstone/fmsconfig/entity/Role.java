package com.capstone.fmsconfig.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table("Role")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {
    @Id
    @Column("RoleID")
    private Integer roleId;
    @Column("EmployeeID")
    private Integer employeeId;
    @Column("EmployeeName")
    private String  employeeName;
    @Column("Email")
    private String email;
    @Column("Role")
    private String role;
}

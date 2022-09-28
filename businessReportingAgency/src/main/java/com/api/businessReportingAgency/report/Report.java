package com.api.businessReportingAgency.report;

import com.api.businessReportingAgency.report.Period;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cnpj;
    private String descricao;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, unique = true)
    private Period periodo;
}

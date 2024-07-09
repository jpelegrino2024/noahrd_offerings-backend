package com.julioluis.offeringsbackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "transactions")
public class Settlement {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.DATE)
    private LocalDate transactionDate;
    @ManyToOne
    @JoinColumn(name = "offerings_id")
    private Offering offering;
    @ManyToOne
    @JoinColumn(name = "spents_id")
    private Spent spent;
}

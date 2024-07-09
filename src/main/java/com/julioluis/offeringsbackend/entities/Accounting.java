package com.julioluis.offeringsbackend.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity
public abstract class Accounting {
    @TableGenerator(name = "accounting_gen",table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_value")
    @Id @GeneratedValue(strategy = GenerationType.TABLE,generator = "accounting_gen")
    protected Long id;
    protected BigDecimal amount;
    protected String comment;
}

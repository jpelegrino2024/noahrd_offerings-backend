package com.julioluis.offeringsbackend.entities;

import com.julioluis.offeringsbackend.entities.helper.Transactionable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "spents")
public class Spent extends Accounting implements Transactionable {
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "spent_type_id")
    private SpentType spentType;
    @OneToMany(mappedBy = "spent", cascade = CascadeType.ALL)
    private Set<Settlement> transactions;


    @Override
    public void addSettlement(Settlement settlement) {
        if(Objects.nonNull(settlement)) {
            if (Objects.isNull(transactions)) {
                transactions = new HashSet<>();
            }
            settlement.setSpent(this);
            transactions.add(settlement);
        }
    }
}

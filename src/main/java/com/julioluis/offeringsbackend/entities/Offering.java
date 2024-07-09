package com.julioluis.offeringsbackend.entities;

import com.julioluis.offeringsbackend.entities.helper.Transactionable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "offerings")
public class Offering extends Accounting implements Transactionable {

    @OneToMany(mappedBy = "offering", cascade = CascadeType.ALL)
    private Set<Settlement> transactions;

    @Override
    public void addSettlement(Settlement settlement) {
        if(Objects.nonNull(settlement)) {
            if (Objects.isNull(transactions)) {
                transactions = new HashSet<>();
            }
            settlement.setOffering(this);
            transactions.add(settlement);
        }
    }
}

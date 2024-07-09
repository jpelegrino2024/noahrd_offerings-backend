package com.julioluis.offeringsbackend.entities.helper;

import com.julioluis.offeringsbackend.entities.Settlement;

public interface Transactionable {
    void addSettlement(Settlement settlement);
}

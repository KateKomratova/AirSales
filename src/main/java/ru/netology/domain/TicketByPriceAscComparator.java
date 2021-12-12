package ru.netology.domain;

import java.util.Comparator;

public class TicketByPriceAscComparator implements Comparator<TicketOffer> {

    @Override
    public int compare(TicketOffer t1, TicketOffer t2) {
        return t1.getTimeFlight() - t2.getTimeFlight();
    }
}

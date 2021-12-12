package ru.netology.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.TicketOffer;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketRepository {
    private TicketOffer[] tickets = new TicketOffer[0];

    public void save(TicketOffer ticket) {
        int length = tickets.length + 1;
        TicketOffer[] tmp = new TicketOffer[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public TicketOffer[] findAll() {
        return tickets;
    }

    public void removeById(int id) {
        int length = tickets.length - 1;
        TicketOffer[] tmp = new TicketOffer[length];
        int index = 0;
        for (TicketOffer ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
    }
}

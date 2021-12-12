package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;

@NoArgsConstructor
@Data
public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    void add(TicketOffer ticket) {
        repository.save(ticket);
    }

    private void findAll(TicketOffer ticket) {
        repository.findAll();
    }

    public void removeById(int id) {
        repository.removeById(id);
    }

    public TicketOffer[] searchBy(String from, String to) {
        TicketOffer[] result = new TicketOffer[0];
        for (TicketOffer ticket : repository.findAll()) {
            if (ticket.getFrom().equalsIgnoreCase((from)) && ticket.getTo().equalsIgnoreCase(to)) {
                TicketOffer[] tmp = new TicketOffer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
            Arrays.sort(result);
        }
        return result;
    }

}

package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    TicketOffer ticket1 = new TicketOffer(5, 15000, "MRV", "DME", 5000);
    TicketOffer ticket3 = new TicketOffer(12, 31000, "SVO", "MMK", 9000);
    TicketOffer ticket5 = new TicketOffer(18, 56000, "DME", "BKK", 10000);
    TicketOffer ticket6 = new TicketOffer(20, 19000, "MRV", "DME", 5000);
    TicketOffer ticket8 = new TicketOffer(30, 61000, "DME", "BKK", 10000);
    TicketOffer ticket9 = new TicketOffer(38, 55550, "DME", "BKK", 10000);


    @BeforeEach
    void setUp() {
        manager.add(ticket1);
        manager.add(ticket3);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket8);
        manager.add(ticket9);

    }


    @Test
    void shouldSearchByAirport() {
        TicketOffer[] expected = new TicketOffer[]{ticket1, ticket6};
        TicketOffer[] actual = manager.searchBy("MRV", "DME");

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchByAirportOneTicket() {
        TicketOffer[] expected = new TicketOffer[]{ticket3};
        TicketOffer[] actual = manager.searchBy("SVO", "MMK");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAirportThreeTickets() {
        TicketOffer[] expected = new TicketOffer[]{ticket9, ticket5, ticket8};
        TicketOffer[] actual = manager.searchBy("DME", "BKK");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAirportNonExistent() {
        TicketOffer[] expected = new TicketOffer[]{};
        TicketOffer[] actual = manager.searchBy("DME", "VKO");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAirportNullFirstField() {
        TicketOffer[] expected = new TicketOffer[]{};
        TicketOffer[] actual = manager.searchBy("", "MMK");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAirportNullSecondField() {
        TicketOffer[] expected = new TicketOffer[]{};
        TicketOffer[] actual = manager.searchBy("DMY", "");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAirportNull() {
        TicketOffer[] expected = new TicketOffer[]{};
        TicketOffer[] actual = manager.searchBy("", "");

        assertArrayEquals(expected, actual);
    }
}
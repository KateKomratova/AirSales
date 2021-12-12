package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.TicketByPriceAscComparator;
import ru.netology.domain.TicketOffer;
import ru.netology.repository.TicketRepository;

import static org.junit.jupiter.api.Assertions.*;

class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    TicketByPriceAscComparator comparator = new TicketByPriceAscComparator();
    TicketOffer ticket1 = new TicketOffer(5, 15000, "MRV", "DME", 5000);
    TicketOffer ticket3 = new TicketOffer(12, 31000, "SVO", "MMK", 9000);
    TicketOffer ticket5 = new TicketOffer(18, 56000, "DME", "BKK", 9000);
    TicketOffer ticket6 = new TicketOffer(20, 15000, "MRV", "DME", 6000);
    TicketOffer ticket8 = new TicketOffer(30, 61000, "DME", "BKK", 6000);
    TicketOffer ticket9 = new TicketOffer(38, 55550, "DME", "BKK", 10000);
    TicketOffer ticket10 = new TicketOffer(12, 31000, "SVO", "MMK", 7000);
    TicketOffer ticket11 = new TicketOffer(12, 31000, "SVO", "MMK", 7000);
    TicketOffer ticket12 = new TicketOffer(12, 6000, "PEZ", "DME", 2500);


    @BeforeEach
    void setUp() {
        manager.add(ticket1);
        manager.add(ticket3);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        manager.add(ticket11);
        manager.add(ticket12);

    }


    @Test
    void shouldSearchByAirportTwoTicket() {
        TicketOffer[] expected = new TicketOffer[]{ticket1, ticket6};
        TicketOffer[] actual = manager.searchBy("MRV", "DME", comparator);

        assertArrayEquals(expected, actual);
    }


    @Test
    void shouldSearchByAirportOneTicket() {
        TicketOffer[] expected = new TicketOffer[]{ticket12};
        TicketOffer[] actual = manager.searchBy("PEZ", "DME", comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAirportThreeTickets() {
        TicketOffer[] expected = new TicketOffer[]{ticket8, ticket5, ticket9};
        TicketOffer[] actual = manager.searchBy("DME", "BKK", comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAirportTwoTicketsEqualTime() {
        TicketOffer[] expected = new TicketOffer[]{ticket10, ticket11,ticket3};
        TicketOffer[] actual = manager.searchBy("SVO", "MMK", comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAirportNonExistent() {
        TicketOffer[] expected = new TicketOffer[]{};
        TicketOffer[] actual = manager.searchBy("DME", "VKO", comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAirportNullFirstField() {
        TicketOffer[] expected = new TicketOffer[]{};
        TicketOffer[] actual = manager.searchBy("", "MMK", comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAirportNullSecondField() {
        TicketOffer[] expected = new TicketOffer[]{};
        TicketOffer[] actual = manager.searchBy("DMY", "", comparator);

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAirportNull() {
        TicketOffer[] expected = new TicketOffer[]{};
        TicketOffer[] actual = manager.searchBy("", "", comparator);

        assertArrayEquals(expected, actual);
    }
}
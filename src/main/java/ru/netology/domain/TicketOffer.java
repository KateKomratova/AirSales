package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class TicketOffer implements Comparable<TicketOffer> {
    private int id;
    private int price;
    private String from;
    private String to;
    private int timeFlight;

    @Override
    public int compareTo(TicketOffer t) {
        return this.price - t.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TicketOffer that = (TicketOffer) o;
        return id == that.id && price == that.price && timeFlight == that.timeFlight && Objects.equals(from, that.from) && Objects.equals(to, that.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, from, to, timeFlight);
    }

    @Override
    public String toString() {
        return "TicketOffer{" +
                "id=" + id +
                ", price=" + price +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", timeFlight=" + timeFlight +
                '}';
    }
}

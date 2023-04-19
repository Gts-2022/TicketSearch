package ru.netology.domain;

public class Ticket implements Comparable<Ticket> {
    protected int id; // ID билета
    protected int price; // Стоимость билета
    protected String from;//Аэропорт вылета, вы можете использовать IATA-коды.

    protected String to;//Аэропорт прилёта, вы можете использовать IATA-коды.
    protected int travelTime;//Время в пути в минутах.

    public Ticket(int id, int price, String from, String to, int travelTime) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.travelTime = travelTime;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public int getTravelTime() {
        return travelTime;
    }

    @Override
    public int compareTo(Ticket o) {
        if (this.price < o.price) {
            return -1;
        } else if (this.price > o.price) {
            return 1;
        } else {
            return 0;
        }
    }
}

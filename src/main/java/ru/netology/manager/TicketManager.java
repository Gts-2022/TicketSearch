package ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

import java.util.Arrays;


public class TicketManager {
    private TicketRepository repository;

    public TicketManager(TicketRepository repository) {
        this.repository = repository;
    }

    public void addTicket(Ticket ticket) {
        repository.addTicket(ticket);

    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0]; // тут будем хранить подошедшие запросу, билеты
        for (Ticket ticket : repository.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                // System.arraycopy(result, 0, tmp, 0, result.length);//Заменяет 2 строчки выше
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }

    private boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().equals(from)) {
            if (ticket.getTo().equals(to)) {
                return true;
            }
        }
        return false;
    }
}

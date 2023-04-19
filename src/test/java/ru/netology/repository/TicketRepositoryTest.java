package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

public class TicketRepositoryTest {
    TicketRepository repository = new TicketRepository();
    Ticket ticket1 = new Ticket(1, 2000, "SVX", "VKO", 90);
    Ticket ticket2 = new Ticket(2, 4000, "SVX", "VKO", 80);
    Ticket ticket3 = new Ticket(3, 3000, "SVX", "VKO", 76);
    Ticket ticket4 = new Ticket(4, 2000, "VKO", "MRV", 103);
    Ticket ticket5 = new Ticket(5, 4500, "SVX", "VKO", 69);
    Ticket ticket6 = new Ticket(6, 3500, "SVX", "VKO", 99);

    @Test //Тест 1 (успешное удаление существующего билета по ID)
    public void successfullyDeletingExistingItem() {
        repository.addTicket(ticket1);
        repository.addTicket(ticket2);
        repository.addTicket(ticket3);
        repository.addTicket(ticket4);
        repository.addTicket(ticket5);
        repository.addTicket(ticket6);
        repository.removeById(3);
        Ticket[] expected = {ticket1, ticket2, ticket4, ticket5, ticket6};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //Тест 1 (Добавление билетов)
    public void successfullyDeletingExistingIte() {
        repository.addTicket(ticket1);
        repository.addTicket(ticket2);
        Ticket[] expected = {ticket1, ticket2};
        Ticket[] actual = repository.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }
}

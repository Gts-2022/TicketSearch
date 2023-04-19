package ru.netology.manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {
    TicketRepository repository = new TicketRepository();
    TicketManager manager = new TicketManager(repository);
    Ticket ticket1 = new Ticket(1, 2000, "SVX", "VKO", 90);
    Ticket ticket2 = new Ticket(2, 4000, "SVX", "VKO", 80);
    Ticket ticket3 = new Ticket(3, 3000, "SVX", "VKO", 76);
    Ticket ticket4 = new Ticket(4, 2000, "VKO", "MRV", 103);
    Ticket ticket5 = new Ticket(5, 4500, "SVX", "VKO", 69);
    Ticket ticket6 = new Ticket(6, 3500, "SVX", "VKO", 99);

    @Test//Тест 1
    public void shouldFindTicketsWithCorrectAirport() {
        // //Должен найти билеты с верными кодами аэропорта отправления и прибытия("SVX", "VKO" аэропорт)
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        Ticket[] expected = {ticket1, ticket3, ticket6, ticket2, ticket5};
        Ticket[] actual = manager.findAll("SVX", "VKO");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test//Тест 2
    public void shouldFindTicketsByPriceIfThereAreNone() {
        //Должен найти и отсортировать билеты, когда нет билетов
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("SVX", "VKO");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test//Тест 3
    public void shouldFindTicketsByPriceMinMaxIfOne() {
        //Должен найти все билеты по цене от min>max, если билет только 1("SVX","VKO" аэропорт)
        manager.addTicket(ticket2);

        Ticket[] expected = {ticket2};
        Ticket[] actual = manager.findAll("SVX", "VKO");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test//Тест 4
    public void sortingTicketsAtSamePrice() {
        //Должен найти и отсортировать все билеты, когда цена одинаковая
        Ticket ticket1 = new Ticket(1, 2000, "SVX", "VKO", 90);
        Ticket ticket2 = new Ticket(2, 2000, "SVX", "VKO", 80);
        Ticket ticket3 = new Ticket(3, 2000, "SVX", "VKO", 76);
        Ticket ticket4 = new Ticket(4, 2000, "SVX", "VKO", 103);
        Ticket ticket5 = new Ticket(5, 2000, "SVX", "VKO", 69);
        Ticket ticket6 = new Ticket(6, 2000, "SVX", "VKO", 99);
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5, ticket6};
        Ticket[] actual = manager.findAll("SVX", "VKO");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test//Тест 5
    public void shouldSortingAllTickets() {
        //Должен найти и отсортировать все билеты("SVX","VKO" аэропорт)
        Ticket ticket1 = new Ticket(1, 2000, "SVX", "VKO", 90);
        Ticket ticket2 = new Ticket(2, 4000, "SVX", "VKO", 80);
        Ticket ticket3 = new Ticket(3, 3000, "SVX", "VKO", 76);
        Ticket ticket4 = new Ticket(4, 2, "SVX", "VKO", 103);
        Ticket ticket5 = new Ticket(5, 20, "SVX", "VKO", 69);
        Ticket ticket6 = new Ticket(6, 200, "SVX", "VKO", 99);
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);

        Ticket[] expected = {ticket4, ticket5, ticket6, ticket1, ticket3, ticket2};
        Ticket[] actual = manager.findAll("SVX", "VKO");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test//Тест 6
    public void shouldFindOneTicketOutOfAll() {
        //Должен найти один билет из всех, который попадает под параметры Аэропортов("VKO", "SVX" аэропорт)
        Ticket ticket1 = new Ticket(1, 1000, "SVX", "VKO", 90);
        Ticket ticket2 = new Ticket(2, 2000, "SVX", "VKO", 80);
        Ticket ticket3 = new Ticket(3, 3000, "SVX", "VKO", 76);
        Ticket ticket4 = new Ticket(4, 4000, "VKO", "SVX", 103);
        Ticket ticket5 = new Ticket(5, 5000, "SVX", "VKO", 69);
        Ticket ticket6 = new Ticket(6, 6000, "SVX", "VKO", 99);
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.findAll("VKO", "SVX");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test //Тест 6
    public void shouldNotFindTicketsWithWrongAirportCodes() {
        //Не должен найти билеты с неправильными кодами аэропорта("ABC", "DFG" аэропорт)
        Ticket ticket1 = new Ticket(1, 1000, "SVX", "VKO", 90);
        Ticket ticket2 = new Ticket(2, 2000, "SVX", "VKO", 80);
        Ticket ticket3 = new Ticket(3, 3000, "SVX", "VKO", 76);
        Ticket ticket4 = new Ticket(4, 4000, "VKO", "SVX", 103);
        Ticket ticket5 = new Ticket(5, 5000, "SVX", "VKO", 69);
        Ticket ticket6 = new Ticket(6, 6000, "SVX", "VKO", 99);
        manager.addTicket(ticket1);
        manager.addTicket(ticket2);
        manager.addTicket(ticket3);
        manager.addTicket(ticket4);
        manager.addTicket(ticket5);
        manager.addTicket(ticket6);
        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("ABC", "DFG");
        Assertions.assertArrayEquals(expected, actual);
    }

}
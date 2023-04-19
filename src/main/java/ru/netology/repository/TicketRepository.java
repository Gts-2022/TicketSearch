package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {
    private Ticket[] tickets = new Ticket[0];// Создаем массив билетов

    public void addTicket(Ticket ticket) {//Метод добавления билетов
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];

        }
        tmp[tmp.length - 1] = ticket;
        tickets = tmp;
    }

    public void removeById(int id) {//Удалять по ID
      /*  Ticket[] remove = findAll();// Ищем товар ,который нужно удалить, используя метод findById
        if (remove == null) {//Если товар не находится , то подключаем исключение otFoundException
            throw new NotFoundException(id);
        }*/
        int length = tickets.length - 1;
        Ticket[] tmp = new Ticket[length];
        int copyToIndex = 0; //Переменная для сохоанения места, куда будет сохранятся новый массив
        for (Ticket ticket : tickets) {//Проходимся по всем билетам, которые сохранены в новом массиве
            if (ticket.getId() != id) { //Если у билета не такое id, которое хотим удалить
                tmp[copyToIndex] = ticket;//То мы его копируем в новый массив
                copyToIndex++;

            }
        }
        tickets = tmp;//Сохраняем новый массив в нашем поле
    }

    public Ticket[] findAll() { //Возвращение всех билетов
        return tickets;
    }
}

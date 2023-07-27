package Core;

import ClientApplication.EnterData;
import Interfaces.ICarrierRepo;
import Interfaces.ICashRepo;
import Models.Carrier;
import Models.Ticket;
import Models.User;
import Services.CarrierRepository;
import Services.CashRepository;


/**
 * Класс - провайдер для взаимодействия с банком и базой перевозчиков
 */
public class CashProvider extends EnterData {
    private ICarrierRepo carrierRepository;
    private ICashRepo cashRepository;


    /**
     * Конструктор класса
     */
    public CashProvider() {
        // Класс репозитория находится в единственном экземпляре для того, чтобы не создавать несколько подключений
        // к базе данных. Реализация паттерна Синглтон.
        this.carrierRepository = CarrierRepository.getCarrierRepository();
        this.cashRepository = CashRepository.getCashRepository();
    }


    /**
     * Метод покупки билета
     *
     * @param ticket билет
     * @return результат выполнения операции
     * @throws RuntimeException
     */
    // подсказка  Carrier carrier = carrierRepository.read(1);
    // подсказка  return cashRepository.transaction(ticket.getPrice(), cardNumber, carrier.getCardNumber());
    public boolean buy(Ticket ticket) {
        Carrier carrier = carrierRepository.read(1);
        long cardNumber = inputLong(1000_0000_0000_0000L, 9999_9999_9999_9999L);
        return cashRepository.transaction(ticket.getPrice(), cardNumber, carrier.getCardNumber());
    }


    /**
     * Метод авторизации клиента. Здесь должно быть реализовано обращение к банку для подтверждения личности клиента.
     *
     * @param client
     */
    public void authorization(User client) {
        if (client.getId() != 0){
            System.out.println("Accept");
        }
        else System.out.println("Not Accept");
    }
}

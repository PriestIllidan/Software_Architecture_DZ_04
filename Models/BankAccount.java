package Models;

/**
 * Модель банковского аккаунта
 */
public class BankAccount {
    private long card;
    private int balance;
    private long oldCard;


    public BankAccount() {
        this.card = oldCard + 1;
        oldCard = this.card;
        balance = 1000;
    }

    @Override
    public String toString() {
        return "BankAccount {" +
                " card= " + (String.format("%016d", card)) +
                ", balance= " + balance +
                " }";
    }

    public long getCard() {
        return card;
    }

    public int getBalance() {
        return balance;
    }

    public long getOldCard() {
        return oldCard;
    }

    public void setBalance(int i) {
    }
}

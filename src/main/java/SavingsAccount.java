public class SavingsAccount extends Account {   // сберегательный счет

    public SavingsAccount() {
        super(5000000);
    }

    @Override
    boolean pay(int amount) {
        System.out.println("Оплата с этого счета не возможна.");
        return false;
    }

    @Override
    boolean transfer(Account account, int amount) {
        if (amount > balance) {
            System.out.println("Средств на вашем счете не достаточно.");
            return false;
        } else {
            boolean result = account.addMoney(amount);
            if (result) {
                balance -= amount;
                System.out.println("Произведен перевод на сумму " + amount +
                        " руб. Оставшийся баланс вашего счета: " + balance + " руб.");
            } else {
                System.out.println("Перевод не будет выполнен.");
            }
            return result;
        }
    }

    @Override
    boolean addMoney(int amount) {
        balance += amount;
        System.out.println("Ваш счет пополнен на " + amount + " руб. Баланс счета: " + balance + " руб.");
        return true;
    }
}

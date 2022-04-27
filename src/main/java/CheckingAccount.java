public class CheckingAccount extends Account {       // расчетный счет
    public CheckingAccount() {
        super(1000000);
    }

    @Override
    boolean pay(int amount) {
        if (amount < balance) {
            balance -= amount;
            System.out.println("Произведена оплата в размере " + amount + " руб. Баланс счета: " + balance + " руб.");
            return true;
        } else {
            System.out.println("Средств на вашем счете не достаточно.");
            return false;
        }
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
                System.out.println("Перевод не будет произведен");
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

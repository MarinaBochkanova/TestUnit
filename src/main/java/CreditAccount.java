public class CreditAccount extends Account {     // кредитный счет

    public CreditAccount() {
        super(0);
    }

    @Override
    boolean pay(int amount) {
        balance -= amount;
        System.out.println("Произведена оплата в размере " + amount + " руб. Баланс счета: " + balance + " руб.");
        return true;
    }

    @Override
    boolean transfer(Account account, int amount) {
        balance -= amount;
        System.out.println("Произведен перевод на сумму " + amount +
                " руб. Баланс вашего счета: " + balance + " руб.");
        account.addMoney(amount);
        return true;
    }

    @Override
    boolean addMoney(int amount) {
        int addBalance = 0;
        addBalance = balance + amount;
        if (addBalance <= 0) {
            balance += amount;
            System.out.println("Ваш счет пополнен на " + amount + " руб. Баланс счета: " + balance + " руб.");
            return true;
        } else {
            int depositAmount = 0;
            depositAmount -= balance;
            System.out.println("Сумма пополнения этого счета не может превышать " + depositAmount + " руб.");
            return false;
        }
    }

}

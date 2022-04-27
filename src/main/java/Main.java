public class Main {


    public static void main(String[] args) {

        Account accountSav = new SavingsAccount();
        Account accountCred = new CreditAccount();
        Account accountCheck = new CheckingAccount();


        accountSav.transfer(accountCheck, 500000);
        System.out.println();
        accountSav.transfer(accountCred, 100000);
        System.out.println();
        accountCheck.addMoney(150000);
        System.out.println();
        accountCred.pay(200000);
        System.out.println();
        accountCred.addMoney(150000);
        System.out.println();
        accountCheck.transfer(accountCred, 50001);
        System.out.println();
        accountCheck.transfer(accountCred, 50000);
        System.out.println();
        accountSav.pay(100);
    }
}

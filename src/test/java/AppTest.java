import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class AppTest {

    @Test
    public void testConcat_validArgument_success() {
        SavingsAccount savingsAccount = new SavingsAccount();
        // given:
        Account account = new CheckingAccount();
        int amount = 150000;
        int expected = 4850000;
        // when:
        boolean booleanResult = savingsAccount.transfer(account, amount);
        int result = savingsAccount.balance;
        // then:
        Assertions.assertTrue(booleanResult);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testPaySavingAc() {
        SavingsAccount savingsAccount = new SavingsAccount();
        int amount = 100000;
        boolean result = savingsAccount.pay(amount);
        Assertions.assertFalse(result);
    }

    @ParameterizedTest
    @MethodSource("methodSource")
    public void testParamMethodSourceAddMoney(int amount, int expected) {
        CheckingAccount checkingAccount = new CheckingAccount();
        checkingAccount.addMoney(amount);
        int result = checkingAccount.balance;
        Assertions.assertEquals(expected, result);
    }

    static Stream<Arguments> methodSource() {
        return Stream.of(
                Arguments.of(200000, 1200000),
                Arguments.of(1500000, 2500000),
                Arguments.of(800000, 1800000)
        );
    }

    @ParameterizedTest
    @MethodSource("sourceCreditPay")
    public void testParamCreditPay(int amount, int expected) {
        CreditAccount creditAccount = new CreditAccount();
        creditAccount.pay(amount);
        int result = creditAccount.balance;
        Assertions.assertEquals(expected, result);
    }
    static Stream<Arguments> sourceCreditPay() {
        return Stream.of(
                Arguments.of(200000, -200000),
                Arguments.of(1500000, -1500000),
                Arguments.of(800000, -800000)
        );
    }



}

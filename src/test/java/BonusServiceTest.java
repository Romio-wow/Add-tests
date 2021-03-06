import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void calculate() {
        BonusService service = new BonusService();
// подготавливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;
// вызываем целевой метод:
        long actual = service.calculate(amount, registered);
// производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredUserUnderLimit() {
        BonusService service = new BonusService();
        long amount = 2000_60;
        boolean registered = false;
        long expected = 20;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForNotRegisteredUserOverLimit() {
        BonusService service = new BonusService();
        long amount = 3_400_000_60;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }


}
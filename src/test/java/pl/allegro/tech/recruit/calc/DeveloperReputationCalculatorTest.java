package pl.allegro.tech.recruit.calc;

import org.junit.jupiter.api.Test;
import pl.allegro.tech.recruit.calc.data.TestData1;

import java.time.Month;
import java.time.ZonedDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.times;


class DeveloperReputationCalculatorTest {

    private DeveloperReputationCalculator calculator;
    private TimeUtil timeUtil;

    void calculatorActual() {
        timeUtil = spy(TimeUtil.class);
        calculator = new DeveloperReputationCalculator(timeUtil);
    }

    void calculatorWithMockDate() {
        timeUtil = mock(TimeUtil.class);
        calculator = new DeveloperReputationCalculator(timeUtil);
    }

    @Test
    void testCalculateMethodFor3Followers_returnSuccess() {
        calculatorActual();
        int actual = calculator.calculate(TestData1.getDeveloperWith3());
        int expected = ZonedDateTime.now().getMonth() == Month.OCTOBER ? 16 : 6;
        assertEquals(expected, actual);
        verify(timeUtil).getZonedDateTime();
    }

    @Test
    void testCalculateMethodFor2Followers_returnSuccess() {
        calculatorActual();
        int actual = calculator.calculate(TestData1.getDeveloperWith2());
        int expected = ZonedDateTime.now().getMonth() == Month.OCTOBER ? 14 : 4;
        assertEquals(expected, actual);
    }

    @Test
    void testCalculateMethodFor2FollowersMockOctober_returnSuccess() {
        calculatorWithMockDate();
        when(timeUtil.getZonedDateTime()).thenReturn(TestData1.getMockDateOctober());
        int actual = calculator.calculate(TestData1.getDeveloperWith2());
        assertEquals(14, actual);
        verify(timeUtil, times(1)).getZonedDateTime();
    }

    @Test
    void testCalculateMethodFor2FollowersMockNotOctober_returnSuccess() {
        calculatorWithMockDate();
        when(timeUtil.getZonedDateTime()).thenReturn(TestData1.getMockDateNotOctober());
        int actual = calculator.calculate(TestData1.getDeveloperWith2());
        assertEquals(4, actual);
        verify(timeUtil).getZonedDateTime();
    }
}
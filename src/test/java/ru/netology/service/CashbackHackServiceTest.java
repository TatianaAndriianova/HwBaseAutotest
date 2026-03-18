package ru.netology.service;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CashbackHackServiceTest {

    private final CashbackHackService service = new CashbackHackService();

    // Обычная покупка — 900 руб, нужно докупить на 100
    @Test
    public void shouldReturnRemainFor900() {
        int amount = 900;
        int expected = 100;
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected);
    }

    // Покупка на 1 руб — нужно докупить на 999
    @Test
    public void shouldReturnRemainFor1() {
        int amount = 1;
        int expected = 999;
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected);
    }

    // Покупка на 500 руб — нужно докупить на 500
    @Test
    public void shouldReturnRemainFor500() {
        int amount = 500;
        int expected = 500;
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected);
    }

    // BUG: покупка ровно на 1000 руб — остаток должен быть 0, а не 1000
    @Test
    public void shouldReturnZeroWhenAmountIsExactlyBoundary() {
        int amount = 1000;
        int expected = 0;
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected); // Этот тест УПАДЁТ — баг в сервисе
    }

    // Покупка на 1500 руб — нужно докупить на 500
    @Test
    public void shouldReturnRemainFor1500() {
        int amount = 1500;
        int expected = 500;
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected);
    }

    // Покупка на 2000 руб — остаток должен быть 0, а не 1000
    @Test
    public void shouldReturnZeroWhenAmountIsMultipleOfBoundary() {
        int amount = 2000;
        int expected = 0;
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected); // Этот тест УПАДЁТ — баг в сервисе
    }
}

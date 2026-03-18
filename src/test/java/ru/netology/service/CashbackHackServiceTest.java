package ru.netology.service;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CashbackHackServiceTest {

    private final CashbackHackService service = new CashbackHackService();

    @Test
    public void shouldReturnRemainFor900() {
        int amount = 900;
        int expected = 100;
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnRemainFor1() {
        int amount = 1;
        int expected = 999;
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnRemainFor500() {
        int amount = 500;
        int expected = 500;
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnZeroWhenAmountIsExactlyBoundary() {
        int amount = 1000;
        int expected = 0;
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnRemainFor1500() {
        int amount = 1500;
        int expected = 500;
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void shouldReturnZeroWhenAmountIsMultipleOfBoundary() {
        int amount = 2000;
        int expected = 0;
        int actual = service.remain(amount);
        Assert.assertEquals(actual, expected);
    }
}

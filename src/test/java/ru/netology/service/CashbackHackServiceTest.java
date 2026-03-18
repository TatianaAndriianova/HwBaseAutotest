package ru.netology.service;

import org.junit.Assert;
import org.junit.Test;

public class CashbackHackServiceTest {

    private final CashbackHackService service = new CashbackHackService();

    @Test
    public void shouldReturnRemainFor900() {
        int expected = 100;
        int actual = service.remain(900);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnRemainFor1() {
        int expected = 999;
        int actual = service.remain(1);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnRemainFor500() {
        int expected = 500;
        int actual = service.remain(500);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroWhenAmountIsExactlyBoundary() {
        int expected = 0;
        int actual = service.remain(1000);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnRemainFor1500() {
        int expected = 500;
        int actual = service.remain(1500);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnZeroWhenAmountIsMultipleOfBoundary() {
        int expected = 0;
        int actual = service.remain(2000);
        Assert.assertEquals(expected, actual);
    }
}

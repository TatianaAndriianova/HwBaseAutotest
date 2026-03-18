# CashBackHacker

---

## Баг-репорт

### BUG-001: `remain()` возвращает 1000 вместо 0 при сумме, кратной 1000

**Серьёзность:** Major  
**Приоритет:** High

---

**Окружение:**

- ОС: Ubuntu 22.04 LTS x64 / Windows 10 x64
- Java: OpenJDK 11
- Gradle: 8.x
- TestNG: 7.1.0 (ветка `testng`) / JUnit: 4.13 (ветка `junit4`)

---

**Шаги для воспроизведения:**

1. Склонировать репозиторий:
   ```bash
   git clone https://github.com/username/cashbackhacker.git
   cd cashbackhacker
   ```
2. Переключиться на ветку с тестами:
   ```bash
   git checkout testng
   ```
3. Запустить тесты:
   ```bash
   ./gradlew test
   ```
4. Наблюдать падение теста `    shouldReturnZeroWhenAmountIsMultipleOfBoundary и shouldReturnZeroWhenAmountIsExactlyBoundary`

---

**Ожидаемый результат:**

`remain(1000)` возвращает `0` — пользователь уже потратил ровно 1000 рублей, кешбек будет начислен, докупать ничего не нужно.

**Фактический результат:**

`remain(1000)` возвращает `1000` — сервис ошибочно советует докупить ещё на 1000 рублей.

---

**Текст ошибки (лог консоли):**

```
FAILED: shouldReturnZeroWhenAmountIsExactlyBoundary
org.testng.TestException:
Expected [0] but found [1000]
  at org.testng.Assert.fail(Assert.java:96)
  at org.testng.Assert.failNotEquals(Assert.java:776)
  at org.testng.Assert.assertEquals(Assert.java:127)
  at ru.netology.service.CashbackHackServiceTest
      .shouldReturnZeroWhenAmountIsExactlyBoundary(CashbackHackServiceTest.java:34)
```
---

**Причина:**

В методе `remain()` используется выражение `boundary - amount % boundary`.  
При `amount = 1000`: `1000 % 1000 = 0`, затем `1000 - 0 = 1000` — результат некорректен.

---
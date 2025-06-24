package org.example;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Random;

public class BankAccount {
    private String Name;
    private Integer Balance = 0;
    private LocalDateTime DataOpen = LocalDateTime.now();
    private boolean AccountBlocked = false;
    private String AccountNumber; // Новое поле

    public BankAccount(String Name) {
        this.Name = Name;
        this.AccountNumber = generateAccountNumber(); // Генерируем при создании
    }

    public boolean deposit(int amount) {
        if (amount > 0) {
            Balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(int amount) {
        if (amount > 0 && Balance >= amount) {
            Balance -= amount;
            return true;
        }
        return false;
    }

    public boolean transfer(BankAccount otherAccount, int amount) {
        if (otherAccount == null) {
            return false;
        }
        if (this.withdraw(amount)) {
            otherAccount.deposit(amount);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "/////"+ "\n"+
                "Информация о клиенте:" + "\n"+
                "Имя владельца: " + Name + "\n" +
                "Баланс: " + Balance + "\n" +
                "Дата открытия: " + DataOpen + "\n" +
                "Номер счёта: " + AccountNumber + "\n" +
                "Статус аккаунта: " + (AccountBlocked ? "Заблокирован" : "Активен")+ "\n"+
                "//////" + "\n";
    }

    private String generateAccountNumber() {
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            accountNumber.append(random.nextInt(10));
        }
        return accountNumber.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BankAccount that)) return false;
        return Objects.equals(AccountNumber, that.AccountNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AccountNumber);
    }
}
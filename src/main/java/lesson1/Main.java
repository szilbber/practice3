package lesson1;

public class Main {
    public static void main(String[] args) {

        BankAccount accountIvan = new BankAccount("Иван");
        BankAccount accountPetr = new BankAccount("Петр");

        boolean depositSuccess1 = accountIvan.deposit(1000);
        System.out.println("Пополнение accountIvan на 1000: " + depositSuccess1);
        System.out.println(accountIvan.toString());
        boolean depositNegative = accountPetr.deposit(-500);
        System.out.println("Пополнение accountPetr на -500: " + depositNegative);
        System.out.println(accountPetr.toString());
        System.out.println();

        boolean withdrawSuccess = accountIvan.withdraw(300);
        System.out.println("Снятие с accountIvan 300: " + withdrawSuccess);
        System.out.println(accountIvan.toString());
        boolean withdrawTooMuch = accountPetr.withdraw(1000);
        System.out.println("Снятие с accountPetr 1000 (недостаточно средств): " + withdrawTooMuch);
        System.out.println(accountPetr.toString());
        System.out.println();

        boolean transferSuccess = accountIvan.transfer(accountPetr, 200);
        System.out.println("Перевод с accountIvan на accountPetr 200: " + transferSuccess);
        System.out.println(accountIvan.toString());
        System.out.println(accountPetr.toString());
        System.out.println();

        boolean transferNull = accountIvan.transfer(null, 100);
        System.out.println("Перевод на null аккаунт: " + transferNull);
        System.out.println();

        BankAccount accountIvan2 = new BankAccount("Иван"); // Новый объект с тем же именем

        System.out.println("accountIvan.equals(accountPetr)? " + accountIvan.equals(accountPetr));
        System.out.println("accountIvan.equals(accountIvan2)? " + accountIvan.equals(accountIvan2));

        System.out.println("hashCode accountIvan: " + accountIvan.hashCode());
        System.out.println("hashCode accountIvan2: " + accountIvan2.hashCode());
    }
}
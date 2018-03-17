package Testings;

public class TestingArgs {
    public static void checkPerson(Integer cnp, String nume, String adresa, Integer age) {
        if (cnp < 0) throw new IllegalArgumentException("CNP can not be negative");
        if (nume == null) throw new IllegalArgumentException("name can not be null");
        if (adresa == null) throw new IllegalArgumentException("adresa can not be null");
        if (age < 0 || age > 100) throw new IllegalArgumentException("illegal age");
    }

    public static void checkAccount(Integer suma, Integer interestRate) {
        if (suma <= 0) throw new IllegalArgumentException("suma can not be negative");
        if (interestRate < 0 || interestRate > 100) throw new IllegalArgumentException("interestRate is type %");
    }
}

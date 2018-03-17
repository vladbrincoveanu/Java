package Banca;

interface BankProc {

    void addClient(Person person);

    Person removeClient(Person person);

    Cont addAccount(Person person, Cont cont);

    Cont removeAccount(Person person, Cont cont);

    String readAccount(Person person, Cont cont);

    Person editClient(Person person, String nume, String adresa);

    Cont writeAccount(Person person, Cont cont, int interestRate, int balance);

}

package Banca;

import org.junit.jupiter.api.Assertions;

import java.util.Date;

class BancaTest {
    @org.junit.jupiter.api.Test
    void addClient() {
        Banca b = new Banca();
        Person person = new Person(302, "Ionel", "Albiniel", 30);
        b.addClient(person);
        assert (b.getDataBase().containsKey(person));
    }

    @org.junit.jupiter.api.Test
    void editClient() {
        Banca b = new Banca();
        Person a = b.editClient(b.getPersoane().get(0), "Alin", "aaaa");
        Assertions.assertEquals(b.getPersoane().get(0), a);
    }

    @org.junit.jupiter.api.Test
    void removeClient() {
        Banca b = new Banca();
        Person a = b.removeClient(b.getPersoane().get(0));
        assert (!b.getDataBase().containsKey(a));
    }

    @org.junit.jupiter.api.Test
    void addAccount() {
        Banca b = new Banca();
        Cont c = new SpendingAccount(1, 100, new Date());
        Cont a = b.addAccount(b.getPersoane().get(0), c);
        Assertions.assertEquals(c, a);
    }

    @org.junit.jupiter.api.Test
    void removeAccount() {
        Banca b = new Banca();
        Cont c = b.getContsOfUser(b.getPersoane().get(0)).get(0);
        Cont a = b.removeAccount(b.getPersoane().get(0), c);
        Assertions.assertEquals(c, a);
    }

    @org.junit.jupiter.api.Test
    void readAccount() {
        Banca b = new Banca();
        Cont c = b.getContsOfUser(b.getPersoane().get(0)).get(0);
        String a = b.readAccount(b.getPersoane().get(0), c);
        Assertions.assertEquals(c.toString(), a);
    }

    @org.junit.jupiter.api.Test
    void writeAccount() {
        Banca b = new Banca();
        Cont c = b.getContsOfUser(b.getPersoane().get(0)).get(0);
        Cont a = b.writeAccount(b.getPersoane().get(0), c, 10, 100);
        Assertions.assertEquals(c, a);
    }
}
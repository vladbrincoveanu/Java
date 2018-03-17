package Banca;

import java.io.Serializable;

public class Person implements Serializable, Observer {
    private final int cnp;
    private final int age;
    private String nume;
    private String adresa;

    Person(int cnp, String nume, String adresa, int age) {
        this.cnp = cnp;
        this.nume = nume;
        this.adresa = adresa;
        this.age = age;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (cnp != person.cnp) return false;
        if (age != person.age) return false;
        return (nume != null ? nume.equals(person.nume) : person.nume == null) && (adresa != null ? adresa.equals(person.adresa) : person.adresa == null);
    }

    public int hashCode() {
        int result = cnp;
        result = 31 * result + age;
        return result;
    }

    void setNume(String nume) {
        this.nume = nume;
    }

    void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String toString() {
        return cnp + " " + nume + " " + age + " " + adresa;
    }

    public void update(int id, int balance, int suma) {
        System.out.println();
        System.out.println("Hello " + nume + " pe accontul " + id + " s-a updatat stocul cu " + suma + ".Suma totala " + balance);
        System.out.println();
    }

}

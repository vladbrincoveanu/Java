package Banca;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;

@SuppressWarnings("ClassExplicitlyAnnotation")
public class Cont implements Serializable, Subject, DesiredField {
    @DesiredField
    private int id;
    @DesiredField
    private Date data; // data
    @DesiredField
    private int balance;
    @DesiredField
    private int interestRate;

    private ArrayList<Observer> observers = new ArrayList<Observer>();

    Cont() {
        super();
    }

    Cont(int id, int balance, Date data) {
        this.id = id;
        this.data = data;
        this.balance = balance;
    }

    Cont(int id, int balance, Date data, int interestRate) {
        this.id = id;
        this.data = data;
        this.balance = balance;
        this.interestRate = interestRate;
    }

    int getBalance() {
        return balance;
    }

    void refreshBalance(int suma) {
        this.balance = this.balance + suma;
        NotifyObservers(suma);
    }

    public String toString() {
        return id + " " + balance + " " + data + " " + interestRate;
    }

    public Class<? extends Annotation> annotationType() {
        return null;
    }

    public void AddObserver(Observer o) {
        observers.add(o);
    }

    public void RemoveObserver(Observer o) {
        observers.remove(o);
    }

    public void NotifyObservers(int suma) {
        for (Observer observer : observers) {
            observer.update(id, balance, suma);
        }
    }

}

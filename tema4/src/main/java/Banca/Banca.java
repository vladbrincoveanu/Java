package Banca;


import java.io.Serializable;
import java.util.*;

public class Banca implements BankProc, Serializable {

    private Map<Person, HashSet<Cont>> dataBase;
    private ArrayList<Person> persoane;

    public Banca(){
        dataBase = new HashMap<Person, HashSet<Cont>>();
        Person p = new Person(23, "Vasi", "Pestelui", 47);
        Cont c = new SavingsAccount(1, 3, 100, new Date());
        Cont c1 = new SpendingAccount(2, 100, new Date());
        dataBase.put(p, new HashSet<Cont>());
        dataBase.get(p).add(c1);
        dataBase.get(p).add(c);
        c.AddObserver(p);
        c.AddObserver(p);
        persoane = new ArrayList<Person>();
        persoane.add(p);
    }

    Map<Person, HashSet<Cont>> getDataBase() {
        return dataBase;
    }

    public void addClient(Person person) {
        assert (!dataBase.containsKey(person));
        dataBase.put(person, new HashSet<Cont>());
        persoane.add(person);
        for (Person p : persoane) System.out.println(p);
        assert (dataBase.containsKey(person));
    }

    public Person editClient(Person person, String nume, String adresa) {
        assert (dataBase.containsKey(person));
        for (Person p : dataBase.keySet()) {
            if (p.equals(person)) {
                person.setAdresa(adresa);
                person.setNume(nume);
            }
        }
        return person;
    }

    public Person removeClient(Person person) {
        assert (dataBase.containsKey(person));
        dataBase.remove(person);
        persoane.remove(person);
        assert (!dataBase.containsKey(person));
        return person;
    }

    public Cont addAccount(Person person, Cont cont) {
        HashSet<Cont> conts = dataBase.get(person);
        // assert(cont.getClass().getSuperclass().getName().equals("Cont"));
        boolean add = conts.add(cont);
        if (add) {
            assert (conts.contains(cont));
        }else{
            assert (!conts.contains(cont));
        }
        return cont;
    }

    public Cont removeAccount(Person person, Cont cont) {
        HashSet<Cont> conts = dataBase.get(person);
        assert (conts.contains(cont));
        boolean remove = conts.remove(cont);
        if (remove) {
            assert (!conts.contains(cont));
        } else assert (conts.contains(cont));
        assert (!conts.contains(cont));
        return cont;
    }

    public String readAccount(Person person, Cont cont) {
        HashSet<Cont> conts = dataBase.get(person);
        assert (dataBase.containsKey(person));
        assert (conts.contains(cont));
        for(Cont c: conts){
            if (c.equals(cont)) {
                return c.toString();
            }
        }
        return null;
    }

    public Cont writeAccount(Person person, Cont cont, int interestRate, int suma) {
        HashSet<Cont> conts = dataBase.get(person);
        Cont newCont=null;
        for(Cont c: conts){
            if (c.equals(cont)) {
                if (c.getClass().getName().substring(c.getClass().getName().lastIndexOf(".") + 1).equals("SavingsAccount")) {
                    if (c.getBalance() + suma > 0) {
                        c.refreshBalance(suma);
                        ((SavingsAccount) c).setInterestRate(interestRate);
                        newCont = c;
                    } else {
                        throw new IllegalArgumentException("Sum to large");
                    }
                } else if (c.getClass().getName().substring(c.getClass().getName().lastIndexOf(".") + 1).equals("SpendingAccount")) {
                    if (c.getBalance() + suma > 0) {
                        c.refreshBalance(suma);
                        newCont = c;
                    } else {
                        throw new IllegalArgumentException("Sum to large");
                    }
                } else {
                    assert false;
                }
            }
        }
        return newCont;
    }

    ArrayList<Cont> getContsOfUser(Person person) {
        HashSet<Cont> conts = dataBase.get(person);
        ArrayList<Cont> c = new ArrayList<Cont>();
        c.addAll(conts);
        return c;
    }

    ArrayList<Person> getPersoane() {
        return persoane;
    }

}

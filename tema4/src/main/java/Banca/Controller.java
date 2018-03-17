package Banca;

import Presentation.ViewController;
import Serializing.Serializing;
import Testings.TestingArgs;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;

public class Controller {
    private Person person = null;
    private ViewController viewController;
    private Banca banca;

    public Controller() {
        viewController = new ViewController();
        banca = Serializing.Deserialize();
        //   banca = new Banca();
        drawFrame();
        drawPersonPanel();
    }

    private void drawFrame() {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                viewController.showFrame();
            }
        });
    }

    private void drawPersonPanel() {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                viewController.showPersonPanel();
                addDeleteListener();
                addInsertListener();
                addEditListener();
                addViewAccountsListener();
                redrawJTable();
                fillFieldsPers();
                Serializing.Serialize(banca);
            }
        });
    }

    private void drawAccountPanel() {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                viewController.showAccountPanel();
                addDelete1Listener();
                addInsert1Listener();
                addAdaugaSumaListener();
                addRetrageSumaListener();
                BackListener();
                redrawJTable1(person);
                fillFieldsAccount();
                Serializing.Serialize(banca);
            }
        });
    }

    // Person PANEL
    private void addDeleteListener() {
        viewController.getPersPanel().addDeleteListener(new deleteMetod());
    }

    private void addInsertListener() {
        viewController.getPersPanel().addInsertListener(new insertMetod());
    }

    private void addEditListener() {
        viewController.getPersPanel().addEditListener(new editMetod());
    }

    private void addViewAccountsListener() {
        viewController.getPersPanel().addShowAccountsListener(new ViewAccount());
    }

    // Account PANEL
    private void addDelete1Listener() {
        viewController.getAccPanel().addDeleteListener(new deleteMetod());
    }

    private void addAdaugaSumaListener() {
        viewController.getAccPanel().addAdaugaSumaListener(new editMetod());
    }

    private void addRetrageSumaListener() {
        viewController.getAccPanel().addRetrageSumaListener(new editMetod());
    }

    private void addInsert1Listener() {
        viewController.getAccPanel().addInsertListener(new insertMetod());
    }

    private void BackListener() {
        viewController.getAccPanel().BackListener(new BackMetod());
    }

    private void redrawJTable() {
        final ArrayList<?> result = banca.getPersoane();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                viewController.getPersPanel().setTable(createTable(result));
            }
        });
    }

    private void redrawJTable1(Person person) {
        final ArrayList<Cont> c = banca.getContsOfUser(person);
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                viewController.getAccPanel().setTable(createTable(c));
            }
        });
    }

    private void fillFieldsPers() {
        viewController.getPersPanel().getCnp().setText("2130");
        viewController.getPersPanel().getNume().setText("Vlad");
        viewController.getPersPanel().getAdresa().setText("Turnului");
        viewController.getPersPanel().getVarsta().setText("21");
    }

    private void fillFieldsAccount() {
        viewController.getAccPanel().getSuma().setText("100");
        viewController.getAccPanel().getInterestRate().setText("0");

    }

    private JTable createTable(ArrayList<?> obj) {
        String[][] data;
        String[] columnNames;
        Field[] fields;
        int i = 0, j = 0;
        if (obj.get(0).getClass().getName().substring(obj.get(0).getClass().getName().lastIndexOf('.') + 1).equals("Person")) {
            int row = obj.size();
            int col = obj.get(0).getClass().getDeclaredFields().length;
            data = new String[row][col];
            columnNames = new String[col];
            for (Object o : obj) {
                fields = o.getClass().getDeclaredFields();
                for (Field f : fields) {
                    try {
                        f.setAccessible(true);
                        int index = f.getName().lastIndexOf('.');
                        columnNames[j] = f.getName().substring(index + 1);
                        data[i][j] = String.valueOf(f.get(o));
                        j++;
                    } catch (IllegalArgumentException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
                i++;
                j = 0;
            }
        } else {
            int row = obj.size();
            int col = obj.get(0).getClass().getSuperclass().getDeclaredFields().length - 1;
            data = new String[row][col];
            columnNames = new String[col];
            for (Object o : obj) {
                fields = o.getClass().getSuperclass().getDeclaredFields();
                for (Field f : fields) {
                    DesiredField annotation = f.getAnnotation(DesiredField.class);
                    if (annotation != null) {
                        try {
                            f.setAccessible(true);
                            int index = f.getName().lastIndexOf('.');
                            columnNames[j] = f.getName().substring(index + 1);
                            data[i][j] = String.valueOf(f.get(o));
                            j++;
                        } catch (IllegalArgumentException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
                i++;
                j = 0;
            }
        }
        return new JTable(data, columnNames);
    }

    private class ViewAccount implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int index = viewController.getPersPanel().getTable().getSelectedRow();
            person = banca.getPersoane().get(index);
            drawAccountPanel();
        }
    }

    private class BackMetod implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            drawPersonPanel();
        }
    }

    private class deleteMetod implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (viewController.getPersPanel() != null
                    && e.getSource().equals(viewController.getPersPanel().getBtnDelete())) {
                int index = viewController.getPersPanel().getTable().getSelectedRow();
                Person person = banca.getPersoane().get(index);
                banca.removeClient(person);
                drawPersonPanel();
            } else if (viewController.getAccPanel() != null
                    && e.getSource().equals(viewController.getAccPanel().getBtnDelete())) {
                int index = viewController.getAccPanel().getTable().getSelectedRow();
                Cont cont = banca.getContsOfUser(person).get(index);
                cont.RemoveObserver(person);
                banca.removeAccount(person, cont);
                drawAccountPanel();
            }
        }
    }

    private class insertMetod implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (viewController.getPersPanel() != null
                    && e.getSource().equals(viewController.getPersPanel().getInsertPerson())) {
                try {
                    Integer cnp = Integer.valueOf(viewController.getPersPanel().getCnp().getText());
                    String nume = viewController.getPersPanel().getNume().getText();
                    String adresa = viewController.getPersPanel().getAdresa().getText();
                    Integer age = Integer.parseInt(viewController.getPersPanel().getVarsta().getText());
                    TestingArgs.checkPerson(cnp, nume, adresa, age);
                    Person p = new Person(cnp, nume, adresa, age);
                    banca.addClient(p);
                } catch (NullPointerException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.INFORMATION_MESSAGE);
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.INFORMATION_MESSAGE);
                }
                drawPersonPanel();
            } else if (viewController.getAccPanel() != null
                    && e.getSource().equals(viewController.getAccPanel().getBtnAddSaving())) {
                try {
                    Integer suma = Integer.valueOf(viewController.getAccPanel().getSuma().getText());
                    Integer interestRate = Integer.valueOf(viewController.getAccPanel().getInterestRate().getText());
                    TestingArgs.checkAccount(suma, interestRate);
                    int index = banca.getDataBase().get(person).size() + 1;
                    Date d = new Date();
                    int interest = Math.abs((int)d.getTime()%100);
                    SavingsAccount cont ;
                    if(interestRate != 0){
                        cont = new SavingsAccount(index, interestRate, suma, d);
                    }else{
                        cont = new SavingsAccount(index, interest, suma, d);
                    }
                    banca.addAccount(person, cont);
                    cont.AddObserver(person);
                } catch (NullPointerException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.INFORMATION_MESSAGE);
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.INFORMATION_MESSAGE);
                }
                drawAccountPanel();
            } else if (viewController.getAccPanel() != null
                    && e.getSource().equals(viewController.getAccPanel().getBtnAddspending())) {
                try {
                    Integer suma = Integer.valueOf(viewController.getAccPanel().getSuma().getText());
                    TestingArgs.checkAccount(suma, 1);
                    int index = banca.getDataBase().get(person).size() + 1;
                    SpendingAccount cont = new SpendingAccount(index, suma, new Date());
                    banca.addAccount(person, cont);
                    cont.AddObserver(person);
                } catch (NullPointerException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.INFORMATION_MESSAGE);
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.INFORMATION_MESSAGE);
                }
                drawAccountPanel();
            }
        }
    }

    private class editMetod implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (viewController.getPersPanel() != null
                    && e.getSource().equals(viewController.getPersPanel().getBtnEdit())) {
                int index = viewController.getPersPanel().getTable().getSelectedRow();
                Person person = banca.getPersoane().get(index);
                try {
                    String nume = viewController.getPersPanel().getNume().getText();
                    String adresa = viewController.getPersPanel().getAdresa().getText();
                    TestingArgs.checkPerson(11, nume, adresa, 11);
                    banca.editClient(person, nume, adresa);
                } catch (NullPointerException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.INFORMATION_MESSAGE);
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.INFORMATION_MESSAGE);
                }
                drawPersonPanel();
            } else if (viewController.getAccPanel() != null
                    && e.getSource().equals(viewController.getAccPanel().getBtnAdd())) {
                int index = viewController.getAccPanel().getTable().getSelectedRow();
                Cont c = banca.getContsOfUser(person).get(index);
                try {
                    Integer suma = Integer.valueOf(viewController.getAccPanel().getSuma().getText());
                    Integer interestRate = Integer.valueOf(viewController.getAccPanel().getInterestRate().getText());
                    TestingArgs.checkAccount(suma, interestRate);
                    //int balance = suma + c.getBalance();
                    if (c.getClass().getName().substring(c.getClass().getName().lastIndexOf(".") + 1).equals("SpendingAccount")) {
                        banca.writeAccount(person, c, 0, suma);
                    } else {
                        //banca.writeAccount(person, c, ((SavingsAccount) c).getInterestRate(), suma);
                        JOptionPane.showMessageDialog(null, "Nu poti adauga la un cont de salvari.", null, JOptionPane.INFORMATION_MESSAGE);
                    }
                } catch (NullPointerException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.INFORMATION_MESSAGE);
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.INFORMATION_MESSAGE);
                }
                drawAccountPanel();
            } else if (viewController.getAccPanel() != null
                    && e.getSource().equals(viewController.getAccPanel().getBtnRetrage())) {
                int index = viewController.getAccPanel().getTable().getSelectedRow();
                Cont c = banca.getContsOfUser(person).get(index);
                try {
                    Integer suma = Integer.valueOf(viewController.getAccPanel().getSuma().getText());
                    Integer interestRate = Integer.valueOf(viewController.getAccPanel().getInterestRate().getText());
                    TestingArgs.checkAccount(suma, interestRate);
                    // int balance = c.getBalance() - suma;
                    //if (balance > 0) {
                    if (c.getClass().getName().substring(c.getClass().getName().lastIndexOf(".") + 1).equals("SpendingAccount")) {
                        banca.writeAccount(person, c, 0, -suma);
                    } else {
                        banca.writeAccount(person, c, ((SavingsAccount) c).getInterestRate(), -suma);
                    }
                    // } else {
                    //     throw new IllegalArgumentException("Sum to large!");
                    // }
                } catch (NullPointerException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.INFORMATION_MESSAGE);
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(null, e1.getMessage(), null, JOptionPane.INFORMATION_MESSAGE);
                }
                drawAccountPanel();
            }
        }
    }
}
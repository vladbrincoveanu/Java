package Banca;

import java.util.Date;

class SavingsAccount extends Cont {
    private int interestRate;

    SavingsAccount(int id, int interestRate, int balance, Date data) {
        super(id, balance, data, interestRate);
        this.interestRate = interestRate;
    }

    int getInterestRate() {
        return interestRate;
    }

    void setInterestRate(int interestRate) {
        this.interestRate = interestRate;
    }
}

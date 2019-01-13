package com.turchenkov.ChainOfResponsibility;

public class Program {

    public static void main(String[] args) {
        Receiver receiver = new Receiver(false, false, true);

        Payment bank = new BankPayment();
//        bank.handler(receiver);
        Payment payPal = new PayPalTransfer();
//        payPal.handler(receiver);
        bank.setSuccessor(payPal);
        bank.handler(receiver);
    }
}

class Receiver {

    boolean bankTransfer;
    private boolean moneyTransfer;
    boolean payPalTransfer;

    Receiver(boolean bankTransfer, boolean moneyTransfer, boolean payPalTransfer) {
        this.bankTransfer = bankTransfer;
        this.moneyTransfer = moneyTransfer;
        this.payPalTransfer = payPalTransfer;
    }

    public boolean isBankTransfer() {
        return bankTransfer;
    }

    public void setBankTransfer(boolean bankTransfer) {
        this.bankTransfer = bankTransfer;
    }

    public boolean isMoneyTransfer() {
        return moneyTransfer;
    }

    public void setMoneyTransfer(boolean moneyTransfer) {
        this.moneyTransfer = moneyTransfer;
    }

    public boolean isPayPalTransfer() {
        return payPalTransfer;
    }

    public void setPayPalTransfer(boolean payPalTransfer) {
        this.payPalTransfer = payPalTransfer;
    }
}

abstract class Payment {

    Payment successor;

    abstract void handler(Receiver receiver);

    Payment getSuccessor() {
        return successor;
    }

    void setSuccessor(Payment successor) {
        this.successor = successor;
    }
}

class BankPayment extends Payment {

    @Override
    void handler(Receiver receiver) {
        if (receiver.bankTransfer) {
            System.out.println("Doing bank transfer");
        } else if (getSuccessor() != null) {
            successor.handler(receiver);
        }
    }
}

class PayPalTransfer extends Payment {

    @Override
    void handler(Receiver receiver) {
        if (receiver.payPalTransfer) {
            System.out.println("Doing Paypal transfer");
        } else if (getSuccessor() != null) {
            successor.handler(receiver);
        }
    }
}
package com.KomSoft.lection8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    3. Создать класс Account с внутренним классом, с помощью объектов которого
    можно хранить информацию обо всех операциях со счетом (снятие, платежи, поступления).
*/
public class Account3 {

    public enum Operation {WITHDRAW, PAYMENT, INCOME};
//    public enum Currency {UAH, USD, EUR};
//    это я перестарался, счет только в одной валюте !
    private int id;
    private Currency accountCurrency;
    private final static int MAX_OPERATION = 100;
    private AccountOps[] accOps;
    private String firstName;
    private String lastName;
    private LocalDateTime creationDate;
    private int amount;
    private int opsCount;

    private class AccountOps {
        private LocalDateTime opsDate;
        private Operation opsType;
        private int opsAmount;

        public AccountOps(LocalDateTime opsDate, Operation opsType, int opsAmount) {
            this.opsDate = opsDate;
            this.opsType = opsType;
            this.opsAmount = opsAmount;
            switch (opsType) {
                case INCOME : {
                    amount += opsAmount;
                    break;
                }
                case PAYMENT:
                case WITHDRAW: {
                    amount -= opsAmount;
                    break;
                }
            }
        }

        public boolean isThisDay(int year, int month, int day) {
            return (year == opsDate.getYear() && month == opsDate.getMonthValue() && day == opsDate.getDayOfMonth() );
        }

        public String getTime() {
            return String.format("%02d:%02d:%02d", opsDate.getHour(), opsDate.getMinute(), opsDate.getSecond());
        }

        public Operation getOperation() {
            return opsType;
        }

        public int getOperationAmount() {
            return opsAmount;
        }

    }

    public Account3(String firstName, String lastName, Currency accCurrency) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountCurrency = accCurrency;
        id = LocalDateTime.now().getNano(); // ну хоть так
        creationDate = LocalDateTime.now();
        accOps = new AccountOps[MAX_OPERATION];
        opsCount = 0;
    }

    public Currency getAccountCurrency() {
        return accountCurrency;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getId() {
        return id;
    }
    public String getLastName() {
        return lastName;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public int getOpsCount() {
        return opsCount;
    }

    public int getAmount() {
        return amount;
    }

    public boolean addOperation(Operation opsType, int amount) {
        if(opsCount < MAX_OPERATION) {
            accOps[opsCount++] = new AccountOps(LocalDateTime.now(), opsType, amount);
            return true;
        } else {
            return false;
        }
    }

    public String[] getOperationByDate(int year, int month, int day) {
        int count = 0;
        for(int i = 0; i < opsCount; i++) {
           if (accOps[i].isThisDay(year, month, day)) {
               count++;
           }
        }
        if (count == 0) {
            return null;
        }
        String[] result = new String[count];
        for(int i=0; i < opsCount; i++) {
            if (accOps[i].isThisDay(year, month, day)) {
                result[result.length - count--] = "at " + accOps[i].getTime() + " -> " + accOps[i].getOperation() + " " + accOps[i].getOperationAmount();
            }
        }
        return result;
    }


}

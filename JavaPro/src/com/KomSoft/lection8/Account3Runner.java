package com.KomSoft.lection8;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

public class Account3Runner {

    public static void main(String[] args) throws InterruptedException {
        String[] str;

        Account3 acc5 = new Account3("John", "Doe", Currency.UAH);
        System.out.println("Please wait few seconds... Account is being created now.");
        TimeUnit.SECONDS.sleep(1);
        acc5.addOperation(Account3.Operation.INCOME, 500);
        TimeUnit.SECONDS.sleep(1);
        acc5.addOperation(Account3.Operation.INCOME, 1000);
        TimeUnit.SECONDS.sleep(1);
        acc5.addOperation(Account3.Operation.WITHDRAW, 70);
        TimeUnit.SECONDS.sleep(1);
        acc5.addOperation(Account3.Operation.PAYMENT, 65);
        TimeUnit.SECONDS.sleep(1);
        acc5.addOperation(Account3.Operation.PAYMENT, 30);
        TimeUnit.SECONDS.sleep(1);
        acc5.addOperation(Account3.Operation.WITHDRAW, 300);
        TimeUnit.SECONDS.sleep(1);
        acc5.addOperation(Account3.Operation.INCOME, 200);

        System.out.println("Счет " + acc5.getId() + " открыт " + acc5.getCreationDate().getDayOfMonth() + '.' +
                acc5.getCreationDate().getMonthValue() + '.' + acc5.getCreationDate().getYear() + " в " +
                acc5.getCreationDate().getHour() + ':' + acc5.getCreationDate().getMinute() + ':' + acc5.getCreationDate().getSecond() +
                "   на имя " + acc5.getFirstName() + ' ' + acc5.getLastName() + ". Валюта счета - " + acc5.getAccountCurrency());
        System.out.println("Всего операций по счету: " + acc5.getOpsCount() + ", остаток на счете: " + acc5.getAmount() + ' ' + acc5.getAccountCurrency());
//        System.out.println("Всего операций по счету: " + acc5.getOpsCount());
        str = acc5.getOperationByDate(LocalDate.now().getYear(), LocalDate.now().getMonthValue(), LocalDate.now().getDayOfMonth());
        System.out.println();
        System.out.println("На дату: " + LocalDate.now().getYear() + '.' + LocalDate.now().getMonthValue() + '.' + LocalDate.now().getDayOfMonth() +
                "  совершено " + str.length + " операций:");
        for(String s : str) {
            System.out.println(s);
        }
    }
}

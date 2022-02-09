package com.KomSoft.lection8;

import java.time.LocalDate;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    1.Создать класс Notepad с внутренним классом или классами,
    с помощью объектов которого могут храниться несколько записей на одну дату.
*/
public class Notepad {
    private static final int MAX_RECORD = 100;
    private static final int MAX_TASK = 10;
    private int countOfRecords;
    private Record[] dataRec;       // without sorting !!!

    private class Record {
        LocalDate rDate;
        String[] task;
        int taskCount = 0;

        public LocalDate getRDate() {
            return rDate;
        }

        public String getStringRDate() {
            return "" + rDate.getDayOfMonth() + '.' + rDate.getMonthValue() + '.' + rDate.getYear();
        }

        public int getTaskCount() {
            return taskCount;
        }

        public boolean tasksExist() {
            return this.taskCount != 0;
        }

        public boolean isThisDate(LocalDate date) {
            return (this.rDate.getYear() == date.getYear() ) && (this.rDate.getMonthValue() == date.getMonthValue()) && (this.rDate.getDayOfMonth() == date.getDayOfMonth());
        }

        public int taskExists(String task) {
            for(int i=0; i < taskCount; i++) {
                if(this.task[i].equalsIgnoreCase(task)) {   // task exists
                    return i;
                }
            }
            return -1;
        }

        public Record(LocalDate locDate, String task) {
            this.rDate = locDate;
            this.task = new String[MAX_TASK];
            this.task[taskCount++] = task;
        }

        public boolean deleteTask(String task) {
            int i = this.taskExists(task);
            if( i >= 0) {
                for(int j=i; j < taskCount-1; j++) {
                    this.task[j] = this.task[j+1];
                }
                taskCount--;
                return true;
            } else {
                return false; //    task not found
            }
        }

        public boolean addTask(String task) {
            if(taskCount < MAX_TASK) {
                if (this.taskExists(task) < 0 ) {   // add the task
                    this.task[taskCount++] = task;
                    return true;
                }
            }
            return false;
        }

        public String getTasks() {
            if (taskCount == 0 ) {
                return "No tasks for this date.";
            }
            String str = "";
            for(int i=0; i < taskCount; i++) {
                str += this.task[i] + '\n';
            }
            return str;
        }

        public String getTasksWithDate() {
            String str = "The date " + rDate.getDayOfMonth() + '.' + rDate.getMonthValue() + '.' + rDate.getYear();
            str += " has " + taskCount + " tasks:\n" + this.getTasks();
            return str;
        }
    }

    public Notepad() {
        dataRec = new Record[MAX_RECORD];
        countOfRecords = 0;
    }

    public Notepad(LocalDate date, String task) {
        dataRec = new Record[MAX_RECORD];
        countOfRecords = 0;
        addTask(date, task);
    }

    public boolean addTask(LocalDate date, String task) {
        for(int i=0; i < countOfRecords; i++) {
            if(dataRec[i].isThisDate(date)) { // date exists, add the task
                return dataRec[i].addTask(task);
            }
        }
        if (countOfRecords < MAX_RECORD){ //    add a date with the task
            dataRec[countOfRecords++] = new Record(date, task);
            return true;
        } else {        // no free date
            return false;
        }
    }

    public boolean addTask(int year, int month, int day, String task) {
        return addTask(LocalDate.of(year, month, day), task);
    }

    public boolean deleteDate(LocalDate date) {
        for(int i=0; i < countOfRecords; i++) {
            if (dataRec[i].isThisDate(date)) { // delete record. TODO - Удаляет только первую встретившуюся запись!!!
                for(int j=i; j < countOfRecords - 1; j++) {
                    dataRec[j] = dataRec[j+1];
                }
                countOfRecords--;
                return true;
            }
        }
        return false;
    }

    public boolean deleteDate(int year, int month, int day) {
        return deleteDate(LocalDate.of(year, month, day));
    }

    public boolean deleteTask(String task) {
        boolean result;
        for(int i=0; i < countOfRecords; i++) {
            if (dataRec[i].taskExists(task) >= 0 ) {        // task found
                result = dataRec[i].deleteTask(task);
                if (!dataRec[i].tasksExist()) {
                    //  можем удалить и всю запись, если задач не осталось
                    result = result & this.deleteDate(dataRec[i].getRDate());
                }
            return result;
            }
        }
        return false;
    }

    public void getTasksByDate(LocalDate date) {
        for(int i=0; i < countOfRecords; i++) {
            if(dataRec[i].isThisDate(date)) {
                System.out.println(dataRec[i].getTasks());
                break;
            }
        }
    }

    public void printPlan() {
        System.out.println("Notepad has " + countOfRecords + " record(s)");
        for(int i=0; i < countOfRecords; i++) {
            System.out.println("Date " + dataRec[i].getStringRDate() + " has " + dataRec[i].taskCount + " task(s)");
        }
        System.out.println();
    }

    public void printFullPlan() {
        System.out.println("Notepad has " + countOfRecords + " record(s)");
        for(int i=0; i < countOfRecords; i++) {
            System.out.println(dataRec[i].getTasksWithDate());
        }
        System.out.println();
    }
}

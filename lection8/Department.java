package com.KomSoft.lection8;

import java.time.LocalDate;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    5. Создать класс Department с внутренним классом, с помощью объектов
    которого можно хранить информацию обо всех должностях отдела и обо
    всех сотрудниках, когда-либо занимавших конкретную должность.
*/
public class Department {
    private final int MAX_RECORDS = 100;
    private final int MAX_PERSONS_RECORDS = 100;
    public String depName;
    private int depId;
    private Position[] positions;
    private int posCount;

    public Department(String depName, int depId) {
        this.depName = depName;
        this.depId = depId;
        positions = new Position[MAX_RECORDS];
        posCount = 0;
    }

    public int getActivePositionCount() {
        int count = 0;
        for(int i = 0; i < posCount; i++) {
            if(positions[i].isActive()) {
                count++;
            }
        }
        return count;
    }

    public String getActivePositionList() {
        String str = "Отдел '" + depName + "', всего должностей - " + posCount + ", активных - " + getActivePositionCount() + '\n';
        for(int i = 0; i < posCount; i++) {
            if(positions[i].isActive()) {
//                str += "\t(id:" + positions[i].getId() + ") " + positions[i].getShortHistory() + '\n';
                str += '\t' + positions[i].getShortHistory();
            }
        }
        return str;
    }

    public String getAllPositionList() {
        String str = "Отдел '" + depName + "', всего должностей - " + posCount + ", активных - " + getActivePositionCount() + '\n';
        for(int i = 0; i < posCount; i++) {
            str += '\t' + positions[i].getShortHistory();
        }
        return str;
    }

    public int getAllPositionCount() {
        return posCount;
    }

    public int getPositionById(int id) {
        for(int i = 0; i < posCount; i++) {
            int temp = positions[i].getId();
//            if(positions[i].getId() == id) {
            if(temp == id) {
                return i;
            }
        }
        return -1;
    }

    public boolean addPosition(int id, String position) {
        if(posCount >= MAX_RECORDS || getPositionById(id) != -1) {
            return false;       // некуда или така должность уже есть
        }
        positions[posCount++] = new Position(position, id);
        return true;
    }

    public void activatePosition(int id) {
        // не заморачиваемся с результатом boolean, для примера делаем void
        int ind = getPositionById(id);
        if(ind != -1) {
            positions[ind].setActive();
        }
    }

    public void deactivatePosition(int id) {
        // не заморачиваемся с результатом boolean, для примера делаем void
        int ind = getPositionById(id);
        if(ind != -1) {
            positions[ind].setInActive();
        }
    }

    public void hireAtPosition(int posId, String firstName, String lastName, int personId, LocalDate date) {
        // не заморачиваемся с результатом boolean, для примера делаем void
        int ind = getPositionById(posId);
        if(ind != -1) {
            positions[ind].hirePerson(firstName, lastName, personId, date);
        }
    }

    public void fireFromPosition(int posId, int personId, LocalDate date) {
        // не заморачиваемся с результатом boolean, для примера делаем void
        int ind = getPositionById(posId);
        if(ind != -1) {
            positions[ind].firePerson(personId, date);
        }
    }

    public String getEmployeeAtPosition(int posId) {
        int ind = getPositionById(posId);
        if(ind == -1) {
            return "Должности с id=" + posId + " не существует";
        }
        return  "(id:" + positions[ind].posId + ") " + positions[ind].posName + " - " + positions[ind].getEmployee();
    }

    public String getPositionHistory(int posId) {
        int ind = getPositionById(posId);
        if(ind == -1) {
            return "Должности с id=" + posId + " не существует";
        }
        return positions[ind].getHistory();
    }

    // inner class PersonAtPosition
    private class PersonAtPosition {    // может наследовать какой-либо класс Person, а может просто создаваться локальная запись.
        private String firstName;
        private String lastName;
        private int id;
        private LocalDate hireDate;
        public LocalDate fireDate = null;

        public PersonAtPosition(String firstName, String lastName, int id, LocalDate date) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.id = id;
            this.hireDate = date;
        }

        public boolean fire(int id, LocalDate date) {
            if(this.id == id) {
                fireDate = date;
                return true;
            } else {
                return false;       // не то человек
            }
        }

        public boolean isHired() {
            return fireDate == null;        // если не уволен, значит работает, должность занята
        }

        // getters, сеттеров не будет
        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public int getId() {
            return id;
        }

        public LocalDate getHireDate() {
            return hireDate;
        }

        public LocalDate getFireDate() {
            return fireDate;
        }

        @Override
        public String toString() {
            String str = getFirstName() + ' ' + getLastName() + " (id: " + id + "), назначен: " + hireDate.toString();
            if(!isHired()) {
                str += ", уволен: " + fireDate.toString();
            }
            return str;
        }
    }

    // end of inner class PersonAtPosition

    // inner class Position
    public class Position {
        private String posName;
        private int posId;
        private PersonAtPosition[] persons;
        private int recCount = 0;
        private boolean active;     // активна ли должность. Можно еще хранить даты, когда создана, сокращена и т.д.

        public int getId() {
            return posId;
        }

        public boolean isActive() {
            return active;
        }

        public void setActive() {   // ввести (возобновить) должность
            // можно проверять posId
            this.active = true;
        }

        public void setInActive() {     // сократить должность
            // можно проверять posId
            if(!isOccupied()) {         // нельзя сократить занятую должность, нужно вначале уволить сотрудника
                this.active = false;
            }
        }

        public Position(String posName, int posId) {
            this.posName = posName;
            this.posId = posId;
            persons = new PersonAtPosition[MAX_PERSONS_RECORDS];    // конечно List предпочтительней
            active = true;
        }

        public boolean isOccupied() {
            return recCount != 0 && persons[recCount-1].isHired();  // если есть записи и нанятый сотрудник
        }

        public boolean hirePerson(String firstName, String lastName, int id, LocalDate date) { // назначить человека
            if(recCount >= MAX_PERSONS_RECORDS || !active || isOccupied())  {
                return false;   // назначать некуда
            }
            persons[recCount++] = new PersonAtPosition(firstName, lastName, id, date);
            return true;
        }

        public boolean firePerson(int id, LocalDate date) {     // уволить человека, работаем только по id
            if(recCount == 0 || !active || !persons[recCount-1].isHired()) {
                return false;               // нет записей или не активна или уже уволен
            }
            return persons[recCount-1].fire(id, date);
        }

        public String getEmployee() {
            // активный у нас только последний
            if(!active) {
                return "не активна";
            }
            if(isOccupied()) {
                return "на должности работает: " + persons[recCount-1].toString();
            } else {
                return "вакантна";
            }
        }

        public String getShortHistory() {
            String str = "(id:" + posId + ") " + posName + ", записей - " + recCount;
            str += active ? " (активна).\n" : " (неактивна).\n";
            return str;
        }

        public String getHistory() {
            String str = getShortHistory();
            for(int i = 0; i < recCount; i++) {
                str += persons[i].toString() + '\n';
            }
            return str;
        }
    }
    // end of inner class Position

}

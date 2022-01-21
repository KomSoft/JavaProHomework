package com.KomSoft.lection8;

import java.time.LocalDate;
import java.util.ArrayList;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    7. Создать класс Европа с внутренним классом, с помощью объектов которого можно хранить
    информацию об истории изменения территориального деления на государства.
    Х.з. как это сделать, будем заносить инфу про новые и старые страны.
*/
public class Europe {
    public final String NAME = "Europe";
    public ArrayList<Country> countryList;
    private int uniqueId = 0;


    // inner class Country
    public class Country {
        private final String countryName;
        private final int countryId;
        private final LocalDate creationDate;
        private final LocalDate changeDate;
        private LocalDate disappearDate = null;
        public float area;
        public int population; // не Китай, пока хватит, можно long
        // ... etc.

        public Country(String countryName, LocalDate date) {
            this.countryName = countryName;
            for(Country c : countryList) {
                if (c.countryName.equalsIgnoreCase(countryName)) {  // есть такая страна
                    countryId = c.countryId;       // id уже есть
                    this.creationDate = c.creationDate;
                    this.changeDate = date;
                    return;
                }
            }
            // новая страна
            this.countryId = uniqueId++;        // присвоить ID и увеличить его для подсчетов
            this.creationDate = date;
            this.changeDate = date;
        }

        public void disappear(LocalDate disappearDate) {
            if(disappearDate.isAfter(this.creationDate) && this.disappearDate == null) {
                this.disappearDate = disappearDate;
            }
        }

        public boolean isExist(LocalDate date) {
            return (creationDate.isBefore(date) && (disappearDate == null || disappearDate.isAfter(date)));
        }

        @Override
        public String toString() {
            StringBuilder str = new StringBuilder(countryName);
            str.append(" (id:").append(countryId).append("), was created ").append(creationDate.toString()).append(", changed ").append(changeDate.toString());
            if(disappearDate != null) {
                str.append(", disappeared ").append(disappearDate.toString());
            }
            return str.toString();
        }
    }
    // end of inner class Country

    public Europe() {
        countryList = new ArrayList<>();
//        uniqueId = 0;
    }

    public int getCountOfUniqueCountry() {
        return uniqueId;
    }

    public boolean addChange(String countryName, LocalDate date) {
        return countryList.add(new Country(countryName, date));
    }

    public String[] getUniqueCountryList() {
        String[] cList = new String[uniqueId];
        for(Country c : countryList) {
           if(cList[c.countryId] == null) {
               cList[c.countryId] = c.countryName + " (id:" + c.countryId + ")";
           }
        }
        return cList;
    }

    public void delCountry(String countryName, LocalDate date) {
        for(Country c : countryList) {
            if (c.countryName.equalsIgnoreCase(countryName) && c.isExist(date)) {  // есть такая страна
                c.disappear(date);         // установить, что ее больше нет
            }
        }
    }

    public String[] getFullHistory() {
        String[] cList = new String[countryList.size()];
        for(int i = 0; i < countryList.size(); i++) {
            cList[i] = countryList.get(i).toString();
        }
        return cList;
    }

    public String[] getHistoryOnDate(LocalDate date) {
        String[] cList = new String[countryList.size()];
        StringBuilder str;
        for(int i = 0; i < countryList.size(); i++) {
            str = new StringBuilder(countryList.get(i).countryName);
            str.append(" (id:").append(countryList.get(i).countryId);
            str.append("), was created " + countryList.get(i).creationDate.toString() + ", changed " + countryList.get(i).changeDate.toString());
            // если бы не эта проверка по дате, можно было бы через toString класса
            if(!countryList.get(i).isExist(date)) {
                str.append(", disappeared " + countryList.get(i).disappearDate.toString());
            }
//            str.append("\n");
            cList[i] = str.toString();
        }
        return cList;
    }

}

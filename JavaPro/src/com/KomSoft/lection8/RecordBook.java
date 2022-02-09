package com.KomSoft.lection8;

import java.time.LocalDate;

/*
    Created by Volodymyr P. Komarov aka KomSoft
*/
/*
    4. Создать класс Зачетная Книжка с внутренним классом, с помощью объектов которого
    можно хранить информацию о сессиях, зачетах, экзаменах.
*/
public class RecordBook {
    private final int MAX_RECORDS = 20;
    private final int MAX_EXAMS_PER_SESSION = 20;   // с учетом пересдач
    private String firstName;       // имя и фамилию менять нельзя
    private String lastName;
    private String faculty; // при переходе на другой факультет выдадут новую зачетку
    public String group;    // разрешим переходить в другую группу
    private int id;
    private LocalDate issueDate;
    public SessionRecord[] session;
    private int recordsCount;

    public RecordBook(String firstName, String lastName, String faculty, String group, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
        this.group = group;
        this.id = id;
        session = new SessionRecord[MAX_RECORDS];
        recordsCount = 0;
        issueDate = LocalDate.now();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getId() {
        return id;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public int getRecordsCount() {
        return recordsCount;
    }

    public double getAverageScore() {
        double aScore = 0;
        for(int i = 0; i < recordsCount; i++) {
            aScore += session[i].getAverageScore();
        }
        return aScore;
    }

    // добавляем без возвращаемого значения, просто проверяем на переполенние
    // удалять и редактировать сессии нельзя.
    public void addSession(LocalDate startDate, LocalDate endDate) {
        if(recordsCount < MAX_RECORDS) {
            session[recordsCount++] = new SessionRecord(startDate, endDate);
        }
    }

    public String getBookInfo() {
        String str = "Студент " + firstName + ' ' + lastName + " (id: " + id + "), факультет: " + faculty + ", группа: " + group;
        int count = 0;
        for(int i = 0; i < recordsCount; i++) {
            if(session[i].isClosed()) {
                count++;
            }
        }
        str += '\n' + "Зачетка выдана: " + issueDate.toString() + ". Запланировано сессий: " + recordsCount + ", cдано: " + count;
        return str;
    }

    public String getShortInfo() {
        String str = "";
//        str = getBookInfo() + '\n' + "Запланировано сессий: " + recordsCount + '\n';
//        str = "Запланировано сессий: " + recordsCount + '\n';
        for(int i=0; i < recordsCount; i++) {
            str += String.format("%2d. ", i+1) + session[i].getShortSessionInfo() + '\n';
        }
        return str;
    }

    public String getFullInfo() {
        String str = getBookInfo() + '\n' + "Запланировано сессий: " + recordsCount + '\n';
        for(int i=0; i < recordsCount; i++) {
            str += String.format("%2d. ", i+1) + session[i].getSessionInfo() + '\n';
/*
            if(session[i].isPassed) {
                str += "Сессия успешно сдана!\n";
            }
*/
        }
        return str;
    }

// ***  start of 1-st inner class
    public class SessionRecord {
//        private static int sessionNumber;
        private LocalDate startDate;
        private LocalDate endDate;
//        private boolean isPassed;
        private int examCount;
        public TestBase[] examRec;

        public SessionRecord(LocalDate startDate, LocalDate endDate) {
            this.startDate = startDate;
            this.endDate = endDate;
//            isPassed = false;
            examRec = new TestBase[MAX_EXAMS_PER_SESSION];    // пока без коллекций
            examCount = 0;
        }

        private void markIfRetake(String subject) {            // проверить, если пересдача, то отменить предыдущий тест
            for(int i=0; i < examCount; i++) {
                if(examRec[i].subject.equalsIgnoreCase(subject)) {  // проверка по названию предмета
                    examRec[i].setRetook();     // отменяем результат предыдущего теста(ов). Без доп проверок.
                }
            }
        }

        public boolean addTest(LocalDate date, String subject) {
            if(date.isBefore(startDate) || date.isAfter(endDate) || examCount >= MAX_EXAMS_PER_SESSION) {
                return false;
            }
            markIfRetake(subject);
            examRec[examCount++] = new TestRecord(date, subject);
            return true;
        }

        public boolean addExam(LocalDate date, String subject) {
            if(date.isBefore(startDate) || date.isAfter(endDate) || examCount >= MAX_EXAMS_PER_SESSION) {
                return false;
            }
            markIfRetake(subject);
            examRec[examCount++] = new ExamRecord(date, subject);
            return true;
        }

        public boolean isClosed() {     // сданы ли все экзамены?
            boolean result = true;
            for(int i = 0; i < examCount; i++) {
                if(!examRec[i].isRetook()) {        // если пересдан - не учитываем это тест
                    result = result && examRec[i].isPassed();
                }
            }
            return result;
        }

        public String getShortSessionInfo() {
            String str = "Сессия с " + startDate.toString() + " по " + endDate.toString() + '.';
            int passedCount = 0;
            int retookCount = 0;
            if (examCount > 0) {
                str += " Зачетов/экзаменов: всего - " + examCount;
                for(int i = 0; i < examCount; i++) {
                    if (examRec[i].isPassed()) {
                        passedCount++;
                    }
                    if (examRec[i].isRetook()) {
                        retookCount++;
                    }
                }
                str += ", успешно сдано - " + passedCount + ", пересдач - " + retookCount;
                str += String.format(", средний балл - %.2f", getAverageScore());
            } else {
                str += " Тестов еще не запланировано.";
            }
            return str;
        }

        public String getSessionInfo() {
            String str = getShortSessionInfo() + '\n';
            for(int i = 0; i < examCount; i++) {
                str += '\t' + examRec[i].toString() + '\n';
            }
            if(isClosed()) {
                str += "Сессия успешно сдана!\n";
            }
            return str;
        }

        public double getAverageScore() {
            double aScore = 0;
            int eCount = 0;
            ExamRecord tempExamRecord;
            for(int i = 0; i < examCount; i++) {
                if(examRec[i].isGraded() && examRec[i].isPassed()) {     // это экзамен с оценкой
                    tempExamRecord = (ExamRecord) examRec[i];
                    aScore += tempExamRecord.getGrade();
                    eCount++;
                }
            }
            return eCount == 0 ? 0 : aScore / eCount;
        }

        // найти тест по названию и выдать его индекс. Если не найден - выдать -1.
        //TODO ищет только последнее вхождение теста. Если тесты удалять нельзя, то двигаясь с конца, мы найдем нужный нам тест,
        // а "пересданные" останутся в начале. Логика кривоватая, но пока так. Нужно доделывать getNext или поиск по id теста.
        public int getTestBySubject(String subject) {
            int ind = -1;
            for(int i = examCount-1; i >= 0; i--) {
                if(examRec[i].getSubject().equalsIgnoreCase(subject)) {
                    ind = i;
                    break;
                }
            }
            return ind;
        }

        public boolean setGradeBySubject(String subject, int grade) {
            int ind = getTestBySubject(subject);        // найти зачет или экзамен
            if(ind < 0 ) {
                return false;       // не нашли
            }
            examRec[ind].setGrade(grade);       // оцениваем
            return true;
        }

    }
// ***  end of 1-st inner class

// ***  start of 2-nd inner class - Parent
    private abstract class TestBase {
        private LocalDate examDate;
        private String subject;
        public boolean retook = false;

        public TestBase(LocalDate examDate, String subject) {
        this.examDate = examDate;
        this.subject = subject;
        }

        public LocalDate getDate() {
            return examDate;
        }

        public void changeDate(LocalDate examDate) {
            this.examDate = examDate;           // сменить дату экзамена / зачета
        }

        public String getSubject() {
            return subject;
        }

        public boolean isRetook() {
            return retook;
        }

        public void setRetook() {
            this.retook = true;     // отправить на пересдачу (в смысле, что будет новый тест, а эта запись остается как есть)
        }

        public abstract void setGrade(int grade);
        public abstract boolean isPassed();
        public abstract boolean isGraded(); // оценивается (для экзамена) или нет (для зачета)

    }
// ***  end of 2-nd inner class

// ***  start of 3-rd inner class
    private class ExamRecord extends TestBase {     // экзамен
        private int grade = -1;

        public ExamRecord(LocalDate examDate, String subject) {
            super(examDate, subject);
        }

        public int getGrade() {
            return grade;
        }

        @Override
        public void setGrade(int grade) {
            if (grade > 0 && grade <= 12) {     // типа проверка, если неправильная оценка, то останется -1
                this.grade = grade;
            }
        }

        @Override
        public boolean isPassed() {
            return grade > 2;       // пусть так
        }

        @Override
        public boolean isGraded() {
            return true;
        }

        @Override
        public String toString() {
            String str = "Date: " + this.getDate().toString() + "  Subject: " + getSubject() + " -> ";
            //TODO по-хорошему нужно проверять дату: не сдавался или сдавался, но не сдан.
            str += isPassed() ? "Passed." : "Not passed.";
            str += getGrade() < 0 ? " Not graded." : " Graded: " + getGrade() + '.';
/*
            if(this.getDate().isBefore(***)) {
               str += " Needs to be retaken."       // тут можно добавить про пересдачу - была или только планируется
            }
*/
            if (isRetook()) {
                str += " (Пересдан)";
            }
            return str;
        }
}
// ***  end of 3-rd inner class

// ***  start of 4-th inner class
    private class TestRecord extends TestBase {     // зачет
        private boolean passed = false;

        public TestRecord(LocalDate examDate, String subject) {
            super(examDate, subject);
        }

        @Override
        public void setGrade(int grade) {
            this.passed = grade > 0;
        }

        @Override
        public boolean isPassed() {
            return passed;
        }

        @Override
        public boolean isGraded() {
            return false;
        }

        @Override
        public String toString() {
            String str = "Date: " + this.getDate().toString() + "  Subject: " + getSubject() + " -> ";
            //TODO по-хорошему нужно проверять дату: не сдавался или сдавался, но не сдан.
            str += isPassed() ? "Passed." : "Not passed.";
/*
            if(this.getDate().isBefore(***)) {
               str += " Needs to be retaken."       // тут можно добавить про пересдачу - была или только планируется
            }
*/
            if (isRetook()) {
                str += " (Пересдан)";
            }
            return str;
        }
}
// ***  end of 4-th inner class


}

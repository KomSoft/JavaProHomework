package sql.demo.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Traider extends BaseModel {
    private String name;
    private int sfreqTick;          // частота совершения сделок
    private BigDecimal cash;        // сумма денег, кроме акций
    private int traidingMethod;     // используемый алгоритм. Зададим его константой
    private int changeProbability;  // Вероятность выполнения операций в %
    private String about;           // дополнительная информация

    public Traider() {
    }

    public Traider(long id, String name, int sfreqTick, BigDecimal cash, int traidingMethod, int changeProbability, String about) {
        super(id);
        this.name = name;
        this.sfreqTick = sfreqTick;
        this.cash = cash;
        this.traidingMethod = traidingMethod;
        this.changeProbability = changeProbability;
        this.about = about;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSfreqTick() {
        return sfreqTick;
    }

    public void setSfreqTick(int sfreqTick) {
        this.sfreqTick = sfreqTick;
    }

    public BigDecimal getCash() {
        return cash;
    }

    public void setCash(BigDecimal cash) {
        this.cash = cash;
    }

    public int getTraidingMethod() {
        return traidingMethod;
    }

    public void setTraidingMethod(int traidingMethod) {
        this.traidingMethod = traidingMethod;
    }

    public int getChangeProbability() {
        return changeProbability;
    }

    public void setChangeProbability(int changeProbability) {
        this.changeProbability = changeProbability;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Traider traider = (Traider) o;
        return sfreqTick == traider.sfreqTick && traidingMethod == traider.traidingMethod && changeProbability == traider.changeProbability && name.equals(traider.name) && cash.equals(traider.cash) && about.equals(traider.about);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, sfreqTick, cash, traidingMethod, changeProbability, about);
    }
}

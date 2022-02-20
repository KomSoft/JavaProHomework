package sql.demo.model;

import java.util.Objects;

public class TraiderShareAction extends BaseModel {
    private int operation;          // тип сделки (покупка/продажа)
    private Traider traider_id;     // ссылка на трейдера
    private ShareRate share_rate_id; // ссылка на курс акции (акцию, ее курс и время выставления)
    private Long amount;            // количество акций, учавствующих в операции

    public TraiderShareAction() {
    }

    public TraiderShareAction(long id, int operation, Traider traider_id, ShareRate share_rate_id, Long amount) {
        super(id);
        this.operation = operation;
        this.traider_id = traider_id;
        this.share_rate_id = share_rate_id;
        this.amount = amount;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }

    public Traider getTraider_id() {
        return traider_id;
    }

    public void setTraider_id(Traider traider_id) {
        this.traider_id = traider_id;
    }

    public ShareRate getShare_rate_id() {
        return share_rate_id;
    }

    public void setShare_rate_id(ShareRate share_rate_id) {
        this.share_rate_id = share_rate_id;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TraiderShareAction that = (TraiderShareAction) o;
        return operation == that.operation && traider_id.equals(that.traider_id) && share_rate_id.equals(that.share_rate_id) && amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), operation, traider_id, share_rate_id, amount);
    }
}

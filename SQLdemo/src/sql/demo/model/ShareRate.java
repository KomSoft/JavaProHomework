package sql.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;

public class ShareRate extends BaseModel {
    private LocalDateTime operDate;
    private Share share_id;
    private BigDecimal rate;

    public ShareRate() {
    }

    public ShareRate(long id, LocalDateTime operDate, Share share_id, BigDecimal rate) {
        super(id);
        this.operDate = operDate;
        this.share_id = share_id;
        this.rate = rate;
    }

    public LocalDateTime getOperDate() {
        return operDate;
    }

    public void setOperDate(LocalDateTime operDate) {
        this.operDate = operDate;
    }

    public Share getShare_id() {
        return share_id;
    }

    public void setShare_id(Share share_id) {
        this.share_id = share_id;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ShareRate shareRate = (ShareRate) o;
        return Objects.equals(operDate, shareRate.operDate) && Objects.equals(share_id, shareRate.share_id) && Objects.equals(rate, shareRate.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), operDate, share_id, rate);
    }
}

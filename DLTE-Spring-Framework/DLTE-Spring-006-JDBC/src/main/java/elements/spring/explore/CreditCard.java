package elements.spring.explore;

import java.io.Serializable;
import java.util.Date;

public class CreditCard {
    // creditCardNumber = credit_card_number
    private Long creditcardNumber;
    private Integer creditcardCvv;
    private Date creditcardExpiry;

    public CreditCard() {
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "creditcardNumber=" + creditcardNumber +
                ", creditcardCvv=" + creditcardCvv +
                ", creditcardExpiry=" + creditcardExpiry +
                ", creditcardPin=" + creditcardPin +
                ", creditcardLimit=" + creditcardLimit +
                ", creditcardUsage=" + creditcardUsage +
                ", creditcardAvailable=" + creditcardAvailable +
                ", creditcardStatus=" + creditcardStatus +
                ", creditcardHolder='" + creditcardHolder + '\'' +
                '}';
    }

    public CreditCard(Long creditcardNumber, Integer creditcardCvv, Date creditcardExpiry, Integer creditcardPin, Integer creditcardLimit, Integer creditcardUsage, Integer creditcardAvailable, boolean creditcardStatus, String creditcardHolder) {
        this.creditcardNumber = creditcardNumber;
        this.creditcardCvv = creditcardCvv;
        this.creditcardExpiry = creditcardExpiry;
        this.creditcardPin = creditcardPin;
        this.creditcardLimit = creditcardLimit;
        this.creditcardUsage = creditcardUsage;
        this.creditcardAvailable = creditcardAvailable;
        this.creditcardStatus = creditcardStatus;
        this.creditcardHolder = creditcardHolder;
    }

    public Long getCreditcardNumber() {
        return creditcardNumber;
    }

    public void setCreditcardNumber(Long creditcardNumber) {
        this.creditcardNumber = creditcardNumber;
    }

    public Integer getCreditcardCvv() {
        return creditcardCvv;
    }

    public void setCreditcardCvv(Integer creditcardCvv) {
        this.creditcardCvv = creditcardCvv;
    }

    public Date getCreditcardExpiry() {
        return creditcardExpiry;
    }

    public void setCreditcardExpiry(Date creditcardExpiry) {
        this.creditcardExpiry = creditcardExpiry;
    }

    public Integer getCreditcardPin() {
        return creditcardPin;
    }

    public void setCreditcardPin(Integer creditcardPin) {
        this.creditcardPin = creditcardPin;
    }

    public Integer getCreditcardLimit() {
        return creditcardLimit;
    }

    public void setCreditcardLimit(Integer creditcardLimit) {
        this.creditcardLimit = creditcardLimit;
    }

    public Integer getCreditcardUsage() {
        return creditcardUsage;
    }

    public void setCreditcardUsage(Integer creditcardUsage) {
        this.creditcardUsage = creditcardUsage;
    }

    public Integer getCreditcardAvailable() {
        return creditcardAvailable;
    }

    public void setCreditcardAvailable(Integer creditcardAvailable) {
        this.creditcardAvailable = creditcardAvailable;
    }

    public boolean isCreditcardStatus() {
        return creditcardStatus;
    }

    public void setCreditcardStatus(boolean creditcardStatus) {
        this.creditcardStatus = creditcardStatus;
    }

    public String getCreditcardHolder() {
        return creditcardHolder;
    }

    public void setCreditcardHolder(String creditcardHolder) {
        this.creditcardHolder = creditcardHolder;
    }

    private Integer creditcardPin;
    private Integer creditcardLimit;
    private Integer creditcardUsage;
    private Integer creditcardAvailable;
    private boolean creditcardStatus;
    private String creditcardHolder;
}
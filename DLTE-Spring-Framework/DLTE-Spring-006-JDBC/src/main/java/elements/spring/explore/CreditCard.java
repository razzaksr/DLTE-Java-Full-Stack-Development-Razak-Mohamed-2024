package elements.spring.explore;

import java.io.Serializable;
import java.util.Date;

public class CreditCard {
    // creditCardNumber = credit_card_number
    private Long creditcardNumber;
    private Integer creditcardCvv;
    private Date creditcardExpiry;

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
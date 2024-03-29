package elements.spring.explore;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;
import java.util.ResourceBundle;
public class CreditCard {
    // creditCardNumber = credit_card_number
    @NotNull(message = "Credit card number should be present")
    private Long creditcardNumber;
    @NotNull(message = "CVV number must be valid")
    @Digits(integer = 3, fraction = 0, message = "${card.cvv}")
    private Integer creditcardCvv;
    @NotNull(message = "Expiry date must be present")
    @Future(message = "Invalid date")
    private Date creditcardExpiry;
    @NotNull(message = "PIN must be present")
    @Digits(integer = 4, fraction = 0, message = "Invalid PIN ")
    private Integer creditcardPin;
    @NotNull(message = "Limit must be valid one")
    private Integer creditcardLimit;
    @NotNull(message = "Usage must be valid")
    private Integer creditcardUsage;
    @NotNull(message = "Card availability must be valid number")
    private Integer creditcardAvailable;
    @NotNull(message = "Card status must be valid")
    private boolean creditcardStatus;

    @NotNull(message = "Credit card holder should not empty")
    @Pattern(regexp = "^[a-zA-Z\\s]*$",message = "Invalid Credit card holder")
    private String creditcardHolder;

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
}
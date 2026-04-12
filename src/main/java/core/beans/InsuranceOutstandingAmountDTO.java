package core.beans;


import dao.enums.TransactionType;
import lombok.Builder;
import lombok.Data;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class InsuranceOutstandingAmountDTO implements Serializable {
    private BigDecimal amount;
    private TransactionType transactionType; // e.g "creditor" or "debtor"
    private String description;
    private Date entryDate;

}

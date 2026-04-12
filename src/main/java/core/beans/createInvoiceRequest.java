package core.beans;

import dao.enums.InvoiceType;
import lombok.*;

import java.io.Serializable;
@Data
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class createInvoiceRequest implements Serializable {
    private String sessionId;
    private String insurancePolicyId;
    private InvoiceType  invoiceType;
}

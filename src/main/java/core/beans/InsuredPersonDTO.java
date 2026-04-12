package core.beans;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class InsuredPersonDTO implements Serializable {
    private String fullName;
    private String nationalId;
    private String gender;
    private String birthDate;
    private String phoneNumber;
    private String altPhoneNumber;
    private String email;
    private String address;
}

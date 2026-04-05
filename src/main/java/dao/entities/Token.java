package dao.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Builder
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Token implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn
    private InsurancePolicy insurancePolicy;

    @Column(length = 100, nullable = false)
    private String token;

    private LocalDateTime expiryDate;

    private LocalDateTime lastUpdated;

    @Column(nullable = false)
    private Boolean isUsed = false;
}

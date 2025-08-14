package system.bank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "account_applications")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ApplicationID")
    private int applicationId;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private User userId;

    @Column(name = "ApplicationDate")
    private LocalDateTime applicationDate;

    @Column(name = "Status", nullable = false)
    private String status;

    @Column(name = "ApprovedBy")
    private int approvedBy; // EmployeeID reference

    // Getters and Setters
}
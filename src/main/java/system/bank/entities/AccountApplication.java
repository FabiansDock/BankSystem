package system.bank.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "account_applications")
public class AccountApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ApplicationID")
    private Long applicationId;

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private User customerId;

    @Column(name = "ApplicationDate")
    private LocalDateTime applicationDate;

    @Column(name = "Status", nullable = false)
    private String status;

    @Column(name = "ApprovedBy")
    private Long approvedBy; // EmployeeID reference

    // Getters and Setters
}
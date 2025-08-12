package system.bank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "audit_log")
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int logId;

    @Column(nullable = false)
    private String action;

    @Column(nullable = false)
    private int userId;

    @Column(nullable = false)
    private LocalDateTime date;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String details;
}

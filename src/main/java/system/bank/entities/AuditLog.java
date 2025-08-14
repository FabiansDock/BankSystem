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

    @Column(name = "action",nullable = false, length = 60)
    private String action;

    @Column(name = "user_id",nullable = false, length = 100)
    private String userId;

    @Column(name = "date",nullable = false, length = 50)
    private LocalDateTime date;

    @Column(name ="details", nullable = true, columnDefinition = "TEXT")
    private String details;
}

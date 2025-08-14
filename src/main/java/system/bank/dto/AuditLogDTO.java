package system.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin("*")
public class AuditLogDTO {

    private int logId;
    private String action;
    private String userId;
    private LocalDateTime date;
    private String details;



}

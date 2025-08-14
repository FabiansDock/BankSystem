package system.bank.mappers;

import system.bank.dto.AuditLogDTO;
import system.bank.entities.AuditLog;

import java.time.LocalDateTime;

public class AuditLogMapper {

    public static AuditLogDTO toDTO(AuditLog auditLog){

        return new AuditLogDTO(auditLog.getLogId(), auditLog.getAction(), auditLog.getUserId(), auditLog.getDate(),auditLog.getDetails());
    }

    public static AuditLog toEntity(AuditLogDTO auditLogDTO){
        AuditLog auditLog = new AuditLog();
        auditLog.setLogId(auditLogDTO.getLogId());
        auditLog.setAction(auditLogDTO.getAction());
        auditLog.setUserId(auditLogDTO.getUserId());
        auditLog.setDate(LocalDateTime.now());
        auditLog.setDetails(auditLogDTO.getDetails());
        return auditLog;

    }
}

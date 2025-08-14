package system.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.bank.dto.AuditLogDTO;
import system.bank.entities.AuditLog;
import system.bank.mappers.AuditLogMapper;
import system.bank.repositories.AuditLogRepository;

import java.util.List;

@Service
public class AuditLogService {

    @Autowired
    private AuditLogRepository auditLogRepository;


    public List<AuditLogDTO> getAllAuditLogs() {

        List<AuditLog> auditLogs = auditLogRepository.findAll();

        List<AuditLogDTO> auditLogDTOList = auditLogs.stream()
                .map(a->new AuditLogDTO(a.getLogId(),a.getAction(),a.getUserId(),a.getDate(),a.getDetails()))
                .toList();
        return auditLogDTOList;
    }

    public AuditLogDTO createAuditLog(AuditLogDTO auditLogDTO) {
        AuditLog auditLog = AuditLogMapper.toEntity(auditLogDTO);

        auditLog = auditLogRepository.save(auditLog);

        return AuditLogMapper.toDTO(auditLog);
    }
}

package system.bank.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.bank.dto.AuditLogDTO;
import system.bank.dto.BranchDTO;
import system.bank.services.AuditLogService;

import java.util.List;

@RestController
@RequestMapping("/api/auditLogs")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;


    @GetMapping
    public ResponseEntity<List<AuditLogDTO>> getAllAuditLogs(){

        return ResponseEntity.ok(auditLogService.getAllAuditLogs());
    }

    @PostMapping("/add")
    public ResponseEntity<AuditLogDTO> createBranch(@RequestBody AuditLogDTO auditLogDTO){

        return ResponseEntity.ok(auditLogService.createAuditLog(auditLogDTO));

    }
}

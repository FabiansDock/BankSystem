package system.bank.controllers;

import system.bank.dto.LoanPaymentDTO;
import system.bank.services.LoanPaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/loan-payments")
public class LoanPaymentController {

    @Autowired
    private LoanPaymentService loanPaymentService;

    @PostMapping
    public ResponseEntity<LoanPaymentDTO> createLoanPayment(@RequestBody LoanPaymentDTO loanPaymentDTO) {
        return ResponseEntity.ok(loanPaymentService.createLoanPayment(loanPaymentDTO));
    }

    @GetMapping
    public ResponseEntity<List<LoanPaymentDTO>> getAllLoanPayments() {
        return ResponseEntity.ok(loanPaymentService.getAllLoanPayments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanPaymentDTO> getLoanPaymentById(@PathVariable int id) {
        LoanPaymentDTO loanPaymentDTO = loanPaymentService.getLoanPaymentById(id);
        return loanPaymentDTO != null ? ResponseEntity.ok(loanPaymentDTO) : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LoanPaymentDTO> updateLoanPayment(@PathVariable int id, @RequestBody LoanPaymentDTO loanPaymentDTO) {
        LoanPaymentDTO updatedPayment = loanPaymentService.updateLoanPayment(id, loanPaymentDTO);
        return updatedPayment != null ? ResponseEntity.ok(updatedPayment) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLoanPayment(@PathVariable int id) {
        if (loanPaymentService.deleteLoanPayment(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}


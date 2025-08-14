package system.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@Data
@NoArgsConstructor
@AllArgsConstructor
@CrossOrigin("*")
public class BranchDTO {
    private int branch_id;
    private String branchName;
    private String branchAddress;
    private String managerId;

}



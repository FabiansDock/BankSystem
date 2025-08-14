package system.bank.mappers;

import system.bank.dto.BranchDTO;
import system.bank.entities.Branch;

public class BranchMapper {
    public static BranchDTO toDTO(Branch branch){

        return new BranchDTO(branch.getBranchId(), branch.getBranchName(), branch.getBranchAddress(), branch.getManagerId());
    }

    public static Branch toEntity(BranchDTO branchDTO){
        Branch branch = new Branch();
        branch.setBranchId(branchDTO.getBranch_id());
        branch.setBranchName(branchDTO.getBranchName());
        branch.setBranchAddress(branchDTO.getBranchAddress());
        branch.setManagerId(branchDTO.getManagerId());
        return branch;

    }
}




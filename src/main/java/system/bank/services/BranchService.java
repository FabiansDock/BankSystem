package system.bank.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import system.bank.dto.BranchDTO;
import system.bank.entities.Branch;
import system.bank.exceptions.ResourceAlreadyExistsException;
import system.bank.mappers.BranchMapper;
import system.bank.repositories.BranchRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BranchService {

    @Autowired
    private BranchRepository branchRepository;


    public BranchDTO createBranch(BranchDTO branchDTO) {

        // Check if branch name already exists
        if (branchRepository.existsByBranchName(branchDTO.getBranchName())) {
            throw new ResourceAlreadyExistsException("Branch", "branchName" , branchDTO.getBranchName());
        }
        if (branchRepository.existsByManagerId(branchDTO.getManagerId())) {
            throw new ResourceAlreadyExistsException("Branch", "Manager Id" , branchDTO.getManagerId());
        }

        Branch branch = BranchMapper.toEntity(branchDTO);

        branch = branchRepository.save(branch);

        return BranchMapper.toDTO(branch);
    }

    public List<BranchDTO> getAllBranches(){

        List<Branch> branches = branchRepository.findAll();

        List<BranchDTO> branchDTOList = branches.stream()
                .map(b->new BranchDTO(b.getBranchId(), b.getBranchName(),b.getBranchAddress(),b.getManagerId()))
                .toList();
        return branchDTOList;
    }

    public BranchDTO getBranchById(int id) {

        Optional<Branch> optionalBranch = branchRepository.findById(id);

        if (optionalBranch.isPresent()) {
            return BranchMapper.toDTO(optionalBranch.get());
        } else {
            return null;
        }

    }


    public BranchDTO updateBranch(int id,BranchDTO branchDTO){


        Optional<Branch> optionalRole = branchRepository.findById(id);

        if (optionalRole.isPresent()) {
            Branch existingBranch = optionalRole.get();
            existingBranch.setBranchName(branchDTO.getBranchName());
            existingBranch.setBranchAddress(branchDTO.getBranchAddress());
            existingBranch.setManagerId(branchDTO.getManagerId());
            return BranchMapper.toDTO(branchRepository.save(existingBranch));
        }

        return null;
    }

    public boolean deleteBranch(Integer id) {
        if(branchRepository.existsById(id)){
            branchRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

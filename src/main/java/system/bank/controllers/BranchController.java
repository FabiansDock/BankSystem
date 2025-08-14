package system.bank.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import system.bank.dto.BranchDTO;
import system.bank.entities.Branch;
import system.bank.mappers.BranchMapper;
import system.bank.services.BranchService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/branches")
public class BranchController {

    @Autowired
    private BranchService branchService;


//    @GetMapping
//    public String hi(){
//        return "Hi";
//    }


    @GetMapping
    public ResponseEntity<List<BranchDTO>> getAllBranches(){

        return ResponseEntity.ok(branchService.getAllBranches());

    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchDTO> getRoleById(@PathVariable int id){
        BranchDTO branchDTO = branchService.getBranchById(id);
        return branchDTO != null ? ResponseEntity.ok(branchDTO): ResponseEntity.ofNullable(branchDTO);
    }

    @PostMapping("/add")
    public ResponseEntity<BranchDTO> createBranch(@RequestBody BranchDTO branchDTO){

        return ResponseEntity.ok(branchService.createBranch(branchDTO));

    }

    @PutMapping("/update/{id}")
    public ResponseEntity<BranchDTO> updateBranch(@PathVariable int id, @RequestBody BranchDTO branchDTO){
        BranchDTO updateBranch = branchService.updateBranch(id,branchDTO);
        return updateBranch != null ? ResponseEntity.ok(updateBranch) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable int id){
        return branchService.deleteBranch(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();

    }

}

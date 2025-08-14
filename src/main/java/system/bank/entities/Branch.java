package system.bank.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int branchId;

    @Column(name = "branch_name",nullable = false, unique = true, length = 50)
    private String branchName;

    @Column(name = "branch_address",nullable = false, length = 500)
    private String branchAddress;

    @Column(name = "user_id",nullable = true, unique = true, length = 100)
    private String managerId;
}

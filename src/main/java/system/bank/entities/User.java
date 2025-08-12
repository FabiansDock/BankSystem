package system.bank.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Long userId;

    @Column(name = "SerialID", unique = true, nullable = false)
    private String serialId;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Email", nullable = false, unique = true)
    private String email;

    @Column(name = "PhoneNumber", nullable = false)
    private String phoneNumber;

    @Column(name = "Address")
    private String address;

    @Column(name = "AaadharNumber", unique = true)
    private String aadharNumber;

    @Column(name = "PANCardNumber", unique = true)
    private String panCardNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RoleID", nullable = false)
    private Long roleId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BranchID", nullable = false)
    private Long branchId;

    @Column(name = "UserName", unique = true, nullable = false)
    private String userName;

    @Column(name = "PasswordSalt", nullable = false)
    private String passwordSalt;

    @Column(name = "PasswordHash", unique = true, nullable = false)
    private String passwordHash;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<Account> accounts;

    @OneToMany(mappedBy = "users", cascade = CascadeType.ALL)
    private List<AccountApplication> accountApplications;

    // Getters and Setters
}

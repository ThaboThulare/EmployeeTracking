package za.co.employeetracking.domain;

import javax.persistence.*;

@javax.persistence.Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "role_desc")
    private String roleDesc;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getRoleDesc()
    {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc)
    {
        this.roleDesc = roleDesc;
    }

    
}

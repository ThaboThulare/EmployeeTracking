package za.co.employeetracking.domain;

import javax.persistence.*;

@Entity
@Table(name = "user_role")
public class UserRole
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @Column(name = "user_role_description")
    private String user_desc;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUser_desc() {
        return user_desc;
    }

    public void setUser_desc(String user_desc) {
        this.user_desc = user_desc;
    }
}

package za.co.employeetracking.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "scanner")
public class Scanner
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "user_detail")
    UserDetail userDetail;

    @Column(name = "login_time_stamp")
    private Date loginTime;

    @Column(name = "logout_time_stamp")
    private Date logoutTime;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public UserDetail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(UserDetail userDetail) {
        this.userDetail = userDetail;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }
}

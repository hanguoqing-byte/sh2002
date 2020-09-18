package com.powernode.app;

/**
 * Company : BJPowernode
 * Date : 2020/9/15
 * Description :
 *
 * RequesBody(value="xxx")
 */

@Table("user")
public class User {

    @Column(value = "id",isPk = true)
    private int id;

    @Column(value = "use")
    private  String username;

    @Column(value = "pass")
    private  String password;










    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

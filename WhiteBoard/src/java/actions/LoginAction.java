/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import model.ModeloProvisional;

/**
 *
 * @author ridao
 */
public class LoginAction extends ActionSupport {

    String user;
    String password;
    String loginError;

    public LoginAction() {
    }

    public String execute() throws Exception {
        if (ModeloProvisional.login(user, password)) {
            return SUCCESS;
        } else {
            addActionError(getText("loginError"));
            return ERROR;
        }
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

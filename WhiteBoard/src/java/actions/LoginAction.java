/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionSupport;
import model.ModeloProvisional;
import model.dao.Alumnos;

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
        if (login(user, password) != null) {
            return SUCCESS;
        }
        return ERROR;
        // Guardar aliumno en session
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

    private static Alumnos login(java.lang.String user, java.lang.String pass) {
        model.dao.DAO_Service service = new model.dao.DAO_Service();
        model.dao.DAO port = service.getDAOPort();
        return port.login(user, pass);
    }


}

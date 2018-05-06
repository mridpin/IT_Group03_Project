/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;
import model.Alumnos;

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

        if (!user.equals("") && !password.equals("")) {
            Alumnos current = login(user, password);
            if (current != null) {
                Map session = (Map) ActionContext.getContext().get("session");
                session.put("usuario", current);
                return SUCCESS;
            }
            else
            {
                //This has to be done here because the invalid login case doesn't have a validation
                addFieldError("user",getText("login.error"));
                return INPUT;
            }
        }
        else
        {
            return INPUT;
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

    private static Alumnos login(java.lang.String user, java.lang.String pass) {
        model.DAO_Service service = new model.DAO_Service();
        model.DAO port = service.getDAOPort();
        return port.login(user, pass);
    }

    public String logout() {
        Map session = (Map) ActionContext.getContext().get("session");
        session.put("usuario", null);
        return SUCCESS;
    }

}

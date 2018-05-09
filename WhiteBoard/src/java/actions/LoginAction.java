/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import model.dao.DAOImpl;
import java.util.Map;
import model.POJOs.Alumnos;
import model.POJOs.Administradores;
import model.POJOs.Asignaturas;
import model.POJOs.Profesores;
import model.POJOs.Usuario;

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

        String res = ERROR;

        if (!user.equals("") && !password.equals("")) {
            // Comprobar si es alumno, profesor o admin
            Usuario current = login(user, password);
            Alumnos a = (Alumnos) current;
            List<Asignaturas> test = a.getAsignaturasList();
            if (current != null) {
                Map session = (Map) ActionContext.getContext().get("session");
                session.put("usuario", current);
                if (current instanceof Profesores) {
                    res = "success_prof";
                } else if (current instanceof Alumnos) {
                    res = "success_alumno";
                } else {
                    res = "success_admin";
                }
            } else {
                addFieldError("user", getText("login.error"));
                res = INPUT;
            }
        }
        return res;
    }
//            Alumnos current = login(user, password);
//            if (current != null) {
//                Map session = (Map) ActionContext.getContext().get("session");
//                session.put("usuario", current);
//                return SUCCESS;
//            } else {
//                //This has to be done here because the invalid login case doesn't have a validation
//                addFieldError("user", getText("login.error"));
//                return INPUT;
//            }
//        } else {
//            return INPUT;
//        }
//    }

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

    private Usuario login(java.lang.String user, java.lang.String pass) {
//        model.DAO_Service service = new model.DAO_Service();
//        model.DAO port = service.getDAOPort();
//        return port.login(user, pass);
        if (user.startsWith("alu")) {
            return DAOImpl.findStudent(user, password);
        } else if (user.startsWith("prof")) {
            return DAOImpl.findProf(user, password);
        } else {
            return DAOImpl.findAdmin(user, password);
        }
    }

    public String logout() {
        Map session = (Map) ActionContext.getContext().get("session");
        session.put("usuario", null);
        return SUCCESS;
    }

}

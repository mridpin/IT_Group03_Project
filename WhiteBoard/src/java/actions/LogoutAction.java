/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actions;

import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Map;

/**
 *
 * @author ridao
 */
public class LogoutAction extends ActionSupport {
    
    public LogoutAction() {
    }
    

    public String logout() {
        Map session = (Map) ActionContext.getContext().get("session");
        session.put("usuario", null);
        return SUCCESS;
    }
    
}

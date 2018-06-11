package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.Map;
import model.POJOs.Alumnos;
import model.POJOs.Usuario;
import static model.dao.DAOImpl.realizarEntrega;

/**
 *
 * @author Portatil
 */
public class EntregaActions extends ActionSupport {
    
    private File file;
    
    public EntregaActions() {
    }
    
    public String execute() throws Exception {
         Map session = (Map) ActionContext.getContext().get("session");
        Usuario current = (Usuario) session.get("usuario");       
        
        realizarEntrega(current.getIdUsuario().toString(),file);
        return SUCCESS;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

}

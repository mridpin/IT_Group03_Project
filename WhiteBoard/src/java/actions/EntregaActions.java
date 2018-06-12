package actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.io.File;
import java.util.Map;
import model.POJOs.Actividades;
import model.POJOs.Entrega;
import model.POJOs.Usuario;
import static model.dao.DAOImpl.*;

/**
 *
 * @author Portatil
 */
public class EntregaActions extends ActionSupport {

    private File file;

    String fileContentType;

    String fileFileName;

    private String actividadId;

    public EntregaActions() {
    }

    public String execute() throws Exception {
        Map session = (Map) ActionContext.getContext().get("session");
        Usuario current = (Usuario) session.get("usuario");

        //Find actividad
        Actividades actividad = findActividad(actividadId);

        Entrega newEntrega = new Entrega();

        //Create folder to store entrega (lo hace dentro de glass fish)
        File saveFolder = new File(path + "/" + actividad.getAsignaturaId().getNombre() + "/entregas/" + actividad.getNombre() + "/" + current.getUsername());

        
        saveFolder.mkdirs();
       
        file.renameTo(new File(saveFolder.getAbsolutePath()+"/"+fileFileName));
        
        return SUCCESS;
    }

    public String getActividadId() {
        return actividadId;
    }

    public void setActividadId(String actividadId) {
        this.actividadId = actividadId;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    
    
    

}

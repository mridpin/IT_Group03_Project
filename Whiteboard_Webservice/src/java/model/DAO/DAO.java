/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import model.POJOs.Alumnos;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author ridao
 */
@WebService(serviceName = "DAO")
public class DAO {

    Session session = null;

    /**
     * Login
     */
    @WebMethod(operationName = "login")
    public Alumnos login(@WebParam(name = "user") String user, @WebParam(name = "pass") String pass) {
        String token = "";
        Alumnos a = null;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Alumnos where idUsuario='" + user + "' and password='" + pass + "'");
        a = (Alumnos)q.uniqueResult();
        tx.commit();
        return a;
    }
}

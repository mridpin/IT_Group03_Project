/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.DAO;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.DatatypeConverter;
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
        Alumnos aux = null;
        session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("from Alumnos where idUsuario='" + user + "'");
        aux = (Alumnos)q.uniqueResult();
        tx.commit();
        
        if(aux!=null && checkPassword(pass,aux.getPassword()))
        {
            a=aux;
        }
        return a;
    }
    
    /*
    Function that checks if the hash of both input parameters are the same
    */
    private boolean checkPassword(String provided,String stored)
    {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(provided.getBytes());
            byte[] digest = md.digest();
            return DatatypeConverter
                    .printHexBinary(digest).equals(stored);
        } catch (NoSuchAlgorithmException ex) {
            return false;
        }
        
    }
    
}

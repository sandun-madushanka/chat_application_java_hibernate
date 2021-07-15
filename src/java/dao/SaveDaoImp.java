/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Shakthi Dilshan
 */
public class SaveDaoImp implements SaveDao{

    @Override
    public Object saveData(Object o) {
        Object ob =null;
        Session ses = connection.NewHibernateUtil.getSessionFactory().openSession();
        Transaction tra = ses.beginTransaction();
        ob = ses.save(o);
        tra.commit();
        ses.flush();
        ses.close();
      
        
        
        return ob;
    }
    
}

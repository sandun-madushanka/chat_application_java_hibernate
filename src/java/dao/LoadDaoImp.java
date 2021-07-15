/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;

/**
 *
 * @author Shakthi Dilshan
 */
public class LoadDaoImp  implements LoadDao{

    @Override
    public List<Object> loadData(Object o, List<Criterion> cri) {
    List<Object> list = null;
    
        Session ses = connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cr = ses.createCriteria(o.getClass());
        if(cri != null){
            for (Criterion crite : cri) {
                cr.add(crite);
            }
            
        }
        list = cr.list();
    
       // ses.close();
    return list;
        
    }
    
}

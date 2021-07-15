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
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import pojos.Message;

/**
 *
 * @author Shakthi Dilshan
 */
public class LoadMsgDaoImp implements LoadMsgDao {

    @Override
    public List<Message> loadMsg(Criterion criterion) {
        List<Message> msglist = null;
        Session ses = connection.NewHibernateUtil.getSessionFactory().openSession();
        
        Criteria count = ses.createCriteria(Message.class);
        count.add(criterion);
        count.setProjection(Projections.rowCount());
        long total = (long) count.uniqueResult();
        System.out.println(total);
        int n =30;
        Criteria cr = ses.createCriteria(Message.class);
        cr.setFirstResult((int) (total-n));
        //cr.setFirstResult(30);
        
        
        cr.add(criterion);
        
        msglist = cr.list();        
        //ses.close();
        return msglist;
        
    }

    @Override
    public List<Message> loadMsg(int firstResult, Criterion criterion) {
       
         List<Message> msglist = null;
        Session ses = connection.NewHibernateUtil.getSessionFactory().openSession();
        
   
        Criteria count = ses.createCriteria(Message.class);
        //count.add(Restrictions.gt("msgId", firstResult));
        count.add(criterion);
        //count.setFirstResult(firstResult);
        
        count.setProjection(Projections.rowCount());
        long total = (long) count.uniqueResult();
        int n =30;
        Criteria cr = ses.createCriteria(Message.class);
        cr.setFirstResult((int) (total-n));
        
        cr.add(criterion);
        
        msglist = cr.list();        
        //ses.close();
        return msglist;
        
    }

}

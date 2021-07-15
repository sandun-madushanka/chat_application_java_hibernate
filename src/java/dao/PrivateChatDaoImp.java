/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import pojos.Chatroom;
import pojos.Privatechatroom;
import pojos.User;

/**
 *
 * @author Shakthi Dilshan
 */
public class PrivateChatDaoImp implements PrivateChatDao {

    @Override
    public Chatroom checkChatRoom(User u1, User u2) {
        Chatroom cr = new Chatroom();
        cr.setCrId(5000);
        Session ses = connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cri = ses.createCriteria(Privatechatroom.class);
        Criterion ci1 = Restrictions.eq("user1Id", u1.getUId());
        Criterion ci2 = Restrictions.eq("user2Id", u2.getUId());
        Criterion ci3 = Restrictions.eq("user1Id", u2.getUId());
        Criterion ci4 = Restrictions.eq("user2Id", u1.getUId());

        LogicalExpression le1 = Restrictions.and(ci1, ci2);
        LogicalExpression le2 = Restrictions.and(ci3, ci4);
        LogicalExpression le3 = Restrictions.or(le1, le2);
        cri.add(le3);
        Privatechatroom pc = (Privatechatroom) cri.uniqueResult();
        if (pc == null) {
            //session 2
            Session ses2 = connection.NewHibernateUtil.getSessionFactory().openSession();
            Chatroom chatroom = new Chatroom();
            chatroom.setType("private");
            Transaction tr = ses2.beginTransaction();
            int crid = (int) ses2.save(chatroom);
            tr.commit();
            ses2.flush();
            ses2.close();
            //session 3
             Session ses3 = connection.NewHibernateUtil.getSessionFactory().openSession();
             Transaction tr2 = ses3.beginTransaction();
            chatroom.setCrId(crid);
            Privatechatroom pvtcr = new Privatechatroom();
            pvtcr.setChatroom(chatroom);
            pvtcr.setUser1Id(u1.getUId());
            pvtcr.setUser2Id(u2.getUId());
            ses3.save(pvtcr);
            tr2.commit();
            ses3.flush();
            ses3.close();
            cr = chatroom;
        } else {
            cr = pc.getChatroom();
        }

        return cr;
    }

}

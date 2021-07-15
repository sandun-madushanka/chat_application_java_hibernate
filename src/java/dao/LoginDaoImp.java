package dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.criterion.SimpleExpression;
import pojos.User;

/**
 *
 * @author Shakthi Dilshan
 */
public class LoginDaoImp implements LoginDao{

    @Override
    public User login(User u) {
    User user =null;
    
        Session ses = connection.NewHibernateUtil.getSessionFactory().openSession();
        Criteria cri = ses.createCriteria(User.class);
        Criterion cr1 = Restrictions.eq("username", u.getUsername());
        Criterion cr2 = Restrictions.eq("password", u.getPassword());
        cri.add(cr1);
        cri.add(cr2);
         user = (User) cri.uniqueResult();
         ses.close();
    return user;
        
    }
    
}

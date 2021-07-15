/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.criterion.Criterion;
import pojos.Message;

/**
 *
 * @author Shakthi Dilshan
 */
public interface LoadMsgDao {
    public List<Message> loadMsg(Criterion criterion );
    public List<Message> loadMsg(int firstResult, Criterion criterion );
}

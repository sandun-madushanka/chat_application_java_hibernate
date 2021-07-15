/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import org.hibernate.criterion.Criterion;

/**
 *
 * @author Shakthi Dilshan
 */
public interface LoadDao {
    public List<Object> loadData(Object o,List<Criterion> cri);
}

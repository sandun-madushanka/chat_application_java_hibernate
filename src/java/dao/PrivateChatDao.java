/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import pojos.Chatroom;
import pojos.User;

/**
 *
 * @author Shakthi Dilshan
 */
public interface PrivateChatDao {
    public Chatroom checkChatRoom(User u1, User u2);
}

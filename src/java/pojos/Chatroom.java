package pojos;
// Generated Nov 12, 2017 8:05:52 AM by Hibernate Tools 3.6.0


import java.util.HashSet;
import java.util.Set;

/**
 * Chatroom generated by hbm2java
 */
public class Chatroom  implements java.io.Serializable {


     private Integer crId;
     private String type;
     private Set privatechatrooms = new HashSet(0);
     private Set messages = new HashSet(0);

    public Chatroom() {
    }

    public Chatroom(String type, Set privatechatrooms, Set messages) {
       this.type = type;
       this.privatechatrooms = privatechatrooms;
       this.messages = messages;
    }
   
    public Integer getCrId() {
        return this.crId;
    }
    
    public void setCrId(Integer crId) {
        this.crId = crId;
    }
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    public Set getPrivatechatrooms() {
        return this.privatechatrooms;
    }
    
    public void setPrivatechatrooms(Set privatechatrooms) {
        this.privatechatrooms = privatechatrooms;
    }
    public Set getMessages() {
        return this.messages;
    }
    
    public void setMessages(Set messages) {
        this.messages = messages;
    }




}



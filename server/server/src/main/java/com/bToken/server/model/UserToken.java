package com.bToken.server.model;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "userToken")
@NoArgsConstructor
@AllArgsConstructor
public class UserToken extends com.bToken.server.model.config.Entity<Integer>{
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAcquisition;

    @ManyToOne
    private UserGroupToken userGroupToken;

    @OneToOne
    private Token token;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDateAcquisition() {
        return dateAcquisition;
    }

    public void setDateAcquisition(Date dateAcquisition) {
        this.dateAcquisition = dateAcquisition;
    }

    public UserGroupToken getUserGroupToken() {
        return userGroupToken;
    }

    public void setUserGroupToken(UserGroupToken userGroupToken) {
        this.userGroupToken = userGroupToken;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.dateAcquisition);
        hash = 53 * hash + Objects.hashCode(this.userGroupToken);
        hash = 53 * hash + Objects.hashCode(this.token);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final UserToken other = (UserToken) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.dateAcquisition, other.dateAcquisition)) {
            return false;
        }
        if (!Objects.equals(this.userGroupToken, other.userGroupToken)) {
            return false;
        }
        return Objects.equals(this.token, other.token);
    }

    
}

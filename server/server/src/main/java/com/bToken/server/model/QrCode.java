package com.bToken.server.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="qrCode")
@NoArgsConstructor
@AllArgsConstructor
public class QrCode extends com.bToken.server.model.config.Entity<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    private Token token;

    private String qrContent;

    private String hash;

    @Temporal(TemporalType.TIMESTAMP)
    private Date expirationDate;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

     public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getQrContent() {
        return qrContent;
    }

    public void setQrContent(String qrContent) {
        this.qrContent = qrContent;
    }
    
    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((token == null) ? 0 : token.hashCode());
        result = prime * result + ((qrContent == null) ? 0 : qrContent.hashCode());
        result = prime * result + ((hash == null) ? 0 : hash.hashCode());
        result = prime * result + ((expirationDate == null) ? 0 : expirationDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        QrCode other = (QrCode) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (token == null) {
            if (other.token != null)
                return false;
        } else if (!token.equals(other.token))
            return false;
        if (qrContent == null) {
            if (other.qrContent != null)
                return false;
        } else if (!qrContent.equals(other.qrContent))
            return false;
        if (hash == null) {
            if (other.hash != null)
                return false;
        } else if (!hash.equals(other.hash))
            return false;
        if (expirationDate == null) {
            if (other.expirationDate != null)
                return false;
        } else if (!expirationDate.equals(other.expirationDate))
            return false;
        return true;
    }


    

    
}

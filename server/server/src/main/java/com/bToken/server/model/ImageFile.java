package com.bToken.server.model;

import java.util.Arrays;
import java.util.Objects;

import com.bToken.server.model.enums.ImageStorageTypeEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "imageFile")
@NoArgsConstructor
@AllArgsConstructor
public class ImageFile extends com.bToken.server.model.config.Entity<Integer>  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne 
    private Token token;

    private String url;

    private String mimeType;

    private Long size;

    private ImageStorageTypeEnum imageStorageTypeEnum;

    /**
    * Atributte that saves the image content, if stored in the dataBase.
    */
    private byte[] content;

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public ImageStorageTypeEnum getImageStorageTypeEnum() {
        return imageStorageTypeEnum;
    }

    public void setImageStorageTypeEnum(ImageStorageTypeEnum imageStorageTypeEnum) {
        this.imageStorageTypeEnum = imageStorageTypeEnum;
    }

    public Token getToken() {
        return token;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
        hash = 59 * hash + Objects.hashCode(this.token);
        hash = 59 * hash + Objects.hashCode(this.url);
        hash = 59 * hash + Objects.hashCode(this.mimeType);
        hash = 59 * hash + Objects.hashCode(this.size);
        hash = 59 * hash + Objects.hashCode(this.imageStorageTypeEnum);
        hash = 59 * hash + Arrays.hashCode(this.content);
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
        final ImageFile other = (ImageFile) obj;
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        if (!Objects.equals(this.mimeType, other.mimeType)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.token, other.token)) {
            return false;
        }
        if (!Objects.equals(this.size, other.size)) {
            return false;
        }
        if (this.imageStorageTypeEnum != other.imageStorageTypeEnum) {
            return false;
        }
        return Arrays.equals(this.content, other.content);
    }

    
}
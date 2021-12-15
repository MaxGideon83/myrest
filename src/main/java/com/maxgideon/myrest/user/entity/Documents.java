package com.maxgideon.myrest.user.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.maxgideon.myrest.user.entity.references.DocumentsType;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class Documents {

    @Id
    @Column(name = "id")
    private long id;

    @Version
    private Integer version;

    @Column(name = "doc_number", length = 30)
    private String docNumber;

    @Column(name = "doc_date", length = 15)
    private String docDate;

    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "doc_type")
    private DocumentsType docType;

    @OneToOne(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "user_id")
    @MapsId
    @JsonBackReference
    private User user;


    public long getId() {
        return id;
    }


    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public DocumentsType getDocType() {
        return docType;
    }

    public void setDocType(DocumentsType docType) {
        this.docType = docType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

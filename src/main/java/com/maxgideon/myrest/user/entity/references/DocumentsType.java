package com.maxgideon.myrest.user.entity.references;

import com.maxgideon.myrest.user.entity.Documents;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "documents_type")
public class DocumentsType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "doc_name", unique = true, nullable = false)
    private String docName;

    @Column(name = "doc_code", unique = true, nullable = false)
    private String docCode;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docType")
    private List<Documents> documents;

    public DocumentsType() {
    }

    public long getId() {
        return id;
    }


    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public void addDocumentToDocType(Documents document){
        if(documents == null){
            documents = new ArrayList<>();
        }
        documents.add(document);
        document.setDocType(this);
    }

    public List<Documents> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Documents> documents) {
        this.documents = documents;
    }
}

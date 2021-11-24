package com.maxgideon.myrest.user.entity.references;



import javax.persistence.*;


@Entity
@Table(name = "documents_type")
public class DocumentsType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Version
    private Integer version;

    @Column(name = "doc_name", unique = true, nullable = false)
    private String docName;

    @Column(name = "doc_code", unique = true, nullable = false)
    private String docCode;


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


}

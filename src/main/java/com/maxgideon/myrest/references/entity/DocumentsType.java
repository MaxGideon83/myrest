package com.maxgideon.myrest.references.entity;



import javax.persistence.*;

/**
 * Тип документов
 */
@Entity
@Table(name = "documents_type")
public class DocumentsType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    /**
     * Служебное поле hibernate
     */
    @Version
    private Integer version;
    /**
     * Название документа
     */
    @Column(name = "doc_name", unique = true, nullable = false, length = 30)
    private String docName;
    /**
     * Код документа
     */
    @Column(name = "doc_code", unique = true, nullable = false, length = 15)
    private String docCode;



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

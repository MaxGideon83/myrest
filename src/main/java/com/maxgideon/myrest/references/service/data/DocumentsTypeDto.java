package com.maxgideon.myrest.references.service.data;

import com.maxgideon.myrest.references.entity.DocumentsType;

public class DocumentsTypeDto {

    private long id;

    private String docName;

    private String docCode;

    public DocumentsTypeDto() {
    }

    public DocumentsTypeDto(DocumentsType documentsType) {
        this.id = documentsType.getId();
        this.docName = documentsType.getDocName();
        this.docCode = documentsType.getDocCode();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

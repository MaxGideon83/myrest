package com.maxgideon.myrest.references.dao;

import com.maxgideon.myrest.references.entity.Countries;
import com.maxgideon.myrest.references.entity.DocumentsType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class ReferencesDaoImpl implements ReferencesDao{

    @Autowired
    EntityManager em;

    @Override
    public List<DocumentsType> getAllDocumentsType() {
        Query query = em.createQuery("from DocumentsType");
        List<DocumentsType> docList = query.getResultList();
        return docList;
    }

    @Override
    public List<Countries> getAllCountries() {
        Query query = em.createQuery("from Countries");
        List<Countries> contList = query.getResultList();
        return contList;
    }
}

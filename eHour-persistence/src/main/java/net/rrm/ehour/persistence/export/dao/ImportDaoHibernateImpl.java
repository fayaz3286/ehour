package net.rrm.ehour.persistence.export.dao;

import net.rrm.ehour.domain.DomainObject;
import net.rrm.ehour.persistence.dao.AbstractAnnotationDaoHibernateImpl;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * @author thies (Thies Edeling - thies@te-con.nl)
 *         Created on: Nov 19, 2010 - 12:09:19 AM
 */
@Repository("importDao")
public class ImportDaoHibernateImpl extends AbstractAnnotationDaoHibernateImpl implements ImportDao
{
    @Override
    public <T extends DomainObject<?, ?>> Serializable persist(T object)
    {
        getHibernateTemplate().saveOrUpdate(object);

        return object.getPK();
    }

    @Override
    public <T, PK extends Serializable> T find(PK primaryKey, Class<T> type)
    {
        return (T)getHibernateTemplate().get(type, primaryKey);
    }
}
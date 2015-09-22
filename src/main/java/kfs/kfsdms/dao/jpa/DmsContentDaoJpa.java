package kfs.kfsdms.dao.jpa;

import java.util.List;
import kfs.kfsdms.dao.DmsContentDao;
import kfs.kfsdms.domain.DmsContent;
import kfs.kfsdms.domain.DmsDocument;
import kfs.springutils.BaseDaoJpa;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pavedrim
 */
@Repository
public class DmsContentDaoJpa extends BaseDaoJpa<DmsContent, String> implements DmsContentDao{

    @Override
    protected Class<DmsContent> getDataClass() {
        return DmsContent.class;
    }

    @Override
    protected String getId(DmsContent t) {
        return t.getId();
    }

    @Override
    public Integer getLastVersion(DmsDocument doc) {
        return (Integer)
                em.createQuery("SELECT MAX(c.version) FROM DmsContent c WHERE c.document = :doc")
                .setParameter("doc", doc)
                .getSingleResult();
        //return 0;
    }
    
    @Override
    public List<DmsContent> load(DmsDocument doc) {
        return em.createQuery("SELECT c FROM DmsContent c WHERE c.document = :doc ORDER BY c.version DESC")
                .setParameter("doc", doc)
                .getResultList();
    }

}

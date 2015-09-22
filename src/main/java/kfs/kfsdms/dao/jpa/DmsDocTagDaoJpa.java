package kfs.kfsdms.dao.jpa;

import java.util.List;
import kfs.kfsdms.dao.DmsDocTagDao;
import kfs.kfsdms.domain.DmsDocTag;
import kfs.kfsdms.domain.DmsDocument;
import kfs.springutils.BaseDaoJpa;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pavedrim
 */
@Repository
public class DmsDocTagDaoJpa extends BaseDaoJpa<DmsDocTag, String> implements DmsDocTagDao{

    @Override
    protected Class<DmsDocTag> getDataClass() {
        return DmsDocTag.class;
    }

    @Override
    protected String getId(DmsDocTag t) {
        return t.getId();
    }

    @Override
    public List<DmsDocTag> load(DmsDocument doc) {
        return em.createQuery("SELECT t FROM DmsDocTag t WHERE t.document = :doc")
                .setParameter("doc", doc)
                .getResultList();
    }

}

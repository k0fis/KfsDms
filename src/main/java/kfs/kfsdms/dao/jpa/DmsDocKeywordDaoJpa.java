package kfs.kfsdms.dao.jpa;

import java.util.List;
import kfs.kfsdms.dao.DmsDocKeywordDao;
import kfs.kfsdms.domain.DmsDocKeyword;
import kfs.kfsdms.domain.DmsDocument;
import kfs.springutils.BaseDaoJpa;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pavedrim
 */
@Repository
public class DmsDocKeywordDaoJpa extends BaseDaoJpa<DmsDocKeyword, String> implements DmsDocKeywordDao{

    @Override
    protected Class<DmsDocKeyword> getDataClass() {
        return DmsDocKeyword.class;
    }

    @Override
    protected String getId(DmsDocKeyword t) {
        return t.getId();
    }

    @Override
    public List<DmsDocKeyword> load(DmsDocument doc){
        return em.createQuery("select k from DmsDocKeyword k where k.document = :doc ORDER BY k.name")
                .setParameter("doc", doc)
                .getResultList();
    }
}

package kfs.kfsdms.dao.jpa;

import java.util.List;
import kfs.kfsdms.dao.DmsTagDao;
import kfs.kfsdms.domain.DmsTag;
import kfs.springutils.BaseDaoJpa;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pavedrim
 */
@Repository
public class DmsTagDaoJpa extends BaseDaoJpa<DmsTag, String> implements DmsTagDao{

    @Override
    protected Class<DmsTag> getDataClass() {
        return DmsTag.class;
    }

    @Override
    protected String getId(DmsTag t) {
        return t.getId();
    }

    @Override
    public List<DmsTag> load() {
        return em.createQuery("SELECT t FROM DmsTag t ORDER BY t.name")
                .getResultList();
    }

}

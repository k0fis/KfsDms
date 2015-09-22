package kfs.kfsdms.dao.jpa;

import java.util.List;
import kfs.kfsdms.dao.DmsDocCommentDao;
import kfs.kfsdms.domain.DmsDocComment;
import kfs.kfsdms.domain.DmsDocument;
import kfs.springutils.BaseDaoJpa;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pavedrim
 */
@Repository
public class DmsDocCommentDaoJpa extends BaseDaoJpa<DmsDocComment, String> implements DmsDocCommentDao{

    @Override
    protected Class<DmsDocComment> getDataClass() {
        return DmsDocComment.class;
    }

    @Override
    protected String getId(DmsDocComment t) {
        return t.getId();
    }
    
    @Override
    public List<DmsDocComment> load(DmsDocument doc) {
        return em.createQuery("SELECT c FROM DmsDocComment c WHERE c.document = :doc ORDER BY c.commentDate DESC")
                .setParameter("doc", doc)
                .getResultList();
    }

}

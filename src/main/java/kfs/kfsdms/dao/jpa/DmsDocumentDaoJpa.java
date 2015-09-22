package kfs.kfsdms.dao.jpa;

import kfs.kfsdms.dao.DmsDocumentDao;
import kfs.kfsdms.domain.DmsDocument;
import kfs.springutils.BaseDaoJpa;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pavedrim
 */
@Repository
public class DmsDocumentDaoJpa extends BaseDaoJpa<DmsDocument, String> implements DmsDocumentDao{

    @Override
    protected Class<DmsDocument> getDataClass() {
        return DmsDocument.class;
    }

    @Override
    protected String getId(DmsDocument t) {
        return t.getId();
    }

}

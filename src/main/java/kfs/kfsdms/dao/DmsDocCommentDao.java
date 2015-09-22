package kfs.kfsdms.dao;

import java.util.List;
import kfs.kfsdms.domain.DmsDocComment;
import kfs.kfsdms.domain.DmsDocument;
import kfs.springutils.BaseDao;

/**
 *
 * @author pavedrim
 */
public interface DmsDocCommentDao extends BaseDao<DmsDocComment, String> {

    List<DmsDocComment> load(DmsDocument doc);

}

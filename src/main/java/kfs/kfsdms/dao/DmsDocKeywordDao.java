package kfs.kfsdms.dao;

import java.util.List;
import kfs.kfsdms.domain.DmsDocKeyword;
import kfs.kfsdms.domain.DmsDocument;
import kfs.springutils.BaseDao;

/**
 *
 * @author pavedrim
 */
public interface DmsDocKeywordDao extends BaseDao<DmsDocKeyword, String> {

    List<DmsDocKeyword> load(DmsDocument doc);

}

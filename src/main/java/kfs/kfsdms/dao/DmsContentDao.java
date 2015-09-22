package kfs.kfsdms.dao;

import java.util.List;
import kfs.kfsdms.domain.DmsContent;
import kfs.kfsdms.domain.DmsDocument;
import kfs.springutils.BaseDao;

/**
 *
 * @author pavedrim
 */
public interface DmsContentDao extends BaseDao<DmsContent, String>{
    
    Integer getLastVersion(DmsDocument doc);

    List<DmsContent> load(DmsDocument doc);
}

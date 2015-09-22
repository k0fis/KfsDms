package kfs.kfsdms.dao;

import java.util.List;
import kfs.kfsdms.domain.DmsDocTag;
import kfs.kfsdms.domain.DmsDocument;
import kfs.springutils.BaseDao;

/**
 *
 * @author pavedrim
 */
public interface DmsDocTagDao extends BaseDao<DmsDocTag, String>{

    List<DmsDocTag> load(DmsDocument doc);
    
}

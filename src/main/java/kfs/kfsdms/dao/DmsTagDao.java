package kfs.kfsdms.dao;

import java.util.List;
import kfs.kfsdms.domain.DmsTag;
import kfs.springutils.BaseDao;

/**
 *
 * @author pavedrim
 */
public interface DmsTagDao extends BaseDao<DmsTag, String>{

    List<DmsTag> load();
    
}

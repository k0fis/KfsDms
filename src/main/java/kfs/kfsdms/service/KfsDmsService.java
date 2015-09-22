package kfs.kfsdms.service;

import java.util.List;
import kfs.kfsdms.domain.*;
import kfs.kfsusers.domain.KfsUser;

/**
 *
 * @author pavedrim
 */
public interface KfsDmsService {
    
    void contentSave(DmsContent data, KfsUser user);
    void contentSaveNewVersion(DmsContent data, KfsUser user);
    List<DmsContent> contentLoad(DmsDocument doc);
    
    void docCommentSave(DmsDocComment data, KfsUser user);
    List<DmsDocComment> docCommentLoad(DmsDocument doc);
    
    void docKeywordSave(DmsDocKeyword data, KfsUser user);
    List<DmsDocKeyword> docKeywordLoad(DmsDocument doc);
    
    void docTagSave(DmsDocTag data, KfsUser user);
    List<DmsDocTag> docTagLoad(DmsDocument doc);
    
    void tagSave(DmsTag data);
    List<DmsTag> tagLoad();

    void documentSave(DmsDocument data, KfsUser user);
    
}

package kfs.kfsdms.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import kfs.kfsdms.dao.*;
import kfs.kfsusers.domain.KfsUser;
import kfs.kfsdms.domain.*;
import kfs.kfsdms.service.KfsDmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author pavedrim
 */
@Service
@Transactional
public class KfsDmsServiceImpl implements KfsDmsService {

    @Autowired
    DmsContentDao contentDao;
    @Autowired
    DmsDocCommentDao docCommentDao;
    @Autowired
    DmsDocKeywordDao docKeywordDao;
    @Autowired
    DmsDocTagDao docTagDao;
    @Autowired
    DmsDocumentDao documentDao;
    @Autowired
    DmsTagDao tagDao;

    private Timestamp ts() {
        return new Timestamp(new Date().getTime());
    }

    @Override
    public void contentSave(DmsContent data, KfsUser user) {
        if (data.getId() == null) {
            data.setVersion(1);
            contentDao.insert(data);
        } else {
            contentDao.update(data);
        }
        documentSave(data.getDocument(), user);
    }

    @Override
    public void contentSaveNewVersion(DmsContent data, KfsUser user) {
        DmsDocument doc = data.getDocument();
        data.setVersion(contentDao.getLastVersion(doc) + 1);
        contentDao.insert(data);
        documentSave(doc, user);
    }

    @Override
    public List<DmsContent> contentLoad(DmsDocument doc) {
        return contentDao.load(doc);
    }

    @Override
    public void docCommentSave(DmsDocComment data, KfsUser user) {
        data.setCommentDate(ts());
        data.setUserName(user.getUserName());
        docCommentDao.insert(data);
        documentSave(data.getDocument(), user);
    }

    @Override
    public List<DmsDocComment> docCommentLoad(DmsDocument doc) {
        return docCommentDao.load(doc);
    }

    @Override
    public void docKeywordSave(DmsDocKeyword data, KfsUser user) {
        docKeywordDao.insert(data);
        documentSave(data.getDocument(), user);
    }
    
    @Override
    public List<DmsDocKeyword> docKeywordLoad(DmsDocument doc) {
        return docKeywordDao.load(doc);
    }
    

    @Override
    public void docTagSave(DmsDocTag data, KfsUser user) {
        if (data.getId() == null) {
            docTagDao.insert(data);
        } else {
            docTagDao.update(data);
        }
        documentSave(data.getDocument(), user);
    }
    
    @Override
    public List<DmsDocTag> docTagLoad(DmsDocument doc){
        return docTagDao.load(doc); 
    }

    @Override
    public void tagSave(DmsTag data) {
        if (data.getId() == null) {
            tagDao.insert(data);
        } else {
            tagDao.update(data);
        }
    }

    @Override
    public List<DmsTag> tagLoad() {
        return tagDao.load();
    }
    
    @Override
    public void documentSave(DmsDocument data, KfsUser user) {
        data.setModified(ts());
        data.setLastModifiedBy(user.getUserName());
        if (data.getId() == null) {
            data.setCreated(data.getModified());
            data.setCreatedBy(data.getLastModifiedBy());
            documentDao.insert(data);
        } else {
            documentDao.update(data);
        }
    }    
}

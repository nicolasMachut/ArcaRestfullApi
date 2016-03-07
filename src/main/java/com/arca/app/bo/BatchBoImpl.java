package com.arca.app.bo;

import com.arca.app.dao.BatchDaoImpl;
import com.arca.app.domain.Batch;
import org.jvnet.hk2.annotations.Service;

/**
 * Created by machu on 05/03/2016.
 */
public class BatchBoImpl implements BatchBo {

    private BatchDaoImpl batchDao;

    public Batch getLast() {
        return batchDao.getLast();
    }
}

package com.arca.app.dao;

import com.arca.app.domain.Batch;
import org.jvnet.hk2.annotations.Service;

/**
 * Created by machu on 05/03/2016.
 */
@Service(name = "batchDaoImpl")
public class BatchDaoImpl implements BatchDao {

    public Batch getLast() {
        return null;
    }
}

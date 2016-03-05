package com.arca.app.bo;

import com.arca.app.dao.LineDaoImpl;
import com.arca.app.domain.Line;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

/**
 * Created by machu on 05/03/2016.
 */
@Service(name = "lineBoImpl")
public class LineBoImpl implements LineBo {

    private LineDaoImpl lineDao;


    public List<Line> getAll() {
        return lineDao.getAll();
    }

    public List<Line> getByCountry() {
        return lineDao.getByCountry();
    }
}

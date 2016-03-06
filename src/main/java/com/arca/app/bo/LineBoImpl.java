package com.arca.app.bo;

import com.arca.app.dao.LineDaoImpl;
import com.arca.app.domain.ChartLine;
import com.arca.app.domain.GroupedLine;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

/**
 * Created by machu on 05/03/2016.
 */
@Service(name = "lineBoImpl")
public class LineBoImpl implements LineBo {

    private LineDaoImpl lineDao;

    public LineBoImpl () {
        this.lineDao = new LineDaoImpl();
    }

    public List<GroupedLine> getByCountry() {
        return lineDao.getByCountry();
    }

    public List<ChartLine> getForChart(int year) {
        return lineDao.getForChart(year);
    }
}

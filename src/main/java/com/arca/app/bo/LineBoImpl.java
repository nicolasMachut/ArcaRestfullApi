package com.arca.app.bo;

import com.arca.app.dao.LineDaoImpl;
import com.arca.app.domain.ChartLine;
import com.arca.app.domain.GroupedLine;
import org.jvnet.hk2.annotations.Service;

import java.util.Calendar;
import java.util.Date;
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
        return lineDao.getForChart(getFirstDayOfTheYear(year), getLastDayOfTheYear(year));
    }

    private Date getFirstDayOfTheYear (int year) {
        Calendar start = Calendar.getInstance();
        start.set(year,0,1,0,0,0);
        return start.getTime();
    }

    private Date getLastDayOfTheYear (int year) {
        Calendar end = Calendar.getInstance();
        end.set(year, 11, 31, 23, 59, 59);
        return end.getTime();
    }
}

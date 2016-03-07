package com.arca.app.bo;

import com.arca.app.dao.LineDaoImpl;
import com.arca.app.domain.GroupedLine;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LineBoImpl implements LineBo {

    private LineDaoImpl lineDao;

    public LineBoImpl () {
        this.lineDao = new LineDaoImpl();
    }

    public List<GroupedLine> getByCountry() {
        return lineDao.getByCountry();
    }

    public List<GroupedLine> getForChart(int year) {
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

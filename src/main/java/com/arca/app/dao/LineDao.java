package com.arca.app.dao;

import com.arca.app.domain.ChartLine;
import com.arca.app.domain.GroupedLine;

import java.util.Date;
import java.util.List;

/**
 * Created by machu on 05/03/2016.
 */
public interface LineDao {

    List<GroupedLine> getByCountry ();
    List<ChartLine> getForChart (Date start, Date end);
}

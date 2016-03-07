package com.arca.app.dao;

import com.arca.app.domain.GroupedLine;

import java.util.Date;
import java.util.List;

public interface LineDao {

    List<GroupedLine> getByCountry ();
    List<GroupedLine> getForChart (Date start, Date end);
}

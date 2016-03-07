package com.arca.app.bo;

import com.arca.app.domain.GroupedLine;

import java.util.List;

public interface LineBo {

    List<GroupedLine> getByCountry ();

    List<GroupedLine> getForChart(int year);
}

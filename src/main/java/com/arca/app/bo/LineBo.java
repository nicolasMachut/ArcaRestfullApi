package com.arca.app.bo;

import com.arca.app.domain.ChartLine;
import com.arca.app.domain.GroupedLine;

import java.util.List;

/**
 * Created by machu on 05/03/2016.
 */
public interface LineBo {

    List<GroupedLine> getByCountry ();

    List<ChartLine> getForChart(int year);
}

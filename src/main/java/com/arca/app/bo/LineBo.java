package com.arca.app.bo;

import com.arca.app.domain.Line;

import java.util.List;

/**
 * Created by machu on 05/03/2016.
 */
public interface LineBo {

    List<Line> getAll();
    List<Line> getByCountry ();
}

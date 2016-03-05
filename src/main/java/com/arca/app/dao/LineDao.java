package com.arca.app.dao;

import com.arca.app.domain.Line;

import java.util.List;

/**
 * Created by machu on 05/03/2016.
 */
public interface LineDao {

    List<Line> getAll();
    List<Line> getByCountry ();
}

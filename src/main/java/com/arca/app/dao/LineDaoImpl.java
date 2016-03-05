package com.arca.app.dao;

import com.arca.app.domain.Line;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

/**
 * Created by machu on 05/03/2016.
 */
@Service (name = "lineDaoImpl")
public class LineDaoImpl implements LineDao {


    public List<Line> getAll() {
        return null;
    }

    public List<Line> getByCountry() {
        /*Aggregation aggregation = newAggregation(group("country").sum("value").as("test"));
        AggregationResults results = mongoOperations.aggregate(aggregation, "arcaFile", LineGroup.class);
        Iterator it = results.iterator();
        while (it.hasNext()) {
            LineGroup lg = (LineGroup)it.next();
            System.out.println(lg.get_id());
        }
        List<LineGroup> res = results.getMappedResults();
        for (LineGroup l : res) {
            System.out.println(l.get_id() + " " + l.getTest());
        }*/
        return null;
    }
}

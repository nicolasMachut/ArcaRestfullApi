package com.arca.app.bo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class LineBoImplTest {

    private LineBoImpl lineBo;

    @Before
    public void SetUp (){
        this.lineBo = new LineBoImpl();
    }

    @Test
    public void getLastDayOfYearTest () {
        int year = 2015;
        Date date = this.lineBo.getLastDayOfTheYear(year);
        Calendar assertedDate = Calendar.getInstance();
        assertedDate.set(year,11,31,23,59,59);
        assertedDate.set(Calendar.MILLISECOND, 999);
        Assert.assertEquals(assertedDate.getTimeInMillis(), date.getTime());
    }

    @Test
    public void getFirstDayOfTheYearTest (){
        int year = 2018;
        Date date = this.lineBo.getFirstDayOfTheYear(year);
        Calendar assertedDate = Calendar.getInstance();
        assertedDate.set(year,0,1,0,0,0);
        assertedDate.set(Calendar.MILLISECOND, 0);
        Assert.assertEquals(assertedDate.getTimeInMillis(), date.getTime());
    }
}

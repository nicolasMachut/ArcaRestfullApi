package com.arca.app;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit getDataGroupByCountry for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the getDataGroupByCountry case
     *
     * @param testName name of the getDataGroupByCountry case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
}

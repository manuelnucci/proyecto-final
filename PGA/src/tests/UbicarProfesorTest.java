package tests;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class UbicarProfesorTest
{
    TestFixtureProfesor fixture1 = new TestFixtureProfesor();

    public UbicarProfesorTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture1.setUp();
    }

    @After
    public void tearDown() throws Exception
    {
        fixture1.tearDown();
    }

    /**
     * @see pga.Manager#ubicarProfesor(String,String)
     */
    @Test
    public void testUbicarProfesor()
    {
        fail("Unimplemented");
    }
}

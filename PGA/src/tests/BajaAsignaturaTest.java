package tests;

import org.junit.After;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class BajaAsignaturaTest
{
    private TestFixtureAsignatura fixture = new TestFixtureAsignatura();

    public BajaAsignaturaTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture.setUpBaja();
    }

    @After
    public void tearDown() throws Exception
    {
        fixture.tearDown();
    }

    /**
     * @see pga.Manager#bajaAsignatura(pga.Asignatura)
     */
    @Test
    public void testBajaAsignatura()
    {
        fail("Unimplemented");
    }
}

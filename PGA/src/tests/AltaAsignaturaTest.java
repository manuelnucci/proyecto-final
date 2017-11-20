package tests;

import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import pga.Asignatura;

public class AltaAsignaturaTest
{
    private TestFixtureAsignatura fixture = new TestFixtureAsignatura();

    public AltaAsignaturaTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture.setUpAgregarYModif();
    }

    @After
    public void tearDown() throws Exception
    {
        fixture.tearDown();
    }

    /**
     * @see pga.Manager#altaAsignatura(String)
     */
    @Test
    public void testAltaAsignaturaExitoso_1_1()
    {
        int size = this.fixture.manager.getAsignaturas().size();
        this.fixture.manager.altaAsignatura("Mate C");
        assertTrue("La asignatura no se agregó bien al sistema.", this.fixture.manager.getAsignaturas().size() == size + 1);
    }
    
    /**
     * @see pga.Manager#altaAsignatura(String)
     */
    @Test
    public void testAltaAsignaturaExitoso_1_2()
    {
        int size = this.fixture.manager.getAsignaturas().size();
        this.fixture.manager.altaAsignatura("A");
        assertTrue("La asignatura no se agregó bien al sistema.", this.fixture.manager.getAsignaturas().size() == size + 1);
    }
    
    /**
     * @see pga.Manager#altaAsignatura(String)
     */
    @Test
    public void testAltaAsignaturaErroneo_2_2()
    {
        try
        {
            this.fixture.manager.altaAsignatura(null);
            fail("Tendría que haberse lanzado la excepción NullPointerException."); 
        }
        catch (NullPointerException e)
        {
            fail("Se intentó agregar una asignatura con un nombre nulo.");   
        }
    }
    
    /**
     * @see pga.Manager#altaAsignatura(String)
     */
    @Test
    public void testAltaAsignaturaErroneo_4_2()
    {
        this.fixture.manager.altaAsignatura("");
        fail("Se intentó agregar una asignatura con un nombre vacío.");
    }
    
    /**
     * @see pga.Manager#altaAsignatura(String)
     */
    @Test
    public void testAltaAsignaturaErroneo_8()
    {
        Asignatura.setNumAsignatura(Asignatura.getNumAsignatura() - 1);
        this.fixture.manager.altaAsignatura("Química");
        fail("Tendría que haberse lanzado la excepción EntidadRepetidaException que no está contemplada en el método.");
    }
}

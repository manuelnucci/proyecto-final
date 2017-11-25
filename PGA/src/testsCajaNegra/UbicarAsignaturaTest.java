package testsCajaNegra;

import exceptions.NoEstaEntidadException;

import java.util.HashMap;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import pga.Asignatura;

public class UbicarAsignaturaTest
{
    private TestFixtureAsignatura fixture = new TestFixtureAsignatura();

    public UbicarAsignaturaTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture.setUpUbicar();
    }

    @After
    public void tearDown() throws Exception
    {
        fixture.tearDown();
    }

    /**
     * @see pga.Manager#ubicarAsignatura(String)
     */
    @Test
    public void testUbicarAsignaturaExitoso()
    {
        try
        {
            HashMap<String, Asignatura> hash = this.fixture
                                                   .manager
                                                   .ubicarAsignatura("Mate B");
            assertTrue("La asignatura debería haber sido encontrada en el sistema.", hash.containsKey(this.fixture.asignatura_b.getId()));
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción NoEstaEntidadException porque en el TestFixtureAsignatura se la agregó.");
        }
    }
    
    /**
     * @see pga.Manager#ubicarAsignatura(String)
     */
    @Test
    public void testUbicarAsignaturaErroneo_2()
    {
        try
        {
            this.fixture.manager.ubicarAsignatura(null);
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción NoEstaEntidadException.");
        }
        catch(NullPointerException e)
        {
            fail("Se intentó buscar una asignatura con un nombre nulo.");
        }
    }
    
    /**
     * @see pga.Manager#ubicarAsignatura(String)
     */
    @Test
    public void testUbicarAsignaturaErroneo_4()
    {
        try
        {
            this.fixture.manager.ubicarAsignatura("Algebra");
            fail("Tendría que haberse lanzado la excepción NoEstaEntidadException.");
        } 
        catch (NoEstaEntidadException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", e.getMessage(), "Ninguna asignatura encontrada.");
        }
    }
}

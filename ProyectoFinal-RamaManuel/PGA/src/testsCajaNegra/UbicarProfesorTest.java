package testsCajaNegra;

import exceptions.NoEstaEntidadException;

import java.util.HashMap;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import pga.Profesor;

public class UbicarProfesorTest
{
    private TestFixtureProfesor fixture = new TestFixtureProfesor();

    public UbicarProfesorTest()
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
     * @see pga.Manager#ubicarProfesor(String,String)
     */
    @Test
    public void testUbicarProfesorExitoso()
    {
        try
        {
            HashMap<String, Profesor> hash = this.fixture.manager.ubicarProfesor(
                                                this.fixture.profesor_b.getNombre(), this.fixture.profesor_b.getApellido());
            assertTrue("El profesor debería haber sido encontrado en el sistema.", hash.containsKey(this.fixture.profesor_b.getLegajo()));
            
        }
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción NoEstaEntidadException");
        }
    }
    

    /**
     * @see pga.Manager#ubicarProfesor(String,String)
     */
    @Test
    public void testUbicarProfesorErroneo2_1()
    {
        try
        {
            this.fixture.manager.ubicarProfesor(null, this.fixture.profesor_b.getApellido());
            fail("Tendrpia que haberse lanzado la excepción NoEstaEntidadException.");
        } 
        catch (NoEstaEntidadException e)
        {
            fail("Se intentó buscar un profesor con un nombre nulo.");
        }
    }
    
    /**
     * @see pga.Manager#ubicarProfesor(String,String)
     */
    @Test
    public void testUbicarProfesorErroneo2_2()
    {
        try
        {
            this.fixture.manager.ubicarProfesor(this.fixture.profesor_b.getNombre(), null);
            fail("Tendrpia que haberse lanzado la excepción NoEstaEntidadException.");
        } 
        catch (NoEstaEntidadException e)
        {
            fail("Se intentó buscar un profesor con un apellido nulo.");
        }
    }
    
    /**
     * @see pga.Manager#ubicarProfesor(String,String)
     */
    @Test
    public void testUbicarProfesorErroneo4()
    {
        try
        {
            this.fixture.manager.ubicarProfesor(this.fixture.profesor_a.getApellido(), this.fixture.profesor_a.getNombre());
            fail("Tendría que haberse lanzado la excepción NoEstaEntidadException.");
        } 
        catch (NoEstaEntidadException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", "Ningún profesor encontrado.", e.getMessage());
        }
    }

}

package tests;

import exceptions.NoEstaEntidadException;

import java.util.HashMap;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import pga.Alumno;
import pga.Profesor;

public class UbicarProfesorTest
{
    TestFixtureProfesor fixture1 = new TestFixtureProfesor();

    public UbicarProfesorTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture1.setUpAgregarYModif();
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
    public void testUbicarProfesorExitoso()
    {
        try
        {
            HashMap<String, Profesor> hash = this.fixture1.manager.ubicarProfesor(
                                                this.fixture1.profesor_b.getNombre(), this.fixture1.profesor_b.getApellido());
            assertTrue("El profesor debería haber sido encontrado en el sistema.", hash.containsKey(this.fixture1.profesor_b.getLegajo()));
            
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
            this.fixture1.manager.ubicarProfesor(null, this.fixture1.profesor_b.getApellido());
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción NoEstaEntidadException");
        }
        catch(NullPointerException e)
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
            this.fixture1.manager.ubicarProfesor(this.fixture1.profesor_b.getNombre(), null);
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción NoEstaEntidadException");
        }
        catch(NullPointerException e)
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
            this.fixture1.manager.ubicarProfesor(this.fixture1.profesor_a.getApellido(), this.fixture1.profesor_a.getNombre());
            fail("Tendría que haberse lanzado la excepción NoEstaEntidadException.");
        } 
        catch (NoEstaEntidadException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", "Ningún profesor encontrado.", e.getMessage());
        }
    }

}

package tests;

import exceptions.NoEstaEntidadException;

import java.util.HashMap;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import pga.Alumno;

public class UbicarAlumnoTest
{
    private TestFixtureAlumno fixture = new TestFixtureAlumno();

    public UbicarAlumnoTest()
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
     * @see pga.Manager#ubicarAlumno(String,String)
     */
    @Test
    public void testUbicarAlumnoExitoso()
    {
        try
        {
            HashMap<String, Alumno> hash = this.fixture
                                               .manager
                                               .ubicarAlumno(this.fixture.alumno_b.getNombre(), this.fixture.alumno_b.getApellido());
            assertTrue("El alumno debería haber sido encontrado en el sistema.", hash.containsKey(this.fixture.alumno_b.getLegajo()));
            
        }
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción NoEstaEntidadException");
        }
    }
    
    /**
     * @see pga.Manager#ubicarAlumno(String,String)
     */
    @Test
    public void testUbicarAlumnoErroneo2_1()
    {
        try
        {
            this.fixture.manager.ubicarAlumno(null, this.fixture.alumno_b.getApellido());
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción NoEstaEntidadException");
        }
        catch(NullPointerException e)
        {
            fail("Se intentó buscar un alumno con un nombre nulo.");
        }
    }
    
    /**
     * @see pga.Manager#ubicarAlumno(String,String)
     */
    @Test
    public void testUbicarAlumnoErroneo2_2()
    {
        try
        {
            this.fixture.manager.ubicarAlumno(this.fixture.alumno_b.getNombre(), null);
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción NoEstaEntidadException");
        }
        catch(NullPointerException e)
        {
            fail("Se intentó buscar un alumno con un apellido nulo.");
        }
    }
    
    /**
     * @see pga.Manager#ubicarAlumno(String,String)
     */
    @Test
    public void testUbicarAlumnoErroneo4()
    {
        try
        {
            this.fixture.manager.ubicarAlumno(this.fixture.alumno_a.getApellido(), this.fixture.alumno_a.getNombre());
            fail("Tendría que haberse lanzado la excepción NoEstaEntidadException.");
        } 
        catch (NoEstaEntidadException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", e.getMessage(), "Ningún alumno encontrado.");
        }
    }
}

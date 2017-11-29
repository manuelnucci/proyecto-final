package testsCajaNegra;

import exceptions.NoEstaEntidadException;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class BajaAlumnoDeCursadaTest
{
    private TestFixtureAlumno fixture = new TestFixtureAlumno();

    public BajaAlumnoDeCursadaTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture.setUpBajaDeCursada();
    }

    @After
    public void tearDown() throws Exception
    {
        fixture.tearDown();
    }

    /**
     * @see pga.Manager#bajaAlumnoDeCursada(pga.Alumno,pga.Cursada)
     */
    @Test
    public void testBajaAlumnoDeCursadaExitoso()
    {
        try
        {
            this.fixture
                .manager
                .bajaAlumnoDeCursada(this.fixture.alumno_a, this.fixture.cursada_a);
            assertTrue("No se eliminó correctamente al alumno de la cursada.", 
                       !this.fixture.cursada_a.getAlumnos().containsKey(this.fixture.alumno_a.getLegajo()));
        }
        catch (NoEstaEntidadException e)
        {
            fail("No tendría que haberse lanzado la excepción NoEstaEntidadException ya que en el TestFixtureAlumno se agregó al alumno.");
        }
    }
    
    /**
     * @see pga.Manager#bajaAlumnoDeCursada(pga.Alumno,pga.Cursada)
     */
    @Test
    public void testBajaAlumnoDeCursadaErroneo_2_1()
    {
        try
        {
            this.fixture
                .manager
                .bajaAlumnoDeCursada(this.fixture.alumno_a, null);
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        }
        catch (NoEstaEntidadException e)
        {
            fail("No tendría que haberse lanzado la excepción NoEstaEntidadException.");
        }
        catch(NullPointerException e)
        {
            fail("Se intentó dar de baja un alumno de una cursada nula.");
        }
    }
    
    /**
     * @see pga.Manager#bajaAlumnoDeCursada(pga.Alumno,pga.Cursada)
     */
    @Test
    public void testBajaAlumnoDeCursadaErroneo_2_2()
    {
        try
        {
            this.fixture
                .manager
                .bajaAlumnoDeCursada(null, this.fixture.cursada_a);
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        }
        catch (NoEstaEntidadException e)
        {
            fail("No tendría que haberse lanzado la excepción NoEstaEntidadException.");
        }
        catch(NullPointerException e)
        {
            fail("Se intentó dar de baja de una cursada un alumno nulo.");
        }
    }
    
    /**
     * @see pga.Manager#bajaAlumnoDeCursada(pga.Alumno,pga.Cursada)
     */
    @Test
    public void testBajaAlumnoDeCursadaErroneo_4()
    {
        try
        {
            this.fixture
                .manager
                .bajaAlumnoDeCursada(this.fixture.alumno_b, this.fixture.cursada_a);
            fail("Tendría que haberse lanzado la excepción NoEstaEntidadException.");
        }
        catch (NoEstaEntidadException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", 
                         e.getMessage(), "Alumno no encontrado en la cursada.");
        }
    }
}

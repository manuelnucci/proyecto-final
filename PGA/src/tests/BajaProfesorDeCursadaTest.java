package tests;

import exceptions.NoEstaEntidadException;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class BajaProfesorDeCursadaTest
{
    private TestFixtureProfesor fixture = new TestFixtureProfesor();

    public BajaProfesorDeCursadaTest()
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
     * @see pga.Manager#bajaProfesorDeCursada(pga.Profesor,pga.Cursada)
     */
    @Test
    public void testBajaProfesorDeCursadaExitoso()
    {
        try
        {
            this.fixture
                .manager
                .bajaProfesorDeCursada(this.fixture.profesor_a, this.fixture.cursada_a);
            assertTrue("No se eliminó correctamente al profesor de la cursada.", 
                       !this.fixture.cursada_a.getProfesores().containsKey(this.fixture.profesor_a.getLegajo()));
        }
        catch (NoEstaEntidadException e)
        {
            fail("No tendría que haberse lanzado la excepción NoEstaEntidadException ya que en el TestFixtureProfesor se agregó al profesor.");
        }
    }
    
    /**
     * @see pga.Manager#bajaProfesorDeCursada(pga.Profesor,pga.Cursada)
     */
    @Test
    public void testBajaProfesorDeCursadaErroneo_2_1()
    {
        try
        {
            this.fixture
                .manager
                .bajaProfesorDeCursada(this.fixture.profesor_a, null);
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        }
        catch (NoEstaEntidadException e)
        {
            fail("No tendría que haberse lanzado la excepción NoEstaEntidadException.");
        }
        catch(NullPointerException e)
        {
            fail("Se intentó dar de baja un profesor de una cursada nula.");
        }
    }
    
    /**
     * @see pga.Manager#bajaProfesorDeCursada(pga.Profesor,pga.Cursada)
     */
    @Test
    public void testBajaProfesorDeCursadaErroneo_2_2()
    {
        try
        {
            this.fixture
                .manager
                .bajaProfesorDeCursada(null, this.fixture.cursada_a);
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        }
        catch (NoEstaEntidadException e)
        {
            fail("No tendría que haberse lanzado la excepción NoEstaEntidadException.");
        }
        catch(NullPointerException e)
        {
            fail("Se intentó dar de baja de una cursada un profesor nulo.");
        }
    }
    
    /**
     * @see pga.Manager#bajaProfesorDeCursada(pga.Profesor,pga.Cursada)
     */
    @Test
    public void testBajaProfesorDeCursadaErroneo_4()
    {
        try
        {
            this.fixture
                .manager
                .bajaProfesorDeCursada(this.fixture.profesor_b, this.fixture.cursada_a);
            fail("Tendría que haberse lanzado la excepción NoEstaEntidadException.");
        }
        catch (NoEstaEntidadException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", 
                         e.getMessage(), "Profesor no encontrado en la cursada.");
        }
    }
}

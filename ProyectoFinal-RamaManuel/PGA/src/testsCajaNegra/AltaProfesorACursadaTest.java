package testsCajaNegra;

import exceptions.EntidadNoAptaParaCursadaException;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class AltaProfesorACursadaTest
{
    TestFixtureProfesor fixture = new TestFixtureProfesor();

    public AltaProfesorACursadaTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture.setUpAgregarACursada();
    }

    @After
    public void tearDown() throws Exception
    {
        fixture.tearDown();
    }

    /**
     * @see pga.Manager#altaProfesorACursada(pga.Profesor,pga.Cursada)
     */
    @Test
    public void testAltaProfesorACursadaExitoso()
    {
        try
        {
            this.fixture
                .manager
                .altaProfesorACursada(this.fixture.profesor_b, this.fixture.cursada_b);
            assertTrue("El profesor no se incribió correctamente en la cursada.", this.fixture.cursada_b.getProfesores().containsKey(this.fixture.profesor_b.getLegajo()));
        } 
        catch (EntidadNoAptaParaCursadaException e)
        {
            fail("No tendría que haberse lanzado la excepción EntidadNoAptaParaCursadaException ya que en el TestFixtureProfesor se arregló el escenario para que esto no ocurra.");
        }
    }
    
    /**
     * @see pga.Manager#altaProfesorACursada(pga.Profesor,pga.Cursada)
     */
    @Test
    public void testAltaProfesorACursadaErroneo_2_1()
    {
        try
        {
            this.fixture
                .manager
                .altaProfesorACursada(this.fixture.profesor_b, null);
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        } 
        catch (EntidadNoAptaParaCursadaException e)
        {
            fail("No tendría que haberse lanzado la excepción EntidadNoAptaParaCursadaException.");
        }
        catch(NullPointerException e)
        {
            fail("Se intentó agregar un profesor a una cursada nula.");
        }
    }
    
    /**
     * @see pga.Manager#altaProfesorACursada(pga.Profesor,pga.Cursada)
     */
    @Test
    public void testAltaProfesorACursadaErroneo_2_2()
    {
        try
        {
            this.fixture
                .manager
                .altaProfesorACursada(null, this.fixture.cursada_b);
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        } 
        catch (EntidadNoAptaParaCursadaException e)
        {
            fail("No tendría que haberse lanzado la excepción EntidadNoAptaParaCursadaException");
        }
        catch(NullPointerException e)
        {
            fail("Se intentó agregar a una cursada un profesor nulo.");
        }
    }
    
    /**
     * @see pga.Manager#altaProfesorACursada(pga.Profesor,pga.Cursada)
     */
    @Test
    public void testAltaProfesorACursadaErroneo_6()
    {
        try
        {
            this.fixture
                .manager
                .altaProfesorACursada(this.fixture.profesor_a, this.fixture.cursada_c);
            fail("Tendría que haberse lanzado la excepción EntidadNoAptaParaCursadaException.");
        } 
        catch (EntidadNoAptaParaCursadaException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", 
                         e.getMessage(), "El profesor no está habilitado para dictar la cursada.");
        }
    }
    
    /**
     * @see pga.Manager#altaProfesorACursada(pga.Profesor,pga.Cursada)
     */
    @Test
    public void testAltaProfesorACursadaErroneo_8()
    {
        try
        {
            this.fixture
                .manager
                .altaProfesorACursada(this.fixture.profesor_a, this.fixture.cursada_d);
            fail("Tendría que haberse lanzado la excepción EntidadNoAptaParaCursadaException.");
        } 
        catch (EntidadNoAptaParaCursadaException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", 
                         e.getMessage(), "El profesor no cumple con las franjas horarias para inscribirse a la cursada");
        }
    }
}

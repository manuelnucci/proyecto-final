package testsCajaNegra;

import exceptions.NoEstaEntidadException;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class BajaProfesorTest
{
    private TestFixtureProfesor fixture = new TestFixtureProfesor();

    public BajaProfesorTest()
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
     * @see pga.Manager#bajaProfesor(pga.Profesor)
     */
    @Test
    public void testBajaProfesorExitoso()
    {
        try
        {
            this.fixture.manager.bajaProfesor(this.fixture.profesor_a);
        } catch (NoEstaEntidadException e)
        {
            fail("No tendria que lanzar la excepcion de que no esta la entidad");
        }
    }
    
    /**
     * @see pga.Manager#bajaProfesor(pga.Profesor)
     */
    @Test
    public void testBajaProfesorErroneo_2()
    {
        
        try
        {
            this.fixture.manager.bajaProfesor(null);
            fail("Tendria que lanzar la excepcion NullPointerException");
        } catch (NoEstaEntidadException e)
        {
            fail("No tendria que lanzar la excepcion de que no esta la entidad");
        } catch(NullPointerException e)
        {
            fail("Se intento dar de baja a un profesor nulo");
        }
        
    }

    /**
     * @see pga.Manager#bajaProfesor(pga.Profesor)
     */
    @Test
    public void testBajaProfesorErroneo_4()
    {
        
        try
        {
            this.fixture.manager.bajaProfesor(this.fixture.profesor_b);
            fail("El método debería haber lanzado la excepción NoEstaEntidadException.");
        } 
        catch (NoEstaEntidadException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", e.getMessage(), "Profesor no encontrado en el sistema.");
        }      
    }
    
    /**
     * @see pga.Manager#bajaProfesor(pga.Profesor)
     */
    @Test
    public void testBajaAlumnoErroneo6()
    {
        
        try
        {
            this.fixture.manager.bajaProfesor(this.fixture.profesor_c);
            assertTrue("La cursada aún contiene al alumno a eliminar.", this.fixture.cursada_a.getProfesores().containsKey(this.fixture.profesor_c.getLegajo()));
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción porque en el TextFicture se lo agregó.");
        }
        
    }

}

package tests;

import exceptions.NoEstaEntidadException;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class BajaProfesorTest
{
    TestFixtureProfesor fixture1 = new TestFixtureProfesor();

    public BajaProfesorTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture1.setUpBaja();
    }

    @After
    public void tearDown() throws Exception
    {
        fixture1.tearDown();
    }

    /**
     * @see pga.Manager#bajaProfesor(pga.Profesor)
     */
    @Test
    public void testBajaProfesorExitoso()
    {
        try
        {
            this.fixture1.manager.bajaProfesor(this.fixture1.profesor_a);
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
            this.fixture1.manager.bajaProfesor(null);
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
            this.fixture1.manager.bajaProfesor(null);
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
    public void testBajaAlumnoErroneo6()
    {
        
        try
        {
            this.fixture1.manager.bajaProfesor(this.fixture1.profesor_c);
            assertTrue("La cursada a�n contiene al alumno a eliminar.", this.fixture1.cursada.getProfesores().containsKey(this.fixture1.profesor_c.getLegajo()));
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No deber�a lanzarse la excepci�n porque en el TextFicture se lo agreg�.");
        }
        
    }

}
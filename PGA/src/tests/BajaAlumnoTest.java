package tests;

import exceptions.NoEstaEntidadException;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class BajaAlumnoTest
{
    private TestFixtureAlumno fixture = new TestFixtureAlumno();

    public BajaAlumnoTest()
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
     * @see pga.Manager#bajaAlumno(pga.Alumno)
     */
    @Test
    public void testBajaAlumnoExitoso()
    {
        try
        {
            this.fixture
                .manager
                .bajaAlumno(this.fixture.alumno_a);
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción NoEstaEntidadException");
        }
    }
    
    /**
     * @see pga.Manager#bajaAlumno(pga.Alumno)
     */
    @Test
    public void testBajaAlumnoErroneo2()
    {
        try
        {
            this.fixture
                .manager
                .bajaAlumno(null);
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción NoEstaEntidadException");
        }
        catch(NullPointerException e)
        {
            fail("Se intentó borrar un alumno nulo.");
        }
    }
    
    /**
     * @see pga.Manager#bajaAlumno(pga.Alumno)
     */
    @Test
    public void testBajaAlumnoErroneo4()
    {
        try
        {
            this.fixture
                .manager
                .bajaAlumno(this.fixture.alumno_b);
            fail("El método debería haber lanzado la excepción NoEstaEntidadException.");
        } 
        catch (NoEstaEntidadException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", e.getMessage(), "Alumno no encontrado en el sistema.");
        }
    }
    
    /**
     * @see pga.Manager#bajaAlumno(pga.Alumno)
     */
    @Test
    public void testBajaAlumnoErroneo6()
    {
        try
        {
            this.fixture
                .manager
                .bajaAlumno(this.fixture.alumno_c);
            assertTrue("La cursada aún contiene al alumno a eliminar.", this.fixture.
                                                                             cursada.
                                                                             getAlumnos().
                                                                             containsKey(this.fixture.alumno_c.getLegajo()));
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción porque en el TextFicture se lo agregó.");
        }
    }
    
}

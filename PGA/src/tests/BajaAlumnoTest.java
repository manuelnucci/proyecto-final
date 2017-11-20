package tests;

import exceptions.NoEstaEntidadException;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import pga.Alumno;

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
            assertTrue("La colección de alumnos aún contiene al alumno eliminado.", 
                       !this.tieneAlumno(this.fixture.alumno_a, this.fixture.manager.getAlumnos()));
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
    public void testBajaAlumnoErroneo_2()
    {
        try
        {
            this.fixture
                .manager
                .bajaAlumno(null);
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
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
    public void testBajaAlumnoErroneo_4()
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
    public void testBajaAlumnoErroneo_6()
    {
        try
        {
            this.fixture
                .manager
                .bajaAlumno(this.fixture.alumno_c);
            assertTrue("La cursada aún contiene al alumno a eliminar.", this.fixture.
                                                                             cursada_a.
                                                                             getAlumnos().
                                                                             containsKey(this.fixture.alumno_c.getLegajo()));
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción porque en el TestFixtureAlumno se lo agregó.");
        }
    }
    
    private boolean tieneAlumno(Alumno alumno, HashMap<String, HashMap<String, Alumno>> hash)
    {
        Iterator<HashMap<String, Alumno>> itH;
        boolean sigue = true;
        
        itH = hash.values().iterator();
        while (itH.hasNext() && sigue)
        {
            if (itH.next().containsKey(alumno.getLegajo()))
                sigue = false;
        }
        return !sigue;
    }
}

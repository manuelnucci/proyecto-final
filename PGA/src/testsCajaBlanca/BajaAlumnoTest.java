package testsCajaBlanca;

import exceptions.NoEstaEntidadException;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

import pga.Alumno;

public class BajaAlumnoTest
{
    private TestFixtureAlumno fixture = new TestFixtureAlumno();

    public BajaAlumnoTest()
    {
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
    public void testBajaAlumnoCamino1() throws Exception
    {
        try
        {
            this.fixture.setUpBajaAlumnoCamino1();
            this.fixture
                .manager
                .bajaAlumno(this.fixture.alumno_a);
            fail("Tendría que haberse lanzado la excepción NoEstaEntidadException.");
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
    public void testBajaAlumnoCamino2() throws Exception
    {
        try
        {
            this.fixture.setUpBajaAlumnoCamino2();
            this.fixture
                .manager
                .bajaAlumno(this.fixture.alumno_b);
            fail("Tendría que haberse lanzado la excepción NoEstaEntidadException.");
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
    public void testBajaAlumnoCamino3() throws Exception
    {
        try
        {
            this.fixture.setUpBajaAlumnoCamino3();
            this.fixture
                .manager
                .bajaAlumno(this.fixture.alumno_b);
            assertTrue("La colección de alumnos aún contiene al alumno eliminado.", 
                       !this.tieneAlumno(this.fixture.alumno_b, this.fixture.manager.getAlumnos()));
        }
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción NoEstaEntidadException.");
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

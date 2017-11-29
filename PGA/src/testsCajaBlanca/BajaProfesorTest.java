package testsCajaBlanca;

import exceptions.NoEstaEntidadException;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

import pga.Profesor;

public class BajaProfesorTest
{
    private TestFixtureProfesor fixture = new TestFixtureProfesor();

    public BajaProfesorTest()
    {
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
    public void testBajaProfesorCamino1() throws Exception
    {
        try
        {
            this.fixture.setUpBajaProfesorCamino1();
            this.fixture
                .manager
                .bajaProfesor(this.fixture.profesor_a);
            fail("Tendría que haberse lanzado la excepción NoEstaEntidadException.");
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
    public void testBajaProfesorCamino2() throws Exception
    {
        try
        {
            this.fixture.setUpBajaProfesorCamino2();
            this.fixture
                .manager
                .bajaProfesor(this.fixture.profesor_b);
            fail("Tendría que haberse lanzado la excepción NoEstaEntidadException.");
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
    public void testBajaProfesorCamino3() throws Exception
    {
        try
        {
            this.fixture.setUpBajaProfesorCamino3();
            this.fixture
                .manager
                .bajaProfesor(this.fixture.profesor_b);
            assertTrue("La colección de profesores aún contiene al profesor eliminado.", 
                       !this.tieneProfesor(this.fixture.profesor_b, this.fixture.manager.getProfesores()));
        }
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción NoEstaEntidadException.");
        }
    }
    
    private boolean tieneProfesor(Profesor profesor, HashMap<String, HashMap<String, Profesor>> hash)
    {
        Iterator<HashMap<String, Profesor>> itH;
        boolean sigue = true;
        
        itH = hash.values().iterator();
        while (itH.hasNext() && sigue)
        {
            if (itH.next().containsKey(profesor.getLegajo()))
                sigue = false;
        }
        return !sigue;
    }
}

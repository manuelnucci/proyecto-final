package tests;

import exceptions.NoEstaEntidadException;

import java.util.HashMap;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import pga.Cursada;
import pga.Profesor;

public class UbicarCursadaTest
{
    TestFixtureCursada fixture1 = new TestFixtureCursada();

    public UbicarCursadaTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture1.setUpUbicar();
    }

    @After
    public void tearDown() throws Exception
    {
        fixture1.tearDown();
    }

    /**
     * @see pga.Manager#ubicarCursada(String)
     */
    @Test
    public void testUbicarCursadaExitosa()
    {
        
        try
        {
            HashMap<String, Cursada> hash = this.fixture1.manager.ubicarCursada("Cursada Mate A 2");
            assertTrue("La cursada debería haber sido encontrada en el sistema.", hash.containsKey(this.fixture1.cursada_b.getId()));
        } catch (NoEstaEntidadException e)
        {
            fail("No tendria que haber salido por la excepcion NoEstaEntidadException");
        }
        
    }
    
    /**
     * @see pga.Manager#ubicarCursada(String)
     */
    @Test
    public void testUbicarCursadaErronea_2()
    {
        
        try
        {
            HashMap<String, Cursada> hash = this.fixture1.manager.ubicarCursada(null);
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        } catch (NoEstaEntidadException e)
        {
            fail("No tendria que haber salido por la excepcion NoEstaEntidadException");
        } catch (NullPointerException e)
        {
            fail("Se intentó buscar una cursada con un nombre nulo.");
        }
        
    }
    
    /**
     * @see pga.Manager#ubicarCursada(String)
     */
    @Test
    public void testUbicarCursadaErronea_4()
    {
        
        try
        {
            HashMap<String, Cursada> hash = this.fixture1.manager.ubicarCursada("Cursada Mate A 4");
            fail("Tendría que haberse lanzado la excepción NoEstaEntidadException.");
        } catch (NoEstaEntidadException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", "Cursada no encontrada en el sistema.", e.getMessage());
        }
        
    }
}

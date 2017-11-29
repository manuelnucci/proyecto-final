package testsCajaBlanca;

import exceptions.NoEstaEntidadException;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;
import org.junit.Test;

import pga.Cursada;

public class BajaCursadaTest
{
    private TestFixtureCursada fixture = new TestFixtureCursada();

    public BajaCursadaTest()
    {
    }

    @After
    public void tearDown() throws Exception
    {
        fixture.tearDown();
    }

    /**
     * @see pga.Manager#bajaCursada(pga.Cursada)
     */
    @Test
    public void testBajaCursadaCamino1() throws Exception
    {
        try
        {
            this.fixture.setUpBajaCursadaCamino1();
            this.fixture
                .manager
                .bajaCursada(this.fixture.cursada_a);
            fail("Tendría que haberse lanzado la excepción NoEstaEntidadException.");
        }
        catch (NoEstaEntidadException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", e.getMessage(), "Cursada no encontrada en el sistema.");
        }
    }
    
    /**
     * @see pga.Manager#bajaCursada(pga.Cursada)
     */
    @Test
    public void testBajaCursadaCamino2() throws Exception
    {
        try
        {
            this.fixture.setUpBajaCursadaCamino2();
            this.fixture
                .manager
                .bajaCursada(this.fixture.cursada_b);
            fail("Tendría que haberse lanzado la excepción NoEstaEntidadException.");
        }
        catch (NoEstaEntidadException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", e.getMessage(), "Cursada no encontrada en el sistema.");
        }
    }
    
    /**
     * @see pga.Manager#bajaCursada(pga.Cursada)
     */
    @Test
    public void testBajaCursadaCamino3() throws Exception
    {
        try
        {
            this.fixture.setUpBajaCursadaCamino3();
            this.fixture
                .manager
                .bajaCursada(this.fixture.cursada_b);
            assertFalse("La colección de cursadas aún contiene a la cursada eliminada.", this.existeCursada(this.fixture.cursada_b));
        }
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción NoEstaEntidadException.");
        }
    }
    
    private boolean existeCursada(Cursada cursada)
    {
        Iterator<HashMap<String, Cursada>> it = this.fixture.manager.getCursadas().values().iterator();
        boolean sigue = true;
        
        while(it.hasNext() && sigue)
        {
            sigue = !it.next().containsKey(cursada.getId());
        }
        return !sigue;
    }
}

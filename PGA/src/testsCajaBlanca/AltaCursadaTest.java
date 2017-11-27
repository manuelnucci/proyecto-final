package testsCajaBlanca;

import exceptions.HoraInvalidaException;
import exceptions.PeriodoInvalidoException;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import pga.Cursada;

public class AltaCursadaTest
{
    private TestFixtureCursada fixture = new TestFixtureCursada();

    public AltaCursadaTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture.setUpAltaCursada();
    }

    @After
    public void tearDown() throws Exception
    {
        fixture.tearDown();
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaCamino4()
    {
        try
        {
            int size = this.cantidadCursadas(this.fixture.manager.getCursadas());
            this.fixture
                .manager
                .altaCursada("Mi cursada", this.fixture.asignatura, "02-2017", "Lunes", "12:00", "14:00");
            assertTrue("La cursada no se agregó correctamente al sistema.", 
                       this.cantidadCursadas(this.fixture.manager.getCursadas()) == size + 1);
        }
        catch (HoraInvalidaException e)
        {
            fail("No debería haberse lanzado la excepción HoraInvalidaException.");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No debería haberse lanzado la excepción PeriodoInvalidoException.");
        }
    }
    
    private int cantidadCursadas(HashMap<String, HashMap<String, Cursada>> hash)
    {
        Iterator<HashMap<String, Cursada>> itH;
        Iterator<Cursada> itC;
        int ret = 0;
        
        itH = hash.values().iterator();
        while (itH.hasNext())
        {
            itC = itH.next().values().iterator();
            while (itC.hasNext())
            {
                itC.next();
                ret++;
            }
        }
        return ret;
    }
}

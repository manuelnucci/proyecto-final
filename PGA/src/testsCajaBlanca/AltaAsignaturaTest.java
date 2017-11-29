package testsCajaBlanca;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.After;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import pga.Asignatura;

public class AltaAsignaturaTest
{
    private TestFixtureAsignatura fixture = new TestFixtureAsignatura();

    public AltaAsignaturaTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture.setUpAltaAsignaturaCamino1();
    }

    @After
    public void tearDown() throws Exception
    {
        fixture.tearDown();
    }

    /**
     * @see pga.Manager#altaAsignatura(String)
     */
    @Test
    public void testAltaAsignaturaCamino1()
    {
        int size = this.cantidadAsignaturas(this.fixture.manager.getAsignaturas());
        this.fixture.manager.altaAsignatura("Programación");
        assertTrue("La asignatura no se agregó correctamente al sistema.", 
                       this.cantidadAsignaturas(this.fixture.manager.getAsignaturas()) == size + 1);
    }
    
    private int cantidadAsignaturas(HashMap<String, HashMap<String, Asignatura>> hash)
    {
        Iterator<HashMap<String, Asignatura>> itH;
        Iterator<Asignatura> itA;
        int ret = 0;
        
        itH = hash.values().iterator();
        while (itH.hasNext())
        {
            itA = itH.next().values().iterator();
            while (itA.hasNext())
            {
                itA.next();
                ret++;
            }
        }
        return ret;
    }
}

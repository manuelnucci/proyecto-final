package testsCajaBlanca;

import exceptions.EmailInvalidoException;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import pga.Alumno;

public class AltaAlumnoTest
{
    private TestFixtureAlumno fixture = new TestFixtureAlumno();

    public AltaAlumnoTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture.setUpAltaAlumno();
    }

    @After
    public void tearDown() throws Exception
    {
        fixture.tearDown();
    }

    /**
     * @see pga.Manager#altaAlumno(String,String,String,String,String)
     */
    @Test
    public void testAltaAlumnoCamino2()
    {
        try
        {
            int size = this.cantidadAlumnos(this.fixture.manager.getAlumnos());
            this.fixture
                .manager
                .altaAlumno("Manuel", "Nucci", "Jujuy 345", "123456789", "nucci@gmail.com");
            assertTrue("El alumno no se agregó correctamente al sistema.", 
                       this.cantidadAlumnos(this.fixture.manager.getAlumnos()) == size + 1);
        }
        catch (EmailInvalidoException e)
        {
            fail("No tendría que lanzarse la excepción EmailInvalidoException.");
        }
    }
    
    private int cantidadAlumnos(HashMap<String, HashMap<String, Alumno>> hash)
    {
        Iterator<HashMap<String, Alumno>> itH;
        Iterator<Alumno> itA;
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

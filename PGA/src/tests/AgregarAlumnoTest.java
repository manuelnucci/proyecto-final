package tests;

import exceptions.EmailInvalidoException;

import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class AgregarAlumnoTest
{
    private TestFixture fixture = new TestFixture(); 
    
    public AgregarAlumnoTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
    }

    @After
    public void tearDown() throws Exception
    {
    }

    /**
     * @see pga.Manager#altaAlumno(String,String,String,String,String)
     */
    @Test
    public void testAltaAlumnoExitoso_1()
    {   
        int size = this.fixture.manager.getAlumnos().size();
        try
        {
            this.fixture.manager.altaAlumno("Martin", "Perez", "Catamarca 2050", "2235235475", "mprez@live.com");
        } catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
        assertTrue("El alumno se agregó bien al sistema", this.fixture.manager.getAlumnos().size() == size + 1);
    }
}

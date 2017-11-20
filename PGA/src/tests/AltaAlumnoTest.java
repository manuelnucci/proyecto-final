package tests;

import exceptions.EmailInvalidoException;

import org.junit.After;
import static org.junit.Assert.assertEquals;
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
        this.fixture.setUpAgregarYModif();
    }

    @After
    public void tearDown() throws Exception
    {
        this.fixture.tearDown();
    }

    /**
     * @see pga.Manager#altaAlumno(String,String,String,String,String)
     */
    @Test
    public void testAltaAlumnoExitoso_1_1()
    {   
        try
        {
            int size = this.fixture.manager.getAlumnos().size();
            this.fixture.manager.altaAlumno("Martin", "Perez", "Catamarca 2050", "2235235475", "mprez@live.com");
            assertTrue("El alumno no se modificó correctamente en el sistema.", this.fixture.manager.getAlumnos().size() == size + 1);
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
    }
    
    /**
     * @see pga.Manager#altaAlumno(String,String,String,String,String)
     */
    @Test
    public void testAltaAlumnoExitoso_1_2()
    {   
        try
        {
            int size = this.fixture.manager.getAlumnos().size();
            this.fixture.manager.altaAlumno("M", "P", "D", "1", "a@j");
            assertTrue("El alumno no se agregó bien al sistema.", this.fixture.manager.getAlumnos().size() == size + 1);
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
    }
    
    /**
     * @see pga.Manager#altaAlumno(String,String,String,String,String)
     */
    @Test
    public void testAltaAlumnoErroneo_2_2()
    {   
        try
        {
            this.fixture.manager.altaAlumno(null, "Quito", "Alvear 123", "4756545", "mimail@gmail.com");
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
        catch (NullPointerException e)
        {
            fail("Se intentó agregar un alumno con un nombre nulo.");
        }
    }
    
    /**
     * @see pga.Manager#altaAlumno(String,String,String,String,String)
     */
    @Test
    public void testAltaAlumnoErroneo_2_3()
    {   
        try
        {
            this.fixture.manager.altaAlumno("Adolfo", null, "Alvear 123", "4756545", "mimail@gmail.com");
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
        catch (NullPointerException e)
        {
            fail("Se intentó agregar un alumno con un apellido nulo.");
        }
    }
    
    /**
     * @see pga.Manager#altaAlumno(String,String,String,String,String)
     */
    @Test
    public void testAltaAlumnoErroneo_2_4()
    {   
        try
        {
            this.fixture.manager.altaAlumno("Leonel", "Quito", null, "4756545", "mimail@gmail.com");
            fail("Se intentó agregar un alumno con un domicilio nulo.");
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
    }
    
    /**
     * @see pga.Manager#altaAlumno(String,String,String,String,String)
     */
    @Test
    public void testAltaAlumnoErroneo_2_5()
    {   
        try
        {
            this.fixture.manager.altaAlumno("Aquiles", "Bailo", "Alvear 123", null, "mimail@gmail.com");
            fail("Se intentó agregar un alumno con un teléfono nulo.");
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
    }
    
    /**
     * @see pga.Manager#altaAlumno(String,String,String,String,String)
     */
    @Test
    public void testAltaAlumnoErroneo_2_6()
    {   
        try
        {
            this.fixture.manager.altaAlumno("Elsa", "Pato", "Alvear 123", "4756545", null);
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
        catch (NullPointerException e)
        {
            fail("Se intentó agregar un alumno con un email nulo.");
        }
    }
    
    /**
     * @see pga.Manager#altaAlumno(String,String,String,String,String)
     */
    @Test
    public void testAltaAlumnoErroneo_4_2()
    {   
        try
        {
            this.fixture.manager.altaAlumno("", "Quito", "Alvear 123", "4756545", "mimail@gmail.com");
            fail("Se intentó agregar un alumno con un nombre vacío.");
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
    }
    
    /**
     * @see pga.Manager#altaAlumno(String,String,String,String,String)
     */
    @Test
    public void testAltaAlumnoErroneo_4_3()
    {   
        try
        {
            this.fixture.manager.altaAlumno("Adolfo", "", "Alvear 123", "4756545", "mimail@gmail.com");
            fail("Se intentó agregar un alumno con un apellido vacío.");
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
    }
    
    /**
     * @see pga.Manager#altaAlumno(String,String,String,String,String)
     */
    @Test
    public void testAltaAlumnoErroneo_4_4()
    {   
        try
        {
            this.fixture.manager.altaAlumno("Leonel", "Quito", "", "4756545", "mimail@gmail.com");
            fail("Se intentó agregar un alumno con un domicilio vacío.");
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
    }
    
    /**
     * @see pga.Manager#altaAlumno(String,String,String,String,String)
     */
    @Test
    public void testAltaAlumnoErroneo_4_5()
    {   
        try
        {
            this.fixture.manager.altaAlumno("Aquiles", "Bailo", "Alvear 123", "", "mimail@gmail.com");
            fail("Se intentó agregar un alumno con un teléfono vacío.");
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
    }
    
    /**
     * @see pga.Manager#altaAlumno(String,String,String,String,String)
     */
    @Test
    public void testAltaAlumnoErroneo_4_6()
    {   
        try
        {
            this.fixture.manager.altaAlumno("Elsa", "Pato", "Alvear 123", "4756545", "");
            fail("Tendría que haberse lanzado la excepción EmailInvalidoException.");
        } 
        catch (EmailInvalidoException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", e.getMessage(), "El mail ingresado no cumple con el formato previsto.");
        }
    }
    
    /**
     * @see pga.Manager#altaAlumno(String,String,String,String,String)
     */
    @Test
    public void testAltaAlumnoErroneo_8_1()
    {   
        try
        {
            this.fixture.manager.altaAlumno("Elsa", "Pato", "Alvear 123", "4756545", "@mail");
            fail("Tendría que haberse lanzado la excepción EmailInvalidoException.");
        } 
        catch (EmailInvalidoException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", e.getMessage(), "El mail ingresado no cumple con el formato previsto.");
        }
    }
    
    /**
     * @see pga.Manager#altaAlumno(String,String,String,String,String)
     */
    @Test
    public void testAltaAlumnoErroneo_8_2()
    {   
        try
        {
            this.fixture.manager.altaAlumno("Elsa", "Pato", "Alvear 123", "4756545", "mail@");
            fail("Tendría que haberse lanzado la excepción EmailInvalidoException.");
        } 
        catch (EmailInvalidoException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", e.getMessage(), "El mail ingresado no cumple con el formato previsto.");
        }
    }
    
    /**
     * @see pga.Manager#altaAlumno(String,String,String,String,String)
     */
    @Test
    public void testAltaAlumnoErroneo_8_3()
    {   
        try
        {
            this.fixture.manager.altaAlumno("Elsa", "Pato", "Alvear 123", "4756545", "mail");
            fail("Tendría que haberse lanzado la excepción EmailInvalidoException.");
        } 
        catch (EmailInvalidoException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", e.getMessage(), "El mail ingresado no cumple con el formato previsto.");
        }
    }
    
    /**
     * @see pga.Manager#altaAlumno(String,String,String,String,String)
     */
    @Test
    public void testAltaAlumnoErroneo_10()
    {   
        try
        {
            Alumno.setLegajoAlumno(Alumno.getLegajoAlumno() - 1);
            this.fixture.manager.altaAlumno("Elsa", "Pato", "Alvear 123", "4756545", "mail");
            fail("Tendría que haberse lanzado la excepción EntidadRepetidaException que no está contemplada en el método.");
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
    }  
}

package tests;

import exceptions.EmailInvalidoException;

import exceptions.NoEstaEntidadException;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class AltaProfesorTest
{
    private TestFixtureProfesor fixture = new TestFixtureProfesor(); 
    
    public AltaProfesorTest()
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
     * @see pga.Manager#altaProfesor(String,String,String,String,String)
     */
    @Test
    public void testModificacionProfesorExitoso_1_1()
    {   
        try
        {
            int size = this.fixture.manager.getAlumnos().size();
            this.fixture.manager.altaProfesor("Oscar", "Acol", "Entre Rios 2674", "2235235475", "oacol@live.com");
            assertTrue("El profesor se agrego correctamente al sistema", this.fixture.manager.getAlumnos().size() == size + 1);
        } catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
    }
    
    /**
     * @see pga.Manager#altaProfesor(String,String,String,String,String)
     */
    @Test
    public void testModificacionProfesorExitoso_1_2()
    {   
        try
        {
            int size = this.fixture.manager.getAlumnos().size();
            this.fixture.manager.altaProfesor("M", "P", "D", "1", "a@j");
            assertTrue("El profesor se agrego correctamente al sistema", this.fixture.manager.getAlumnos().size() == size + 1);
        } catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
    }
    
    /**
     * @see pga.Manager#altaProfesor(String,String,String,String,String)
     */
    @Test
    public void testAltaProfesorErroneo_2_2()
    {   
        try
        {
            this.fixture.manager.altaProfesor(null, "Quito", "Alvear 123", "4756545", "mimail@gmail.com");
            fail("Tendria que haberse lanzado la excepcion NullPointerException");
        } catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
        catch (NullPointerException e)
        {
            fail("Se intento agregar un profesor con un nombre nulo.");
        }
    }
    
    /**
     * @see pga.Manager#altaProfesor(String,String,String,String,String)
     */
    @Test
    public void testAltaProfesorErroneo_2_3()
    {   
        try
        {
            this.fixture.manager.altaProfesor("Adolfo", null, "Alvear 123", "4756545", "mimail@gmail.com");
            fail("Tendria que haberse lanzado la excepcion NullPointerException");
        } catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
        catch (NullPointerException e)
        {
            fail("Se intento agregar un profesor con un apellido nulo.");
        }
    }
    
    /**
     * @see pga.Manager#altaProfesor(String,String,String,String,String)
     */
    @Test
    public void testAltaProfesorErroneo_2_4()
    {   
        try
        {
            this.fixture.manager.altaProfesor("Leonel", "Quito", null, "4756545", "mimail@gmail.com");
            fail("Se agrego un profesor con un domicilio nulo.");
        } catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
    }
    
    /**
     * @see pga.Manager#altaProfesor(String,String,String,String,String)
     */
    @Test
    public void testAltaProfesorErroneo_2_5()
    {   
        try
        {
            this.fixture.manager.altaProfesor("Aquiles", "Bailo", "Alvear 123", null, "mimail@gmail.com");
            fail("Se agrego un profesor con telefono nulo");
        } catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
    }
    
    /**
     * @see pga.Manager#altaProfesor(String,String,String,String,String)
     */
    @Test
    public void testAltaProfesorErroneo_2_6()
    {   
        try
        {
            this.fixture.manager.altaProfesor("Elsa", "Pato", "Alvear 123", "4756545", null);
            fail("Tendria que haberse lanzado la excepcion NullPointerException");
        } catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
        catch (NullPointerException e)
        {
            fail("Se intento agregar un profesor con mail nulo.");
        }
    }
    
    /**
     * @see pga.Manager#altaProfesor(String,String,String,String,String)
     */
    @Test
    public void testAltaProfesorErroneo_4_2()
    {   
        try
        {
            this.fixture.manager.altaProfesor("", "Quito", "Alvear 123", "4756545", "mimail@gmail.com");
            fail("Se agrego un profesor con un nombre vacio.");
        } catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
    }
    
    /**
     * @see pga.Manager#altaProfesor(String,String,String,String,String)
     */
    @Test
    public void testAltaProfesorErroneo_4_3()
    {   
        try
        {
            this.fixture.manager.altaProfesor("Adolfo", "", "Alvear 123", "4756545", "mimail@gmail.com");
            fail("Se agrego un profesor con un apellido vacio.");
        } catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
    }
    
    /**
     * @see pga.Manager#altaProfesor(String,String,String,String,String)
     */
    @Test
    public void testAltaProfesorErroneo_4_4()
    {   
        try
        {
            this.fixture.manager.altaProfesor("Leonel", "Quito", "", "4756545", "mimail@gmail.com");
            fail("Se agrego un profesor con un domicilio vacio.");
        } catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
    }
    
    /**
     * @see pga.Manager#altaProfesor(String,String,String,String,String)
     */
    @Test
    public void testAltaProfesorErroneo_4_5()
    {   
        try
        {
            this.fixture.manager.altaProfesor("Aquiles", "Bailo", "Alvear 123", "", "mimail@gmail.com");
            fail("Se agrego un profesor con un telefono vacio.");
        } catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        }
    }
    
    /**
     * @see pga.Manager#altaProfesor(String,String,String,String,String)
     */
    @Test
    public void testAltaProfesorErroneo_4_6()
    {   
        try
        {
            this.fixture.manager.altaProfesor("Elsa", "Pato", "Alvear 123", "4756545", "");
            fail("Tendria que haberse lanzado la excepcion EmailInvalidoException");
        } catch (EmailInvalidoException e)
        {
            assertEquals("Las excepciones no coinciden", "El mail ingresado no cumple con el formato previsto.", e.getMessage());
        }
    }
    
    /**
     * @see pga.Manager#altaProfesor(String,String,String,String,String)
     */
    @Test
    public void testAltaProfesorErroneo_8_1()
    {   
        try
        {
            this.fixture.manager.altaProfesor("Elsa", "Pato", "Alvear 123", "4756545", "@gmail.com");
            fail("Tendria que haberse lanzado la excepcion EmailInvalidoException");
        } catch (EmailInvalidoException e)
        {
            assertEquals("Las excepciones no coinciden", "El mail ingresado no cumple con el formato previsto.", e.getMessage());
        }
    }
    
    /**
     * @see pga.Manager#altaProfesor(String,String,String,String,String)
     */
    @Test
    public void testAltaProfesorErroneo_8_2()
    {   
        try
        {
            this.fixture.manager.altaProfesor("Elsa", "Pato", "Alvear 123", "4756545", "mimail@");
            fail("Tendria que haberse lanzado la excepcion EmailInvalidoException");
        } catch (EmailInvalidoException e)
        {
            assertEquals("Las excepciones no coinciden", "El mail ingresado no cumple con el formato previsto.", e.getMessage());
        }
    }
    
    /**
     * @see pga.Manager#altaProfesor(String,String,String,String,String)
     */
    @Test
    public void testAltaProfesorErroneo_8_3()
    {   
        try
        {
            this.fixture.manager.altaProfesor("Elsa", "Pato", "Alvear 123", "4756545", "mimailgmail.com");
            fail("Tendria que haberse lanzado la excepcion EmailInvalidoException");
        } catch (EmailInvalidoException e)
        {
            assertEquals("Las excepciones no coinciden", "El mail ingresado no cumple con el formato previsto.", e.getMessage());
        }
    }
    
}

package tests;

import exceptions.EmailInvalidoException;

import exceptions.NoEstaEntidadException;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import pga.Profesor;


public class ModificarProfesorTest
{
    TestFixtureProfesor fixture = new TestFixtureProfesor();

    public ModificarProfesorTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture.setUp();
    }

    @After
    public void tearDown() throws Exception
    {
        fixture.tearDown();
    }
    
    /**
     * @see Manager#modificaProfesor(Profesor,String,String,String,String,String)
     */
    @Test
    public void testModificacionProfesorExitoso()
    {   
        try
        {
            this.fixture.manager.modificaProfesor(this.fixture.profesor, "Oscar", "Acol", "Entre Rios 2674", "2235235475", "oacol@live.com");
            assertTrue("El profesor no se modifico correctamente",
                        this.fixture.profesor.getNombre().equals("Oscar") &&
                        this.fixture.profesor.getApellido().equals("Acol") &&
                        this.fixture.profesor.getDomicilio().equals("Entre Rios 2674") &&
                        this.fixture.profesor.getTelefono().equals("2235235475") &&
                        this.fixture.profesor.getMail().equals("oacol@live.com"));
            
        } catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        } catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción por no encontrarse la entidad.");
        }
    }
    
    /**
     * @see Manager#modificaProfesor(Profesor,String,String,String,String,String)
     */
    @Test
    public void testModificacionProfesorErroneo_2_2()
    {   
        try
        {
            this.fixture.manager.modificaProfesor(this.fixture.profesor, null, "Quito", "Alvear 123", "4756545", "mimail@gmail.com");
        } catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        } catch (NoEstaEntidadException e)
        {
            fail("No deberia lanzarse la excepcion de que no se encuentra la entidad");
        } catch (NullPointerException e)
        {
            fail("Se intento modificar un profesor con un nombre nulo");
        }
    }
    
    /**
     * @see Manager#modificaProfesor(Profesor,String,String,String,String,String)
     */ 
    @Test
    public void testModificaProfesorErroneo_4_2()
    {   
        try
        {
            this.fixture.manager.modificaProfesor(this.fixture.profesor, "", "Quito", "Alvear 123", "4756545", "mimail@gmail.com");
            fail("Se modifico un profesor con un nombre vacio.");
        } catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        } catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción por no encontrarse la entidad.");
        }
    }
    
    /**
     * @see Manager#modificaProfesor(Profesor,String,String,String,String,String)
     */
    @Test
    public void testModificaProfesorErroneo_14()
    {
        
        try
        {
            Profesor p = new Profesor("Martin", "Perez", "Catamarca 2050", "2235235475", "mprez@live.com");
            this.fixture.manager.modificaProfesor(p, "", "Quito", "Alvear 123", "4756545", "mimail@gmail.com");
            fail("Tendria que haberse lanzado la excepcion NoEstaEntidadException");
        } catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        } catch (NoEstaEntidadException e)
        {
            assertEquals("Las excepciones no coinciden", "Profesor no encontrado en el sistema.",e.getMessage());
        }
    }
    
}

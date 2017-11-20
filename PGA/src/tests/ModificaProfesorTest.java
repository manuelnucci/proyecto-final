package tests;

import exceptions.EmailInvalidoException;
import exceptions.NoEstaEntidadException;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import pga.Profesor;


public class ModificaProfesorTest
{
    private TestFixtureProfesor fixture = new TestFixtureProfesor();

    public ModificaProfesorTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture.setUpAgregarYModif();
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
    public void testModificaProfesorExitoso_1_1()
    {   
        try
        {
            this.fixture.manager.modificaProfesor(this.fixture.profesor_a, "Oscar", "Acol", "Entre Rios 2674", "2235235475", "oacol@live.com");
            assertTrue("El profesor no se modificó correctamente.",
                        this.fixture.profesor_a.getNombre().equals("Oscar") &&
                        this.fixture.profesor_a.getApellido().equals("Acol") &&
                        this.fixture.profesor_a.getDomicilio().equals("Entre Rios 2674") &&
                        this.fixture.profesor_a.getTelefono().equals("2235235475") &&
                        this.fixture.profesor_a.getMail().equals("oacol@live.com"));
            
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
    public void testModificaProfesorExitoso_1_2()
    {   
        try
        {
            this.fixture.manager.modificaProfesor(this.fixture.profesor_a, "M", "P", "D", "1", "A@J");
            assertTrue("El profesor no se modificó correctamente.",
                        this.fixture.profesor_a.getNombre().equals("M") &&
                        this.fixture.profesor_a.getApellido().equals("P") &&
                        this.fixture.profesor_a.getDomicilio().equals("D") &&
                        this.fixture.profesor_a.getTelefono().equals("1") &&
                        this.fixture.profesor_a.getMail().equals("A@J"));
            
        }
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción por no encontrarse la entidad.");
        }
    }
    
    /**
     * @see Manager#modificaProfesor(Profesor,String,String,String,String,String)
     */
    @Test
    public void testModificaProfesorErroneo_2_2()
    {   
        try
        {
            this.fixture.manager.modificaProfesor(this.fixture.profesor_a, null, "Quito", "Alvear 123", "4756545", "mimail@gmail.com");
            fail("Se modificó un profesor con un nombre nulo.");
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No deberia lanzarse la excepcion de que no se encuentra la entidad.");
        } 
        catch (NullPointerException e)
        {
            fail("Se intento modificar un profesor con un nombre nulo.");
        }
    }
    
    /**
     * @see Manager#modificaProfesor(Profesor,String,String,String,String,String)
     */
    @Test
    public void testModificaProfesorErroneo_2_3()
    {   
        try
        {
            this.fixture.manager.modificaProfesor(this.fixture.profesor_a, "Esteban", null, "Alvear 123", "4756545", "mimail@gmail.com");
            fail("Se modificó un profesor con un apellido nulo.");
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No deberia lanzarse la excepcion de que no se encuentra la entidad.");
        } 
        catch (NullPointerException e)
        {
            fail("Se intento modificar un profesor con un apellido nulo.");
        }
    }
    
    /**
     * @see Manager#modificaProfesor(Profesor,String,String,String,String,String)
     */
    @Test
    public void testModificaProfesorErroneo_2_4()
    {   
        try
        {
            this.fixture.manager.modificaProfesor(this.fixture.profesor_a, "Esteban", "Quito", null, "4756545", "mimail@gmail.com");
            fail("Se modificó un profesor con un domicilio nulo.");
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No deberia lanzarse la excepcion de que no se encuentra la entidad.");
        }
    }
    
    /**
     * @see Manager#modificaProfesor(Profesor,String,String,String,String,String)
     */
    @Test
    public void testModificaProfesorErroneo_2_5()
    {   
        try
        {
            this.fixture.manager.modificaProfesor(this.fixture.profesor_a, "Esteban", "Quito", "Alvear 123", null, "mimail@gmail.com");
            fail("Se modificó un profesor con un apellido nulo.");
        } catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        } catch (NoEstaEntidadException e)
        {
            fail("No deberia lanzarse la excepcion de que no se encuentra la entidad.");
        }
    }
    
    /**
     * @see Manager#modificaProfesor(Profesor,String,String,String,String,String)
     */
    @Test
    public void testModificaProfesorErroneo_2_6()
    {   
        try
        {
            this.fixture.manager.modificaProfesor(this.fixture.profesor_a, "Esteban", "Quito", "Alvear 123", "4756545", null);
            fail("Se modificó un profesor con un mail nulo.");
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No deberia lanzarse la excepcion de que no se encuentra la entidad.");
        } 
        catch (NullPointerException e)
        {
            fail("Se intento modificar un profesor con un mail nulo.");
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
            this.fixture.manager.modificaProfesor(this.fixture.profesor_a, "", "Quito", "Alvear 123", "4756545", "mimail@gmail.com");
            fail("Se modificó un profesor con un nombre vacio.");
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción por no encontrarse la entidad.");
        }
    }
    
    /**
     * @see Manager#modificaProfesor(Profesor,String,String,String,String,String)
     */
    @Test
    public void testModificaProfesorErroneo_4_3()
    {   
        try
        {
            this.fixture.manager.modificaProfesor(this.fixture.profesor_a, "Adolfo", "", "Alvear 123", "4756545", "mimail@gmail.com");
            fail("Se modificó un profesor poniéndole un apellido vacío.");
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción porque en el TextFixtureProfesor se lo agregó.");
        }
    }
    
    /**
     * @see Manager#modificaProfesor(Profesor,String,String,String,String,String)
     */
    @Test
    public void testModificaProfesorErroneo_4_4()
    {   
        try
        {
            this.fixture.manager.modificaProfesor(this.fixture.profesor_a, "Leonel", "Quito", "", "4756545", "mimail@gmail.com");
            fail("Se modificó un profesor poniéndole un domicilio vacío.");
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción porque en el TextFixtureProfesor se lo agregó.");
        }
    }
    
    /**
     * @see Manager#modificaProfesor(Profesor,String,String,String,String,String)
     */
    @Test
    public void testModificaProfesorErroneo_4_5()
    {   
        try
        {
            this.fixture.manager.modificaProfesor(this.fixture.profesor_a, "Aquiles", "Bailo", "Alvear 123", "", "mimail@gmail.com");
            fail("Se modificó un profesor poniéndole un teléfono vacío.");
        } 
        catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción porque en el TextFixtureProfesor se lo agregó.");
        }
    }
    
    /**
     * @see Manager#modificaProfesor(Profesor,String,String,String,String,String)
     */
    @Test
    public void testModificaProfesorErroneo_4_6()
    {   
        try
        {
            this.fixture.manager.modificaProfesor(this.fixture.profesor_a, "Elsa", "Pato", "Alvear 123", "4756545", "");
            fail("Tendría que haberse lanzado la excepción EmailInvalidoException.");
        } 
        catch (EmailInvalidoException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", "El mail ingresado no cumple con el formato previsto.",e.getMessage());
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción porque en el TestFixtureProfesor se lo agregó.");
        }
    }
    
    /**
     * @see Manager#modificaProfesor(Profesor,String,String,String,String,String)
     */
    @Test
    public void testModificaProfesorErroneo_8_1()
    {   
        try
        {
            this.fixture.manager.modificaProfesor(this.fixture.profesor_a, "Elsa", "Pato", "Alvear 123", "4756545", "@mail");
            fail("Tendría que haberse lanzado la excepción EmailInvalidoException.");
        } 
        catch (EmailInvalidoException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", "El mail ingresado no cumple con el formato previsto.", e.getMessage());
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción porque en el TestFixtureProfesor se lo agregó.");
        }
    }
    
    /**
     * @see Manager#modificaProfesor(Profesor,String,String,String,String,String)
     */
    @Test
    public void testModificaProfesorErroneo_8_2()
    {   
        try
        {
            this.fixture.manager.modificaProfesor(this.fixture.profesor_a, "Elsa", "Pato", "Alvear 123", "4756545", "mail@");
            fail("Tendría que haberse lanzado la excepción EmailInvalidoException.");
        } 
        catch (EmailInvalidoException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", "El mail ingresado no cumple con el formato previsto.", e.getMessage());
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción porque en el TestFixtureProfesor se lo agregó.");
        }
    }
    
    /**
     * @see Manager#modificaProfesor(Profesor,String,String,String,String,String)
     */
    @Test
    public void testModificaProfesorErroneo_8_3()
    {   
        try
        {
            this.fixture.manager.modificaProfesor(this.fixture.profesor_a, "Elsa", "Pato", "Alvear 123", "4756545", "mail");
            fail("Tendría que haberse lanzado la excepción EmailInvalidoException.");
        } 
        catch (EmailInvalidoException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", "El mail ingresado no cumple con el formato previsto.", e.getMessage());
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción porque en el TestFixtureProfesor se lo agregó.");
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
            fail("Tendría que haberse lanzado la excepción NoEstaEntidadException.");
        } catch (EmailInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del email incorrecto.");
        } catch (NoEstaEntidadException e)
        {
            assertEquals("Las excepciones no coinciden", "Profesor no encontrado en el sistema.",e.getMessage());
        }
    }
}

package testsCajaBlanca;

import exceptions.HoraInvalidaException;
import exceptions.NoEstaEntidadException;
import exceptions.PeriodoInvalidoException;

import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

public class ModificaCursadaTest
{
    protected TestFixtureCursada fixture = new TestFixtureCursada();

    public ModificaCursadaTest()
    {
    }

    @After
    public void tearDown() throws Exception
    {
        fixture.tearDown();
    }

    /**
     * @see pga.Manager#modificaCursada(pga.Cursada,String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testModificaCursadaCamino4() throws Exception
    {
        try
        {
            this.fixture.setUpModificaCursadaCamino4();
            this.fixture.manager.modificaCursada(this.fixture.cursada_a, "cursada1", this.fixture.asignatura, "01-2018", "Lunes", "14:00", "16:00");
            assertTrue("La cursada no se modificó correctamente en el sistema.", 
                       this.fixture.cursada_a.getNombre().equals("cursada1") &&
                       this.fixture.cursada_a.getAsignatura().equals(this.fixture.asignatura) &&
                       this.fixture.cursada_a.getPeriodo().equals("01-2018") &&
                       this.fixture.cursada_a.getDia().equals("Lunes") &&
                       this.fixture.cursada_a.getHoraInicio().equals("14:00") &&
                       this.fixture.cursada_a.getHoraFin().equals("16:00"));
        } 
        catch (PeriodoInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del período incorrecto.");
        }
        catch (HoraInvalidaException e)
        {
            fail("No debería lanzarse la excepción por el formato de la hora incorrecta.");
        }
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción porque en el TestFixtureCursada se la agregó.");
        }
    }
    
    /**
     * @see pga.Manager#modificaCursada(pga.Cursada,String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testModificaCursadaCamino5() throws Exception
    {
        try
        {
            this.fixture.setUpModificaCursadaCamino5();
            this.fixture.manager.modificaCursada(this.fixture.cursada_b, "CURSADA1", this.fixture.asignatura, "01-2018", "Lunes", "14:00", "16:00");
            fail("Tendría que haberse lanzado la excepción NoEstaEntidadException");
        } 
        catch (PeriodoInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del período incorrecto.");
        }
        catch (HoraInvalidaException e)
        {
            fail("No debería lanzarse la excepción por el formato de la hora incorrecta.");
        }
        catch (NoEstaEntidadException e)
        {
            assertTrue("El mensaje de la excepción no coincide con el previsto.", e.getMessage().equals("Cursada no encontrada en el sistema."));
        }
    }
    
    /**
     * @see pga.Manager#modificaCursada(pga.Cursada,String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testModificaCursadaCamino9() throws Exception
    {
        try
        {
            this.fixture.setUpModificaCursadaCamino9();
            this.fixture.manager.modificaCursada(this.fixture.cursada_a, "cursada2", this.fixture.asignatura, "01-2018", "Lunes", "14:00", "16:00");
            assertTrue("La cursada no se modificó correctamente en el sistema.", 
                       this.fixture.cursada_a.getNombre().equals("cursada2") &&
                       this.fixture.cursada_a.getAsignatura().equals(this.fixture.asignatura) &&
                       this.fixture.cursada_a.getPeriodo().equals("01-2018") &&
                       this.fixture.cursada_a.getDia().equals("Lunes") &&
                       this.fixture.cursada_a.getHoraInicio().equals("14:00") &&
                       this.fixture.cursada_a.getHoraFin().equals("16:00"));
        } 
        catch (PeriodoInvalidoException e)
        {
            fail("No debería lanzarse la excepción por el formato del período incorrecto.");
        }
        catch (HoraInvalidaException e)
        {
            fail("No debería lanzarse la excepción por el formato de la hora incorrecta.");
        }
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción porque en el TestFixtureCursada se la agregó.");
        }
    }
}

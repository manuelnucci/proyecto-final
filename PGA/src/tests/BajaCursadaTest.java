package tests;

import exceptions.HoraInvalidaException;

import exceptions.NoEstaEntidadException;
import exceptions.PeriodoInvalidoException;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import pga.Cursada;

public class BajaCursadaTest
{
    TestFixtureCursada fixture1 = new TestFixtureCursada();

    public BajaCursadaTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture1.setUpBaja();
    }

    @After
    public void tearDown() throws Exception
    {
        fixture1.tearDown();
    }
    
    /**
     * @see pga.Manager#bajaCursada(pga.Cursada)
     */
    @Test
    public void testBajaCursadaExitosa()
    {
        try
        {
            this.fixture1.manager.bajaCursada(this.fixture1.cursada_a);
            assertFalse("La cursada no fue eliminada", this.buscaCursada(this.fixture1.cursada_a));
        } catch (NoEstaEntidadException e)
        {
            fail("No tendria que haber salido la excepcion de NoEstaEntidadException");
        }

    }
    
    /**
     * @see pga.Manager#bajaCursada(pga.Cursada)
     */
    @Test
    public void testBajaCursadaErronea_2()
    {
        try
        {
            this.fixture1.manager.bajaCursada(null);
        } catch (NoEstaEntidadException e)
        {
            fail("No tendria que haber salido la excepcion de NoEstaEntidadException");
        } catch(NullPointerException e)
        {
            fail("Se intento dar de baja una cursada nula");
        }

    }
    
    /**
     * @see pga.Manager#bajaCursada(pga.Cursada)
     */
    @Test
    public void testBajaCursadaErronea_4()
    {
        
        try
        {
            this.fixture1.manager.bajaCursada(this.fixture1.cursada_b);
            fail("Tendria que haber salido por la excepcion NoEstaEntidadException");
        } catch (NoEstaEntidadException e)
        {
            assertEquals("Las excepciones no coinciden", "Cursada no encontrada en el sistema.", e.getMessage());
        } 

    }
    
    
    
    
    
    
    /**
     * @see pga.Manager#bajaCursada(pga.Cursada)
     */
    @Test
    public void testBajaCursadaExitosa_1_1()
    {
        try
        {
            this.fixture1.manager.altaCursada(this.fixture1.cursada_a.getNombre(),
                                              this.fixture1.cursada_a.getAsignatura(),
                                              this.fixture1.cursada_a.getPeriodo(),
                                              this.fixture1.cursada_a.getDia(), 
                                              this.fixture1.cursada_a.getHoraInicio(), 
                                              this.fixture1.cursada_a.getHoraFin());
        } 
        catch(HoraInvalidaException e)
        {
            fail("No tendria que haber salido la excepcion de HoraInvalidaException");
        } catch(PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido la excepcion de PeriodoInvalidoException");
        }
        
    }
    
    /**
     * @see pga.Manager#bajaCursada(pga.Cursada)
     */
    @Test
    public void testBajaCursadaExitosa_1_2()
    {
        try
        {
            this.fixture1.manager.altaCursada(this.fixture1.cursada_a.getNombre(),
                                              this.fixture1.cursada_a.getAsignatura(),
                                              this.fixture1.cursada_a.getPeriodo(),
                                              this.fixture1.cursada_a.getDia(), 
                                              this.fixture1.cursada_a.getHoraInicio(), 
                                              this.fixture1.cursada_a.getHoraFin());
        } 
        catch(HoraInvalidaException e)
        {
            fail("No tendria que haber salido la excepcion de HoraInvalidaException");
        } catch(PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido la excepcion de PeriodoInvalidoException");
        }
        
    }

    private boolean buscaCursada(Cursada cursada)
    {
        Iterator<HashMap<String, Cursada>> it = this.fixture1.manager.getCursadas().values().iterator();
        boolean sigue = false;
        
        while(it.hasNext() && !sigue)
        {
            sigue = it.next().containsKey(cursada.getId());
        }
        return sigue;
    }
}

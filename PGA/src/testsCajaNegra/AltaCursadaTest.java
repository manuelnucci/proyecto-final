package testsCajaNegra;

import exceptions.HoraInvalidaException;
import exceptions.PeriodoInvalidoException;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

public class AltaCursadaTest
{
    private TestFixtureCursada fixture = new TestFixtureCursada();

    public AltaCursadaTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture.setUpAltayModif();
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
    public void testAltaCursadaExitosa_1_1()
    {
        try
        {
            int size = this.fixture
                           .manager
                           .getCursadas()
                           .size();
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "15:00", "17:00");
            assertTrue("La cursada no se anadio al sistema", this.fixture
                                                                 .manager
                                                                 .getCursadas()
                                                                 .size() == size + 1);
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaExitosa_1_2()
    {
        try
        {
            int size = this.fixture
                           .manager
                           .getCursadas()
                           .size();
            this.fixture
                .manager
                .altaCursada("C", this.fixture.asignatura_a, "01-2000", "Lunes", "00:00", "00:01");
            assertTrue("La cursada no se anadio al sistema", this.fixture
                                                                 .manager
                                                                 .getCursadas()
                                                                 .size() == size + 1);
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaExitosa_1_3()
    {
        try
        {
            int size = this.fixture
                           .manager
                           .getCursadas()
                           .size();
            this.fixture
                .manager
                .altaCursada("C", this.fixture.asignatura_a, "02-2099", "Domingo", "23:58", "23:59");
            assertTrue("La cursada no se anadio al sistema", this.fixture
                                                                 .manager
                                                                 .getCursadas()
                                                                 .size() == size + 1);
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_2_2()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada(null, this.fixture.asignatura_a, "01-2017", "Lunes", "12:00", "14:00");
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException.");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
        catch (NullPointerException e)
        {
            fail("Se intento dar de alta una cursada con nombre nulo.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_2_3()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", null, "01-2017", "Lunes", "12:00", "14:00");
            fail("Se dio de alta en el sistema una cursada con una asignatura nula.");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException.");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_2_4()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, null, "Lunes", "12:00", "14:00");
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException.");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
        catch (NullPointerException e)
        {
            fail("Se intento dar de alta una cursada con período nulo.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_2_5()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", null, "12:00", "14:00");
            fail("Se intentó dar de alta una cursada con día nulo.");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_2_6()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", null, "14:00");
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException.");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
        catch (NullPointerException e)
        {
            fail("Se intentó dar de alta una cursada con hora de inicio nulo.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_2_7()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "12:00", null);
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException.");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
        catch (NullPointerException e)
        {
            fail("Se intentó dar de alta una cursada con hora de fin nulo.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_4_2()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("", this.fixture.asignatura_a, "01-2017", "Lunes", "12:00", "14:00");
            fail("Se intentó dar de alta en el sistema una cursada con un nombre vacío.");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException.");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_4_3()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "", "Lunes", "12:00", "14:00");
            fail("Tendría que haberse lanzado la excepción PeriodoInvalidoException");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException");
        }
        catch (PeriodoInvalidoException e)
        {
            assertEquals("Las excepciones no coinciden", "El periodo ingresado no cumple con el formato previsto.",
                         e.getMessage());
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_4_4()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "", "12:00", "14:00");
            fail("Se intentó agregar al sistema una cursada con el día vacío.");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException.");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_4_5()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "", "14:00");
            fail("La cursada se anadio al sistema con una hora de inicio vacio");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden.", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_4_6()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "12:00", "");
            fail("La cursada se anadio al sistema con una hora de fin vacio");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden.", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_8_1()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01P-A2017", "Lunes", "12:00", "14:00");
            fail("La cursada se anadio al sistema con un periodo invalido");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException");
        }
        catch (PeriodoInvalidoException e)
        {
            assertEquals("Las excepciones no coinciden", "El periodo ingresado no cumple con el formato previsto.",
                         e.getMessage());
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_8_2()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01:2017", "Lunes", "12:00", "14:00");
            fail("La cursada se anadio al sistema con un periodo invalido");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException");
        }
        catch (PeriodoInvalidoException e)
        {
            assertEquals("Las excepciones no coinciden.", "El periodo ingresado no cumple con el formato previsto.",
                         e.getMessage());
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_8_3()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "03-2017", "Lunes", "12:00", "14:00");
            fail("La cursada se anadio al sistema con un periodo invalido.");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException.");
        }
        catch (PeriodoInvalidoException e)
        {
            assertEquals("Las excepciones no coinciden.", "El periodo ingresado no cumple con el formato previsto.",
                         e.getMessage());
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_8_4()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-20L7", "Lunes", "12:00", "14:00");
            fail("La cursada se anadio al sistema con un periodo invalido");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException");
        }
        catch (PeriodoInvalidoException e)
        {
            assertEquals("Las excepciones no coinciden", "El periodo ingresado no cumple con el formato previsto.",
                         e.getMessage());
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_8_5()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-1950", "Lunes", "12:00", "14:00");
            fail("La cursada se anadio al sistema con un periodo invalido");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException");
        }
        catch (PeriodoInvalidoException e)
        {
            assertEquals("Las excepciones no coinciden", "El periodo ingresado no cumple con el formato previsto.",
                         e.getMessage());
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_8_5_2()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-1999", "Lunes", "12:00", "14:00");
            fail("La cursada se anadio al sistema con un periodo invalido.");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException.");
        }
        catch (PeriodoInvalidoException e)
        {
            assertEquals("Las excepciones no coinciden", "El periodo ingresado no cumple con el formato previsto.",
                         e.getMessage());
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_8_6()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2150", "Lunes", "12:00", "14:00");
            fail("La cursada se anadio al sistema con un periodo invalido");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException");
        }
        catch (PeriodoInvalidoException e)
        {
            assertEquals("Las excepciones no coinciden", "El periodo ingresado no cumple con el formato previsto.",
                         e.getMessage());
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_8_6_2()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2101", "Lunes", "12:00", "14:00");
            fail("La cursada se anadio al sistema con un periodo invalido");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException");
        }
        catch (PeriodoInvalidoException e)
        {
            assertEquals("Las excepciones no coinciden", "El periodo ingresado no cumple con el formato previsto.",
                         e.getMessage());
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_10()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2101", "Osvaldo", "12:00", "14:00");
            fail("La cursada se anadio al sistema con un dia invalido");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException");
        }
        catch (PeriodoInvalidoException e)
        {
            assertEquals("Las excepciones no coinciden", "El periodo ingresado no cumple con el formato previsto.",
                         e.getMessage());
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_1()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "122:00", "14:00");
            fail("La cursada se anadio al sistema con una hora de inicio invalido.");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_2()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "A1:00", "14:00");
            fail("La cursada se anadio al sistema con una hora de inicio invalido");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_3()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "12:D2", "14:00");
            fail("La cursada se anadio al sistema con una hora de inicio invalido.");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_4()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "12-00", "14:00");
            fail("La cursada se anadio al sistema con una hora de inicio invalido");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_5()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "-5:00", "14:00");
            fail("La cursada se anadio al sistema con una hora de inicio invalido.");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_5_2()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "-1:00", "14:00");
            fail("La cursada se anadio al sistema con una hora de inicio invalido.");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_6()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "40:00", "14:00");
            fail("La cursada se anadio al sistema con una hora de inicio invalido.");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_6_2()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "24:00", "14:00");
            fail("La cursada se anadio al sistema con una hora de inicio invalido.");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_7()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "12:-5", "14:00");
            fail("La cursada se anadio al sistema con una hora de inicio invalido.");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_7_2()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "12:-1", "14:00");
            fail("La cursada se anadio al sistema con una hora de inicio invalido.");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_8()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "12:67", "14:00");
            fail("La cursada se anadio al sistema con una hora de inicio invalido");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_8_2()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "12:60", "14:00");
            fail("La cursada se anadio al sistema con una hora de inicio invalido");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_9()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "12:00", "143:00");
            fail("La cursada se anadio al sistema con una hora de fin invalido");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_10()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "12:00", "A2:00");
            fail("La cursada se anadio al sistema con una hora de fin invalido.");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_11()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "12:00", "14:F3");
            fail("La cursada se anadio al sistema con una hora de fin invalido.");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_12()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "12:00", "14-00");
            fail("La cursada se anadio al sistema con una hora de fin invalido.");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_14()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "12:00", "-5:00");
            fail("La cursada se anadio al sistema con una hora de fin invalido.");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_14_2()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "12:00", "-1:00");
            fail("La cursada se anadio al sistema con una hora de fin invalido.");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_15()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "12:00", "14:-5");
            fail("La cursada se anadio al sistema con una hora de fin invalido.");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_15_2()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "12:00", "14:-1");
            fail("La cursada se anadio al sistema con una hora de fin invalido.");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_16()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "12:00", "14:67");
            fail("La cursada se anadio al sistema con una hora de fin invalido.");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_12_16_2()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "12:00", "14:60");
            fail("La cursada se anadio al sistema con una hora de fin invalido.");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_14()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Mate A 1", this.fixture.asignatura_a, "01-2017", "Lunes", "16:00", "14:00");
            fail("Se intentó añadir al sistema una cursada con un horario inválido (nosotros no lo verificamos).");
        }
        catch (HoraInvalidaException e)
        {
            assertEquals("Las excepciones no coinciden", "La hora ingresada no cumple con el formato previsto.",
                         e.getMessage());
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }

    /**
     * @see pga.Manager#altaCursada(String,pga.Asignatura,String,String,String,String)
     */
    @Test
    public void testAltaCursadaErronea_28()
    {
        try
        {
            this.fixture
                .manager
                .altaCursada("Cursada Estadistica", this.fixture.asignatura_d, "01-2017", "Lunes", "16:00", "14:00");
            fail("La cursada se añadió al sistema con una asignatura que no pertenece al mismo (no se lo verifica).");
        }
        catch (HoraInvalidaException e)
        {
            fail("No tendria que haber salido por la excepcion HoraInvalidaException.");
        }
        catch (PeriodoInvalidoException e)
        {
            fail("No tendria que haber salido por la excepcion PeriodoInvalidoException.");
        }
    }
}

package tests;

import exceptions.NoEstaEntidadException;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import pga.Asignatura;
import pga.Cursada;
import pga.Profesor;

public class BajaAsignaturaTest
{
    private TestFixtureAsignatura fixture = new TestFixtureAsignatura();

    public BajaAsignaturaTest()
    {
    }

    @Before
    public void setUp() throws Exception
    {
        fixture.setUpBaja();
    }

    @After
    public void tearDown() throws Exception
    {
        fixture.tearDown();
    }

    /**
     * @see pga.Manager#bajaAsignatura(pga.Asignatura)
     */
    @Test
    public void testBajaAsignaturaExitoso()
    {
        try
        {
            this.fixture
                .manager
                .bajaAsignatura(this.fixture.asignatura_c);
            assertTrue("La asignatura sigue existiendo en las asignaturas, el profesor, la cursada u otra asignatura", 
                       !existeAsignatura(this.fixture.asignatura_c, 
                                         this.fixture.manager.getAsignaturas(), 
                                         this.fixture.manager.getCursadas(), 
                                         this.fixture.manager.getProfesores()));
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción NoEstaEntidadException porque en el TestFixtureAsignatura se la agregó.");
        }
    }
    
    /**
     * @see pga.Manager#bajaAsignatura(pga.Asignatura)
     */
    @Test
    public void testBajaAsignaturaErroneo_2()
    {
        try
        {
            this.fixture
                .manager
                .bajaAsignatura(null);
            fail("Tendría que haberse lanzado la excepción NullPointerException.");
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción NoEstaEntidadException.");
        }
        catch(NullPointerException e)
        {
            fail("Se intentó borrar una asignatura nula.");
        }
    }
    
    /**
     * @see pga.Manager#bajaAsignatura(pga.Asignatura)
     */
    @Test
    public void testBajaAsignaturaErroneo_4()
    {
        try
        {
            this.fixture
                .manager
                .bajaAsignatura(this.fixture.asignatura_b);
            fail("Tendría que haberse lanzado la excepción NoEstaEntidadException.");
        } 
        catch (NoEstaEntidadException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", e.getMessage(), "Asignatura no encontrada en el sistema.");
        }
    }
    
    private boolean existeAsignatura(Asignatura asignatura,
                                     HashMap<String, HashMap<String, Asignatura>> hashAsig, 
                                     HashMap<String, HashMap<String, Cursada>> hashCur, 
                                     HashMap<String, HashMap<String, Profesor>> hashProf)
    {
        Iterator<HashMap<String, Asignatura>> itHA;
        Iterator<Asignatura> itA;
        Iterator<HashMap<String, Cursada>> itHC;
        Iterator<Cursada> itC;
        Iterator<HashMap<String, Profesor>> itHP;
        Iterator<Profesor> itP;
        boolean sigue = true;
        
        itHA = hashAsig.values().iterator();
        while (itHA.hasNext() && sigue)
        {
            HashMap<String, Asignatura> hash = itHA.next();
            if (hash.containsKey(asignatura.getId())) // Se borró mal la asignatura
                sigue = false;
            itA = hash.values().iterator();
            while (itA.hasNext() && sigue)
                if (itA.next().getCorrelatividades().containsKey(asignatura.getId())) // Se borraron mal las correlatividades
                    sigue = false;
        }
        
        
        itHC = hashCur.values().iterator();
        while (itHC.hasNext() && sigue)
        {
            itC = itHC.next().values().iterator();
            while (itC.hasNext() && sigue)
                if (itC.next().getAsignatura().equals(asignatura)) // Se borraron mal las cursadas que contienen a la asignatura
                    sigue = false;
        }
        
        
        itHP = hashProf.values().iterator();
        while (itHP.hasNext() && sigue)
        {
            itP = itHP.next().values().iterator();
            while (itP.hasNext() && sigue)
                if (itP.next().getCompetencias().containsKey(asignatura.getId())) // Se borraron mal las competencias
                    sigue = false;
        }
        
        return !sigue;
    }
}

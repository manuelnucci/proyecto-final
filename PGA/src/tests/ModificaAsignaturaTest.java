package tests;

import exceptions.NoEstaEntidadException;

import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;

import pga.Asignatura;

public class ModificaAsignaturaTest
{
    private TestFixtureAsignatura fixture = new TestFixtureAsignatura();

    public ModificaAsignaturaTest()
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
     * @see pga.Manager#modificaAsignatura(pga.Asignatura,String)
     */
    @Test
    public void testModificaAsignaturaExitoso_1_1()
    {
        try
        {
            this.fixture
                .manager
                .modificaAsignatura(this.fixture.asignatura, "Mate C");
            assertTrue("La asignatura no se modificó correctamente en el sistema", this.fixture.asignatura.getNombre().equals("Mate C"));
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción porque en el TestFixtureAsignatura se la agregó.");
        }
    }
    
    /**
     * @see pga.Manager#modificaAsignatura(pga.Asignatura,String)
     */
    @Test
    public void testModificaAsignaturaExitoso_1_2()
    {
        try
        {
            this.fixture
                .manager
                .modificaAsignatura(this.fixture.asignatura, "A");
            assertTrue("La asignatura no se modificó correctamente en el sistema", this.fixture.asignatura.getNombre().equals("A"));
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción porque en el TestFixtureAsignatura se la agregó.");
        }
    }
    
    /**
     * @see pga.Manager#modificaAsignatura(pga.Asignatura,String)
     */
    @Test
    public void testModificaAsignaturaErroneo_2_2()
    {
        try
        {
            this.fixture
                .manager
                .modificaAsignatura(this.fixture.asignatura, null);
            fail("Tendría que haberse lanzado la excepción NullPointerException."); 
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción porque en el TestFixtureAsignatura se la agregó.");
        }
        catch (NullPointerException e)
        {
            fail("Se intentó modificar una asignatura dándole un nombre nulo.");
        }
    }
    
    /**
     * @see pga.Manager#modificaAsignatura(pga.Asignatura,String)
     */
    @Test
    public void testModificaAsignaturaErroneo_4_2()
    {
        try
        {
            this.fixture
                .manager
                .modificaAsignatura(this.fixture.asignatura, "");
            fail("Se intentó modificar una asignatura poniéndole un nombre vacío.");
        } 
        catch (NoEstaEntidadException e)
        {
            fail("No debería lanzarse la excepción porque en el TestFixtureAsignatura se la agregó.");
        }
    }
    
    /**
     * @see pga.Manager#modificaAsignatura(pga.Asignatura,String)
     */
    @Test
    public void testModificaAsignaturaErroneo_14()
    {
        try
        {
            Asignatura asignatura = new Asignatura("Fundamentos");
            this.fixture.manager.modificaAsignatura(asignatura, "Mate C");
            fail("Tendría que haberse lanzado la excepción NoEstaEntidadException.");
        } 
        catch (NoEstaEntidadException e)
        {
            assertEquals("El mensaje de la excepción no coincide con el previsto.", e.getMessage(), "Asignatura no encontrada en el sistema.");
        }
    }
}

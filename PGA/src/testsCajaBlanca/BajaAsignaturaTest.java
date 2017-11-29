package testsCajaBlanca;

import exceptions.NoEstaEntidadException;

import java.util.HashMap;
import java.util.Iterator;

import org.junit.After;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;

import pga.Asignatura;
import pga.Cursada;

public class BajaAsignaturaTest
{
    private TestFixtureAsignatura fixture = new TestFixtureAsignatura();

    public BajaAsignaturaTest()
    {
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
     public void testBajaAsignaturaCamino2() throws Exception
     {
         try
         {
             this.fixture.setUpBajaAsignaturaCamino2();
             this.fixture.manager.bajaAsignatura(this.fixture.asignatura_b);
             fail("Tendría que haberse lanzado la excepción NoEstaEntidadException.");
         } 
         catch (NoEstaEntidadException e)
         {
             assertTrue("El mensaje de la excepción no coincide con el previsto.", e.getMessage().equals("Asignatura no encontrada en el sistema."));
         }
     }
     
     /**
      * @see pga.Manager#bajaAsignatura(pga.Asignatura)
      */
     @Test
     public void testBajaAsignaturaCamino8() throws Exception
     {
         try
         {
             this.fixture.setUpBajaAsignaturaCamino8();
             this.fixture.manager.bajaAsignatura(this.fixture.asignatura_a);
             assertTrue("La asignatura sigue existiendo en asignaturas o cursadas.",this.existeAsignatura(this.fixture.asignatura_a,
                                                                                                         this.fixture.manager.getAsignaturas(),
                                                                                                         this.fixture.manager.getCursadas()));
         } 
         catch (NoEstaEntidadException e)
         {
             fail("No debería lanzarse la excepción porque en el TestFixtureAsignatura se la agregó.");
         }

     }
     
     private boolean existeAsignatura(Asignatura asignatura,
                                      HashMap<String, HashMap<String, Asignatura>> hashAsig, 
                                      HashMap<String, HashMap<String, Cursada>> hashCur)
     {
         Iterator<HashMap<String, Asignatura>> itHA;
         Iterator<Asignatura> itA;
         Iterator<HashMap<String, Cursada>> itHC;
         Iterator<Cursada> itC;
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
         
         return !sigue;
     }
}

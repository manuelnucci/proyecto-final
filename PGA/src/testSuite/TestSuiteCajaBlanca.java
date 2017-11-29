package testSuite;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import testsCajaBlanca.AltaAlumnoTest;
import testsCajaBlanca.AltaAsignaturaTest;
import testsCajaBlanca.AltaCursadaTest;
import testsCajaBlanca.BajaAlumnoTest;
import testsCajaBlanca.BajaAsignaturaTest;
import testsCajaBlanca.BajaCursadaTest;
import testsCajaBlanca.BajaProfesorTest;
import testsCajaBlanca.ModificaAlumnoTest;
import testsCajaBlanca.ModificaAsignaturaTest;
import testsCajaBlanca.ModificaCursadaTest;
import testsCajaBlanca.ModificaProfesorTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ModificaProfesorTest.class, ModificaCursadaTest.class, ModificaAsignaturaTest.class,
                      ModificaAlumnoTest.class, BajaProfesorTest.class, BajaCursadaTest.class, BajaAsignaturaTest.class,
                      BajaAlumnoTest.class, AltaCursadaTest.class, AltaAsignaturaTest.class, AltaAlumnoTest.class
    })
public class TestSuiteCajaBlanca
{
    public static void main(String[] args)
    {
        String[] args2 =
        {
            TestSuiteCajaBlanca.class.getName()
        };
        JUnitCore.main(args2);
    }
}

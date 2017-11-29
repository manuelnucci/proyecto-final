package testSuite;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import testsCajaNegra.AltaAlumnoACursadaTest;
import testsCajaNegra.AltaAlumnoTest;
import testsCajaNegra.AltaAsignaturaTest;
import testsCajaNegra.AltaCursadaTest;
import testsCajaNegra.AltaProfesorACursadaTest;
import testsCajaNegra.AltaProfesorTest;
import testsCajaNegra.BajaAlumnoDeCursadaTest;
import testsCajaNegra.BajaAlumnoTest;
import testsCajaNegra.BajaAsignaturaTest;
import testsCajaNegra.BajaCursadaTest;
import testsCajaNegra.BajaProfesorDeCursadaTest;
import testsCajaNegra.BajaProfesorTest;
import testsCajaNegra.ModificaAlumnoTest;
import testsCajaNegra.ModificaAsignaturaTest;
import testsCajaNegra.ModificaCursadaTest;
import testsCajaNegra.ModificaProfesorTest;
import testsCajaNegra.UbicarAlumnoTest;
import testsCajaNegra.UbicarAsignaturaTest;
import testsCajaNegra.UbicarCursadaTest;
import testsCajaNegra.UbicarProfesorTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({ UbicarProfesorTest.class, UbicarCursadaTest.class, UbicarAsignaturaTest.class,
                      UbicarAlumnoTest.class, TestSuiteCajaNegra.class, TestSuiteCajaBlanca.class,
                      ModificaProfesorTest.class, testsCajaBlanca.ModificaProfesorTest.class, ModificaCursadaTest.class,
                      testsCajaBlanca.ModificaCursadaTest.class, ModificaAsignaturaTest.class,
                      testsCajaBlanca.ModificaAsignaturaTest.class, ModificaAlumnoTest.class,
                      testsCajaBlanca.ModificaAlumnoTest.class, BajaProfesorTest.class,
                      testsCajaBlanca.BajaProfesorTest.class, BajaProfesorDeCursadaTest.class, BajaCursadaTest.class,
                      testsCajaBlanca.BajaCursadaTest.class, BajaAsignaturaTest.class,
                      testsCajaBlanca.BajaAsignaturaTest.class, BajaAlumnoTest.class,
                      testsCajaBlanca.BajaAlumnoTest.class, BajaAlumnoDeCursadaTest.class, AltaProfesorTest.class,
                      AltaProfesorACursadaTest.class, AltaCursadaTest.class, testsCajaBlanca.AltaCursadaTest.class,
                      AltaAsignaturaTest.class, testsCajaBlanca.AltaAsignaturaTest.class, AltaAlumnoTest.class,
                      testsCajaBlanca.AltaAlumnoTest.class, AltaAlumnoACursadaTest.class
    })
public class TestSuitePGA
{
    public static void main(String[] args)
    {
        String[] args2 =
        {
            TestSuitePGA.class.getName()
        };
        JUnitCore.main(args2);
    }
}

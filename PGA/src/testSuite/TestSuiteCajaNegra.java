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
                      UbicarAlumnoTest.class, TestSuitePGA.class, ModificaProfesorTest.class, ModificaCursadaTest.class,
                      ModificaAsignaturaTest.class, ModificaAlumnoTest.class, BajaProfesorTest.class,
                      BajaProfesorDeCursadaTest.class, BajaCursadaTest.class, BajaAsignaturaTest.class,
                      BajaAlumnoTest.class, BajaAlumnoDeCursadaTest.class, AltaProfesorTest.class,
                      AltaProfesorACursadaTest.class, AltaCursadaTest.class, AltaAsignaturaTest.class,
                      AltaAlumnoTest.class, AltaAlumnoACursadaTest.class
    })
public class TestSuiteCajaNegra
{
    public static void main(String[] args)
    {
        String[] args2 =
        {
            TestSuiteCajaNegra.class.getName()
        };
        JUnitCore.main(args2);
    }
}

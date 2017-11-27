package testsCajaNegra;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ UbicarProfesorTest.class, UbicarCursadaTest.class, UbicarAsignaturaTest.class,
                      UbicarAlumnoTest.class, ModificaProfesorTest.class, ModificaCursadaTest.class,
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

package testsCajaBlanca;

import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ModificaCursadaTest.class, ModificaAlumnoTest.class, ModificaAsignaturaTest.class,
					  ModificaProfesorTest.class, AltaCursadaTest.class, 
                      AltaAsignaturaTest.class, AltaAlumnoTest.class,
                      BajaAlumnoTest.class, BajaAsignaturaTest.class })
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

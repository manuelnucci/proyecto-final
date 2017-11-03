package pga;

import exceptions.EmailInvalidoException;
import exceptions.HoraInvalidaException;
import exceptions.PeriodoInvalidoException;

/**
 * Clase que se encarga de validar que ciertos atributos de las clases utilizadas en la aplicación cuenten
 * con el formato correcto explicitado en la SRS.
 * Se declara a la clase como final para evitar su extensión.
 */
public final class Formato
{
    public static final int TAMANO_PERIODO = 7; // Longitud que debe poseer el período si respeta el formato
    public static final int TAMANO_HORA = 7; // Longitud que deben poseer las horas de inicio y fin si respetan el formato
    
    /**
     * Constructor de la clase. Se lo declara privado para evitar la instanciación de la clase Formato,
     * la cual es una mera verificadora de formatos en las cadenas.
     */
    private Formato()
    {
        super();
    }
    
    /**
     * Método que verifica si el mail ingresado cumple con el formato establecido.<br>
     * 
     * <b>Pre:</b> El mail que viene por parámetro no es nulo.<br>
     * <b>Post:</b> El método finaliza su ejecución si el mail cumple con el formato. Si no lo hace se lanza
     * una excepción notificando esta situación.
     * 
     * @param mail Mail del alumno o profesor. Mail != null.
     * @throws EmailInvalidoException Excepción lanzada si el mail no cumple con el formato.
     */
    public static void verificaMail(String mail) throws EmailInvalidoException
    {
        int indiceArroba;
        
        indiceArroba = mail.indexOf("@");
        if (!(indiceArroba != -1 && indiceArroba == mail.lastIndexOf("@") && indiceArroba != 0 && indiceArroba != mail.length() - 1))
            throw new EmailInvalidoException(mail, "El mail ingresado no cumple con el formato previsto.");
    }
    
    /**
     * Método que verifica si el período ingresado cumple con el formato establecido.<br>
     * 
     * <b>Pre:</b> El período que viene por parámetro no es nulo.<br>
     * <b>Post:</b> El método finaliza su ejecución si el período cumple con el formato. Si no lo hace se lanza
     * una excepción notificando esta situación.
     * 
     * @param periodo Período de la cursada. Periodo != null.
     * @throws PeriodoInvalidoException Exceción lanzada si el período infringe el formato estipulado.
     */
    public static void verificaCursadaPeriodo(String periodo) throws PeriodoInvalidoException
    {
        boolean ret = false;
        String cad;
        
        if(periodo.length() == TAMANO_PERIODO && periodo.indexOf("-") == 2)
        {
            cad = periodo.substring(0,1);
            if(cad.equals("01") || cad.equals("02"))
            {
                cad = periodo.substring(3, 6);
                ret = cad.compareTo("2000") >= 0 && cad.compareTo("2100") <= 0;
            }
        }
        if (!ret)
            throw new PeriodoInvalidoException(periodo, "El periodo ingresado no cumple con el formato previsto.");
    }
    
    /**
     * Método que verifica si la hora ingresada cumple con el formato establecido.<br>
     * 
     * <b>Pre:</b> La hora que viene por parámetro no es nula.<br>
     * <b>Post:</b> El método finaliza su ejecución si la hora cumple con el formato. Si no lo hace se lanza
     * una excepción notificando esta situación.
     * 
     * @param hora Hora (inicio o fin) de la cursada. Hora != null.
     * @throws HoraInvalidaException Excepción lanzada si la hora no cumple con el formato.
     */
    public static void verificaCursadaHora(String hora) throws HoraInvalidaException
    {
        boolean ret = false;
        String cad;
        
        if(hora.length() == TAMANO_HORA && hora.indexOf(":") == 2)
        {
            cad = hora.substring(0,1);
            if(cad.compareTo("00") >= 0 && cad.compareTo("23") <= 0)
            {
                cad = hora.substring(3, 4);
                ret = cad.compareTo("00") >= 0 && cad.compareTo("59") <= 0;
            }
        }
        if (!ret)
            throw new HoraInvalidaException(hora, "La hora ingresada no cumple con el formato previsto.");
    }
}

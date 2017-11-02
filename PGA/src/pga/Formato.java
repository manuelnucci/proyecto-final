package pga;

import exceptions.EmailInvalidoException;
import exceptions.HoraInvalidaException;
import exceptions.PeriodoInvalidoException;

public class Formato
{
    public static final int ALU = 0;
    public static final int PRO = 1;
    public static final int ASI = 2;
    public static final int TAMANO_MAIL = 12;
    public static final int TAMANO_LEGAJO = 7;
    public static final int TAMANO_PERIODO = 7;
    public static final int TAMANO_HORA = 7;
    
    private Formato()
    {
        super();
    }
    
    public static void verificaMail(String mail) throws EmailInvalidoException
    {
        int indiceArroba;
        
        indiceArroba = mail.indexOf("@");
        if (indiceArroba == -1 && indiceArroba == mail.lastIndexOf("@") && indiceArroba != 0 && indiceArroba != mail.length() - 1)
               throw new EmailInvalidoException(mail, "El mail ingresado no cumple con el formato previsto.");
    }
    
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

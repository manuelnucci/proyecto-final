package pga;

public class Formato
{
    public static final int ALU = 0;
    public static final int PRO = 1;
    public static final int ASI = 2;
    public static final int TAMANO_MAIL = 12;
    public static final int TAMANO_LEGAJO = 7;
    public static final int TAMANO_PERIODO = 7;
    public static final int TAMANO_HORA = 7;
    
    public Formato()
    {
        super();
    }
    
    public static boolean verificaId(String id, int tipo)
    {
        boolean ret = false;
        String parteNum;
        
        if(id.length() == TAMANO_LEGAJO)
        {
            parteNum = id.substring(3);
            if(parteNum.compareTo("0000") >= 0 && parteNum.compareTo("9999") <= 0)
            {
                parteNum = id.substring(0, 2);
                switch(tipo)
                {
                    case ALU:   ret = parteNum.equals("ALU");
                                break;
                    case PRO:   ret = parteNum.equals("PRO");
                                break;
                    case ASI:   ret = parteNum.equals("ASI");
                                break;
                    default:    ret = parteNum.equals("CUR");
                                break;
                }
            }
        }
        return ret;
    }
    
    public static boolean verificaMail(String mail)
    {
        int indiceArroba;
        
        indiceArroba = mail.indexOf("@");
        return indiceArroba == mail.lastIndexOf("@") && indiceArroba != 0 && indiceArroba != mail.length() - 1;
    }
    
    public boolean verificaCursadaPeriodo(String periodo)
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
        return ret;
    }
    
    public static boolean verificaCursadaHora(String hora)
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
        return ret;
    }
}

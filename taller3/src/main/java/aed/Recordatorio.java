package aed;

public class Recordatorio {

    private Fecha _fecha;
    private Horario _horario;
    private String _mensaje;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {

        _fecha= new Fecha(fecha.dia(),fecha.mes());
        _horario = horario;
        _mensaje = mensaje;
    }

    public Horario horario() {
        return _horario;
    }

    public Fecha fecha() {
        Fecha variableFecha = new Fecha(_fecha.dia(),_fecha.mes());
        //Esto hace q no haya aliasing entre la instancia .fecha() y el valor interno _fecha. almaceno la info en otro lugar basically. 

        return variableFecha;
    }

    public String mensaje() {
        return _mensaje;
    }

    @Override
    public String toString(){           // formato mensaje @ fecha horario
        StringBuffer sbuffer = new StringBuffer() ;

        sbuffer.append(mensaje());
        sbuffer.append(" @ ");
        sbuffer.append(fecha());
        sbuffer.append(" ");
        sbuffer.append(horario());

        return sbuffer.toString();

    }

    @Override
    public boolean equals(Object otro) {
        boolean esNull= otro.getClass()==null;
        boolean noEsClase= otro.getClass()!=this.getClass();

        if (esNull||noEsClase){
            return false;
        }

        Recordatorio rOtro = (Recordatorio) otro;

        boolean mismoMensaje= rOtro.mensaje()==this.mensaje();

        boolean mismoFecha= rOtro.fecha()==this.fecha();

        boolean mismoHora= rOtro.horario()==this.horario();

        return mismoMensaje && mismoFecha && mismoHora;

    }

}

package aed;

public class Recordatorio {

    private Fecha _fecha;
    private Horario _horario;
    private String _mensaje;

    public Recordatorio(String mensaje, Fecha fecha, Horario horario) {
        fecha= _fecha;
        horario = _horario;
        mensaje = _mensaje;
    }

    public Horario horario() {
        return horario;
    }

    public Fecha fecha() {
        Fecha variableFecha= _fecha;        //Esto hace q no haya aliasing entre la instancia .fecha() y el valor interno _fecha. almaceno la info en otro lugar basically.

        return variableFecha;
    }

    public String mensaje() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    @Override
    public String toString() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    @Override
    public boolean equals(Object otro) {
        throw new UnsupportedOperationException("No implementada aun");
    }

}

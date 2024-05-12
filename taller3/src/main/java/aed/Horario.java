package aed;

public class Horario {

    private int _hora;
    private int _minuto;

    public Horario(int hora, int minutos) {
        _hora = hora;
        _minuto = minutos;
    }

    public int hora() {
        return _hora;
    }

    public int minutos() {
        return _minuto;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();

        sbuffer.append(hora());
        sbuffer.append(":");
        sbuffer.append(minutos());

        return sbuffer.toString();
    }

    @Override
    public boolean equals(Object otro) {

        boolean esNull = (otro == null);
        boolean noEsClase = (otro.getClass() != this.getClass());

        if (noEsClase||esNull){
            return false;
        }


        Horario hOtro = (Horario) otro;

        boolean horaIg= hOtro.hora() == this.hora();
        boolean minutoIg= hOtro.minutos() == this.minutos();

        return horaIg && minutoIg;
    
    }

}

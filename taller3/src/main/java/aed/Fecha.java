package aed;

public class Fecha {
    
    private int _dia;
    private int _mes;

    public Fecha(int dia, int mes) {
        _dia= dia;
        _mes= mes;
    }

    public Fecha(Fecha fecha) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public Integer dia() {
        return _dia;
    }

    public Integer mes() {
       return _mes;
    }

    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();

        sbuffer.append(dia());
        sbuffer.append("/");
        sbuffer.append(mes());

        return sbuffer.toString();

    }

    @Override
    public boolean equals(Object otra) {

        boolean otronull = (otra == null);

        boolean clasedistinta = otra.getClass() != this.getClass();

        if (otronull || clasedistinta){
            return false;
        }

        //AHORA CHEQUEP FECHA ACA:
        
        Fecha fechuela = (Fecha) otra;

        boolean mismoD = (fechuela.dia() == this.dia());

        boolean mismoM = (fechuela.mes() == this.mes());

        return (mismoD && mismoM);
        


    }





    public void incrementarDia() {
        if (diasEnMes(mes())==dia()){
            _dia=1;

            if (mes()==12){
                _mes=1;

            }
            else{
                _mes=mes()+1;

            }
        }
        else{
            _dia=dia()+1;

        }
    }

    private int diasEnMes(int mes) {
        int dias[] = {
                // ene, feb, mar, abr, may, jun
                31, 28, 31, 30, 31, 30,
                // jul, ago, sep, oct, nov, dic
                31, 31, 30, 31, 30, 31
        };
        return dias[mes - 1];
    }

}

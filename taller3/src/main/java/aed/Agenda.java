package aed;

public class Agenda {

    private Fecha _fecha;
    private ArregloRedimensionableDeRecordatorios _conjuntoRecordatorios;

    public Agenda(Fecha fechaActual) {
        _fecha = fechaActual;
        _conjuntoRecordatorios = new ArregloRedimensionableDeRecordatorios();
    }

    public void agregarRecordatorio(Recordatorio recordatorio) {
        _conjuntoRecordatorios.agregarAtras(recordatorio);

    }

    @Override
    public String toString() {      //de la fecha actual
        StringBuffer sbuffer = new StringBuffer();

        sbuffer.append(fechaActual().toString());
        sbuffer.append("\n=====\n");

        //ACA APPENDAMOS CON UN FOR TODOS LOS RECORDATORIOS:

        for (int i=0; i<_conjuntoRecordatorios.longitud();i++){
            if ((_conjuntoRecordatorios.obtener(i).fecha().equals(this.fechaActual()))) {
                sbuffer.append((_conjuntoRecordatorios.obtener(i)).toString()+"\n");
            }
        }

        return sbuffer.toString();


    }

    public void incrementarDia() {
        Fecha fechaVieja=this.fechaActual();
        fechaVieja.incrementarDia();
        
        _fecha = new Fecha(fechaVieja);


        

    }

    public Fecha fechaActual() {
        Fecha res = new Fecha(_fecha);

        return res;
    }

}

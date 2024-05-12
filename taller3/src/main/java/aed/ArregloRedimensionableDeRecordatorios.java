package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {

    private Recordatorio[] _recordatorios;

    public ArregloRedimensionableDeRecordatorios() {
        _recordatorios = new Recordatorio[2];       //TIENE ARRAY[0] Y ARRAY[1]
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public int longitud() {
        int res=0;

        while(res<_recordatorios.length && _recordatorios[res]!=null){      //aprovecho la logica de check primero  Yluego. esto para no acceder a elementos outofbound.
            res++;
        }
        
        return res;
    }

    public void agregarAtras(Recordatorio i) {

       if (_recordatorios.length==this.longitud()){                         // si la cantidad de elemnots usados es igual a la longitud del array, duplico.
            
            _recordatorios= duplicarTamaño(_recordatorios);
       }

       _recordatorios[this.longitud()]=i;                                   // lo meto en la posicion longitud(), ya que es igual a la posicon del ultimo elem + 1.
    }

    private Recordatorio[] duplicarTamaño(Recordatorio[] vector) {

        Recordatorio[] placeholder = new Recordatorio[vector.length * 2];

        for (int i = 0; i<vector.length;i++){
            placeholder[i] = vector[i];
        }

        return placeholder;


    }

    public Recordatorio obtener(int i) {
        return _recordatorios[i];
    }

    public void quitarAtras() {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        throw new UnsupportedOperationException("No implementada aun");

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        throw new UnsupportedOperationException("No implementada aun");
    }

}

package aed;

class ArregloRedimensionableDeRecordatorios implements SecuenciaDeRecordatorios {

    private Recordatorio[] _recordatorios;

    public ArregloRedimensionableDeRecordatorios() {
        _recordatorios = new Recordatorio[2];       //TIENE ARRAY[0] Y ARRAY[1]
    }

    public ArregloRedimensionableDeRecordatorios(ArregloRedimensionableDeRecordatorios vector) {
        _recordatorios = new Recordatorio[2];
        
        for (int i=0; i<vector.longitud();i++){
            this.agregarAtras(obtener(i));

        }
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
        Recordatorio res=_recordatorios[i];
        return res;
    }

    public void quitarAtras() {
        _recordatorios[this.longitud()-1]=null;
    }

    public void modificarPosicion(int indice, Recordatorio valor) {
        while (_recordatorios.length<indice){
            duplicarTamaño(_recordatorios);
        }
        _recordatorios[indice]=valor;

    }

    public ArregloRedimensionableDeRecordatorios copiar() {
        ArregloRedimensionableDeRecordatorios res=new ArregloRedimensionableDeRecordatorios();

        for (int i = 0; i<_recordatorios.length; i++){
            agregarAtras(_recordatorios[i]);

        }
        return res;
    }

}

package aed;

import java.util.*;

// Todos los tipos de datos "Comparables" tienen el método compareTo()
// elem1.compareTo(elem2) devuelve un entero. Si es mayor a 0, entonces elem1 > elem2
public class ABB<T extends Comparable<T>> implements Conjunto<T> {
    private Nodo _raiz;
    private int _cardinal;
    private int _altura;

    private class Nodo {
        T valor;
        Nodo izq;
        Nodo der;
        Nodo arriba;



        // Crear Constructor del nodo
        Nodo(T v){
            valor = v;
            izq = null;
            der = null;
            arriba= null;
        }
    }

    public ABB() {
        _raiz = null;
        _cardinal=0;
        _altura = 0;        //Como uso esto....
    }

    public int cardinal() {
        return _cardinal;
    }

    public T minimo(){
        Nodo nodo_intercambiable = _raiz;
        while(nodo_intercambiable.izq != null){
            nodo_intercambiable = nodo_intercambiable.izq;

        }
        return nodo_intercambiable.valor;
    }

    public T maximo(){
        Nodo nodo_intercambiable = _raiz;
        while(nodo_intercambiable.der != null){
            nodo_intercambiable = nodo_intercambiable.der;

        }
        return nodo_intercambiable.valor;
        
    }

    /*   public void insertar(T elem){
        Nodo i = _raiz;
        while (i!=null){

            if (elem.compareTo(i.valor)>0){                 INTENTE HACERLO CON WHILE PERO ES PARA QUILOMBO
                i=i.der;
            }
            else{
                i=i.izq;
            }
        
        }
        Nodo hoja = new Nodo(elem);
        if (_raiz!=null){
            hoja.arriba = i.arriba;
        }
        else{_raiz = hoja;}
    }
    */ 


    public void insertar(T elem){
        Nodo hoja = new Nodo(elem);

        Nodo ultimo_nodo=buscarNodo(elem,_raiz);

        if (_raiz == null){
            _raiz = hoja;
            _cardinal = _cardinal + 1;
        }

        else if (!(ultimo_nodo.valor.equals(elem))){
            if (elem.compareTo(ultimo_nodo.valor) > 0){
                ultimo_nodo.der=hoja;
                
            }
            else{
                ultimo_nodo.izq = hoja;
            }
            hoja.arriba=ultimo_nodo;
            _cardinal = _cardinal + 1;
        }
        else{
            ;
        }



    }

    private Nodo buscarNodo(T elem, Nodo nodo){
        if (nodo==null || ((nodo.valor).equals(elem))) {
            return nodo;
        }

        else{
            int deroizq= elem.compareTo(nodo.valor);
            
            if (deroizq > 0 && nodo.der != null){
                return buscarNodo(elem, nodo.der);
            }
            else if (deroizq < 0 && nodo.izq != null){
                return buscarNodo(elem, nodo.izq);
            }
            else {
                return nodo;
            }

        }
    
    }

    public boolean pertenece(T elem){
        return busqueda_recursiva(elem,_raiz);
    }

    private boolean busqueda_recursiva(T elem, Nodo nodo){
        if (nodo==null){
            return false;
        }
        if (nodo.valor==null){
            return false;
        }
        if ((nodo.valor).equals(elem)){
            return true;
        }

        if (elem.compareTo(nodo.valor)>0){
            return busqueda_recursiva(elem, nodo.der);
        }
        else{
            return busqueda_recursiva(elem, nodo.izq);
        }

    }

    public void eliminar(T elem){           // 3 CASOS, ADEMAS USO PREDECESOR INMEDIATO
                        
        
        Nodo nodo_eliminar=buscarNodo(elem, _raiz);

        if ((nodo_eliminar==null)||(nodo_eliminar.izq==null && nodo_eliminar.der ==null)){               //CASO 0 HIJOS
            if (nodo_eliminar == null){
                _cardinal=_cardinal+1;
            }
            else{
                desconectarPadre(nodo_eliminar);
            }


        }

        else if (nodo_eliminar.izq == null || nodo_eliminar.der == null){       //CASO 1 HIJO
            eliminar1hijo(nodo_eliminar);
        }

        else if (nodo_eliminar.izq != null && nodo_eliminar.der != null){       //CASO 3, 2 HIJOS       ME LA JUEGO
            Nodo predecesor;

            Nodo i = nodo_eliminar.izq;
            while(i.der!=null){
                i = i.der;
            }
            predecesor = i;
            System.out.println(predecesor.valor);
            //ahora tengo q recolocar predecesor y eliminarlo de donde esta, lo guardo en una cajita

            eliminar(i.valor);      //esto va a llamar a caso 0 hijos o caso un hijo (si tiene un hijo, tiene q estar a la izquierda.)

            nodo_eliminar.valor=predecesor.valor;

            _cardinal = _cardinal +1;

        
            nodo_eliminar = null;
                       
            
        }
        _cardinal = _cardinal -1;

    }
    private void desconectarPadre(Nodo nodo_eliminar){
        if (nodo_eliminar!=_raiz){
            if (nodo_eliminar.arriba.der == nodo_eliminar){
                nodo_eliminar.arriba.der = null;
            }
            else{
                nodo_eliminar.arriba.izq=null;
            }
            nodo_eliminar.arriba=null;

        }
        else{
            _raiz = null;
        }
        nodo_eliminar=null;
    }


    private void reconectar(Nodo nodo_eliminar, Nodo nodoHijo){
        Nodo nodoAbuelo;

        nodoHijo.arriba= nodo_eliminar.arriba;

        if (nodo_eliminar==_raiz){
            
            _raiz = nodoHijo;
            
        }
        else{  
            nodoAbuelo=nodo_eliminar.arriba;
            

            if(nodoAbuelo.der==nodo_eliminar){
                nodoAbuelo.der=nodoHijo;
                System.out.println("ABB.reconectar()"+nodoAbuelo.der.valor);    

            }

            else{
                nodoAbuelo.izq=nodoHijo;    
            }
            nodo_eliminar.arriba=null;
            System.out.println("ABB()"+nodoHijo.arriba.valor);         
        }
        
    }

    private void eliminar1hijo(Nodo nodo_eliminar){
        Nodo nodoHijo;
 
        if (nodo_eliminar.der == null){
            nodoHijo = nodo_eliminar.izq;
        }
        else{
            nodoHijo = nodo_eliminar.der;
        }

        reconectar(nodo_eliminar, nodoHijo);
        
        nodo_eliminar=null;
    }

    public String toString(){       //tienen q estar en orden.... tal vez conviene hacer el iterador primero.... no se....
        Iterador<T> iterador=iterador();

        System.out.println("");

        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append("{");
        
        while (iterador.haySiguiente()){
            
           
            sbuffer.append(iterador.siguiente());
            sbuffer.append(",");

        }
        sbuffer.append(iterador.siguiente());
        sbuffer.append("}");
        
        return sbuffer.toString();

    }
    private Nodo sucesor2(Nodo _actual){     //voy a tener q aprender a debuggear
        if (_actual.der!=null){
            _actual=buscarNodo(minimo(),_actual.der);
        }
        else{
            if (_actual.valor == maximo()){
                return null;
            }
            
            while(_actual.arriba!=_raiz && (_actual.arriba).der==_actual){
                _actual=_actual.arriba;
                
            }
            _actual = _actual.arriba;
        }
        return _actual;
    }
    private class ABB_Iterador implements Iterador<T> {
        private Nodo _actual;

        public ABB_Iterador(){
            _actual= buscarNodo(minimo(),_raiz);
            //System.out.println(_actual.valor);
        }

        public boolean haySiguiente() {            
            return (_actual.valor!=maximo());
        }
    
        public T siguiente() {
            T res = _actual.valor;
            //System.out.println(_actual.valor);
            sucesor();
            return res;

        }  
        private Nodo sucesor(){     //voy a tener q aprender a debuggear
            if (_actual.der!=null){
                _actual=buscarNodo(minimo(),_actual.der);
            }
            else{
                if (_actual.valor == maximo()){
                    return _actual.der;
                }
                
                while(_actual.arriba!=_raiz && (_actual.arriba).der==_actual){
                    _actual=_actual.arriba;
                    
                }
                System.out.println("el actual es "+_actual.valor+" , y el de arriba es: "+_actual.arriba.valor);
                _actual = _actual.arriba;
            }
            return _actual;
        }

    }

    public Iterador<T> iterador() {
        Iterador<T> iterador = new ABB_Iterador();
        return iterador;
    }

}

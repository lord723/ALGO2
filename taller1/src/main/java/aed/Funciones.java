package aed;



class Funciones {




    int cuadrado(int x) {
        // COMPLETAR
        return x * x;
    }

    double distancia(double x, double y) {
        // COMPLETAR

        return Math.sqrt(x*x + y*y);
    }

    boolean esPar(int n) {
        // COMPLETAR
        if (divideA(2,n) ==true) {
            return true;
        }
        return false;
    }

    boolean divideA(int d, int n) {
            for (int i = 0; d*i <= (Math.abs(n)); i++) {
                if (d*i == Math.abs(n)) {
                    return true;
                }   
            
            }
        return false;

    }

    boolean esBisiesto(int n) {
        // COMPLETAR

        return divideA(4,n) && !divideA(100,n) || divideA(400, n) ;
    }

    int factorialIterativo(int n) {
        // COMPLETAR
        int res = 1;
        if(n==0) {
            return 1;
        }
        else {
            for (int i = 1; i<=n; i++) {
                res = res * i;
            }
            return res;
        }
    }

    int factorialRecursivo(int n) {
        // COMPLETAR
        if(n==0) {
            return 1;
        }
        else if (n==1) {
            return 1;
        }
        else return n*factorialIterativo(n-1);
    }

    boolean esPrimo(int n) {
        // COMPLETAR

        if(n==0 || n==1) {return false;}

        
        boolean res = true;

        for(int i = 2; i < n; i++) {
            if (divideA(i, n)) {
                res= false;
            }
        }

        return res;
    }

    int sumatoria(int[] numeros) {
        // COMPLETAR
        int res = 0;

        for (int x:numeros) {
            res = res + x;
        }

        return res;
    }

    int busqueda(int[] numeros, int buscado) {
        // COMPLETAR
        int res =0;
        
        for (int i = 0; i < (numeros.length );i++ ) {
            if(numeros[i]==buscado) {
                res=i;
            }



        }
        return res;
    }

    boolean tienePrimo(int[] numeros) {
        // COMPLETAR
        boolean res =false;
        for(int x:numeros) {
            if(esPrimo(x)){
                res = true;
            }
        }
        return res;
    }

    boolean todosPares(int[] numeros) {
        // COMPLETAR
        boolean res =true;
        for(int x:numeros) {
            if (!divideA(2, x)) {
                res=false;
            }
        }
        return res;
    }
    
    boolean esPrefijo(String s1, String s2) {       //s2 es el mas grande
        // COMPLETAR
        boolean res = true;
        if (s1.length()>s2.length()) {
            res=false;
        } else {

            for(int i = 0; i<s1.length(); i++) {
                if (s1.charAt(i)!=s2.charAt(i)) {
                    res=false;
                }
            }
        }

        return res;
    }
    boolean esSufijo(String s1, String s2) {       //s2 es el mas grande
        // COMPLETAR
        boolean res = true;
        int diferencia =s2.length()-s1.length();
        if (s1.length()>s2.length()) {
            res=false;
        } else {

            for(int i = 0; i<s1.length(); i++) {
                if (s1.charAt(i)!=s2.charAt(i+diferencia)) {
                    res=false;
                }
            }
        }

        return res;
    }

    boolean esSufijo2(String s1, String s2) {    //s1 tiene q ser test y s2 SUPER_TEST_    NO SE ME OCURRIO COMO USAR ESPREFIJO SIN MANIUPLAR STRINGS
        // COMPLETAR
        boolean res = false;
        res =esPrefijo(darVuelta(s1), darVuelta(s2));
        return res;
    }
    String darVuelta(String s1) {
        String res=s1;
        int cantidadLetras=s1.length()/2;
        for (int i=0; i<cantidadLetras; i++){
            //res.charAt(i)=res.charAt(cantidadLetras-i);

        }
        return res;
    }
}



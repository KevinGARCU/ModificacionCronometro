/*
 * Cronometro.java
 * 
 * Created on 7/09/2007, 08:56:17 AM
 * 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package logic;

/**
 *
 * @author alejo
 */
public class Cronometro {
    Horas h;
    Minutos m;
    Segundos s;
    Memoria[] mem;
    
    int memCont;
    
    String cadena;
    
    public String MostrarCadena(int h1, int m1, int s1 ){
        if(h1<10){
            cadena = "0" + h1 + " : " + m1 + " : " + s1;
            if(m1<10){
                cadena = "0" + h1 + " : 0" + m1 + " : " + s1;
                if(s1<10){
                    cadena = "0" + h1 + " : 0" + m1 + " : 0" + s1;
                }
            }
        }
        return cadena;
    }

    public Cronometro() {
        h = new Horas();
        m = new Minutos();
        s = new Segundos();
        mem = new Memoria[5];
        memCont=0;
        
        for(int x=0;x<mem.length;x++){
            mem[x]=new Memoria();
        }
        
        cadena = new String("00 : 00 : 00");

    }
    
    public String avanzar(){       
        if(s.forward()==0){
            if(m.forward()==0){
                h.forward();
            }
        }
  
        return MostrarCadena(h.valor, m.valor, s.valor);
    }
    
     public String retroceder(){       
        if(s.back()==s.tope){
            if(m.back()==m.tope){
                h.back();
            }
        }
        
        return MostrarCadena(h.valor, m.valor, s.valor);
    }
    
    public String reset(){
        s.reset();
        m.reset();
        h.reset();
        return MostrarCadena(h.valor, m.valor, s.valor);
    }
    
    public String generarMemoria(){
        
        mem[memCont].setMemoria(h.valor,m.valor,s.valor);
        cadena = mem[memCont].getMemoria();
        if(memCont<mem.length-1){
            memCont++;
        }else{
            memCont=0;
        }
        return cadena;
    }

}

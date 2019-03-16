/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package objetos;

import IO.escribirBinario;

/**
 *
 * @author Gherni
 */
public class makeUsers {
    public makeUsers(){
        make();
    }
    public void make(){
//        usuarios[] us ={new usuarios("pablom","moromi",3,"Pablo","Moromizato","Empleado"),new usuarios("hernang","herherher",1,"Hernan","Gomez","Desarrollo"),new usuarios("gustavok","kuroka",4,"Gustavo","Kurokawa","Empleado"),new usuarios("damianp","putign",4,"Damian","Putignano","Empleado"),new usuarios("karinap","presed",2,"Karina","Presedo","Directora Nacional")};
        escribirBinario eb = new escribirBinario("users.ext");
//        eb.escribirData(us);
        usuarios[] us = eb.leerBinPC();
        for (int i = 0; i < us.length; i++) {
            System.out.println(us[i].toString());
        }
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author usuar
 */
public class Mensajes {
    
    static String[] aMsj = {"Operacion exitosa",
                            "Operacion no pudo ser realizada",
                            "No agregado, dato ya existe",
                            "No se pudo eliminar usuario"
                            };
    

    public static String getMsj(int i){
        return aMsj[i];
    }
}

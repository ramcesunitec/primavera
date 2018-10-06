/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.primavera;

/**
 *
 * @author ramce
 */
public class TarjetaNomina extends Tarjeta implements Pagos{

    @Override//Sobreescribe
    public void pagar() {
        System.out.println("Pagando Nomina");
    }
    
}

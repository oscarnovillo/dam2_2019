/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testcalculadora;

/**
 *
 * @author oscar
 */
public class Calculadora {

    public static void main(String[] args) {
        if (args.length > 0) {

            switch (args[0]) {
                case "SUMA":
                    System.out.println(Integer.parseInt(args[1])
                            + Integer.parseInt(args[2]));
                    break;
                default:
                    System.out.println("POn bien los parametros");
            }
        }
        else{
            System.out.println("Numero par erroneo bien los parametros");
        }
    }

}

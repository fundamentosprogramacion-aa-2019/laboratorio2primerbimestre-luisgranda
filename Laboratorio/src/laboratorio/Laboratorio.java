/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio;

import java.util.Scanner;

/**
 *
 * @author Granda
 */
public class Laboratorio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Importamos el el metodo Scanner
        Scanner entrada = new Scanner(System.in); 
            
            //Todas las variables a utilizar en el codigo
            String nombre_empleado;
            String nombre_temporal = "";
            int tipo;
            int edad;
            double sueldo_t1 = 340;
            double sueldo_t2 = 460;
            double sueldo_t3 = 580;
            double sueldo_t4 = 600;
            double sueldo_parcial;
            double incentivo_t1 = 0.05;
            double incentivo_t2 = 0.10;
            double incentivo_t3_4 = 0.15;
            double total_incentivo;
            double descuento1 = 0.15;
            double descuento2 = 0.25;
            double descuento3 = 0.35;
            double descuento_total;
            double sueldo_mensual;
            double total_pagar;
            double pago_seguro = 0;
            double pago_incentivo = 0;
            double pago_hijos = 0;
            double pago_total;
            int bono_hijos;
            int cant_hijos;
            int cont_empleados = 0;
            String cadena;
            String respuesta;
            
            //Valor inicial de la variable cadena.
            cadena = String.format("\n-------------------------------------------------------------------------------------------------------------------------------------------\n"
                    + "%90s\n\n%-35s%-20s%-20s%-15s%-20s%-20s\n\n","REPORTE DE ROL DE PAGOS POR EMPLEADO","Nombres",
                    "Sueldo Mensual","Incentivo - 1","Hijos",
                    "Descuento SS","Total a Pagar");
            
            //Ciclo principal
            do{ 
                       cont_empleados = cont_empleados + 1;
                       bono_hijos = 10;
                       System.out.printf("\n%25s\n","REGISTRO DE EMPLEADOS");
                       System.out.printf("\n%s %d\n","Empleado",cont_empleados);
                       System.out.printf("\t%s", "Nombre: ");
                       nombre_empleado = entrada.nextLine().toUpperCase();
                       
                       System.out.printf("\t%s","Edad: ");
                       edad = entrada.nextInt();
                       
                       //concatenacion primera.
                       cadena = String.format("%s%s%s%d%s%-12s",cadena,nombre_empleado,"(",edad,"Años",")");
                       
                       
                      System.out.printf("\t%s","Tipo de empleado: ");
                      tipo = entrada.nextInt();
                      
                      //controla que se ingrese un tipo de empleado permitido.
                       while(tipo > 4){
                                  System.out.printf("\nADVERTENCIA: Se Aceptan valores entre 1 - 4");
                                  System.out.printf("\n\t%s","Ingrese nuevo valor del tipo de empleado: ");
                                  tipo = entrada.nextInt();
                                  entrada.nextLine();
                      }
                      
                      System.out.printf("\t%s","Numero de Hijos: ");
                      cant_hijos = entrada.nextInt();
                      bono_hijos = bono_hijos * cant_hijos;
                     
                      
                      entrada.nextLine();//Limpiador de Scanner
                     
                     //Calculo del saldo parcial de cada empleado
                       if(tipo == 1){
                                  total_incentivo = sueldo_t1 * incentivo_t1;
                                  sueldo_mensual = sueldo_t1 + total_incentivo + bono_hijos;
                                  sueldo_parcial = sueldo_t1;
                       }else{
                                  if(tipo == 2){
                                             total_incentivo = sueldo_t2 * incentivo_t2 ;
                                             sueldo_mensual = sueldo_t2 + total_incentivo + bono_hijos;
                                             sueldo_parcial = sueldo_t2;
                                  }else{
                                             if(tipo == 3){
                                                       total_incentivo = sueldo_t3 * incentivo_t3_4 ;
                                                        sueldo_mensual = sueldo_t3 + total_incentivo + bono_hijos;
                                                        sueldo_parcial = sueldo_t3;
                                             }else{
                                                        total_incentivo = sueldo_t4 * incentivo_t3_4 ;
                                                        sueldo_mensual = sueldo_t4 + total_incentivo + bono_hijos;
                                                        sueldo_parcial = sueldo_t4;
                                             }
                                  }
                       }
                       //Calculo de los descuentos de acuerdo a la edad.
                       if(edad <= 20){
                                  descuento_total = sueldo_mensual * descuento1;
                       }else{
                                  if(edad > 20 && edad < 30){
                                             descuento_total = sueldo_mensual * descuento2;
                                  }else{
                                             descuento_total = sueldo_mensual * descuento3;
                                  }
                       }
                       
                       total_pagar = sueldo_mensual - descuento_total;
                       
                       //Cuarta concatenacion de la variable cadena.
                       cadena = String.format("%s\n%-35s%-20.2f%-20.2f%-15d%-20.2f%.2f\n--------------------------------------------------------------"
                               + "-----------------------------------------------------------------------------\n", cadena,"Totales: ",sueldo_parcial,
                               total_incentivo,bono_hijos,descuento_total,total_pagar);
                       
                       //Calculo de los pagos finales de la empresa.
                       pago_seguro = pago_seguro + descuento_total;
                       pago_incentivo = pago_incentivo + total_incentivo;
                       pago_hijos = pago_hijos +bono_hijos;
                       pago_total = pago_seguro + pago_incentivo + pago_hijos;
                       
                       System.out.printf("----------------------------------------\n");
                               
                       entrada.nextLine();
                       
                       //concidicion que controla la salida del ciclo principal
                       System.out.printf("\nIngrese 'si' para --->%s\nIngrese 'no' para --->%s\n"," Nuevo Empleado","Salir");
                       System.out.printf("\nEscriba su respuesta: ");
                      respuesta = entrada.nextLine().toUpperCase();
                
            }while(respuesta.equals("SI"));
            
            //Valor final de la variable cadena.
            cadena = String.format("%s\n%s\n\n%-35s%-25s%-25s%s\n%-35.2f%-25.2f%-25.2f%.2f\n\n",cadena,"Reporte de Rol de Pagos "
                    + "de la empresa(totales)","Descuento de Seguro Social","Incentivo - 1","Pago por Hijos",
                    "Total Pago de la Empresa",pago_seguro,pago_incentivo,pago_hijos,pago_total);
            
            
            System.out.printf(cadena);
    }
    
}

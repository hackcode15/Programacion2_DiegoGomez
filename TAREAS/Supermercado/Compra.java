package tarea.supermercado;

import lombok.*;
import java.util.*;

public class Compra {

    private Caja caja;
    private Cliente cliente;
    private ArrayList<Producto> productosComprados;
    
    public Compra(Caja caja, Cliente cliente, ArrayList<Producto> listaDeCompra){
        this.caja = caja;
        this.cliente = cliente;
        this.productosComprados = listaDeCompra;
    }

    public void imprimirTicket(){
        
        System.out.println("TICKET CAJA N°" + caja.getNroCaja());
        System.out.println("Datos del cliente");
        // Imprimir solo el nombre
        // System.out.println("Cliente: " + cliente.getNombre());
        // Imprimir todo los datos
        System.out.println(cliente);
        
        System.out.println("Compra realizada:");
        
        // Uso de expresion lambda para mapear y imprimir la lista de productos comprados
        productosComprados.stream()
                .map(p -> "Nombre: " + p.getNombre() + ", Precio: $" + p.getPrecio() + ", Cantidad: " + p.getCantidad())
                .forEach(System.out::println);
        
        // Uso de lambda para sumar el total a pagar de todos los productos comprados
        double totalCompra = productosComprados.stream()
                .mapToDouble(p -> p.getPrecio() * p.getCantidad())
                .sum();
        
        // Condicional para saber si tiene descuento por saber si es mayorista
        if(cliente.isMayorista()){
            totalCompra -= totalCompra * 0.20;
            System.out.println("Por ser mayorista se le aplico un descuento del 20%");
            System.out.println("Total importe: $" + totalCompra);
        }else{
            System.out.println("Total importe: $" + totalCompra);
        }

        System.out.println("----------------------------------------------------");
        
    }
    
}

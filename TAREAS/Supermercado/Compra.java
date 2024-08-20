package tarea;

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
    
    /*public static boolean hayStock(Producto producto){
        return producto.getStock() > 0;
    }*/
    
    public void imprimirTicket(){
        
        System.out.println("TICKET CAJA N°" + caja.getNroCaja());
        System.out.println("Datos del cliente");
        System.out.println(cliente.toString());
        
        System.out.println("Compra realizada:");
        
        productosComprados.stream()
                .map(p -> "Nombre: " + p.getNombre() + ", Precio: $" + p.getPrecio() + ", Cantidad: " + p.getCantidad())
                .forEach(System.out::println);
        
        double totalCompra = productosComprados.stream()
                .mapToDouble(p -> p.getPrecio() * p.getCantidad())
                .sum();
        
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

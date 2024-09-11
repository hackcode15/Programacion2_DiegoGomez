package tarea.compararProductos;

import java.util.*;

public class Principal {

    public static void main(String[] args) {
        
        // Creo nuevos productos
        Producto p1 = new Producto(123, "Notebook", 10);
        Producto p2 = new Producto(223, "Celular", 5);
        Producto p3 = new Producto(123, "Smart TV", 5);
        Producto p4 = new Producto(444, "Tablet", 6);

        // Creo una coleccion de tipo set (No valores repetidos)
        Set<Producto> listaProducto = new HashSet<Producto>();
        
        listaProducto.add(p1);
        listaProducto.add(p2);
        listaProducto.add(p3);
        listaProducto.add(p4);
        
        if(p1.equals(p3)){
            System.out.println("Son iguales");
        }else{
            System.out.println("Son distintos");
        }
        
        // Impresion del hashcode
        System.out.println(p1.hashCode());
        System.out.println(p3.hashCode());
        
        // Listar producto
        for (Producto producto : listaProducto) {
            System.out.println(producto);
        }
        
        // Listar producto con lambda
        //listaProducto.stream().forEach(System.out::println);
        
        
    }
    
}

package tarea.supermercado;

/**
 * Esta clase pretende la simulacion de un supermercado
 * @author Diego
 */

public class Principal {

    public static void main(String[] args) {
        
        // ***********************************************************************************
        // Creo productos
        Producto p1 = new Producto("Leche", 1500, 10);
        Producto p2 = new Producto("Yogurt", 800, 10);
        Producto p3 = new Producto("Cereal", 1800, 10);
        Producto p4 = new Producto("Galletas", 500, 10);
        Producto p5 = new Producto("Azucar", 2500, 10);
        
        // Creo un empleado
        Empleado emp1 = new Empleado("Juan", "Perez", 1414, 1500);
        
        // Creo una caja
        Caja caja1 = new Caja(emp1, 1);
        // ***********************************************************************************
        
        // Creo el cliente N°1
        Cliente cliente1 = new Cliente("Diego", "Gomez", 1255, true);
        
        // Cliente N°1 compra los siguientes productos
        cliente1.comprarProductos(p1, 5);
        cliente1.comprarProductos(p2, 3);
        cliente1.comprarProductos(p3, 1);
        cliente1.comprarProductos(p4, 4);
        
        // El cliente N°1 realiza la compra
        Compra compra1 = new Compra(caja1, cliente1, cliente1.getListaDeCompras());
        
        // Imprimo el ticket
        compra1.imprimirTicket();
        // ***********************************************************************************
        
        System.out.println("");
        
        // ***********************************************************************************
        
        Empleado emp2 = new Empleado("Roberto", "Lopez", 345, 1000);
        
        Caja caja2 = new Caja(emp2, 2);
        
        // Creo el cliente N°2
        Cliente cliente2 = new Cliente("Esteban", "Gomez", 2551, false);
        
        // Cliente N°2 compra los siguientes productos
        cliente2.comprarProductos(p5, 3);
        cliente2.comprarProductos(p2, 5);
        cliente2.comprarProductos(p1, 8);
        
        // El cliente N°2 realiza la compra
        Compra compra2 = new Compra(caja2, cliente2, cliente2.getListaDeCompras());
        
        // Imprimo el ticket
        compra2.imprimirTicket();
        // ***********************************************************************************
        
        
    }
}




package tarea.crudTienda_Collections;

import java.util.*;

public class Principal {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        Tienda miTienda = new Tienda();
        
        Cliente c1 = new Cliente(1, "Diego", "correo1", "123456");
        Cliente c2 = new Cliente(2, "Esteban", "correo2", "246810");
        Cliente c3 = new Cliente(3, "Lidia", "correo3", "3691215");
        Cliente c4 = new Cliente(4, "Ramon", "correo4", "48121620");
        
        miTienda.agregarCliente(c1);
        miTienda.agregarCliente(c2);
        miTienda.agregarCliente(c3);
        miTienda.agregarCliente(c4);
        
        do{
            
            System.out.println("########### TIENDA ###########");
            System.out.println("###### OPERACIONES CRUD ######");
            System.out.println("1) Agregar Cliente - CREATE");
            System.out.println("2) Listar Clientes - READ");
            System.out.println("3) Actualizar Cliente - UPDATE");
            System.out.println("4) Eliminar Cliente - DELETE");
            System.out.println("5) Buscar Cliente por ID");
            System.out.println("6) Finalizar");
            System.out.println("########## C R U D ############");
            
            System.out.print("Selecciona una opcion: ");
            int opcion = sc.nextInt();
            
            int id;
            String nombre, correo, telefono;
            
            switch(opcion){
                case 1:
                    System.out.print("Digite el id: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Ingrese el nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Ingrese el correo: ");
                    correo = sc.nextLine();
                    System.out.print("Digite el numero de telefono: ");
                    telefono = sc.nextLine();
                    
                    miTienda.agregarCliente(id, nombre, correo, telefono);
                    break;
                case 2:
                    System.out.println("######## CLIENTES ########");
                    miTienda.listarCliente();
                    break;
                case 3:
                    System.out.print("Digite el id del cliente a actualizar: ");
                    id = sc.nextInt();
                    miTienda.actualizarCliente(id);
                    break;
                case 4:
                    System.out.print("Digite el id del cliente a eliminar: ");
                    id = sc.nextInt();
                    miTienda.eliminarCliente(id);
                    break;
                case 5:
                    System.out.print("Digite el id del cliente a buscar: ");
                    id = sc.nextInt();
                    
                    // Usando el metodo normal
                    Cliente clienteBuscado = miTienda.buscarCliente(id);
                    if(clienteBuscado != null){
                        System.out.println("Cliente encontrado: " + clienteBuscado);
                    }else{
                        System.out.println("No encontrado");
                    }
                    
                    // Usando el metodo con el uso lambda y Optional
                    // Creamos un objeto de tipo Optional
                    /*Optional<Cliente> clienteBuscado = miTienda.buscarCliente(id); // Llamo al metodo
                    
                    if(clienteBuscado.isPresent()){ // Si el clienteBuscado esta presente
                        System.out.println("Cliente encontrado: " + clienteBuscado.get()); // imprimimos el cliente con el metodo get
                    }else{ // Sino
                        System.out.println("No encontrado");
                    }*/
                    
                    break;
                    
                case 6:
                    System.out.println("Programa finalizado");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion incorrecta. Intentalo nuevamente");
                    break;
            }

        }while(true);
        
        
        
    }
    
}

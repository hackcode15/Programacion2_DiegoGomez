package tarea.crudTiendaBD;

import tarea.crudTiendaBD.Tienda;
import java.util.*;

public class Principal {
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        Tienda miTienda = new Tienda();
        
        do{
            
            System.out.println("########### TIENDA ###########");
            System.out.println("### OPERACIONES CRUD BBDD ###");
            System.out.println("1) Agregar Cliente - CREATE");
            System.out.println("2) Listar Clientes - READ");
            System.out.println("3) Actualizar Cliente - UPDATE");
            System.out.println("4) Eliminar Cliente - DELETE");
            System.out.println("5) Buscar Cliente por ID");
            System.out.println("6) Finalizar");
            System.out.println("########## C R U D ############");
            
            System.out.print("Seleccion una opcion: ");
            int opcion = sc.nextInt();
            
            int id;
            String nombre, correo, telefono;
            boolean estado;
            
            switch(opcion){
                
                case 1:
                    
                    System.out.print("ID: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nombre: ");
                    nombre = sc.nextLine();
                    System.out.print("Correo: ");
                    correo = sc.nextLine();
                    System.out.print("Telefono: ");
                    telefono = sc.nextLine();
                    
                    estado = miTienda.agregarCliente(id, nombre, correo, telefono);
                    
                    if(estado){
                        System.out.println("Cliente agregado con exito");
                    }
                    
                    break;
                case 2:
                    
                    List<Cliente> listaCliente = miTienda.listarClientes();
                    
                    if(!listaCliente.isEmpty()){
                        
                        listaCliente.stream()
                                .map(p -> "ID: " + p.getId() + ", Nombre: " + p.getNombre() + ", Correo: " + p.getCorreo() + ", Telefono: " + p.getTelefono())
                                .forEach(p -> System.out.println(p));
                        
                    }else{
                        System.out.println("Error");
                    }
                    
                    break;
                case 3:
                    
                    System.out.print("Digite el id del cliente a actualizar: ");
                    id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nuevo correo: ");
                    correo = sc.nextLine();
                    System.out.print("Nuevo telefono: ");
                    telefono = sc.nextLine();
                    
                    estado = miTienda.actualizarCliente(id, correo, telefono);
                    
                    if(estado){
                        System.out.println("Cliente actualizado con exito");
                    }
                    break;
                case 4:
                    
                    System.out.print("Digite el id del cliente a eliminar: ");
                    id = sc.nextInt();
                    
                    estado = miTienda.eliminarCliente(id);
                    
                    if(estado){
                        System.out.println("Cliente eliminado con exito");
                    }
                    break;
                case 5:
                    
                    System.out.print("Digite el id del cliente a buscar: ");
                    id = sc.nextInt();
                    
                    Cliente clienteEncontrado = miTienda.buscarCliente(id);
                    
                    if(clienteEncontrado != null){
                        System.out.println("Cliente encontrado\n" + clienteEncontrado);
                    }
                    
                    break;
                case 6:
                    System.out.println("Programa finalizado");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }
            
        }while(true);
        
    }
    
}

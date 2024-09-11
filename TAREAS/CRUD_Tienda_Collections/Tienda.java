package tarea.crudTienda_Collections;

import java.util.*;

public class Tienda {
    
    private Cliente cliente;
    private List<Cliente> listaCliente;
    
    public Tienda(){
        listaCliente = new ArrayList<Cliente>(); // Inicializo la lista
    }
    
    // CRUD
    
    // Agregar - CREATE
    public void agregarCliente(int id, String nombre, String correo, String telefono){
        cliente = new Cliente(id, nombre, correo, telefono);
        listaCliente.add(cliente);
        System.out.println("Cliente agregado con exito");
    }
    // Agregar - CREATE sobreescrito
    public void agregarCliente(Cliente cliente){
        listaCliente.add(cliente);
    }
    
    public void listarCliente(){
        
        if(!listaCliente.isEmpty()){
            
            for (Cliente cliente : listaCliente) {
                System.out.println(cliente);
            }
            
        }else{
            System.out.println("Error: Lista Vacia");
        }
        
    }
    
    // --------------------------------------------------------------------------------------------------------
    // Leer con lamda
    /*public void listarCliente(){
        
        // Si la lista esta vacia
        if(!listaCliente.isEmpty()){
            // Expresion lambda
            listaCliente.stream().forEach(p -> System.out.println(p));
            //listaCliente.stream().forEach(System.out::println);
        }else { // Si no
            System.out.println("Lista vacia");
        }
    
    }*/
    // --------------------------------------------------------------------------------------------------------
    
    // Actualizar - UPDATE
    /*public void actualizarCliente(int id){
        
        Scanner sc = new Scanner(System.in); // Uso de Scanner
        
        // Si la lista esta vacia
        if(listaCliente.isEmpty()){
            System.out.println("Lista vacia");
            return; // Sale del metodo
        } // Sino
        
        boolean estado = false;
        
        //  Uso de la clase iterador
        Iterator<Cliente> iterador = listaCliente.iterator();
        while(iterador.hasNext()){ // Mientras que la lista / iterador tenga un siguiente elemento
            
            Cliente cliente = iterador.next(); // Instancia de cliente
            
            if(cliente.getId() == id){
                
                System.out.print("Ingrese el nuevo nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese el nuevo correo: ");
                String correo = sc.nextLine();
                System.out.print("Ingrese el nuevo telefono: ");
                String telefono = sc.nextLine();
                
                // Actualizo / Modifico
                cliente.setNombre(nombre);
                cliente.setCorreo(correo);
                cliente.setTelefono(telefono);
                
                estado = true;
                break;
                
            }
            
        }
        
        if(estado){
            System.out.println("Cliente con id \"" + id + "\" actualizado con exito");
        }else{
            System.out.println("No existe ningun cliente con ese id");
        }
        
    }*/
    
    // Metodo para actualizar cliente con el uso de lamda y Optional
    public void actualizarCliente(int id){
        
        Scanner sc = new Scanner(System.in); // Uso de Scanner
        
        if(!listaCliente.isEmpty()){
            
            Optional<Cliente> clienteBuscado = listaCliente.stream().filter(p -> p.getId() == id).findFirst();
            
            if(clienteBuscado.isPresent()){
                
                Cliente cliente = clienteBuscado.get();
                
                System.out.print("Ingrese el nuevo nombre: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese el nuevo correo: ");
                String correo = sc.nextLine();
                System.out.print("Ingrese el nuevo telefono: ");
                String telefono = sc.nextLine();
                
                // Actualizo / Modifico
                cliente.setNombre(nombre);
                cliente.setCorreo(correo);
                cliente.setTelefono(telefono);
                
                System.out.println("Cliente con id: \"" + id + "\" actualizado correctamente");
                
            }else{
                System.out.println("Error: No existe ningun cliente con ese id");
            }
            
        }else{
            System.out.println("Error: Lista Vacia");
        }
        
    }
    
    // Eliminar - DELETE
    public void eliminarCliente(int id){
        
        boolean estado = false;
        
        if(!listaCliente.isEmpty()){
            
            // Uso de la clase iterador
            Iterator<Cliente> iterador = listaCliente.iterator();
            while(iterador.hasNext()){ // Mientras que la lista / iterador tenga un siguiente elemento

                Cliente cliente = iterador.next(); // Instancia de cliente

                if(cliente.getId() == id){
                    iterador.remove(); // elimino
                    estado = true;
                    break;
                }

            }
            
            if(estado){
                System.out.println("Cliente eliminado correctamente");
            }else{
                System.out.println("Error: No existe ningun cliente con id \"" + id + "\"");
            }
            
        }else{
            System.out.println("Error: Lista Vacia");
        }
         
    }
    
    // --------------------------------------------------------------------------------------------------------
    // Metodo para eliminar Cliente con expresion lambda
    /*public void eliminarCliente(int id){
        
        if(!listaCliente.isEmpty()){
            
            boolean estado = listaCliente.removeIf(p -> p.getId() == id);
            
            if(estado){
                System.out.println("Cliente eliminado correctamente");
            }else{
                System.out.println("Error: No hay cliente con ese ID");
            }
            
        }else{
            System.out.println("Error: La lista esta vacia");
        }
        
    }*/
    // --------------------------------------------------------------------------------------------------------
    
    // Metodo para buscar Cliente por el ID
    public Cliente buscarCliente(int id){
        
        if(!listaCliente.isEmpty()){ // Si la lista no esta vacia
            
            for (Cliente cliente : listaCliente) {
            
                if(cliente.getId() == id){
                    return cliente;
                }
            
            }
            
        }
        
        return null;
        
    }
    
    // --------------------------------------------------------------------------------------------------------
    // Metodo para buscar producto con Lambda y uso de la clase Optional
    // Devuelve un objeto de tipo Optional
    /*public Optional<Cliente> buscarCliente(int id){
        
        return listaCliente.stream().filter(p -> p.getId() == id).findFirst(); // Devuelve un objeto de tipo cliente o null
        
    }*/
    // --------------------------------------------------------------------------------------------------------
    
}

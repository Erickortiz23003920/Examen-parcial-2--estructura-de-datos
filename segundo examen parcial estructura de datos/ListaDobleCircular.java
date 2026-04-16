public class ListaDobleCircular {
    Nodo head;

    // 6.1 Insertar al Inicio 
    public void insertarInicio(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (head == null) { 
            nuevoNodo.siguiente = nuevoNodo;
            nuevoNodo.anterior = nuevoNodo;
            head = nuevoNodo; 
        } else {
            Nodo ultimo = head.anterior; 
            nuevoNodo.siguiente = head;
            nuevoNodo.anterior = ultimo;
            ultimo.siguiente = nuevoNodo;
            head.anterior = nuevoNodo;
            head = nuevoNodo; 
        }
        imprimir();
    }

    // 6.2 Insertar al Final 
    public void insertarFinal(int dato) {
        Nodo nuevoNodo = new Nodo(dato);
        if (head == null) { 
            nuevoNodo.siguiente = nuevoNodo;
            nuevoNodo.anterior = nuevoNodo;
            head = nuevoNodo;
        } else {
            Nodo ultimo = head.anterior; 
            nuevoNodo.siguiente = head;
            nuevoNodo.anterior = ultimo;
            ultimo.siguiente = nuevoNodo;
            head.anterior = nuevoNodo; 
        }
        imprimir();
    }

    // 6.3 Eliminar al Inicio 
    public void eliminarInicio() {
        if (head == null) {
            System.out.println("Error: Lista vacía");
            return;
        }
        if (head.siguiente == head) {
            head = null;
        } else {
            Nodo ultimo = head.anterior; 
            head = head.siguiente; 
            head.anterior = ultimo;
            ultimo.siguiente = head; 
        }
        imprimir();
    }

    // 6.4 Eliminar al Final 
    public void eliminarFinal() {
        if (head == null) {
            System.out.println("Error: Lista vacía"); 
            return;
        }
        if (head.siguiente == head) {
            head = null; 
        } else {
            Nodo ultimo = head.anterior;
            Nodo penultimo = ultimo.anterior; 
            penultimo.siguiente = head;
            head.anterior = penultimo; 
        }
        imprimir();
    }

    // 6.5 Buscar Elemento 
    public void buscar(int valor) {
        if (head == null) {
            System.out.println("No encontrado (lista vacía)");
            return;
        }
        Nodo actual = head;
        boolean encontrado = false;
        do {
            if (actual.dato == valor) {
                encontrado = true;
                break;
            }
            actual = actual.siguiente;
        } while (actual != head);

        if (encontrado) System.out.println("Resultado: Encontrado");
        else System.out.println("Resultado: No encontrado");
    }

    // 6.6 Imprimir (Código de referencia proporcionado) 
    public void imprimir() {
        if (head == null) {
            System.out.println("La lista está vacía");
            return;
        }
        Nodo actual = head;
        System.out.print("Lista: ");
        do {
            System.out.print(actual.dato + " <-> ");
            actual = actual.siguiente;
        } while (actual != head);
        System.out.println("(circular -> " + head.dato + ")");
    }
}

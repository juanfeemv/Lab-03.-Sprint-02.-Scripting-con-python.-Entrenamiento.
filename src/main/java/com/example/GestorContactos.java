package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GestorContactos {
    private List<Contacto> contactos;

    public GestorContactos() {
        this.contactos = new ArrayList<>();
    }

    // Guardar / Añadir contacto
    public boolean guardarContacto(Contacto contacto) {
        if (contacto == null) {
            return false;
        }
        return contactos.add(contacto);
    }

    // Buscar contacto por ID
    public Optional<Contacto> buscarContactoPorId(int id) {
        return contactos.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    // Obtener todos los contactos
    public List<Contacto> obtenerTodos() {
        return new ArrayList<>(contactos);
    }

    // Eliminar contacto por ID
    public boolean eliminarContacto(int id) {
        return contactos.removeIf(c -> c.getId() == id);
    }
}

package com.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class GestorContactosTest {

    private GestorContactos gestor;
    private Contacto contacto1;

    @BeforeEach
    void setUp() {
        gestor = new GestorContactos();
        contacto1 = new Contacto(1, "Ana Pérez", "ana@example.com", 28);
    }

    @Test
    void testGuardarContacto() {
        boolean guardado = gestor.guardarContacto(contacto1);
        assertTrue(guardado, "El contacto debería haberse guardado exitosamente");
        assertEquals(1, gestor.obtenerTodos().size(), "Debe haber exactamente 1 contacto en la lista");
    }

    @Test
    void testBuscarContactoPorId() {
        gestor.guardarContacto(contacto1);
        Optional<Contacto> encontrado = gestor.buscarContactoPorId(1);

        assertTrue(encontrado.isPresent(), "El contacto debería ser encontrado");
        assertEquals("Ana Pérez", encontrado.get().getNombre());
    }

    @Test
    void testEliminarContacto() {
        gestor.guardarContacto(contacto1);
        boolean eliminado = gestor.eliminarContacto(1);

        assertTrue(eliminado, "El contacto debería eliminarse correctamente");
        assertTrue(gestor.obtenerTodos().isEmpty(), "La lista de contactos debería estar vacía");
    }
}

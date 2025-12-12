# Dragonlandia

## Introduccion

Juego de consola sencillo para simular la conquista de un bosque entre un mago y monstruos usando Hibernate y MySQL. El flujo se gestiona desde una interfaz de texto que solicita los datos por teclado y persiste entidades en la base de datos.

### Diagrama de Clases Mermaid 

```mermaid
classDiagram
    class Main {
        +main(args: String[]) void
    }

    class Interfaz {
        +iniciar() void
    }

    class Controller {
        +guardarMago(mago: Mago) void
        +guardarMonstruo(monstruo: Monstruo) void
        +guardarBosque(bosque: Bosque) void
        +actualizarBosque(bosque: Bosque) void
        +simularBatalla(mago: Mago, monstruo: Monstruo) void
    }

    class Mago {
        -id: int
        -nombre: String
        -vida: int
        -nivelMagia: int
        +lanzarHechizo(monstruo: Monstruo) void
    }

    class Monstruo {
        -id: int
        -nombre: String
        -vida: int
        -tipo: tipo
        -fuerza: int
        -bosque: Bosque
        +atacar(mago: Mago) void
    }

    class Bosque {
        -id: int
        -nombre: String
        -nivelPeligro: int
        -monstruoJefe: Monstruo
        -monstruos: List~Monstruo~
        +mostrarJefe() void
        +cambiarJefe(nuevoJefe: Monstruo) void
    }

    class tipo {
        <<enumeration>>
        OGRO
        TROLL
        ESPECTRO
    }

    Main --> Interfaz : crea
    Interfaz --> Controller : usa
    Controller --> Mago :usa
    Controller --> Bosque :usa
    Controller --> Monstruo :usa
    Monstruo --> tipo :usa
```

### Diagrama BD Mermaid 

```mermaid
erDiagram
    BOSQUE ||--|| MONSTRUO : "1.1 es jefe"
    MONSTRUO ||--|| BOSQUE : "1-N tiene"

    MAGO {
        int id
        string nombre
        int vida
        int nivelMagia
    }

    MONSTRUO {
        int id
        string nombre
        int vida
        string tipo
        int fuerza
        int bosque_id
    }

    BOSQUE {
        int id
        string nombre
        int nivelPeligro
        int monstruoJefe_id
    }
```
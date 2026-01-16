# Dragonlandia

## Introduccion

Juego de consola sencillo para simular la conquista de un bosque entre un mago y monstruos usando Hibernate y MySQL. El flujo se gestiona desde una interfaz de texto que solicita los datos por teclado y persiste entidades en la base de datos.

## Analisis

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
        -Todos los Controllers
        +guardarMago(mago: Mago) void
        +guardarMonstruo(monstruo: Monstruo) void
        +guardarBosque(bosque: Bosque) void
        +guardarDragon(dragon: Dragon) void
        +actualizarDragon(dragon: Dragon) void
        +actualizarMonstruo(mostruo: Mosntruo) void
        +actualizarBosque(bosque: Bosque) void
        +actualizarMago(mago: Mago) void
        +...(Todo lo demas)
        +simularBatalla(mago: Mago, monstruo: Monstruo, mago2: Mago, monstruo2: Mostruo, monstruo3: Mostruo, dragon: Dragon) void
        +getInstance() Controller
    }

    class Mago {
        -id: int
        -nombre: String
        -vida: int
        -nivelMagia: int
        -hechizos: List~Hechizo~
        +lanzarHechizo(monstruo: Monstruo) void
    }

    class Hechizo {
        -id: int
        -nombre: nombreHechizo
        -efecto: int
        -mago: Mago
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
        -dragones: List~Dragon~
        +mostrarJefe() void
        +cambiarJefe(nuevoJefe: Monstruo) void
    }

    class Dragon {
        -id: int
        -nombre: String
        -intensidadFuego: int
        -resistencia: int
        -bosque: Bosque
        +exhalar(monstruo: Monstruo) void
    }

    class tipo {
        <<enumeration>>
        OGRO
        TROLL
        ESPECTRO
    }

    class nombreHechizo {
        <<enumeration>>
        Bola_de_fuego
        Rayo
        Bola_de_nieve
        Descarga
        Maldicion_duende
    }

    Main --> Interfaz : crea
    Interfaz --> Controller : usa
    Controller --> Mago :usa
    Controller --> Bosque :usa
    Controller --> Monstruo :usa
    Controller --> Dragon :usa
    Monstruo --> tipo :usa
    Mago --> Hechizo :tiene
    Hechizo --> nombreHechizo :usa
    Hechizo --> Mago :pertenece a
    Bosque --> Monstruo :contiene
    Bosque --> Dragon :contiene
    Bosque --> Monstruo :monstruoJefe
```
## Diseño

### Diagrama BD Mermaid 

```mermaid
erDiagram
    BOSQUE ||--|| MONSTRUO : "monstruoJefe_id (1..1)"
    BOSQUE ||--o{ MONSTRUO : "monstruos (1..N)"
    BOSQUE ||--o{ DRAGON : "dragones (1..N)"
    MAGO ||--o{ HECHIZO : "hechizos (1..N)"

    MAGO {
        int id
        string nombre
        int vida
        int nivelMagia
    }

    HECHIZO {
        int id
        string nombreHechizo
        int efecto
        int mago_id
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

    DRAGON {
        int id
        string nombre
        int intensidadFuego
        int resistencia
        int bosque_id
    }
```

## Manual de Usuario

[Manual de Usuario](ManualUsuario.md)

## PFD Tablas

[PDF Tablas](AnteloRey_Fernando_DragonlandiaHibernate.pdf)
# 🌳 Librería Independiente Raíz — Sitio Web

Aplicación web dinámica migrada desde el sitio estático del Núcleo 3 a **Spring Boot**.

## URLs
- **App (Render + Supabase):** https://libreria-raiz.onrender.com
- **Docs (GitHub Pages):** https://dracofactor.github.io/libreria-raiz/
- **Repo:** https://github.com/dracofactor/libreria-raiz

## Tecnologías
Java 21 · Spring Boot 3.4.0 · Maven · Thymeleaf · Lombok · Spring Data JPA · H2 · PostgreSQL (Supabase) · Render · GitHub Pages

## Estructura
```text
libreria-raiz/
├── docs/              # GitHub Pages (documentación)
├── pom.xml
└── src/main/
    ├── java/com/dracofactor/libreriaraiz/
    │   ├── controller/  # Home, Nosotros, Blog, Calendario, Contacto
    │   ├── model/       # Post, Evento, MensajeContacto
    │   └── repository/  # JPA repos
    └── resources/
        ├── application*.properties   # general, dev, prod
        ├── static/{css,js,imagenes}
        └── templates/
```

# Cómo levantar en local

``` bash
git clone https://github.com/dracofactor/libreria-raiz.git
cd libreria-raiz
cp .env.example .env       # y editar con credenciales de Supabase (solo si usarás prod)
./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
```

*Abrir:* http://localhost:8080


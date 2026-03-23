# Consumo de API con JavaScript

Proyecto sencillo en HTML + JavaScript para consumir un servicio API al presionar un boton y mostrar la respuesta en la misma pagina.

## Caracteristicas

- Interfaz simple en un solo archivo (`index.html`).
- Campo para colocar la URL del API.
- Boton para ejecutar el consumo (`fetch`).
- Respuesta mostrada en pantalla dentro de un bloque `<pre>`.
- Manejo de estados: carga, exito y error.

## API de ejemplo

Este proyecto viene configurado con un endpoint de FakerAPI:

`https://fakerapi.it/api/v2/persons?_quantity=5`

Tambien puedes reemplazar esa URL por cualquier otro endpoint que quieras probar.

## Como funciona

1. Escribe o pega la URL del API en el campo.
2. Haz clic en el boton **Consumir API**.
3. JavaScript realiza una solicitud HTTP con `fetch`.
4. Si la respuesta es correcta, se muestra el contenido en pantalla.
5. Si ocurre un error, se muestra un mensaje para ayudarte a identificar el problema.

## Ejecutar el proyecto

Opcion 1 (recomendada):

1. Abre el proyecto en VS Code.
2. Instala la extension **Live Server** (si no la tienes).
3. Clic derecho sobre `index.html`.
4. Selecciona **Open with Live Server**.

Opcion 2:

1. Abre la carpeta del proyecto en el explorador de archivos.
2. Haz doble clic en `index.html` para abrirlo en tu navegador.

## Estructura

- `index.html`: contiene HTML, estilos CSS y logica JavaScript.
- `README.md`: documentacion del proyecto.

## Tecnologias usadas

- HTML5
- CSS3
- JavaScript (Fetch API)

## Autor

Pérez Estrada Luis Ángel

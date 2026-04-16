// Función para mostrar un saludo
function mostrarSaludo() {
    alert("¡Bienvenido a Click & Learn! Nos alegra que estés aquí.");
}

// Función para generar un color aleatorio
function generarColorAleatorio() {
    const colores = [
        'linear-gradient(135deg, rgba(15,52,96,0.8) 0%, rgba(22,33,62,0.8) 50%, rgba(15,52,96,0.8) 100%)',
        'linear-gradient(135deg, rgba(45,27,105,0.8) 0%, rgba(74,47,122,0.8) 50%, rgba(45,27,105,0.8) 100%)',
        'linear-gradient(135deg, rgba(26,58,82,0.8) 0%, rgba(45,90,122,0.8) 50%, rgba(26,58,82,0.8) 100%)',
        'linear-gradient(135deg, rgba(58,26,26,0.8) 0%, rgba(90,42,42,0.8) 50%, rgba(58,26,26,0.8) 100%)',
        'linear-gradient(135deg, rgba(26,58,42,0.8) 0%, rgba(42,90,74,0.8) 50%, rgba(26,58,42,0.8) 100%)',
        'linear-gradient(135deg, rgba(42,26,58,0.8) 0%, rgba(74,42,90,0.8) 50%, rgba(42,26,58,0.8) 100%)',
        'linear-gradient(135deg, rgba(58,42,26,0.8) 0%, rgba(90,74,42,0.8) 50%, rgba(58,42,26,0.8) 100%)',
        'linear-gradient(135deg, rgba(26,42,58,0.8) 0%, rgba(42,74,90,0.8) 50%, rgba(26,42,58,0.8) 100%)',
    ];
    return colores[Math.floor(Math.random() * colores.length)];
}

// Función para cambiar el color de fondo
function cambiarColorFondo() {
    const main = document.querySelector('main');
    main.style.background = generarColorAleatorio();
    main.style.borderRadius = '10px';
    main.style.marginTop = '20px';
    main.style.marginBottom = '20px';
}

// Event listeners cuando el DOM está listo
document.addEventListener('DOMContentLoaded', function() {
    // Vinculamos los botones con sus funciones
    const btnSaludo = document.getElementById('btnSaludo');
    const btnColor = document.getElementById('btnColor');

    if (btnSaludo) {
        btnSaludo.addEventListener('click', mostrarSaludo);
    }

    if (btnColor) {
        btnColor.addEventListener('click', cambiarColorFondo);
    }
});

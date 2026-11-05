// nosotros.js — interacción de la vista Nosotros
document.addEventListener('DOMContentLoaded', () => {
    const logo = document.getElementById('logo-raiz');
    if (logo) {
        logo.style.cursor = 'pointer';
        logo.addEventListener('click', () => {
            alert('🌳 Librería Raíz: espacio independiente dedicado a conectar historias.');
        });
    }
});
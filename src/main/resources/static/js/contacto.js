// contacto.js — envío asíncrono al backend (compatible con Spring Boot)
document.addEventListener('DOMContentLoaded', () => {
    const formulario = document.getElementById('formulario-contacto');
    if (!formulario) return;

    formulario.addEventListener('submit', async (evento) => {
        evento.preventDefault();
        const nombre = document.getElementById('nombre').value;
        const url = formulario.getAttribute('action');
        const data = new URLSearchParams(new FormData(formulario));

        try {
            const respuesta = await fetch(url, {
                method: 'POST',
                headers: { 'Content-Type': 'application/x-www-form-urlencoded' },
                body: data
            });
            if (respuesta.ok) {
                alert(`¡Gracias, ${nombre}! Tu mensaje ha sido enviado.`);
                formulario.reset();
                location.reload(); // Para que Thymeleaf muestre el mensaje de éxito
            } else {
                alert('Revisa los campos: hubo un error de validación.');
            }
        } catch (error) {
            console.error('Error de red:', error);
            alert('Error de conexión. Inténtalo de nuevo.');
        }
    });
});
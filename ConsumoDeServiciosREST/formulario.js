
fetch('https://restcountries.com/v3.1/all?fields=name,flags')
    .then(response => response.json())
    .then(data => {
        const countrySelect = document.getElementById('country');
        countrySelect.innerHTML = '<option value="">Seleccione un país</option>';
        data.sort((a, b) => a.name.common.localeCompare(b.name.common))
            .forEach(country => {
                const option = document.createElement('option');
                option.value = country.name.common;
                option.textContent = country.name.common;
                countrySelect.appendChild(option);
            });
    })
    .catch(error => {
        console.error('Error al cargar los países:', error);
        const countrySelect = document.getElementById('country');
        countrySelect.innerHTML = '<option value="">Error al cargar países</option>';
    });

const form = document.getElementById('formulario_basico');
const limpiarDatos = document.getElementById('limpiarDatos');
const avgInput = document.getElementById('avg');
const countrySelect = document.getElementById('country');

form.addEventListener('submit', function(event) {
    event.preventDefault();

    const promedio = Number(avgInput.value);
    const countrySeleccionado = countrySelect.value;

    if (Number.isNaN(promedio) || promedio < 0 || promedio > 10) {
        alert('El promedio debe estar entre 0 y 10.');
        avgInput.focus();
        return;
    }

    if (!countrySeleccionado) {
        alert('Por favor, selecciona un country.');
        return;
    }

    const payload = new FormData();
    payload.append('name', document.getElementById('name').value);
    payload.append('email', document.getElementById('email').value);
    payload.append('account', document.getElementById('account').value);
    payload.append('lastName', document.getElementById('lastName').value);
    payload.append('avg', promedio);
    payload.append('country', countrySeleccionado);

    fetch('https://masksoft.com.mx/register', {
        method: 'POST',
        body: payload
    })
        .then(response => {
            if (!response.ok) {
                throw new Error('Error al enviar el formulario.');
            }

            alert('Formulario enviado correctamente.');
            form.reset();
            countrySelect.value = '';
        })
        .catch(error => {
            console.error('Error al enviar el formulario:', error);
            alert('No se pudo enviar el formulario.');
        });
});

limpiarDatos.addEventListener('click', function() {
    form.reset();
    countrySelect.value = '';
});
                        
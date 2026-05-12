import { useState } from 'react';
import './Formulario.css';

function Formulario() {
  const [formData, setFormData] = useState({
    nombre: '',
    apellidos: '',
    email: '',
    numeroCuenta: '',
    promedio: '',
    pais: '',
  });

  const [errores, setErrores] = useState({});
  const [mensaje, setMensaje] = useState('');

  // Función para manejar cambios en los inputs
  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({
      ...formData,
      [name]: value,
    });
    // Limpiar el error del campo cuando el usuario empieza a escribir
    if (errores[name]) {
      setErrores({
        ...errores,
        [name]: '',
      });
    }
  };

  // Función para validar el formulario
  const validarFormulario = () => {
    const nuevosErrores = {};

    if (!formData.nombre.trim()) {
      nuevosErrores.nombre = 'El nombre es obligatorio';
    }

    if (!formData.apellidos.trim()) {
      nuevosErrores.apellidos = 'Los apellidos son obligatorios';
    }

    if (!formData.email.trim()) {
      nuevosErrores.email = 'El correo electrónico es obligatorio';
    } else if (!/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(formData.email)) {
      nuevosErrores.email = 'Ingrese un correo válido';
    }

    if (!formData.numeroCuenta.trim()) {
      nuevosErrores.numeroCuenta = 'El número de cuenta es obligatorio';
    }

    if (!formData.promedio.trim()) {
      nuevosErrores.promedio = 'El promedio es obligatorio';
    } else if (isNaN(formData.promedio) || formData.promedio < 0 || formData.promedio > 5) {
      nuevosErrores.promedio = 'El promedio debe ser un número entre 0 y 5';
    }

    if (!formData.pais.trim()) {
      nuevosErrores.pais = 'El país es obligatorio';
    }

    setErrores(nuevosErrores);
    return Object.keys(nuevosErrores).length === 0;
  };

  // Función para guardar la información
  const handleGuardar = (e) => {
    e.preventDefault();

    if (validarFormulario()) {
      // Enviar los datos al servidor usando proxy local de Vite
      fetch('/api/register', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Accept': 'application/json',
        },
        body: JSON.stringify(formData),
      })
        .then((response) => {
          console.log('Status:', response.status);
          if (response.ok) {
            setMensaje('¡Formulario guardado correctamente!');
            console.log('Datos enviados exitosamente:', formData);
            // Opcional: limpiar el formulario después de guardar
            handleLimpiar();
          } else {
            setMensaje(`Error: ${response.status} - ${response.statusText}`);
            console.error('Error del servidor:', response.status, response.statusText);
          }
        })
        .catch((error) => {
          console.error('Error de conexión:', error);
          setMensaje('Error al conectar con el servidor. Asegúrate de estar ejecutando en http://localhost:5173');
        })
        .finally(() => {
          // Limpiar el mensaje después de 4 segundos
          setTimeout(() => {
            setMensaje('');
          }, 4000);
        });
    } else {
      setMensaje('Por favor, complete todos los campos correctamente.');
    }
  };

  // Función para limpiar el formulario
  const handleLimpiar = () => {
    setFormData({
      nombre: '',
      apellidos: '',
      email: '',
      numeroCuenta: '',
      promedio: '',
      pais: '',
    });
    setErrores({});
    setMensaje('');
  };

  return (
    <div className="formulario-container">
      <div className="formulario-card">
        <h2>Formulario de Registro</h2>

        {mensaje && (
          <div className={`mensaje ${mensaje.includes('correctamente') ? 'success' : 'error'}`}>
            {mensaje}
          </div>
        )}

        <form onSubmit={handleGuardar}>
          {/* Campo Nombre */}
          <div className="form-group">
            <label htmlFor="nombre">Nombre(s) *</label>
            <input
              type="text"
              id="nombre"
              name="nombre"
              value={formData.nombre}
              onChange={handleChange}
              placeholder="Ingrese su nombre"
              className={errores.nombre ? 'input-error' : ''}
            />
            {errores.nombre && <span className="error-message">{errores.nombre}</span>}
          </div>

          {/* Campo Apellidos */}
          <div className="form-group">
            <label htmlFor="apellidos">Apellidos *</label>
            <input
              type="text"
              id="apellidos"
              name="apellidos"
              value={formData.apellidos}
              onChange={handleChange}
              placeholder="Ingrese sus apellidos"
              className={errores.apellidos ? 'input-error' : ''}
            />
            {errores.apellidos && <span className="error-message">{errores.apellidos}</span>}
          </div>

          {/* Campo Correo */}
          <div className="form-group">
            <label htmlFor="email">Correo Electrónico *</label>
            <input
              type="email"
              id="email"
              name="email"
              value={formData.email}
              onChange={handleChange}
              placeholder="ejemplo@correo.com"
              className={errores.email ? 'input-error' : ''}
            />
            {errores.email && <span className="error-message">{errores.email}</span>}
          </div>

          {/* Campo Número de Cuenta */}
          <div className="form-group">
            <label htmlFor="numeroCuenta">Número de Cuenta *</label>
            <input
              type="text"
              id="numeroCuenta"
              name="numeroCuenta"
              value={formData.numeroCuenta}
              onChange={handleChange}
              placeholder="Ingrese su número de cuenta"
              className={errores.numeroCuenta ? 'input-error' : ''}
            />
            {errores.numeroCuenta && (
              <span className="error-message">{errores.numeroCuenta}</span>
            )}
          </div>

          {/* Campo Promedio */}
          <div className="form-group">
            <label htmlFor="promedio">Promedio *</label>
            <input
              type="number"
              id="promedio"
              name="promedio"
              value={formData.promedio}
              onChange={handleChange}
              placeholder="Ingrese su promedio (0-5)"
              min="0"
              max="5"
              step="0.1"
              className={errores.promedio ? 'input-error' : ''}
            />
            {errores.promedio && <span className="error-message">{errores.promedio}</span>}
          </div>

          {/* Campo País */}
          <div className="form-group">
            <label htmlFor="pais">País *</label>
            <select
              id="pais"
              name="pais"
              value={formData.pais}
              onChange={handleChange}
              className={errores.pais ? 'input-error' : ''}
            >
              <option value="">Seleccione un país</option>
              <option value="Argentina">Argentina</option>
              <option value="Bolivia">Bolivia</option>
              <option value="Chile">Chile</option>
              <option value="Colombia">Colombia</option>
              <option value="Costa Rica">Costa Rica</option>
              <option value="Cuba">Cuba</option>
              <option value="Ecuador">Ecuador</option>
              <option value="El Salvador">El Salvador</option>
              <option value="España">España</option>
              <option value="Guatemala">Guatemala</option>
              <option value="Honduras">Honduras</option>
              <option value="México">México</option>
              <option value="Nicaragua">Nicaragua</option>
              <option value="Panamá">Panamá</option>
              <option value="Paraguay">Paraguay</option>
              <option value="Perú">Perú</option>
              <option value="Puerto Rico">Puerto Rico</option>
              <option value="República Dominicana">República Dominicana</option>
              <option value="Uruguay">Uruguay</option>
              <option value="Venezuela">Venezuela</option>
            </select>
            {errores.pais && <span className="error-message">{errores.pais}</span>}
          </div>

          {/* Botones */}
          <div className="botones-container">
            <button type="submit" className="btn btn-guardar">
              Guardar
            </button>
            <button type="button" className="btn btn-limpiar" onClick={handleLimpiar}>
              Limpiar
            </button>
          </div>
        </form>
      </div>
    </div>
  );
}

export default Formulario;

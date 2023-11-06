import React, { useState } from 'react';
import './PantallaPrincipal.css';

function PantallaPrincipal() {
  const [isLoginView, setIsLoginView] = useState(true);


  const handleLogin = (event) => {
    event.preventDefault();
    console.log("Iniciar sesión");

  };

  const handleRegister = (event) => {
    event.preventDefault();
    console.log("Registrarse");

  };

  return (
    <div className="pantalla-principal">
      <header className="header-principal">
        <img src="logo-aula-virtual.jpg" alt="Logo" className="logo" />
        <h1 className="nombre-sitio">Aula Conectada</h1>
      </header>
      <div className="main-content">
        <div className="left-side">
          <div className="welcome-text">
            <h2>"Un nuevo concepto de educación."</h2>
          </div>
        </div>
        <div className="right-side">
          {isLoginView ? (
            <div className="login-form">
              <h2>Iniciar Sesión</h2>
              <form onSubmit={handleLogin}>
                <input type="text" placeholder="Email" required />
                <input type="password" placeholder="Contraseña" required />
                <button type="submit">Iniciar Sesión</button>
              </form>
              <button onClick={() => setIsLoginView(false)}>Ir a Registro</button>
            </div>
          ) : (
            <div className="register-form">
              <h2>Registrarse</h2>
              <form onSubmit={handleRegister}>
                <input type="email" placeholder="Email" required />
                <input type="password" placeholder="Contraseña" required />
                <button type="submit">Registrarse</button>
              </form>
              <button onClick={() => setIsLoginView(true)}>Ir a Iniciar Sesión</button>
            </div>
          )}
        </div>
      </div>
    </div>
  );
}

export default PantallaPrincipal;

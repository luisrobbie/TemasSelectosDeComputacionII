package com.clinic.clinic_psychology.dto;

public class PacienteRequest{
        private String nombre;
        private String apellidoPaterno;
        private String apellidoMaterno;
        private String telefono;
        private String correoElectronico;

        public String getNombre(){
            return nombre;
        }

        public void setNombre(String nombre){
            this.nombre = nombre;
        }

        public String getPrimerApellido(){
            return apellidoPaterno;
        }

        public void setPrimerApellido(String apellidoPaterno){
            this.apellidoPaterno=apellidoPaterno;
        }

        
        public String getSegundoApellido(){
            return apellidoMaterno;
        }

        public void setSegundoApellido(String apellidoMaterno){
            this.apellidoMaterno=apellidoMaterno;
        }

        public String getNumeroTelefono(){
            return telefono;
        }

        public void setNumeroTelefono(String telefono){
            this.telefono=telefono;
        }

        
        public String getCorreoElectronico(){
            return correoElectronico;
        }

        public void setCorreoElectronico(String correoElectronico){
            this.correoElectronico = correoElectronico;
        }
}
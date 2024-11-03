package registrodealumnos;

public class Alumno {
    
    String nombre;
    String carrera;
    int grupo;
    String semestre;
    int dni;
    double promedio;

    public Alumno() {
    }
    
    
    public Alumno(String nombre, String carrera, int grupo, String semestre, double promedio) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.grupo = grupo;
        this.semestre = semestre;
        this.promedio = promedio;
        this.dni=dni;
    }

    public Alumno(int dni) {
        this.dni = dni;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getGrupo() {
        return grupo;
    }

    public void setGrupo(int grupo) {
        this.grupo = grupo;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public double getPromedio() {
        return promedio;
    }

    public void setPromedio(double promedio) {
        this.promedio = promedio;
    }

    @Override
    public String toString() {
        return "Alumno{" + "nombre=" + nombre + ", carrera=" + carrera + ", grupo=" + grupo + ", semestre=" + semestre + ", dni=" + dni + ", promedio=" + promedio + '}';
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

         
}

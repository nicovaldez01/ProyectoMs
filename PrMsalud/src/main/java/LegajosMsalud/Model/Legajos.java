package LegajosMsalud.Model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name ="Legajos")

public class Legajos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Id automatico
    private Long id;
    private String apellido;
    private String nombre;
    private Long dni;
    private Long cuil;
    private LocalDate fechaAlta;

    private LocalDate fechaNac;
    @Transient
    private int antiguedad;
    @Transient
    private int edad;

    public Legajos() {
    }

    public Legajos(Long id, String apellido, String nombre, Long dni, Long cuil, LocalDate fechaAlta, LocalDate fechaNac,int antiguedad, int edad) {
        this.id = id;
        this.apellido = apellido;
        this.nombre = nombre;
        this.dni = dni;
        this.cuil = cuil;
        this.fechaAlta = fechaAlta;
        this.fechaNac = fechaNac;
        this.antiguedad = antiguedad;
        this.edad = edad;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public Long getCuil() {
        return cuil;
    }

    public void setCuil(Long cuil) {
        this.cuil = cuil;
    }

    public LocalDate getFechaNac(){
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac){
        this.fechaNac = fechaNac;
    }

    public int getEdad(){
        return Period.between(this.fechaNac,LocalDate.now()).getYears();
    }

    public void setEdad(){
        this.edad = edad;
    }

    public LocalDate getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(LocalDate fechaAlta) {
        this.fechaAlta = fechaAlta;
    }
    public int getAntiguedad() {
        return Period.between(this.fechaAlta, LocalDate.now()).getYears();
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }


}

package maquina.reflection.prueba.concepto.main;

public class Personaje {

    private String raza;
    private String habilidad;

    public String getRaza() {
	return raza;
    }

    public Personaje setRaza(String raza) {
	this.raza = raza;
	return this;
    }

    public String getHabilidad() {
	return habilidad;
    }

    public Personaje setHabilidad(String habilidad) {
	this.habilidad = habilidad;
	return this;
    }

    /**
     * Método privado con fines de testing se pone el supresswarning porque se
     * quiere si o si que sea privado para una prueba de concepto
     * 
     */
    @SuppressWarnings("unused")
    private void evolucionar() {
	raza = "razaCambiada";
    }

}

package maquina.reflection.prueba.concepto.main;

public class Personaje {

    private String raza;
    private String habilidad;

    public Personaje(String raza, String habilidad) {
	super();
	this.raza = raza;
	this.habilidad = habilidad;
    }

    public String getRaza() {
	return raza;
    }

    /**
     * Método privado con fines de testing se pone el supresswarning porque se
     * quiere si o si que sea privado para una prueba de concepto
     */
    @SuppressWarnings("unused")
    private void setRaza(String raza) {
	this.raza = raza;
    }

    public String getHabilidad() {
	return habilidad;
    }

    /**
     * Método privado con fines de testing se pone el supresswarning porque se
     * quiere si o si que sea privado para una prueba de concepto
     */
    @SuppressWarnings("unused")
    private void setHabilidad(String habilidad) {
	this.habilidad = habilidad;
    }

    /**
     * Método privado con fines de testing se pone el supresswarning porque se
     * quiere si o si que sea privado para una prueba de concepto
     */
    @SuppressWarnings("unused")
    private void evolucionar() {
	raza = "razaCambiada";
    }

}

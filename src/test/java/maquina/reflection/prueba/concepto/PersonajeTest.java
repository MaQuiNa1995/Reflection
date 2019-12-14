package maquina.reflection.prueba.concepto;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import maquina.reflection.prueba.concepto.main.Personaje;

/**
 * Test para prueba de concepto de testing a traves de reflection
 * 
 * Mas info <a href="https://stackoverflow.com/questions/11483647/how-do-i-access-private-methods-and-private-data-members-via-reflection/11484158#11484158">Aquí</a>
 */
public class PersonajeTest {

    private final String raza = "Moguri";
    private final String habilidad = "Espiral Mortal";

    private Personaje cut;

    @Before
    public void limpiarInicializarObjeto() {

	// Se inicializa un personaje y se le setean valores a traves de constructor ya
	// que hemos hecho los setter privados para una prueba de concepto
	cut = new Personaje(raza, habilidad);
    }

    /**
     * Caso de prueba en el que se accede a los setter privados de la clase {@link Personaje} - {@link Personaje#setRaza} y {@link Personaje#setHabilidad}
     */
    @Test
    public void reflectionMetodosTest() {

	try {
	    // Invocando al método privado
	    Method metodo = Personaje.class.getDeclaredMethod("evolucionar");

	    // Si se intenta acceder a pelo dará una
	    // Exception java.lang.IllegalAccessException
	    // m.invoke(d);

	    // Para que eso no pase necesitas hacerle accesible
	    metodo.setAccessible(true);

	    // verificamos que antes de invocar al método el objeto tiene lo que queremos y
	    // no se ha modificado
	    Assert.assertTrue(raza.equals(cut.getRaza()));

	    // y ahora ya no tienes que preocuparte de la excepcion
	    metodo.invoke(cut);

	    // Como hemos invocado al metodo la raza ha cambiado
	    Assert.assertTrue("razaCambiada".equals(cut.getRaza()));

	    // Si se captura alguna de estas excepciones el test tiene que fallar
	} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
		| InvocationTargetException exception) {
	    Assert.fail(exception.getMessage());
	}

    }

    @Test
    public void reflectionSetterTest() {

	try {

	    // Obtenemos todos los campos a traves del nombre tambien puedes recuperar un
	    // array con los campos pero es mas lío porque en principio no se sabe en que
	    // orden vienen y tendrías que debugear antes
	    Field atributoRaza = Personaje.class.getDeclaredField("raza");
	    Field atributoHabilidad = Personaje.class.getDeclaredField("habilidad");

	    // Si ahora seteamos algo nos da excepción
	    // atributoRaza.set(objetoClase,"valor");

	    // los tenemos que hacer accesible
	    atributoRaza.setAccessible(true);
	    atributoHabilidad.setAccessible(true);

	    String nuevaHabilidad = "100 Estoques";
	    String nuevaRaza = "Viera";
	    
	    // a traves de asserts verificamos el antes del cambio
	    Assert.assertTrue(raza.equals(cut.getRaza()));
	    Assert.assertTrue(habilidad.equals(cut.getHabilidad()));
	    
	    // Ahora podemos setear
	    atributoRaza.set(cut, nuevaRaza);
	    atributoHabilidad.set(cut, nuevaHabilidad);

	    // a traves de asserts verificamos el cambio
	    Assert.assertTrue(nuevaRaza.equals(cut.getRaza()));
	    Assert.assertTrue(nuevaHabilidad.equals(cut.getHabilidad()));

	    // Si se captura alguna de estas excepciones el test tiene que fallar
	} catch (SecurityException | IllegalArgumentException | NoSuchFieldException | IllegalAccessException exception) {
	    Assert.fail(exception.getMessage());
	}
    }

}

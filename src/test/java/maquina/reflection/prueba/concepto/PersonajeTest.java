package maquina.reflection.prueba.concepto;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Test;

import maquina.reflection.prueba.concepto.main.Personaje;

/**
 * Unit test for simple App.
 */
public class PersonajeTest {

    @Test
    public void reflectionTest() {

	// Se inicializa un personaje y se le setean valores
	Personaje personaje = new Personaje().setHabilidad("Espiral Mortal").setRaza("Moguri");

	try {
	    // Invocando al método privado
	    Method metodo = Personaje.class.getDeclaredMethod("evolucionar");

	    // Si se intenta acceder a pelo dará una
	    // Exception java.lang.IllegalAccessException
	    // m.invoke(d);

	    // Para que eso no pase necesitas hacerle accesible
	    metodo.setAccessible(true);

	    // y ahora ya no tienes que preocuparte de la excepcion
	    metodo.invoke(personaje);

	    // Como hemos invocado al
	    Assert.assertTrue("razaCambiada".equals(personaje.getRaza()));

	} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
		| InvocationTargetException exception) {
	    Assert.fail(exception.getMessage());
	}

    }

}

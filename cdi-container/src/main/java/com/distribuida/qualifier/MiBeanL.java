package com.distribuida.qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Qualifier;

@Qualifier //Indicamos que va ser un calificador
@Retention(RetentionPolicy.RUNTIME) //Tipo de retenci�n en tiempo de ejecuci�n
@Target({ ElementType.METHOD, ElementType.FIELD }) //Indicamos que puede ser aplicado sobre m�todos o variables de instancia
public @interface MiBeanL { //@interfaz para crear anotaci�n (qualifier)
	//Esta clase final nos sirve �nicamente si necesitamos hacer inyecci�n a trav�s de lookup, podemos borrarla si solo vamos a usar DI
	public static final class Literal extends AnnotationLiteral<MiBeanL> implements MiBeanL {

		private static final long serialVersionUID = 1L;
		public static final Literal INSTANCE = new Literal();
	}
}

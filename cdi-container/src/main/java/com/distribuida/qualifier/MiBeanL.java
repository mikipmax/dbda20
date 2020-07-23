package com.distribuida.qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.enterprise.util.AnnotationLiteral;
import javax.inject.Qualifier;

@Qualifier //Indicamos que va ser un calificador
@Retention(RetentionPolicy.RUNTIME) //Tipo de retención en tiempo de ejecución
@Target({ ElementType.METHOD, ElementType.FIELD }) //Indicamos que puede ser aplicado sobre métodos o variables de instancia
public @interface MiBeanL { //@interfaz para crear anotación (qualifier)
	//Esta clase final nos sirve únicamente si necesitamos hacer inyección a través de lookup, podemos borrarla si solo vamos a usar DI
	public static final class Literal extends AnnotationLiteral<MiBeanL> implements MiBeanL {

		private static final long serialVersionUID = 1L;
		public static final Literal INSTANCE = new Literal();
	}
}

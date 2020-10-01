package com.distribuida.utileria;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

public abstract class Mensajes {
	protected void mensajeInfo(String mensaje) {
		anadirMensaje(mensaje, FacesMessage.SEVERITY_INFO);
	}

	protected void mensajeError(String mensaje) {
		anadirMensaje(mensaje, FacesMessage.SEVERITY_ERROR);
	}

	private void anadirMensaje(String mensaje, Severity severity) {

		FacesMessage mensajeJSF = new FacesMessage();
		mensajeJSF.setSeverity(severity);
		mensajeJSF.setSummary(mensaje);
		FacesContext.getCurrentInstance().addMessage(null, mensajeJSF);
	}
}

package br.senai.sc.projeto.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.projeto.model.Regra;
import br.senai.sc.projeto.rn.RegraRN;

@FacesConverter(forClass=Regra.class, value="regraConverter")
public class RegraConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		long id = Long.parseLong(value);
		RegraRN regraRN = new RegraRN();
		return regraRN.buscarPorId(id);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		System.out.println("Teste");
		Regra regra = (Regra) value;
		System.out.println("Teste1");
		return String.valueOf(regra.getId());
	}

}

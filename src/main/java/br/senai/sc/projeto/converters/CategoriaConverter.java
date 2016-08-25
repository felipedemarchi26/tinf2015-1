package br.senai.sc.projeto.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.senai.sc.projeto.model.Categoria;
import br.senai.sc.projeto.rn.CategoriaRN;

@FacesConverter(forClass=Categoria.class)
public class CategoriaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, 
			UIComponent component, String value) {
		CategoriaRN categoriaRN = new CategoriaRN();
		long id = Long.parseLong(value);
		return categoriaRN.buscarPorId(id);
		
	}

	@Override
	public String getAsString(FacesContext context, 
			UIComponent component, Object value) {
		Categoria categoria = (Categoria) value;
		return String.valueOf(categoria.getId());
	
	}

}

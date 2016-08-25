package br.senai.sc.projeto.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.senai.sc.projeto.model.Categoria;
import br.senai.sc.projeto.rn.CategoriaRN;

@ManagedBean
@SessionScoped
public class CategoriaMB {

	private Categoria categoria;
	private CategoriaRN categoriaRN;
	private List<Categoria> categorias;
	
	@PostConstruct
	public void init() {
		categoria = new Categoria();
		categoriaRN = new CategoriaRN();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		if (categorias == null) {
			categorias = categoriaRN.listarCategorias();
		}
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	public String salvar() {
		categoriaRN.salvar(categoria);
		categoria = new Categoria();
		categorias = null;
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Categoria cadastrada com sucesso!", "");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return null;
	}
	
	public String listar() {
		return "listarCategorias";
	}
	
	public String editar() {
		return "cadastroCategoria";
	}
	
	public String excluir() {
		categoriaRN.excluir(categoria);
		categorias.remove(categoria);
		categoria = new Categoria();
		return null;
	}
	
	public String novo() {
		categoria = new Categoria();
		return "cadastroCategoria";
	}
	
	
}

package br.senai.sc.projeto.mb;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.senai.sc.projeto.model.Categoria;
import br.senai.sc.projeto.model.Produto;
import br.senai.sc.projeto.rn.CategoriaRN;
import br.senai.sc.projeto.rn.ProdutoRN;

@ManagedBean
@SessionScoped
public class ProdutoMB {

	private Produto produto;
	private ProdutoRN produtoRN;
	private CategoriaRN categoriaRN;
	
	@PostConstruct
	public void init() {
		produto = new Produto();
		produtoRN = new ProdutoRN();
		categoriaRN = new CategoriaRN();
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public String salvar() {
		produtoRN.salvar(produto);
		produto = new Produto();
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Produto cadastrado com sucesso", "");
		FacesContext.getCurrentInstance().addMessage(null, message);
		return null;
	}
	
	public List<Categoria> completeCategorias(String query) {
		return categoriaRN.listarParaAutoComplete(query);
	}
	
}

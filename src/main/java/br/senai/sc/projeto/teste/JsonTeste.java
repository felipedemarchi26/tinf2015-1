package br.senai.sc.projeto.teste;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import br.senai.sc.projeto.model.Categoria;

public class JsonTeste {

	public static void main(String[] args) {
		Categoria c1 = new Categoria();
		c1.setDescricao("Exemplo");
		c1.setId(1);
		Categoria c2 = new Categoria();
		c2.setDescricao("Outro Exemplo");
		c2.setId(2);
		List<Categoria> categorias = new ArrayList<Categoria>();
		categorias.add(c1);
		categorias.add(c2);
		Gson gson = new Gson();
		String s = gson.toJson(categorias);
		System.out.println(s);
	}
	
}

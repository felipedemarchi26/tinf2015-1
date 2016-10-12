package br.senai.sc.projeto.teste;

import br.senai.sc.projeto.commons.MailUtil;

public class TesteEmail {

	public static void main(String[] args) {
		String texto = "Boa Noite!\n\nEsta mensagem está sendo enviada pelo Java.\n\nAtenciosamente,\nJava";
		MailUtil.enviarEmail("felipe.demarchi@edu.sc.senai.br", "Exemplo de Aula", texto);
		System.out.println("Email enviado!");
	}
	
}

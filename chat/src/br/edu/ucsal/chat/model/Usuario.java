package br.edu.ucsal.chat.model;

import java.util.List;

public class Usuario implements Comparable<Usuario>{
	
	private String nome;
	private String cor;
	private List<Mensagem> mensagens;
	
	public Usuario() {
	}
	
	public Usuario(String nome, List<Mensagem> mensagens) {
		super();
		this.nome = nome;
		this.mensagens = mensagens;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCor() {
		return cor;
	}
	
	public void setCor(String cor) {
		this.cor = cor;
	}

	@Override
	public boolean equals(Object other) {
		return this.nome.equals(((Usuario) other).getNome());
	}

	@Override
	public int compareTo(Usuario other) {
		return this.getNome().compareToIgnoreCase(other.getNome());
	}
	
	@Override
	public int hashCode() {
		return nome.hashCode();
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.nome;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
	
}

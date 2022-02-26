//MARCOS V////////
/////////////////0 0
////////////////  -

package br.marcos.calculadora.model;

import javax.swing.JTextArea;

public class Pilha {

	public Numero[] pilha;
	public int posicaoPilha;

	public Pilha() {
		this.posicaoPilha = -1;
		this.pilha = new Numero[1000];
	}

	public boolean empty() {
		if (this.posicaoPilha == -1) {
			return true;
		}
		return false;
	}

	public int size() {
		if (this.empty()) {
			return 0;
		}
		return this.posicaoPilha + 1;
	}

	public Numero peek() {
		if (this.empty()) {
			return null;
		}
		return this.pilha[this.posicaoPilha];
	}

	public Numero pop() {
		if (empty()) {
			return null;
		}
		return this.pilha[this.posicaoPilha--];
	}

	public void push(Numero valor) {
		if (this.posicaoPilha < this.pilha.length - 1) {
			this.pilha[++posicaoPilha] = valor;
		}
	}

	public void clear() {
		while (!empty()) {
			posicaoPilha--;
		}
	}

	public static void imprimePilha(Pilha memoria, JTextArea painelG) {
		String guarda = "";
		Pilha mcp = new Pilha();

		while (!memoria.empty()) {
			mcp.push(memoria.pop());
		}
		while (!mcp.empty()) {
			guarda = guarda + "\n" + mcp.peek().texto();
			memoria.push(mcp.pop());
		}
		painelG.setText(guarda);
	}
}
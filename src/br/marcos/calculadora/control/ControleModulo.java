//MARCOS V////////
/////////////////0 0
////////////////  -

package br.marcos.calculadora.control;

import br.marcos.calculadora.model.Conta;
import br.marcos.calculadora.model.Numero;
import br.marcos.calculadora.model.Pilha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ControleModulo implements ActionListener {

	private int tam = 1;
	private String guarda = "";
	private final Pilha memoria;
	private JTextArea painelG;
	private JTextField painelP;
	private Numero numc;

	public ControleModulo(Pilha memoria, JTextField visorP, JTextArea visorG) {
		this.memoria = memoria;
		this.painelP = visorP;
		this.painelG = visorG;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		guarda = painelP.getText();
		tam = guarda.length();
		if (tam > 0) {
			ControleEntrada.pegaValor(memoria, painelP, painelG);
		}
		numc = Conta.modulo(memoria);
		if (numc != null) {
			painelP.setText("");
			Pilha.imprimePilha(memoria, painelG);
		}
	}
}
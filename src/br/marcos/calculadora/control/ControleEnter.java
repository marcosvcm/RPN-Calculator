//MARCOS V////////
/////////////////0 0
////////////////  -

package br.marcos.calculadora.control;

import br.marcos.calculadora.model.Pilha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ControleEnter implements ActionListener {

	private final Pilha memoria;
	private JTextArea painelG;
	private JTextField painelP;

	public ControleEnter(Pilha memoria, JTextField visorP, JTextArea visorG) {
		this.memoria = memoria;
		this.painelP = visorP;
		this.painelG = visorG;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ControleEntrada.pegaValor(memoria, painelP, painelG);
	}
}
//MARCOS V////////
/////////////////0 0
////////////////  -

package br.marcos.calculadora.control;

import br.marcos.calculadora.model.Pilha;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ControleDelMemoria2 implements ActionListener {

	String guarda = "";
	private JTextField painelP;
	private JTextArea painelG;
	private final Pilha memoria;

	public ControleDelMemoria2(Pilha memoria, JTextField visorP, JTextArea visorG) {
		this.painelP = visorP;
		this.painelG = visorG;
		this.memoria = memoria;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		guarda = painelP.getText();
		if (guarda.indexOf("Apagar") >= 0) {
			memoria.clear();
			painelG.setText("Memória apagada.");
			painelP.setText("");
		}
	}
}

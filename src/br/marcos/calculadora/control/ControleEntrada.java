//MARCOS V////////
/////////////////0 0
////////////////  -

package br.marcos.calculadora.control;

import br.marcos.calculadora.model.Numero;
import br.marcos.calculadora.model.Pilha;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ControleEntrada {

	public static boolean pegaValor(Pilha memoria, JTextField painelP, JTextArea painelG) {
		double carr1;
		int posc;
		String oper, parteReal, parteImg;

		oper = painelP.getText();
		if (oper.length() == 0) {
			oper = "ACDC";
		} else if (oper.indexOf("j") == oper.length() - 1 && oper.indexOf("j") != 0) {
			oper = oper.substring(0, oper.length() - 1);
			posc = oper.indexOf(" ");
			if (posc >= 0) {
				parteReal = oper.substring(0, posc);
			} else {
				parteReal = "0";
			}
			parteImg = oper.substring(posc + 1, oper.length());
			if (parteImg.charAt(0) != '+' && parteImg.charAt(0) != '-') {
				parteImg = "+" + parteImg;
			}
			try {
				memoria.push(new Numero(Double.parseDouble(parteReal), Double.parseDouble(parteImg)));
				Pilha.imprimePilha(memoria, painelG);
				painelP.setText("");
			} catch (NumberFormatException exc) {
				painelG.setText(painelG.getText() + "\nEntrada invalida 1.");
				painelP.setText("");
			}
		} else {
			try {
				carr1 = Double.parseDouble(oper);
				memoria.push(new Numero(carr1));
				Pilha.imprimePilha(memoria, painelG);
				painelP.setText("");
			} catch (NumberFormatException exc) {
				painelG.setText(painelG.getText() + "\nEntrada invalida 2.");
				painelP.setText("");
			}
		}
		return true;
	}
}
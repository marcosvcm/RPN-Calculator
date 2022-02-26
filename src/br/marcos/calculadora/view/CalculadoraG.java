//MARCOS V////////
/////////////////0 0
////////////////  -

package br.marcos.calculadora.view;

import br.marcos.calculadora.model.Numero;
import br.marcos.calculadora.model.Pilha;
import br.marcos.calculadora.control.ControleClear;
import br.marcos.calculadora.control.ControleDel;
import br.marcos.calculadora.control.ControleDelMemoria;
import br.marcos.calculadora.control.ControleDelMemoria2;
import br.marcos.calculadora.control.ControleDiv;
import br.marcos.calculadora.control.ControleEnter;
import br.marcos.calculadora.control.ControleExp;
import br.marcos.calculadora.control.ControleModulo;
import br.marcos.calculadora.control.ControleMult;
import br.marcos.calculadora.control.ControleNums;
import br.marcos.calculadora.control.ControleSoma;
import br.marcos.calculadora.control.ControleSub;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class CalculadoraG extends JFrame {
	private static final long serialVersionUID = 1L;

	Numero numc;
	double carr1;
	int opt = 0;
	int posc;
	String oper, parteReal, parteImg;
	Pilha memoria = new Pilha();

	private final JTextArea visorGrande = new JTextArea();
	private final JTextField visorPequeno = new JTextField();

	public CalculadoraG() {
		super("Calculadora");
		montaJanela();
	}

	private void montaJanela() {

		// Nome Calculadora
		JLabel painelNomeC = new JLabel("MARCOS - MV6");

		// Criando um painel com o visorGrande
		JPanel painelVisorGrande = new JPanel(new BorderLayout());
		painelVisorGrande.add(new JLabel("Memória:"), BorderLayout.WEST);
		visorGrande.setEnabled(false);
		visorGrande.setDisabledTextColor(Color.black);
		painelVisorGrande.add(new JScrollPane(visorGrande), BorderLayout.CENTER);
		visorGrande.setText("Olá.\n");

		// Criando um painel com o visorPequeno
		JPanel painelVPequeno = new JPanel(new BorderLayout());
		painelVPequeno.add(new JLabel("Entrada:"), BorderLayout.WEST);
		visorPequeno.setEnabled(false);
		painelVPequeno.add(visorPequeno, BorderLayout.CENTER);
		visorPequeno.setDisabledTextColor(Color.black);

		// Criando um painel que contem onome e os visores
		JPanel painelVisores = new JPanel(new BorderLayout());
		painelVisores.add(painelNomeC, BorderLayout.NORTH);
		painelVisores.add(painelVisorGrande, BorderLayout.CENTER);
		painelVisores.add(painelVPequeno, BorderLayout.SOUTH);

		// Criando um painel com os botões sob a lista
		JPanel painelBotoes = new JPanel(new GridLayout(4, 6));
		JButton botaoSoma = new JButton("+");
		JButton botaoSub = new JButton("-");
		JButton botaoMult = new JButton("*");
		JButton botaoDiv = new JButton("/");
		JButton botao0 = new JButton("0");
		JButton botao1 = new JButton("1");
		JButton botao2 = new JButton("2");
		JButton botao3 = new JButton("3");
		JButton botao4 = new JButton("4");
		JButton botao5 = new JButton("5");
		JButton botao6 = new JButton("6");
		JButton botao7 = new JButton("7");
		JButton botao8 = new JButton("8");
		JButton botao9 = new JButton("9");
		JButton botaoPonto = new JButton(".");
		JButton botaoEspaco = new JButton("Space");
		JButton botaoEnter = new JButton("Enter");
		JButton botaoJ = new JButton("j");
		JButton botaoExp = new JButton("x^y");
		JButton botaoModulo = new JButton("|x|");
		JButton botaoClear = new JButton("C");
		JButton botaoDel = new JButton("DEL");
		JButton botaoDelMem = new JButton("1Del M");
		JButton botaoDelMem2 = new JButton("2Del M");
		painelBotoes.add(botao7);
		painelBotoes.add(botao8);
		painelBotoes.add(botao9);
		painelBotoes.add(botaoClear);
		painelBotoes.add(botaoSoma);
		painelBotoes.add(botaoModulo);
		painelBotoes.add(botao4);
		painelBotoes.add(botao5);
		painelBotoes.add(botao6);
		painelBotoes.add(botaoDel);
		painelBotoes.add(botaoSub);
		painelBotoes.add(botaoExp);
		painelBotoes.add(botao1);
		painelBotoes.add(botao2);
		painelBotoes.add(botao3);
		painelBotoes.add(botaoJ);
		painelBotoes.add(botaoMult);
		painelBotoes.add(botaoDelMem);
		painelBotoes.add(botao0);
		painelBotoes.add(botaoPonto);
		painelBotoes.add(botaoEnter);
		painelBotoes.add(botaoEspaco);
		painelBotoes.add(botaoDiv);
		painelBotoes.add(botaoDelMem2);

		// Explicacao de entrada de complexos
		String textoExp = "Digite números complexos assim: 12.34 \"space\" 56.78j"
				+ "\nPara apagar a memória aperte \"1Del M\" + \"2Del M\"";
		JTextPane painelExplica = new JTextPane();
		painelExplica.setText(textoExp);
		painelExplica.setEnabled(false);
		painelExplica.setDisabledTextColor(Color.DARK_GRAY);

		// Criando painel com Botoes e expicações
		JPanel painelBE = new JPanel(new BorderLayout());
		painelBE.add(painelBotoes, BorderLayout.CENTER);
		painelBE.add(painelExplica, BorderLayout.SOUTH);

		// Criando um painel com tudo
		JSplitPane painelPrincipal = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, painelVisores, painelBE);
		painelPrincipal.setDividerLocation(200);
		this.setContentPane(painelPrincipal);
		this.setContentPane(painelPrincipal);

		// Configurando os listeners
		botao0.addActionListener(new ControleNums(visorPequeno, '0'));
		botao1.addActionListener(new ControleNums(visorPequeno, '1'));
		botao2.addActionListener(new ControleNums(visorPequeno, '2'));
		botao3.addActionListener(new ControleNums(visorPequeno, '3'));
		botao4.addActionListener(new ControleNums(visorPequeno, '4'));
		botao5.addActionListener(new ControleNums(visorPequeno, '5'));
		botao6.addActionListener(new ControleNums(visorPequeno, '6'));
		botao7.addActionListener(new ControleNums(visorPequeno, '7'));
		botao8.addActionListener(new ControleNums(visorPequeno, '8'));
		botao9.addActionListener(new ControleNums(visorPequeno, '9'));
		botaoPonto.addActionListener(new ControleNums(visorPequeno, '.'));
		botaoEspaco.addActionListener(new ControleNums(visorPequeno, ' '));
		botaoJ.addActionListener(new ControleNums(visorPequeno, 'j'));
		botaoSoma.addActionListener(new ControleSoma(memoria, visorPequeno, visorGrande));
		botaoSub.addActionListener(new ControleSub(memoria, visorPequeno, visorGrande));
		botaoMult.addActionListener(new ControleMult(memoria, visorPequeno, visorGrande));
		botaoDiv.addActionListener(new ControleDiv(memoria, visorPequeno, visorGrande));
		botaoModulo.addActionListener(new ControleModulo(memoria, visorPequeno, visorGrande));
		botaoExp.addActionListener(new ControleExp(memoria, visorPequeno, visorGrande));
		botaoEnter.addActionListener(new ControleEnter(memoria, visorPequeno, visorGrande));
		botaoDel.addActionListener(new ControleDel(visorPequeno));
		botaoClear.addActionListener(new ControleClear(visorPequeno));
		botaoDelMem.addActionListener(new ControleDelMemoria(visorPequeno));
		botaoDelMem2.addActionListener(new ControleDelMemoria2(memoria, visorPequeno, visorGrande));

		// Configuration a janela
		this.pack();
		this.setSize(450, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		CalculadoraG calculadora = new CalculadoraG();
		calculadora.setVisible(true);
	}
}

package Selecao_FIFA;
import java.util.ArrayList;

public class Main 
{
	static ArrayList<Jogador> jogadores;
	static ArrayList<Posicao> posicoes;
	
	public static void menu() 
	{
		System.out.println("---- MENU DA SELE��O DA FIFA ----");
		System.out.println("1 - Cadastrar Jogador na Sele��o:");
		System.out.println("2 - Pesquisar Jogador pelo Nome:");
		System.out.println("3 - Remover Jogador:");
		System.out.println("4 - Listar Jogadores Cadastrados:");
		System.out.println("5 - Cadastrar Posi��o:");
		System.out.println("6 - Pesquisar Posi��o Cadastrada:");
		System.out.println("7 - Remover Posi��o");
		System.out.println("8 - Adicionar Posi��o ao Jogador");
		System.out.println("9 - Pesquisar Jogador pela Posi��o");
		System.out.println("10 - SAIR:");
		System.out.println("\nDigite as op��es para Acessar o Menu:");
	}
	public static void menuPosicoes() 
	{
		System.out.println("---- MENU DE POSI��ES ----");
		System.out.println("---- Goleiro ----");
		System.out.println("---- Defensor ----");
		System.out.println("---- Meia ----");
		System.out.println("---- Atacante ----");
	}
	
	public static void main(String[] args) 
	{
		java.util.Scanner sc = new java.util.Scanner(System.in);
		jogadores = new ArrayList<Jogador>();
		posicoes = new ArrayList<Posicao>();
		Usuario usuario = new Usuario();
		Estatistica status = new Estatistica();
		System.out.println("Digite Seu Nome para Entrar:");
		String nomeUsuario = sc.nextLine();
		usuario.setNome(nomeUsuario);
		System.out.println("----Ol� "+ usuario.getNome() +", Bem Vindo!-----\n");
		int opcao;
		
		do {
		menu();
		opcao = sc.nextInt();
		
		if(opcao == 1) 
		{
			System.out.println("Digite o Nome do Jogador: ");
			String nomeJogador = sc.next();
			Jogador jogador = new Jogador();
			jogador.setNome(nomeJogador);
			jogadores.add(jogador);
			
			System.out.println("Digite a nacionalidade: ");
			String pais = sc.next();
			System.out.println("Digite o Time que Joga: ");
			String time = sc.next();
			
			System.out.println("Digite a quantidade de Jogos na temporada: ");
			int jogos = sc.nextInt();
			
			System.out.println("Digite a quantidade de Gols na temporada: ");
			int gols = sc.nextInt();
			
			System.out.println("Digite a quantidade de Assist�ncias na temporada ");
			int assist = sc.nextInt();
			
			jogador.setTime(time);
			jogador.setPais(pais);
			status.setJogos(jogos);
			status.setGols(gols);
			status.setAssistencias(assist);

			System.out.println("--- Jogador Cadastrado com Sucesso! ---");
			System.out.println("Jogador: " + jogador.getNome()+ "\n" + "Nacionalidade: " + jogador.getPais() + "\n" + "Time: " + jogador.getTime());
			System.out.println("Media: " + status.mediaGols() + "\n" + "Total de Participa��o em Gols: " + status.participacaoGols());
			
			
		}
		
		if(opcao == 2) 
		{
			System.out.println("Digite o Nome do Jogador que voc� quer pesquisar:");
			String nomeJogador = sc.next();
			Jogador jogador = null;
			for (int i = 0; i < jogadores.size(); i++) 
			{
				Jogador j = jogadores.get(i);
				if (j.getNome().equals(nomeJogador)) 
				{
					jogador = j;
					break;
				}
			}
			if (jogador == null) 
			{
				System.out.println("Jogador n�o encontrado!\n");
			} else 
			{
				System.out.println("Jogador encontrado: "+jogador.getNome()+"\n");
			}
		}
		
		if(opcao == 3) 
		{
			System.out.println("Digite o Jogador que ser� Removido:");
			String nomeJogador =  sc.next();
			Jogador jogador = null;
			for(int i = 0; i < jogadores.size(); i++) 
			{
				Jogador j = jogadores.get(i);
				if(j.getNome().equals(nomeJogador)) 
				{
					jogador = j;
					break;
					
				}
			}
			if(jogador == null) 
			{
				System.out.println("Jogador n�o encontrado!");
			} else 
			{
				System.out.println("Jogador Removido: "+jogador.getNome());
				jogadores.remove(jogador);
			}
		}
		
		if(opcao == 4) 
		{
			System.out.println("Jogadores Cadastrados:\n");
			if(jogadores.isEmpty()) 
			{
				System.out.println("Nenhum Jogador foi cadastrado!\n");
			}else {
				for(int i = 0; i < jogadores.size(); i++)
				{
					Jogador lista = jogadores.get(i);
					System.out.println(lista);
				}
			}
		}
		
		if(opcao == 5) 
		{
			menuPosicoes();
			System.out.println("Digite a Posi��o");
			String nomePosicao = sc.next();
			Posicao posicao = new Posicao();
			posicao.setNome(nomePosicao);
			posicoes.add(posicao);
			System.out.println("Posi��o Cadastrada com Sucesso!\n");
		}
		
		if(opcao == 6) 
		{
			System.out.println("Digite a posicao");
			String novaPosicao = sc.next();
			Posicao posicao = null;
			for (int i = 0; i < posicoes.size(); i++) 
			{
				Posicao p = posicoes.get(i);
				if (p.getNome().equals(novaPosicao)) 
				{
					posicao = p;
					break;
				}
			}
			if(posicao == null) {
				System.out.println("Posicao n�o cadastrada!");
			}
			else {
				System.out.println("Posi��o encontrada: " + posicao.getNome());
			}
		}
		
		if(opcao == 7) 
		{
			System.out.println("Digite a Posi��o que ser� Removida:");
			String nomePosicao =  sc.next();
			Posicao posicao = null;
			for(int i = 0; i < posicoes.size(); i++) 
			{
				Posicao p = posicoes.get(i);
				if(p.getNome().equals(nomePosicao)) 
				{
					posicao = p;
					break;
					
				}
			}
			if(posicao == null) 
			{
				System.out.println("Posi��o n�o encontrada!");
			} else 
			{
				System.out.println("Posi��o Removida: "+posicao.getNome());
				posicoes.remove(posicao);
			}
		}
		
		if(opcao == 8) 
		{	
			System.out.println("Digite nome do jogador a ser adicionado");
			String nomeJogador = sc.next();
			
			Posicao posicao = null;
			Jogador jogador = null;
			
			for(int i = 0 ; i < jogadores.size(); i++) 
			{
				Jogador j = jogadores.get(i);
				if(j.getNome().equals(nomeJogador)) 
				{
					jogador = j;
				}
			}
			if (jogador == null) 
			{
				System.out.println("Jogador n�o encontrado!\n");
			} else {
				System.out.println("Jogador encontrado: "+jogador.getNome());
				
				//Listar posicoes
				System.out.println("Posi��es Cadastradas:");
				for (int i = 0 ; i < posicoes.size(); i++) 
				{
					System.out.println(" " + i + " - "+posicoes.get(i).getNome());
				}
				// pedir para usuario digitar numero da posicao
				System.out.println("Digite o numero da posi��o:");
				int p = sc.nextInt();
				if(p == 0 || p == 1 || p == 2 || p == 3) 
				{
					posicao = posicoes.get(p);
					jogador.setPosicao(posicao);
					System.out.println("Jogador " + jogador.getNome() + " foi cadastrado na Posi��o "+ jogador.getPosicao() + " com Sucesso!\n");
				}else {
					System.out.println("Numero da Posi��o n�o encontrado!\n");
				}
			 }
		}
		
		if(opcao == 9) 
		{
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < jogadores.size(); ++i) 
			{
				Jogador j = jogadores.get(i);
				sb.append(j.getPosicao());
				sb.append(": ");
				sb.append(j.getNome());
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}
			
		} while(opcao != 10);{
			sc.close();
			System.exit(0);
		}
	}
}

package br.com.api.entidade;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MensagemJogoOnline {

	private int tipoAcao = 2;
	private int processamentoImediato = 1;
	private int destinatarioMensagem = 4;
	private int numElementos = 1;
	private int idSequencial = 1234;
	private int dispositivo = 5;
	private String hashString = "gdfgdfg4564ygfdfgfgsgsf";
	private ListadoMensagemBroadcast ListadoMensagemBroadcast =  new ListadoMensagemBroadcast();
	
	public int getTipoAcao() {
		return tipoAcao;
	}

	public void setTipoAcao(int tipoAcao) {
		this.tipoAcao = tipoAcao;
	}

	public int getProcessamentoImediato() {
		return processamentoImediato;
	}

	public void setProcessamentoImediato(int processamentoImediato) {
		this.processamentoImediato = processamentoImediato;
	}

	public int getDestinatarioMensagem() {
		return destinatarioMensagem;
	}

	public void setDestinatarioMensagem(int destinatarioMensagem) {
		this.destinatarioMensagem = destinatarioMensagem;
	}

	public int getNumElementos() {
		return numElementos;
	}

	public void setNumElementos(int numElementos) {
		this.numElementos = numElementos;
	}

	public int getIdSequencial() {
		return idSequencial;
	}

	public void setIdSequencial(int idSequencial) {
		this.idSequencial = idSequencial;
	}

	public int getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(int dispositivo) {
		this.dispositivo = dispositivo;
	}

	public String getHashString() {
		return hashString;
	}

	public void setHashString(String hashString) {
		this.hashString = hashString;
	}

	public ListadoMensagemBroadcast getListadoMensagemBroadcast() {
		return ListadoMensagemBroadcast;
	}

	public void setListadoMensagemBroadcast(
			ListadoMensagemBroadcast listadoMensagemBroadcast) {
		ListadoMensagemBroadcast = listadoMensagemBroadcast;
	}

	public static class ListadoMensagemBroadcast {
		
		private MensagemBroadcast MensagemBroadcast = new MensagemBroadcast();
		
		public MensagemBroadcast getMensagemBroadcast() {
			return MensagemBroadcast;
		}

		public void setMensagemBroadcast(MensagemBroadcast mensagemBroadcast) {
			MensagemBroadcast = mensagemBroadcast;
		}

		public static class MensagemBroadcast{
			
			private Mensagem mensagem = new Mensagem();
			
			public Mensagem getMensagem() {
				return mensagem;
			}

			public void setMensagem(Mensagem mensagem) {
				this.mensagem = mensagem;
			}

			public static class Mensagem{
				
				private Esquerda esquerda = new Esquerda();
				
				private Direita direita = new Direita();
				
				
				public Esquerda getEsquerda() {
					return esquerda;
				}

				public void setEsquerda(Esquerda esquerda) {
					this.esquerda = esquerda;
				}

				public Direita getDireita() {
					return direita;
				}

				public void setDireita(Direita direita) {
					this.direita = direita;
				}

				public static class Esquerda{
					
					private int equipe = 1;
					private String nomeEquipe = "1";
					
					public int getEquipe() {
						return equipe;
					}
					public void setEquipe(int equipe) {
						this.equipe = equipe;
					}
					public String getNomeEquipe() {
						return nomeEquipe;
					}
					public void setNomeEquipe(String nomeEquipe) {
						this.nomeEquipe = nomeEquipe;
					}
					
					
				}
				
				public static class Direita{
					
					private int equipe = 1;
					private String nomeEquipe = "1";
					public int getEquipe() {
						return equipe;
					}
					public void setEquipe(int equipe) {
						this.equipe = equipe;
					}
					public String getNomeEquipe() {
						return nomeEquipe;
					}
					public void setNomeEquipe(String nomeEquipe) {
						this.nomeEquipe = nomeEquipe;
					}
					
					
				}
			}
			
		}
		
	}
	

}
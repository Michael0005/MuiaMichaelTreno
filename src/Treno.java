
/**
 * 
 * <b>Classe treno</b>
 * <p>Array di oggetti</p>
 * <p>Dati in ingresso:</p>
 * <UL>
 * <LI>nome
 * <LI>destinazione
 * <LI>vagoni massimi
 * </UL>
 * @author User
 * versione  2
 */

public class Treno {
	/**
	 * nome= nome del treno
	 */
	private String nome, destinazione;
	private int vagoniMax;
	private Vagone[] vagoni; // 1° parte Array di oggetti
	
	/**
	 * 
	 * @param n
	 * @param d
	 * @param vMax
	 */

	public Treno(String n, String d, int vMax) {
		nome = n;
		destinazione = d;
		vagoniMax = vMax;
		vagoni = new Vagone[vagoniMax]; // 2° parte Array di oggetti
	}

	public String getNome() {
		return nome;
	}

	public String getDestinazione() {
		return destinazione;
	}

	public int getNumMaxVagoni() {
		return vagoniMax;
	}
	
	public void setNumMaxVagoni(int nMacVag) {
		vagoniMax=nMacVag;
	}

	public boolean addVagone(int pos, Vagone vag) {
		if (vagoni[pos] == null) {
			vagoni[pos] = vag;
			return true;
		}
		return false;
	}

	public boolean eliminaVagone(int pos) {
		if (vagoni[pos] != null) {
			vagoni[pos] = null;
			return true;
		}
		return false;
	}
	
	public int postiLiberi() {
		int posLiberi=0;
		for(int i=0; i<vagoniMax; i++) {
			if(vagoni[i]!=null)
				posLiberi+=vagoni[i].postiLiberi();
		}
		return posLiberi;
	}

	// aggiunta oggetto ad array vagoni
	@Override
	/**
	 * @return motodo che restituisce il treno completo
	 */
	public String toString() {
		String s = "Nome treno: " + nome + ", Destinazione: " + destinazione + ", Vagoni Max: " + vagoniMax+", Posti ancora liberi: "+ postiLiberi();
		for (int i = 0; i < vagoni.length; i++) {
			if (vagoni[i] != null)
				s += "\n" + "Vaone n." + i + " " + vagoni[i];
		}
		return s;
	}

	public static void main(String[] args) {
		Treno T1 = new Treno("Freccia Rossa", "Milano", 10);
		Vagone V1 = new Vagone("Prima-1", 30, 70);
		V1.setPostiOccupati(28);
		T1.addVagone(0, V1);
		Vagone V2 = new Vagone("Seconda-1", 20, 70);
		V2.setPostiOccupati(10);
		T1.addVagone(1, V2);
		Vagone V3 = new Vagone("Prima-2", 25, 65);
		V3.setPostiOccupati(5);
		T1.addVagone(1, V3);
		T1.eliminaVagone(2);
		System.out.println(T1);
	}

}

/**
 * <b>Classe Vagone</b>
 * <p>Dati in ingresso:</p>
 * <UL>
 * <LI>
 * @author User
 *
 */
public class Vagone {
	private String classe;
	private int postiDisponibili, postiOccupati, pesoM;

	public Vagone(String cl, int pD, int pesM) {
		classe = cl;
		postiDisponibili = pD;
		postiOccupati = 0;
		pesoM = pesM;
	}

	public boolean setPostiOccupati(int pO) {
		if (postiDisponibili > pO) {
			postiOccupati = pO;
			return true;
		}
		return false;
	}

	public void setPesoM(int pesM) {
		pesoM = pesM;
	}

	public String getClasse() {
		return classe;
	}

	public int getPostiDisponibili() {
		return postiDisponibili;
	}

	public int getPostiOccupati() {
		return postiOccupati;
	}

	public int getPesoM() {
		return pesoM;
	}

	public int pesoTotale() {
		return postiOccupati * pesoM;
	}

	public int postiLiberi() {
		return postiDisponibili - postiOccupati;
	}

	public String toString() {
		return "Classe=" + classe + ", Posti a Sedere=" + postiDisponibili + ", Posti occupati=" + postiOccupati
				+ ", Nella vagone ci sono=" + pesoTotale() + "kg" + " Restano ancora=" + postiLiberi()
				+ " posti liberi";
	}
	/**
	 * Metodo test di classe
	 * @param args
	 */
	public static void main(String[] args) {
		Vagone V1 = new Vagone("Prima", 30, 70);
		System.out.println(V1.toString());
	}

}

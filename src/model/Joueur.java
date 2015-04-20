public class Joueur {
	private Plateau p;

	public Joueur(Plateau p)
	{
		this.plateau = p;
	}

	public void poserPiece(EnumPiece type, Piece referent, int cote_du_referent)
	{
		Piece p;
		switch(type) {
			case EnumPiece.Abeille:
				p = new Abeille();
				break;
			default:
				break;
		}
		referent.setCote(p, cote_du_referent);
	}
}

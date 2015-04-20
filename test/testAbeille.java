public class testAbeille
{
	@Test
	public void testObtenirDeplacementPossible()
	{
		HashMap<Piece, Integer> result;
		HashMap<Piece, Integer> oracle = new HashMap<Piece, Integer>();
		Plateau p = new Plateau();
		Joueur j_a = new Joueur();
		Joueur j_b = new Joueur();
		j_a.poserPiece(EnumPieces.Abeille, null, null);
		oracle.add(p.getPieces().get(0), 2);
		oracle.add(p.getPieces().get(0), 6);
		j_b.poserPiece(EnumPieces.Abeille, p.getPieces().get(0), 1);
		result = j_a.getPiecesPosées().get(0).obtenirDeplacementsPossible()
		assertEquals(oracle, result);
	}

}

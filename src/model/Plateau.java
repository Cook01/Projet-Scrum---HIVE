package model;

import java.awt.*;
import java.util.ArrayList;

public class Plateau {
	private ArrayList<Piece> piece_pose;
	private int tour;
	private Joueur joueurQuiJoue, joueurBlanc, joueurNoir;
	private Piece pieceSelectionne;

	public Plateau(){
		piece_pose = new ArrayList<Piece>();
		tour = 1;
		joueurBlanc = new Joueur("Blanc");
		joueurNoir = new Joueur("Noir");
		joueurQuiJoue = joueurBlanc;
	}

	public void placer(Piece piece, Point point) {
		if(piece_pose.size()==0 && point.equals(new Point(0,0))) {
			piece_pose.add(piece);
			piece.setPosition(point);
		} else if ( piece_pose.size()>0 && this.estPlacementPossible(point)) {
			piece_pose.add(piece);
			piece.setPosition(point);
			this.setDependance(point, piece);
		}
	}

	private void setDependance(Point point, Piece piece) {
		ArrayListPoint pointTester = new ArrayListPoint();
		pointTester.setListe(piece.getVoisinNull());
		for(Piece chaquePiece : piece_pose) {
			if(pointTester.contient(chaquePiece.getPosition())) {
				chaquePiece.setVoisin(point, piece);
				piece.setVoisin(chaquePiece.getPosition(), chaquePiece);
			}
		}
	}

	private boolean estPlacementPossible(Point point) {
		return getPlacementPossible().contient(point);
	}

	public ArrayListPoint getPlacementPossible() {
		ArrayListPoint placementPossible = new ArrayListPoint();
		ArrayListPoint placementPossiblePieceUnitaire = new ArrayListPoint();

		if(tour==1) {
			for (Piece piece : piece_pose) {
				placementPossiblePieceUnitaire.setListe(piece.getVoisinNull());
				for (Point point_libre : placementPossiblePieceUnitaire) {
					if (!placementPossible.contient(point_libre)) {
						placementPossible.add(point_libre);
					}
				}
			}
			if(joueurQuiJoue==joueurBlanc) {
				placementPossible.add(new Point(0, 0));
			}
		} else {
			for (Piece piece : piece_pose) {
				if(piece.getJoueur()==joueurQuiJoue) {
					placementPossiblePieceUnitaire.setListe(piece.getVoisinNull());
					for (Point point_libre : placementPossiblePieceUnitaire) {
						if (!placementPossible.contient(point_libre)) {
							placementPossible.add(point_libre);
						}
					}
				}
			}
			for (Piece piece : piece_pose) {
				if(piece.getJoueur()!=joueurQuiJoue) {
					placementPossiblePieceUnitaire.setListe(piece.getVoisinNull());
					for (Point point_indisponible : placementPossiblePieceUnitaire) {
						if (placementPossible.contient(point_indisponible)) {
							placementPossible.retirer(point_indisponible);
						}
					}
				}
			}
		}
		return placementPossible;
	}

	public void jouer(Piece piece, Point point) {
		if(piece.getPosition() == null) placer(piece, point);
		else deplacer(piece, point);

		if(joueurQuiJoue==joueurBlanc) joueurQuiJoue = joueurNoir;
		else {
			joueurQuiJoue = joueurBlanc;
			tour++;
		}
	}

	private void deplacer(Piece piece, Point point) {
		if ( piece_pose.size()>0 && piece.getDeplacementPossible()!=null && piece.getDeplacementPossible().contient(point)) {
			casserDependance(piece, point);
			piece.setPosition(point);
			setDependance(point, piece);
		}
	}

	private void casserDependance(Piece piece, Point point) {
		for(Piece chaquePiece : piece_pose) {
			if(chaquePiece.getVoisinNull().contient(point)) {
				chaquePiece.retireVoisin(piece);
			}
		}
		piece.nettoyerVoisin();
	}

	public Joueur getJoueurBlanc() {
		return joueurBlanc;
	}

	public Joueur getJoueurNoir() {
		return joueurNoir;
	}

	public ArrayList<Piece> getPiece_pose() {
		return piece_pose;
	}

	public Piece getPiece(Point point) {
		Piece piece = null;
		for(Piece chaquePiece : piece_pose)
			if(chaquePiece.getPosition().equals(point))
				piece = chaquePiece;
		return piece;
	}

	public int getPositionPieceXMax() {
		if(piece_pose.size()!=0) {
			int max_x = piece_pose.get(0).getPosition().x;
			for(Piece piece : piece_pose)
				if(piece.getPosition().x > max_x)
					max_x = piece.getPosition().x;
			return max_x;
		} else return 0;
	}

	public int getPositionPieceYMax() {
		if(piece_pose.size()!=0) {
			int max_y = piece_pose.get(0).getPosition().y;
			for(Piece piece : piece_pose)
				if(piece.getPosition().y > max_y)
					max_y = piece.getPosition().y;
			return max_y;
		} else return 0;
	}

	public int getPositionPieceXMin() {
		if(piece_pose.size()!=0) {
			int min_x = piece_pose.get(0).getPosition().x;
			for (Piece piece : piece_pose)
				if (piece.getPosition().x < min_x)
					min_x = piece.getPosition().x;
			return min_x;
		} else return 0;
	}

	public int getPositionPieceYMin() {
		if(piece_pose.size()!=0) {
			int min_y = piece_pose.get(0).getPosition().y;
			for(Piece piece : piece_pose)
				if(piece.getPosition().y < min_y)
					min_y = piece.getPosition().y;
			return min_y;
		} else return 0;
	}

	public Joueur getJoueurQuiJoue() {
		return joueurQuiJoue;
	}

	public void setPieceSelectionne(Piece pieceSelectionne) {
		this.pieceSelectionne = pieceSelectionne;
	}

	public Piece getPieceSelectionne() {
		return pieceSelectionne;
	}
}

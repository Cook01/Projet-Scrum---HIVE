package model;

import model.typePiece.Abeille;
import model.typePiece.Scarabee;

import java.awt.*;
import java.util.ArrayList;

public class Plateau {
	private ArrayList<Piece> piece_pose;
	public int tour;
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
			if(piece instanceof Scarabee)
				((Scarabee) piece).setPosition(point, this);
			else
				piece.setPosition(point);
		} else if ( piece_pose.size()>0 && this.estPlacementPossible(point)) {
			piece_pose.add(piece);
			if(piece instanceof Scarabee)
				((Scarabee) piece).setPosition(point, this);
			else
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
			if(placementPossible.size()==0) {
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
			casserDependance(piece);
			if(piece instanceof Scarabee)
				((Scarabee) piece).setPosition(point, this);
			else
				piece.setPosition(point);
			setDependance(point, piece);
		}
	}

	private void casserDependance(Piece piece) {
		for(Piece chaquePiece : piece_pose) {
			chaquePiece.retireVoisin(piece);
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

	public Piece getPiece(Point point, Joueur j) {
		Piece a  = null;
		for(Piece chaquePiece : piece_pose) {
			if (point.equals(chaquePiece.getPosition()) && chaquePiece.getJoueur().equals(j)) {
				a = chaquePiece;
				while (a.getSky() != null)
					a = a.getSky();
				if (a.getJoueur() == j)
					return a;
			}
		}
		return null;
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

	public Joueur perdant() {
		Joueur perdant = null;
		for(Piece piece : piece_pose) {
			if(piece instanceof Abeille)
				if(piece.getVoisinNull().size()==0)
					if(perdant == null){
						perdant = piece.getJoueur();
					} else perdant = null;
		}
		return perdant;
	}

	public boolean egalite() {
		Joueur perdant = null;
		for(Piece piece : piece_pose) {
			if(piece instanceof Abeille)
				if(piece.getVoisinNull().size()==0)
					if(perdant == null){
						perdant = piece.getJoueur();
					} else return true;
		}
		return false;
	}

	public void reinitialiser() {
		piece_pose = new ArrayList<Piece>();
		tour = 1;
		joueurBlanc = new Joueur("Blanc");
		joueurNoir = new Joueur("Noir");
		joueurQuiJoue = joueurBlanc;
	}
}

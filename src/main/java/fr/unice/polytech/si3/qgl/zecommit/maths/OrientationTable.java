package fr.unice.polytech.si3.qgl.zecommit.maths;


import java.util.ArrayList;
import java.util.List;


/**
 * Classe qui génère les angles possibles pour tourner
 * @author Vincent
 */

public class OrientationTable {

    private ArrayList<Double> angleTable;
    private ArrayList<ArrayList<Compo>> compoTable;


    public OrientationTable(int oars) {
        this.angleTable = generateAngleTable(oars);
        this.compoTable = generateCompo(oars);
    }


    /**
     * Génére les orientations possibles en fonction du nombre de rames renseignées
     * @param oarsNb int le nombre de rame
     * @return arrayList de doubles correspondants aux angles possibles
     */
    ArrayList<Double> generateAngleTable(int oarsNb) {
        ArrayList<Double> myAngleTable = new ArrayList<>();

        double borneSup =  Math.PI/2;
        double borneInf = -borneSup;
        int efficentOars;

        // On prend un nombre pair de rame
        if (oarsNb % 2 != 0) {
            efficentOars = oarsNb+1;
        }
        else {
            efficentOars = oarsNb;
        }

        // Pas entre chaque angle
        double step = Math.PI/efficentOars;

        // borne inf de l'interval
        myAngleTable.add(borneInf);

        // On remplit les valeurs inf à 0
        for (int i = 1; i < (efficentOars/2) ; i++) {
            myAngleTable.add(borneInf + i*step);
        }
        // 0 au milieu de l'interval
        myAngleTable.add(0.0);

        // On remplit les valeurs sup à 0
        for (int i = 1; i < (efficentOars/2) ; i++) {
            myAngleTable.add(i*step);
        }

        // borne supp de l'interval
        myAngleTable.add(borneSup);

        return myAngleTable;
    }

    ArrayList<ArrayList<Compo>> generateCompo(int oarsNb) {
        ArrayList<ArrayList<Compo>> myCompoTable = new ArrayList<>();

        int oars;

        // On prend un nombre pair de rame
        if (oarsNb % 2 != 0) {
            oars = oarsNb+1;
        }
        else {
            oars = oarsNb;
        }

        // Compo pour Orientation negative
        for (int i = 0; i < (oars/2); i++) {
            myCompoTable.add(compoSpeBeforeZ(i, oars));
        }

        // Compo pour avancer tout droit
        myCompoTable.add(compoSpeForZ(oars));

        //Compo pour Orientation positive
        for (int i = (oars/2)-1; i >= 0; i--) {
            myCompoTable.add(compoSpeAfterZ(i, oars));
        }

        return myCompoTable;
    }

    /**
     * Fonction utilitaire pour generateFormation liste des compos pour un certain angle negatif
     * @param i int
     * @param oars un nombre de rame
     * @return la liste des compo
     */
    ArrayList<Compo> compoSpeBeforeZ(int i, int oars) {
        ArrayList<Compo> tempoTable = new ArrayList<>();
        int ecart = (oars/2)-i;

        for (int k = 0; k+ecart <= (oars/2); k++) {
            tempoTable.add(new Compo(k+ecart, k));
        }

        return tempoTable;
    }

    /**
     * Fonction utilitaire pour generateFormation liste des compos pour un certain angle positif
     * @param i int
     * @param oars nombre de rame
     * @return la liste des compo
     */
    ArrayList<Compo> compoSpeAfterZ(int i, int oars) {
        ArrayList<Compo> tempoTable = new ArrayList<>();
        int ecart = (oars/2)-i;

        for (int k = 0; k+ecart <= (oars/2); k++) {
            tempoTable.add(new Compo(k, k+ecart));
        }

        return tempoTable;
    }

    /**
     * Fonction utilitaire pour generateFormation liste des compos pour aller tout droit
     * @param oars nombre de rqme
     * @return une liste de compo
     */
    ArrayList<Compo>  compoSpeForZ(int oars) {
        ArrayList<Compo> tempoTable = new ArrayList<>();
        for (int i = 1; i <= (oars/2); i++) {
            tempoTable.add(new Compo(i,i));
        }
        return tempoTable;
    }

    public List<Double> getAngleTable() {
        return this.angleTable;
    }

    public List<ArrayList<Compo>> getFormationTable() {
        return compoTable;
    }

    public Compo getCompo(int indexAngle, int indexCompo) {
        if(compoTable.isEmpty() || compoTable.get(indexAngle).isEmpty())
            return new Compo(0,0);
        if(indexAngle == -1)
            indexAngle = 0;
        if(indexAngle == compoTable.size())
            indexAngle--;
        return compoTable.get(indexAngle).get(indexCompo);
    }

    public Compo getLastCompo(int indexAngle) {
        if(compoTable.isEmpty() || compoTable.get(indexAngle).isEmpty())
            return new Compo(0,0);
        if(indexAngle == -1)
            indexAngle = 0;
        if(indexAngle == compoTable.size())
            indexAngle--;
        return compoTable.get(indexAngle).get(compoTable.get(indexAngle).size()-1);
    }


    public Compo getGoodCompo(Compo compo, int nbSailorsRightShip, int nbSailorsLeftShip ){

        int nbSailorsRightCompo = compo.getSailorsRight();
        int nbSailorsLeftCompo = compo.getSailorsLeft();

        while(nbSailorsRightCompo>nbSailorsRightShip && nbSailorsRightCompo>=0 && nbSailorsLeftCompo>=0){

            if(nbSailorsRightCompo!=0)
                nbSailorsRightCompo--;

            if(nbSailorsLeftCompo!=0)
                nbSailorsLeftCompo--;
        }

        while(nbSailorsLeftCompo>nbSailorsLeftShip && nbSailorsRightCompo>=0 && nbSailorsLeftCompo>=0){

            if(nbSailorsRightCompo!=0)
                nbSailorsRightCompo--;

            if(nbSailorsLeftCompo!=0)
                nbSailorsLeftCompo--;
        }


        return new Compo(nbSailorsLeftCompo, nbSailorsRightCompo);
    }

    @Override
    public String toString() {
        return "OT{" +
                "aT=" + angleTable +
                ", cT=" + compoTable +
                '}';
    }
}

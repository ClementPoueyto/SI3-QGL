package fr.unice.polytech.si3.qgl.zecommit.boat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import fr.unice.polytech.si3.qgl.zecommit.Logs;
import fr.unice.polytech.si3.qgl.zecommit.action.Moving;
import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import fr.unice.polytech.si3.qgl.zecommit.deserializer.DeckDeserializer;
import fr.unice.polytech.si3.qgl.zecommit.entite.*;

import java.util.*;
import java.util.stream.Collectors;


/**
 * Classe correspondant au deck du bateau
 * @author Loic Bertolotto
 */
@JsonDeserialize(using = DeckDeserializer.class)
public class Deck{
    private int width;
    private int length;
    @JsonIgnore
    private List<Oar> oars;
    @JsonIgnore
    private Optional<Rudder> rudder;
    @JsonIgnore
    private Optional<Watch> watch;
    @JsonIgnore
    private List<Sail> sails;
    @JsonIgnore
    private List<Sailor> sailors;

    public Deck(int width, int length){

        this.width = width;
        this.length = length;
        this.oars = new ArrayList<>();
        this.sails = new ArrayList<>();
        this.sailors = new ArrayList<>();
        this.rudder = Optional.empty();
        this.watch = Optional.empty();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Deck deck = (Deck) o;
        return width == deck.width &&
                length == deck.length;
    }

    @Override
    public int hashCode() {
        return Objects.hash(width, length);
    }

    @JsonIgnore
    public void initDeck(List<Entity> entities){
        for (Entity entity : entities){
            if (entity.getType().equals(EntityType.oar)) {
                this.oars.add((Oar) entity);
            }
            if (entity.getType().equals(EntityType.rudder)) {
                this.rudder=Optional.of((Rudder)entity);
            }
            if (entity.getType().equals(EntityType.watch)) {
                this.watch = Optional.of((Watch)entity);
            }
            if (entity.getType().equals(EntityType.sail)) {
                this.sails.add((Sail) entity);
            }
        }
        sortOars();
    }
    @JsonIgnore
    public boolean sailorsAreOnTheirEntity() {
        for (Sailor sailor : sailors) {
            if (!sailor.isOnEntity() && sailor.hasEntity())
                return false;
        }
        return true;
    }

    /**
     * Déplace le sailor de la distance demandée. Si la distance dépasse 5 l'action
     * est annulée, ceci est pris en charge dans le constructeur de Moving
     *
     * @param sailor le marin à déplacer
     * @param xdistance le déplacement selon les x
     * @param ydistance le déplacement selon les y
     * @return l'action moving
     */
    @JsonIgnore
    public Moving moveSailor(Sailor sailor, int xdistance, int ydistance) {
        Moving action = new Moving(sailor.getId(), xdistance, ydistance);
        sailor.move(action.getXDistance(), action.getYDistance());
        if (action.getXDistance() != 0 || action.getYDistance() != 0) {
            Logs.add("\nS" + sailor.getId() + " is now on (" + sailor.getX() + "," + sailor.getY() + ")");
            return action;
        }
        return null;
    }

    /**
     *
     * @return la liste des rames à gauche du bateau.
     */
    @JsonIgnore
    public List<Oar> getLeftOars(){
        ArrayList<Oar> oarsList = new ArrayList<>();
        this.oars.forEach(oar->
        {
            if(isLeft(oar))
                oarsList.add(oar);
        });
        return oarsList;
    }

    /**
     *
     * @return la liste des rames à droite du bateau.
     */
    @JsonIgnore
    public List<Oar> getRightOars(){
        ArrayList<Oar> oarsList = new ArrayList<>();
        this.oars.forEach(oar->
        {
            if(!isLeft(oar))
                oarsList.add(oar);
        });
        return oarsList;
    }

    @JsonIgnore
    public List<Oar> getUsedOars(){
        return oars.stream().filter(oar -> oar.hasSailorOn() && oar.getSailorOn().isOnEntity()).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return  "width : "+this.width+
                " | height : "+this.length;
    }

    public boolean isLeft(Oar oar){
        return (oar.getY()<width/2);
    }

    public boolean isRight(Oar oar){
        return (oar.getY()>= ((width / 2) + (width % 2)));
    }


    public List<Sailor> rightSailors(){
        return getUsedOars().stream().filter(this::isRight)
        .map(Oar::getSailorOn).collect(Collectors.toList());
    }

    public List<Sailor> leftSailors(){
        return getUsedOars().stream().filter(this::isLeft)
        .map(Oar::getSailorOn).collect(Collectors.toList());
    }

    public void updateSails(List<Entity> entities){
        List<Sail> mySails = new ArrayList<>();
        for (Entity entity : entities) {
            if(entity.getType()==EntityType.sail)
                mySails.add((Sail)entity);
        }
        this.sails.forEach(sail -> {
            Sail same = sails.stream().filter(sail::equals).findAny().get();
            sail.setOpenned(same.isOpenned());
        });
    }

    private void sortOars(){
        List<Oar> tmpOars = new ArrayList<>(oars);
        List<Oar> sortOars = new ArrayList<>();
        boolean left = true;
        Optional<Oar> currentOar;
        while(!tmpOars.isEmpty()){
            if(left){
                currentOar = tmpOars.stream().filter(this::isLeft).min(Comparator.comparingInt(a -> a.distanceToNearestSailor(sailors)));
                left = false;
            } else {
                currentOar = tmpOars.stream().filter(this::isRight).min(Comparator.comparingInt(a -> a.distanceToNearestSailor(sailors)));
                left = true;
            }
            if(currentOar.isPresent()){
                sortOars.add(currentOar.get());
                tmpOars.remove(currentOar.get());
            }
        }
        oars = sortOars;
    }

    public boolean canUseRudder(){
        return rudder.isPresent() && rudder.get().hasSailorOn() && rudder.get().getSailorOn().isOnEntity();
    }
    //------------------------------GETTER-------------------------//

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    @JsonIgnore
    public Optional<Rudder> getRudder() {
        return rudder;
    }

    @JsonIgnore
    /*
      @return the watch
     */
    public Optional<Watch> getWatch() {
        return watch;
    }

    @JsonIgnore
    public List<Sailor> getSailors() {
        return sailors;
    }

    @JsonIgnore
    public List<Oar> getOars() {
        return oars;
    }

    @JsonIgnore
    public List<Sail> getSails() {
        return sails;
    }

    //------------------------------SETTER-------------------------//


    public void setWidth(int width) {
        this.width = width;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setSailors(List<Sailor> sailors) {
        this.sailors = sailors;
    }

    public void setOars(List<Oar> oars) {
        this.oars = oars;
    }

    public void setRudder(Rudder rudder) {
        this.rudder = Optional.of(rudder);
    }

    /**
     * @param watch the watch to set
     */
    public void setWatch(Optional<Watch> watch) {
        this.watch = watch;
    }

    public void setSails(List<Sail> sails) {
        this.sails = sails;
    }
}

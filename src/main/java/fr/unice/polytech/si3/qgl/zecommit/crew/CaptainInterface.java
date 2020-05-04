package fr.unice.polytech.si3.qgl.zecommit.crew;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;

/**
 * Interface du Captain
 */
public interface CaptainInterface {
    /**
     * Attribue les entités aux marins de manière optimisée
     */
    void attributeEntitiesToSailors();

    /**
     * Vérifie si des marins ne sont pas sur leur entité 
     * @return les marins à déplacer vers les entités auxquelles ils ont été associées, sinon liste vide
     */
    List<Sailor> doMoveSailors();

    /**
     * Calcul l'angle pour atteindre le prochain CP et choisit la compo de marins qui rament
     * @return la liste des marins qui doivent ramer
     */
    List<Sailor> doActivateOars();

    /**
     * Calcul l'angle à appliquer au gouvernail 
     * @return le marin au gouvernail associé à l'angle souhaité
     */
    SimpleEntry<Sailor, Double> doTurn();

    /**
     * Vérifie si il faut monter la voile
     * @return la liste de marins devant monter les voiles, sinon liste vide
     */
    List<Sailor> doLiftSail();

    /**
     * Vérifie si il faut baisser la voile
     * @return la liste de marins devant baisser les voiles, sinon liste vide
     */
    List<Sailor> doLowerSail();

    /**
     * Vérifie si on peut utiliser la vigie
     * @return le marin à la vigie si on active la vigie, sinon null
     */
    Sailor doUseWatch();

    /**
     * Vérifie si on à terminer la simulation
     * @return vrai si on veut continuer la simulation, faut sinon
     */
    boolean pursueGame();

}

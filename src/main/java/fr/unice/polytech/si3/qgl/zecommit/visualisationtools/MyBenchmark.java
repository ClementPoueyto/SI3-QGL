package fr.unice.polytech.si3.qgl.zecommit.visualisationtools;

import fr.unice.polytech.si3.qgl.zecommit.Cockpit;
import fr.unice.polytech.si3.qgl.zecommit.boat.Position;
import fr.unice.polytech.si3.qgl.zecommit.crew.Sailor;
import fr.unice.polytech.si3.qgl.zecommit.entite.Entity;
import fr.unice.polytech.si3.qgl.zecommit.visualisationtools.deckvizu.DeckVizu;
import fr.unice.polytech.si3.qgl.zecommit.visualisationtools.exception.CollisionException;
import fr.unice.polytech.si3.qgl.zecommit.visualisationtools.exception.UnfinishedException;
import fr.unice.polytech.si3.qgl.zecommit.visualisationtools.settings.*;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.profile.StackProfiler;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Benchmark)
//@Fork(value = 2, jvmArgs = {"-Xms2G", "-Xmx2G"})
@Fork()
@Warmup(iterations = 2)
@Measurement(iterations = 5)


public class MyBenchmark {

    public static List<List<Sailor>> SAILORS_VIZU;
    public static List<Entity> ENTITIES_VIZU;

    public static EngineSettingsInterface engineSettings09 = new EngineSettingsWeek9();
    public static EngineSettingsInterface engineSettings10 = new EngineSettingsWeek10();
    public static EngineSettingsInterface engineSettings11 = new EngineSettingsWeek11();
    public static EngineSettingsInterface engineSettings12 = new EngineSettingsWeek12();//A modifier pour changer la simulation

    private Engine engine;

    public static void main(String[] args) throws RunnerException {

        org.openjdk.jmh.runner.options.Options opt = new OptionsBuilder()
                .include(MyBenchmark.class.getSimpleName())
                .shouldDoGC(true)
                .resultFormat(ResultFormatType.JSON)
                .result(".result/result" + System.currentTimeMillis() +".JSON")

                .addProfiler(StackProfiler.class)
                .jvmArgsAppend("-Dmjh.stack.period=1")
                .forks(1)
                .build();

        new Runner(opt).run();

    }


    /**
     * WEEK10
     * @throws UnfinishedException
     * @throws CollisionException
     */
    @Benchmark
    public void engineTestTimeWeek10() throws UnfinishedException, CollisionException {
        List<Position> positions = new ArrayList<>();
        SAILORS_VIZU = new ArrayList<>();

        engineSettings10.initiateSettings();

        ENTITIES_VIZU = engineSettings10.getEntities();

        EngineCalcul engineCalcul =  new EngineCalcul(engineSettings10);
        String json = engineCalcul.thisToJson();
        EngineNextRound engineNextRound = new EngineNextRound();
        Cockpit cockpit = new Cockpit();
        cockpit.initGame(json);

        int currentStep = 0;
        int maxStep = 300;
        String output = "";
        while (!output.equals("[]") && currentStep < maxStep) {
            currentStep++;
            SAILORS_VIZU.add(engineSettings10.getSailors());
            String json2 = engineCalcul.thisToJson2();
            output = cockpit.nextRound(json2);

            try {
                engineCalcul.updateEngine(engineNextRound.getEngineNextRound(output));
            } catch (Exception e) {
                System.err.println(e.getMessage());//affiche une exception en cas de collision
                throw new CollisionException();// a commenter pour ne pas interrompre le code
            }
            Position position = engineSettings10.getShip().getPosition();
            positions.add(position);
            if(currentStep==maxStep) {
                throw new UnfinishedException();
            }
        }
    }

    /**
     * WEEK11
     * @throws UnfinishedException
     * @throws CollisionException
     */
    @Benchmark
    public void engineTestTimeWeek11() throws UnfinishedException, CollisionException {
        List<Position> positions = new ArrayList<>();
        SAILORS_VIZU = new ArrayList<>();

        engineSettings11.initiateSettings();

        ENTITIES_VIZU = engineSettings11.getEntities();

        EngineCalcul engineCalcul =  new EngineCalcul(engineSettings11);
        String json = engineCalcul.thisToJson();
        EngineNextRound engineNextRound = new EngineNextRound();
        Cockpit cockpit = new Cockpit();
        cockpit.initGame(json);

        int currentStep = 0;
        int maxStep = 300;
        String output = "";
        while (!output.equals("[]") && currentStep < maxStep) {
            currentStep++;
            SAILORS_VIZU.add(engineSettings11.getSailors());
            String json2 = engineCalcul.thisToJson2();
            output = cockpit.nextRound(json2);

            try {
                engineCalcul.updateEngine(engineNextRound.getEngineNextRound(output));
            } catch (Exception e) {
                System.err.println(e.getMessage());//affiche une exception en cas de collision
                throw new CollisionException();// a commenter pour ne pas interrompre le code
            }
            Position position = engineSettings11.getShip().getPosition();
            positions.add(position);
            if(currentStep==maxStep) {
                throw new UnfinishedException();
            }
        }
    }

    /**
     * WEEK12
     * @throws UnfinishedException
     * @throws CollisionException
     */
    @Benchmark
    public void engineTestTimeWeek12() throws UnfinishedException, CollisionException {
        List<Position> positions = new ArrayList<>();
        SAILORS_VIZU = new ArrayList<>();

        engineSettings12.initiateSettings();

        ENTITIES_VIZU = engineSettings12.getEntities();

        EngineCalcul engineCalcul =  new EngineCalcul(engineSettings12);
        String json = engineCalcul.thisToJson();
        EngineNextRound engineNextRound = new EngineNextRound();
        Cockpit cockpit = new Cockpit();
        cockpit.initGame(json);

        int currentStep = 0;
        int maxStep = 300;
        String output = "";
        while (!output.equals("[]") && currentStep < maxStep) {
            currentStep++;
            SAILORS_VIZU.add(engineSettings12.getSailors());
            String json2 = engineCalcul.thisToJson2();
            output = cockpit.nextRound(json2);

            try {
                engineCalcul.updateEngine(engineNextRound.getEngineNextRound(output));
            } catch (Exception e) {
                System.err.println(e.getMessage());//affiche une exception en cas de collision
                throw new CollisionException();// a commenter pour ne pas interrompre le code
            }
            Position position = engineSettings12.getShip().getPosition();
            positions.add(position);
            if(currentStep==maxStep) {
                throw new UnfinishedException();
            }
        }
    }
}

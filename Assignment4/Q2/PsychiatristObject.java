package Assignment4;

public class PsychiatristObject {

    public void examine(MoodyObject moodyObject){
        moodyObject.queryMood();
    }

    public void observe(MoodyObject moodyObject){
        moodyObject.expressFeelings();
        System.out.println("Observation: " + moodyObject.toString());
    }

}
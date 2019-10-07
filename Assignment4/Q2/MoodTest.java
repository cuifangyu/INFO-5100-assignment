package Assignment4;

public class MoodTest {

    public static void main(String[] args) {
        PsychiatristObject psy = new PsychiatristObject();
        MoodyObject ha = new HappyObject();
        MoodyObject sa = new SadObject();
        psy.examine(ha);
        psy.observe(ha);
        psy.examine(sa);
        psy.observe(sa);

    }
}

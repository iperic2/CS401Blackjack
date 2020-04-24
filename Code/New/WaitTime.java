import java.util.Timer;
import java.util.TimerTask;

public class WaitTime {

    private Timer timer;

    public WaitTime() {
        timer = new Timer();
        timer.schedule(new DisplayMessage(), 10000);
    }

    class DisplayMessage extends TimerTask {

        public void run() {
            System.out.println("Time up!");
            timer.cancel();
        }

    }

}

package org.gsit.bunnyrace;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BunnyRaceMain {



    public static void main(String[] args) throws IOException {
        List<RabbitRunnable> rabbits = new ArrayList<>();
        List<RabbitThread> rabbitThreads = new ArrayList<>();

        List<Integer> speeds = Arrays.asList(5, 10, 45, 40, 35);

        for (int i = 0; i < speeds.size(); i++) {
            RabbitRunnable rabbitRunnable =
                    new RabbitRunnable(i, speeds.get(i), rabbits);
            rabbits.add(rabbitRunnable);
            rabbitThreads.add(new RabbitThread(rabbitRunnable));
        }

        BunnyFrame frame = new BunnyFrame(rabbits);
        frame.showBunnies();

        for (RabbitThread rt : rabbitThreads) {
            rt.start();
        }
    }


}
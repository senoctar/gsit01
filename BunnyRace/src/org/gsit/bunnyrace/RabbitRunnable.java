package org.gsit.bunnyrace;

import java.util.List;

public class RabbitRunnable implements Runnable {

    private final int nr;
    private int distance;
    private int speed;
    private List<RabbitRunnable> rabbits;

    public RabbitRunnable(int nr, int speed, List<RabbitRunnable> rabbits) {
        this.nr = nr;
        this.speed = speed;
        this.rabbits = rabbits;
    }

    @Override
    public void run() {
        System.out.println("Rabbit " + nr + " is running");
        while (distance < 600) {
            try {
                Thread.sleep(50-speed);

                if (distance % 10 == 0) {
                    adjustSpeed();
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            distance++;
            System.out.println("Rabbit #" + nr + " is at " + distance);
        }
    }

    private void adjustSpeed() {
        int avgDistance = getAvgDistance();
        if (avgDistance > 100) {
            speed = Math.max(speed-(int)(Math.random()*5), 1);
        }
        if (avgDistance < -50) {
            speed = Math.min(speed+(int)(Math.random()*5), 49);
        }
    }

    private int getAvgDistance() {
        return (int) rabbits.stream()
                .filter(r -> r != this)
                .mapToInt(other -> distance - other.distance)
                .average()
                .orElse(0d);
    }

    public int getNr() {
        return nr;
    }

    public int getDistance() {
        return distance;
    }
}

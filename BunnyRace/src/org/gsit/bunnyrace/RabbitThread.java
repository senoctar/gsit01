package org.gsit.bunnyrace;

public class RabbitThread extends Thread {

    public RabbitThread(RabbitRunnable target) {
        super(target, "Rabbit #" + target.getNr());
    }
}

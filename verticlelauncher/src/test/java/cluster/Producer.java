package cluster;

import io.vertx.core.Vertx;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Producer {
    private Vertx vertx;

    public void setVertx(Vertx vertx) {
        this.vertx = vertx;
    }

    public static void main(String[] args) {
        ApplicationContext ctxt = new ClassPathXmlApplicationContext("testContext.xml");
        Producer p = (Producer) ctxt.getBean("producer");
        p.produce();
    }

    public void produce() {
        vertx.eventBus().send("consumer", "Hello world");
    }
}

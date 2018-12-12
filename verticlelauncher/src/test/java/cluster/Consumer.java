package cluster;

import io.vertx.core.Vertx;
import io.vertx.core.eventbus.Message;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Consumer {
    private Vertx vertx;
    private static ApplicationContext ctxt;

    public void setVertx(Vertx vertx) {
        this.vertx = vertx;
    }

    public static void main(String[] args) {
        ctxt = new ClassPathXmlApplicationContext("testContext.xml");
        Consumer c = (Consumer) ctxt.getBean("consumer");
        c.consume();
    }

    public void consume() {
        vertx.eventBus().consumer("consumer", (Message<String> s) -> {
            System.out.print(s.body());
            System.exit(0);
        });
    }
}

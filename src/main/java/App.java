import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        HelloWorld bean = applicationContext.getBean(
                "helloworld", HelloWorld.class
        );
        System.out.println(bean.getMessage());

        Cat catBean = applicationContext.getBean("cat", Cat.class);
        catBean.setName("Pojo");

        HelloWorld bean1 = applicationContext.getBean(
                "helloworld", HelloWorld.class
        );
        Cat catBean1 = applicationContext.getBean("cat", Cat.class);
        catBean1.setName("Pojo");

        System.out.println(bean == bean1);
        System.out.println(catBean == catBean1);

        ((AbstractApplicationContext)applicationContext).close();

    }
}
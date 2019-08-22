package by.bsac;


import by.bsac.persistence.PersistenceConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({PersistenceConfiguration.class})
public class Main implements CommandLineRunner {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    //Application context
    private static ApplicationContext ctx;


    public static void main(String[] args) {

        //Create spring CLI application
        LOGGER.debug("Create Spring boot application.");
        SpringApplication app = new SpringApplication(by.bsac.Main.class);

        //Disable banner and web type
        LOGGER.debug("Disable Spring boot banner.");
        app.setBannerMode(Banner.Mode.OFF);
        LOGGER.debug("Set Spring application type to command line application.");
        app.setWebApplicationType(WebApplicationType.NONE);

        //Run app
        LOGGER.debug("Call run() method");
        ctx = app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Start to execute run() method.");
    }
}

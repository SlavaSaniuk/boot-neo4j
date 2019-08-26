package by.bsac;


import by.bsac.models.nodes.CommentNode;
import by.bsac.models.nodes.PostNode;
import by.bsac.persistence.PersistenceConfiguration;
import by.bsac.repositories.PostNodeRepository;
import by.bsac.services.CommentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = {"by.bsac.services"})
@Import({PersistenceConfiguration.class})
@EnableTransactionManagement
@EnableNeo4jRepositories({"by.bsac.repositories"})
public class Main implements CommandLineRunner {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    //Application context
    private static ApplicationContext ctx;

    @SuppressWarnings("SpringJavaAutowiredFieldsWarningInspection")
    @Autowired @Qualifier("CommentsService")
    CommentsService service;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    PostNodeRepository repository;


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

        //Create post
        PostNode post = new PostNode();

        post.setPost_owner("Slava");
        post.setPost_text("Hello world!");

        //Create comments
        CommentNode comment1 = new CommentNode();
        comment1.setComment_text("Hello too.");
        comment1.setComment_owner("Andrey");

        CommentNode comment2 = new CommentNode();
        comment2.setComment_text("How are you?");
        comment2.setComment_owner("Dima");

        CommentNode comment3 = new CommentNode();
        comment3.setComment_text("Welcome to \"boot-neo4j\" project.");
        comment3.setComment_owner("Masha");

        //Commentate post
        CommentNode[] comments = {comment1, comment2, comment3};
        for (CommentNode comment : comments)  this.service.commentate(post, comment);


    }
}

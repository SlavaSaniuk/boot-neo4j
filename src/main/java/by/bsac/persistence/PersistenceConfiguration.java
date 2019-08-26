package by.bsac.persistence;

import org.neo4j.ogm.session.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersistenceConfiguration {

    //Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(PersistenceConfiguration.class);

    @Bean("sessionFactory")
    public SessionFactory getSessionFactory() {
        LOGGER.info("Create " +SessionFactory.class.getSimpleName() +" persistence bean.");
        return new SessionFactory(this.getNeo4jConfiguration(), "by.bsac.models.nodes");
    }

    @Bean
    public org.neo4j.ogm.config.Configuration getNeo4jConfiguration() {

        //Create neo4j configuration
        LOGGER.debug("Create java-based neo4j configuration bean.");
        org.neo4j.ogm.config.Configuration.Builder config = new org.neo4j.ogm.config.Configuration.Builder();

        //Set neo4j parameters
        config.credentials("neo4j", "12345678");
        config.uri("bolt://localhost");

        return config.build();
    }
}

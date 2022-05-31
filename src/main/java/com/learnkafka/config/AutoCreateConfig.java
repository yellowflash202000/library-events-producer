package com.learnkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

@Configuration      // this is because both the KafkaAdmin and NewTopic bean needs to be present inside the application context
@Profile("local")   // since, this type of configuration is not to be used in the production environment, therefore, we are limiting it only to the local environment
public class AutoCreateConfig {

    @Bean
    public NewTopic libraryEvent(){
        return TopicBuilder.name("library-events")
                .partitions(3)
                .replicas(3)
                .build();
    }

}

package com.microideation.app.analyze.es;

import com.microideation.app.dialogue.autoconfig.EnableDialogue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@EnableElasticsearchRepositories("com.microideation.app.analyze.es.repository")
@SpringBootApplication
@EnableDialogue
public class MiAnalyzeEsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiAnalyzeEsApplication.class, args);
	}
}

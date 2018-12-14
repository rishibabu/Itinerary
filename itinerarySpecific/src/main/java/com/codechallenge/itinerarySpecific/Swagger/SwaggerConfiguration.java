package com.codechallenge.itinerarySpecific.Swagger;

import static springfox.documentation.builders.PathSelectors.regex;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2; 


/**
 * Class Name : SwaggerConfiguration
 * Created By : Rishi Babu
 * Created On : 07/12/2018(dd/mm/yyyy)
 */

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.codechallenge.itinerarySpecific.Controller"))
				.paths(regex("/itinerary.*")).build().apiInfo(metaData());

	}

	private ApiInfo metaData() {
		ApiInfo apiInfo = new ApiInfo("Itinerary REST API", "Itinerary REST API", "1.0", "Terms of service",
				new Contact("Rishi Babu", "", ""), "Apache License Version",
				"https://www.apache.org/licenses/LICENSE-1.0");
		return apiInfo;
	}

}

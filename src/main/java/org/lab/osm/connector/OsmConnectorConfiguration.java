package org.lab.osm.connector;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.type.AnnotationMetadata;

import lombok.extern.slf4j.Slf4j;

/**
 * Spring configuration.
 * 
 * @author lab.cabrera@gmail.com
 * @since 1.0.0
 */
@Configuration
@Slf4j
public class OsmConnectorConfiguration implements ImportBeanDefinitionRegistrar {

	/* (non-Javadoc)
	 * @see org.springframework.context.annotation.ImportBeanDefinitionRegistrar#registerBeanDefinitions(org.springframework.core.type.AnnotationMetadata, org.springframework.beans.factory.support.BeanDefinitionRegistry)
	 */
	@Override
	public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
		AnnotationAttributes attributes = AnnotationAttributes
			.fromMap(importingClassMetadata.getAnnotationAttributes(EnableOsmConnector.class.getName(), false));
		String[] modelPackages = attributes.getStringArray("modelPackages");
		String[] procedurePackages = attributes.getStringArray("repositoryPackages");

		log.info("Starting metadata. Model packages {}, procedure packages: {}", modelPackages, procedurePackages);

		// TODO register beans (like JpaRepositoriesRegistrar)
	}

}

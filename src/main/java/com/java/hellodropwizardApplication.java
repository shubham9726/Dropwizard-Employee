package com.java;

/*
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.java.configuration.AppConfiguration;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vyarus.dropwizard.guice.GuiceBundle;

import javax.servlet.FilterRegistration;
*/

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.java.configuration.AppConfiguration;
import com.roskart.dropwizard.jaxws.JAXWSBundle;
import io.dropwizard.Application;
import io.dropwizard.server.DefaultServerFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vyarus.dropwizard.guice.GuiceBundle;
import ru.vyarus.dropwizard.guice.module.installer.feature.LifeCycleInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.ManagedInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.TaskInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.eager.EagerSingletonInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.health.HealthCheckInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.JerseyFeatureInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.ResourceInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.jersey.provider.JerseyProviderInstaller;
import ru.vyarus.dropwizard.guice.module.installer.feature.plugin.PluginInstaller;

import javax.servlet.FilterRegistration;

/*import com.java.resources.EmployeeResource;*/

public class hellodropwizardApplication extends Application<AppConfiguration> {
  private static final Logger logger = LoggerFactory.getLogger(hellodropwizardApplication.class);

  GuiceBundle<AppConfiguration> guiceBundle;
  private JAXWSBundle jaxwsBundle = new JAXWSBundle();
  public static void main(final String[] args) throws Exception {
    new hellodropwizardApplication().run(args);
  }

  @Override
  public String getName() {
    return "hellodropwizard";
  }

  @Override
  public void run(AppConfiguration appConfiguration, Environment environment) throws Exception {
    FilterRegistration.Dynamic dFilter = environment.servlets().addFilter("employee", CrossOriginFilter.class);

    environment.jersey().packages("service");
    /*environment.jersey().register(new AbstractBinder() {
      @Override
      protected void configure() {
        bind(EmployeeService.class).to(EmployeeServiceImpl.class);
        bind(EmployeeRepository.class).to(EmployeeRepositoryImpl.class);
      }
    });*/
    //  environment.jersey().disable();
  }


  public void initialize(final Bootstrap<AppConfiguration> bootstrap) {
    /*bootstrap.addBundle(GuiceBundle.builder()
      .enableAutoConfig(getClass().getPackage().getName())
      .build());*/
    /*bootstrap.addBundle(GuiceBundle.builder().enableAutoConfig("com.java")
      .build());*/

//      Module[] modules = autoDiscoverModules();
   // Module[] modules =

//    Module[] modules =new ApplicationConnector();

    /*bootstrap.addBundle(GuiceBundle.builder()
      .enableAutoConfig("ru.vyarus.dropwizard.guice.examples")
      // module is not required, but used here to show precise guice beans configuration
      .modules(new ApplicationConnector())
      .build());*/

    bootstrap.getObjectMapper().registerSubtypes(DefaultServerFactory.class);
//bootstrap.getObjectMapper().registerModule(new FCSerializerModule());
    bootstrap.getObjectMapper().enable(DeserializationFeature.READ_ENUMS_USING_TO_STRING);
    bootstrap.addBundle(jaxwsBundle);
    GuiceBundle.Builder builder = GuiceBundle.builder()
               .modules(new ApplicationConnector())
       .noDefaultInstallers()
      .installers(new Class[]{LifeCycleInstaller.class,
        ManagedInstaller.class,
        JerseyFeatureInstaller.class, ResourceInstaller.class,
        JerseyProviderInstaller.class,
        EagerSingletonInstaller.class,
        HealthCheckInstaller.class,
        TaskInstaller.class,
        PluginInstaller.class
      })
      .enableAutoConfig(ApplicationConnector.class.getPackage().getName());

    guiceBundle = builder.build();
    bootstrap.addBundle(guiceBundle);


  }

}
/*
  @Override
  public void run(AppConfiguration configuration, Environment environment) {
//    MongoClient mongoClient = new MongoClient(configuration.getMongoHost(), configuration.getMongoPort());
//    MongoManaged mongoManaged = new MongoManaged(mongoClient);
//    environment.lifecycle().manage(mongoManaged);
//    MongoDatabase db = mongoClient.getDatabase(configuration.getMongoDB());
//    MongoCollection<Document> collection = db.getCollection(configuration.getCollectionName());
    logger.info("Registering RESTful API resources");
//    final EmployeeService employeeService = new EmployeeService(collection);
    environment.jersey().register(new EmployeeResource(employeeService));
   */
/* environment.healthChecks().register("TemplateHealthCheck",
      new TemplateHealthCheck(mongoClient));*//*

  }
}*/

package com.harrychuang.demo.configuration;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConnectorConfig {

  private final int httpPort = 8080;

  @Value("${server.port}")
  private int httpsPort;

  @Bean
  public TomcatServletWebServerFactory servletContainer() {
    TomcatServletWebServerFactory tomcat =
        new TomcatServletWebServerFactory() {
          @Override
          protected void postProcessContext(Context context) {
            SecurityConstraint securityConstraint = new SecurityConstraint();
            securityConstraint.setUserConstraint("CONFIDENTIAL");
            SecurityCollection collection = new SecurityCollection();
            collection.addPattern("/*");
            securityConstraint.addCollection(collection);
            context.addConstraint(securityConstraint);
          }
        };
    tomcat.addAdditionalTomcatConnectors(getHttpConnector());
    return tomcat;
  }

  /**
   * Localhost is actually not trusted by your own machine's trust store. Since we have set the
   * server port to be 8443 and only accept HTTPS request, we cannot access this new localhost at
   * https://localhost:8443
   *
   * <p>Therefore, we are exposing the original localhost 8080 so that postman can access it. In the
   * log, you will see "Tomcat initialized with port(s): 8443 (https) 8080 (http)"
   */
  private Connector getHttpConnector() {
    Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
    connector.setScheme("http");
    connector.setPort(httpPort);
    connector.setSecure(false);
    connector.setRedirectPort(httpsPort);
    return connector;
  }
}

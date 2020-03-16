FROM jenkins/jenkins:2.204.5

USER root

# Install maven
ENV MAVEN_VERSION 3.6.3
RUN mkdir -p mkdir -p /opt/tools/ \
    && curl -fsSL http://downloads.apache.org/maven/maven-3/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.zip -o /opt/tools/apache-maven-${MAVEN_VERSION}-bin.zip  \
    && unzip /opt/tools/apache-maven-${MAVEN_VERSION}-bin.zip -d /opt/tools/ \
    && rm -rf /opt/tools/apache-maven-${MAVEN_VERSION}-bin.zip

USER jenkins

COPY init.groovy ${JENKINS_HOME}/init.groovy.d/

# skip SetupWizard
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

# Install plugins
COPY plugins.txt /usr/share/jenkins/ref/
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

VOLUME /var/jenkins_home

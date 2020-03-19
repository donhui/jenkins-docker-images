FROM jenkins/jenkins:2.204.5

COPY init.groovy ${JENKINS_HOME}/init.groovy.d/

# install plugins
COPY plugins.txt /usr/share/jenkins/ref/
RUN /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins.txt

# copy jenkins.yaml for Jenkins Configuration as Code Plugin
COPY jenkins.yaml ${JENKINS_HOME}

VOLUME /var/jenkins_home

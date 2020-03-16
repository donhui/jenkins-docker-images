#!groovy
import jenkins.model.*
import hudson.security.*

def instance = Jenkins.getInstance()

def desc = instance.getDescriptor("hudson.tasks.Maven")
def mavenInstallation =  new hudson.tasks.Maven.MavenInstallation("M3", "/opt/tools/apache-maven-3.6.3");
desc.setInstallations(mavenInstallation)
desc.save()

def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount('admin', '9YxwvCOUPML8onXF')
instance.setSecurityRealm(hudsonRealm)

def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false)
instance.setAuthorizationStrategy(strategy)

if (!instance.installState.isSetupComplete()) {
    println '--> Neutering SetupWizard'
    InstallState.INITIAL_SETUP_COMPLETED.initializeState()
}

instance.save()

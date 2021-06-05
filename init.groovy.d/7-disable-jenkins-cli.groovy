/*
 * Disable Jenkins CLI.
 * This init script for Jenkins fixes a zero day vulnerability.
 * http://jenkins-ci.org/content/mitigating-unauthenticated-remote-code-execution-0-day-jenkins-cli
 * https://github.com/jenkinsci-cert/SECURITY-218
 */
println "Disabling the Jenkins CLI..."

// disabled CLI access over TCP listener (separate port)
def p = jenkins.AgentProtocol.all()
p.each { x ->
    if (x.name?.contains("CLI")) {
        println "Removing protocol ${x.name}"
        p.remove(x)
    }
}

// disable CLI access over /cli URL
def removal = { lst ->
    lst.each { x ->
        if (x.getClass().name.contains("CLIAction")) {
            println "Removing extension ${x.getClass().name}"
            lst.remove(x)
        }
    }
}
def j = jenkins.model.Jenkins.instance
removal(j.getExtensionList(hudson.model.RootAction.class))
removal(j.actions)
println "CLI disabled"

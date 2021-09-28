FROM jenkins/jenkins:2.296-jdk11

USER root

# Install jq, make, docker, docker-compose and doo
RUN apt update && apt install -y jq make python3-pip wget && \
    \
    curl -sL https://download.docker.com/linux/static/edge/x86_64/docker-17.11.0-ce.tgz | tar zx && \
        mv /docker/* /bin/ && chmod +x /bin/docker* && \
    \
    pip3 install --upgrade pip && \
    pip3 install docker-compose==1.18.0 && \
    pip3 install ruamel.yaml==0.17.16 && \
    \
    curl -sSL https://raw.githubusercontent.com/thbkrkr/doo/7911779151a06d1e7172f0f18effe2ca2435d32a/doo \
        > /usr/local/bin/doo && chmod +x /usr/local/bin/doo

# Init groovy scripts
COPY init.groovy.d /usr/share/jenkins/ref/init.groovy.d

COPY docker-entrypoint.sh /docker-entrypoint.sh

RUN mkdir -p /usr/share/jenkins/keys

COPY git_ssh_private_key /usr/share/jenkins/keys

# Plugins
RUN /usr/local/bin/install-plugins.sh \
    workflow-aggregator:2.5 \
    workflow-multibranch:2.16 \
    pipeline-model-definition:1.8.4 \
    pipeline-stage-view:2.9 \
    pipeline-utility-steps:1.5.1 \
    docker-workflow:1.26 \
    github-branch-source:2.10.4 \
    ssh-agent:1.22 \
    mailer:1.34 \
    buildtriggerbadge:2.9 \
    git:4.7.2 \
    job-dsl:1.77 \
    ansicolor:1.0.0 \
    git-parameter:0.9.13


ENTRYPOINT ["/docker-entrypoint.sh"]

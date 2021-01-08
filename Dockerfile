FROM registry.redhat.io/ubi8:latest as builder

# Install required RPMs and ensure that the packages were installed
RUN yum --setopt=tsflags=nodocs install -y \
    # required RPMs for unpackaging jar files
    unzip tar rsync shadow-utils \
    # install java + maven
    java-11-openjdk-devel  maven


WORKDIR /approval-pam/src

COPY . .
RUN mvn package

FROM registry.redhat.io/rhpam-7/rhpam-kieserver-rhel8:7.8.0
COPY --from=builder /approval-pam/src/target/approval-1.0.0.jar /opt/eap/standalone/deployments/ROOT.war/WEB-INF/lib/

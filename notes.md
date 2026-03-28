# Lecture 03/25

## Build tools continued

Purpose of a build tool: consistent outcome from running source code

Cons of ANT:
- getting wrong dependency versions, relies too much local deployment, therefore not consistent across environments

**Maven**!!! Most common Java deployment platform as of now

## Maven

`pom.xml` used for build process, IDE usually just creates it yourself

Why devs shouldn't change it conflicting with each other? Dependency versions causes things to go wrong


Default locations for Maven project:
- /src/main/java/: source code
- /src/main/resources/: images, shell scripts, etc.
- /target/: compiled code
- /target/classes/: the result JAR file

Maven does not store .jar files of libraries. Sooooo does it need an internet connection? A closed network works too! But mostly yes.

Important life cycle states:
- default: main life cycle responsible for deployment (23 phases)
- clean: all class files (build files) are cleaned (3 phases)
- site: create project site's documentation

### Phases

Specifies order of goal execution, aka a sequence of goals
- **goal**: defines a specific task to build the project
- **plugins**: group of goals that are bounded together (ex. compiler, surefire, install, jar)
- formatted like `mvn plugin:goal`
- luckily, IDE handles most of this!

Typical phase (commands):
- prepare-resources
- validate
- compile
- test
- package
- install
- deploy

Always use `mvn clean install`

### Local and Remote Repositories

3 types of repos w/ Maven: central, remote, local

Remote is your organization repositories

For security reasons, central and remote is separate. Sensitive-ish data lives in the remote repo. External clients uses central.

Central repo is where we download the jar files (i.e. from Apache)

If no internet to Maven central repo, go to remote repo searches

**scp**: secure copy protocol (secure version of FTP) to send files via SSH

Why are we using build scripts? (i.e. tools like babel, maven, etc.) Sync changes across all imports

Need to automate a build to reduce number of steps, which is why workflow is important
- as project gets larger, number of tasks increases

## Gradle

Introduced in 2012. Prof does not like it :/ He's just lazy.

Downloading things so complex and annoying. Gradle allows us to write (structure) the actual build script.

Script that goes in and check if a file has been updated, etc. Build time is very fast! Significantly faster than Maven. 

Two concepts:
- task
- project

Every project has at least one or more task, i.e. command to do, like an Ant target. Written in file `build.gradle`

Gradle is for Kotlin or Groovy. I think it supports Java and C++ and javascript(??) too.

Pulls from local or Maven repository for dependencies

## Continuous Integration

Why? Code works separately but doesn't work together, make sure quality is good!

Tools: jenkins, github actions, ansible

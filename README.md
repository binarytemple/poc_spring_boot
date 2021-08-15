# poc_spring_boot

[![Java CI with Gradle](https://github.com/binarytemple/poc_spring_boot/actions/workflows/gradle.yml/badge.svg)](https://github.com/binarytemple/poc_spring_boot/actions/workflows/gradle.yml)

Messing about with Spring Boot and its HTTP server implementations.

## Local environment 

1. Install [asdf version manager](https://github.com/asdf-vm/asdf)
2. Execute `asdf plugin-add gradle` `asdf pluging-add java`
3. Execute `asdf install`
4. Execute `gradle tasks` to view available project tasks, the most relevant are build, bootJar and bootRun

## Container environment

1. [Install docker](https://docs.docker.com/get-docker/) or a docker compatible runtime such as [buildah](https://github.com/containers/buildah)
2. Execute `make build`

## CI

1. Refer to the contents of .github/workflows directory

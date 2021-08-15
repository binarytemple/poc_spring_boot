.PHONY: build

BUILD_ID := "UNDEFINED"

build:
	DOCKER_BUILDKIT=1 docker build .

BUILD_ID := "UNDEFINED"

build:
	docker build -e BUILD_ID=${{BUILD_ID}} .

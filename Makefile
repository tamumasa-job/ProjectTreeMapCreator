creator.createJar:
	cd project-tree-map-creator && sh ./gradlew shadowJar && cd ..
plantuml.docker.buildAndRun:
	docker build -t test-uml . && docker run -v $(shell pwd)/docs:/docs --rm test-uml
plantuml.docker.build:
	docker build -t test-uml .
plantuml.docker.run:
	docker run -v $(shell pwd)/docs:/docs --rm test-uml
plantuml.run:
	sh java -jar ./lib/plantuml/plantuml-1.2021.14.jar plantuml -o ../docs/uml
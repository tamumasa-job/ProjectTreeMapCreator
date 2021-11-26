creator.createJar:
	cd project-tree-map-creator && sh ./gradlew shadowJar && cd ..
plantuml.buildAndRun:
	docker build -t test-uml . && docker run -v $(shell pwd)/docs:/docs --rm test-uml
plantuml.build:
	docker build -t test-uml .
plantuml.run:
	docker run -v $(shell pwd)/docs:/docs --rm test-uml

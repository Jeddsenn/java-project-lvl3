run-dist:
	./build/install/app/bin/app
lint:
	./gradlew checkstyleMain checkstyleTest
build:
	./gradlew clean build
clean:
	./gradlew clean
install:
	./gradlew clean install
run:
	./gradlew run
test:
	./gradlew test
report:
	./gradlew jacocoTestReport
build-run: build run
.PHONY: build
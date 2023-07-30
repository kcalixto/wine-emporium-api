build:
	mvn -f WineFunction clean install
	sam build

deploy: 
	sam deploy
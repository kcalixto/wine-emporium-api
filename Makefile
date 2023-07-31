build:
	mvn -f WineFunction clean install
	sam build

deploy: 
	sam deploy --region sa-east-1
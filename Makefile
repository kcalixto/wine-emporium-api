build:
	mvn -f WineFunction clean install
	sam build --config-file samconfig.toml

deploy: 
	sam deploy --config-file samconfig.toml
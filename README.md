# fiap-abctechAPI
This project was created in order to learn about Microservices with Java + Springboot (Academic purpose FIAP)

- How to set up the project locally

1) Install Docker desktop following the step by step

https://docs.docker.com/get-docker/

2) Run the script below in order to install the MySql database using docker

`docker run --name abctechdev-mysql -e MYSQL_ROOT_PASSWORD=Fiap123 -p 3306:3306 -d mysql:latest`

3) Set all the environment variables in the IDE project's configuration:
- All Environment variables used in the project:

DB_PASSWORD=

DB_USER=

DB_HOST=

DB_PORT=

DB_NAME=

4) With everything set up you are ready to run the app locally!

PS: When running the app, it will create all the data DDL and DML direct into the database through the migration process (flywaydb)

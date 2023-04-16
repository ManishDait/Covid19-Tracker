# COVID-19 Tracker Webapp

This is a web application made using the Spring framework to track the spread of COVID-19 worldwide. The application uses real-time data from the [Given csv](https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv) and displays it in the form of tables. 

## Features

- Track the number of confirmed, recovered, and death cases of COVID-19 worldwide.
- View the latest statistics of COVID-19 cases for any country.

## Technologies Used

- Spring Boot
- Thymeleaf
- Bootstrap
- Docker

## Getting Started

### Prerequisites

- Java
- Maven
- Docker

### Building and Running with Docker

1. Clone this repository.
```
git clone https://github.com/ManishDait/Covid19-Tracker.git
```
2. Open the terminal and navigate to the root directory of the project.
```
cd Covid19-Tracker
```
3. Build the Docker image with the command:
 ```
 docker build -t covid-tracker .
 ```
4. Run the container with the command: 
```
docker run -p 8080:8080 covid-tracker
```
5. Open your web browser and go to `http://localhost:8080` to access the application.

### Building and Running without Docker

1. Clone this repository.
```
git clone https://github.com/ManishDait/Covid19-Tracker.git
```
2. Open the terminal and navigate to the root directory of the project.
```
cd Covid19-Tracker
```
3. Run the below command to build the project.
```
mvn clean install
```
4. Run the below command to start the application.
```
mvn spring-boot:run
```
5. Open your web browser and go to `http://localhost:8080` to access the application.



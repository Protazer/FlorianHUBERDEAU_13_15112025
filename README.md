# POC YourCarYourWay

![YOURCARYOURWAY image](Front/src/assets/images/your_car_your_way_banner.png)

## Required dependencies

- "@angular/animations": "^19.0.0",
- "@angular/common": "^19.0.0",
- "@angular/compiler": "^19.0.0",
- "@angular/core": "^19.0.0",
- "@angular/forms": "^19.0.0",
- "@angular/platform-browser": "^19.0.0",
- "@angular/platform-browser-dynamic": "^19.0.0",
- "@angular/router": "^19.0.0",
- "@stomp/stompjs": "^7.2.1",
- "rxjs": "~7.8.0",
- "sockjs-client": "^1.6.1",
- "tslib": "^2.3.0",
- "zone.js": "~0.15.0"

## Install and launch the Front-End :

[![forthebadge](https://forthebadge.com/images/badges/uses-html.svg)](https://forthebadge.com)
![SASS](https://img.shields.io/badge/SASS-hotpink.svg?style=for-the-badge&logo=SASS&logoColor=white)
[![forthebadge](https://forthebadge.com/images/badges/made-with-javascript.svg)](https://forthebadge.com)

1. Clone the repository:   
   `git clone https://github.com/Protazer/FlorianHUBERDEAU_13_15112025

2. move to front folder `cd front`
3. Install dependencies :   
   `npm install / yarn install`

4. Launch the Front-End on port 4200:   
   `npm start / yarn start`

5. The application is now available at this adress `http://localhost:4200`.

## Install and launch the Back-End :

[![forthebadge](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)](https://forthebadge.com)
[![forthebadge](https://img.shields.io/badge/Spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://forthebadge.com)

## Configuration

Create a `.env` file (in project root directory), containing variables according
to
`.env.schema`.

```
#API PORT
    TOMCATS_PORT=myPort

#DATABASE
    DATABASE_URL=myUrl
    DATABASE_NAME=myDatabaseName
    DATABASE_USERNAME=myDatabaseUsername
    DATABASE_PASSWORD=myDatabasePassword
```

Create a new database for your application and add all the tables to your
database:

```sql
DROP TABLE IF EXISTS public.message CASCADE;
DROP TABLE IF EXISTS public.session CASCADE;

CREATE TABLE public.session (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT,
    status VARCHAR(20),
    created_at TIMESTAMP,
    closed_at TIMESTAMP
);

CREATE TABLE public.message (
    id BIGSERIAL PRIMARY KEY,
    session_id BIGINT REFERENCES public.session(id),
    sender VARCHAR(20),
    content VARCHAR(255),
    sent_at TIMESTAMP
);

```

## Installation Procedure

1. move to back folder `cd back`
2. install dependencies with `mvn install` command.
3. Run the application using your IDE or by running `mvn spring-boot:run` in the
   project directory.






create database fahrschule;
use fahrschule;


Was sind Leerfahrten?

create table teachers (id int NOT NULL AUTO_INCREMENT, firstname VARCHAR(255) NOT NULL, 
lastname VARCHAR(255) NOT NULL, email VARCHAR(255) NOT NULL, PRIMARY KEY(id));

create table students (id int NOT NULL AUTO_INCREMENT,
firstname VARCHAR(255) NOT NULL, lastname VARCHAR(255) NOT NULL,
email VARCHAR(255) NOT NULL, teacher int NOT NULL, PRIMARY KEY(id),
FOREIGN KEY (teacher) REFERENCES teachers(id));

create table cars (id int NOT NULL AUTO_INCREMENT, driverId int DEFAULT -1, studentId int DEFAULT -1,
                    PRIMARY KEY (id), 
                    FOREIGN KEY (driverId) REFERENCES teachers(id),
                    FOREIGN KEY (studentId) REFERENCES students(id));         
                    
                    
                    
```
> find src/ -name '*.java' | xargs wc -l
```

922 total


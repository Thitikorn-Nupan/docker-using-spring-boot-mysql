CREATE DATABASE to_do_apps_docker;
USE to_do_apps_docker;

CREATE TABLE romances (
                          rid VARCHAR(3),
                          title VARCHAR(60),
                          price INT,
                          PRIMARY KEY(rid),
                          UNIQUE(title)
);


INSERT INTO romances VALUES('R01','Give me a love',450),('R02','Sweet dreams',400),('R03','Go together',390);

SELECT * FROM romances;
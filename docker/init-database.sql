CREATE DATABASE fitti_database;
CREATE USER 'fitti'@'localhost' IDENTIFIED BY 'fitti';
GRANT ALL PRIVILEGES ON *.* TO 'fitti'@'%' WITH GRANT OPTION;
# GRANT ALL PRIVILEGES ON *.* TO 'fitti'@'localhost' WITH GRANT OPTION;
FLUSH PRIVILEGES;

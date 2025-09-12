
# CRUD System dan Absensi 

project part 2 dari CRD system Tamantirto, di repo ini menambahkan beberapa fitur dan peenerapan Absensi dengan menampilkan jam check in dan check Out


## Features

- CRUD System
- Intergrasi dengan database
- Absensi Check In dan Check Out
- penggunaan UX yang simple



## Authors

- [Gilbrant Roychan Kholbi](https://github.com/GilbrantRoychan)


## Tech Stack

**Java** sebagai bahasa Pemrograman

**Maven** sebagai build automation tools

**MYSQL** sebagai implementasi database

**Junit API** sebagai framework testing

**HikariCP** sebagai implementasi Pool Connection 

**JDBC API** sebagai jembatan antara Driver dan DBMS


## Lessons Learned

project ini memberi tantangan seberapa paham mengenai CRUD System  dan bagaimana cara meng implementasi langsung ke database


## Installation

create table di database
```
CREATE TABLE `Profile` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `Nama` varchar(100) NOT NULL,
  `Tanggal_lahir` date NOT NULL,
  `Nomor_telepon` varchar(100) DEFAULT NULL,
  `Created_at` timestamp NULL DEFAULT NULL,
  `Updated_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB;


CREATE TABLE `absensi` (
  `Nomor` int(11) NOT NULL AUTO_INCREMENT,
  `ID_Profile` int(11) DEFAULT NULL,
  `masuk` timestamp NULL DEFAULT NULL,
  `keluar` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00',
  PRIMARY KEY (`Nomor`),
  KEY `fk_idProfile` (`ID_Profile`),
  CONSTRAINT `fk_idProfile` FOREIGN KEY (`ID_Profile`) REFERENCES `Profile` (`ID`)
) ENGINE=InnoDB;
```


Install dependency yang ada di maven
```
    mvn install
```

Running App.java


    
## Hope

Harapanya saya bisa terus berkembang dan bisa menjadi software developer,  Aameen


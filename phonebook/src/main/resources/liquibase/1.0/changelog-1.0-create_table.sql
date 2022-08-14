CREATE TABLE `abbtech.phonebook` (
                                     `ID` varchar(100) NOT NULL,
                                     `USER_NAME` varchar(45) NOT NULL,
                                     `PHONE_NUMBER` varchar(20) DEFAULT NULL,
                                     PRIMARY KEY (`ID`),
                                     UNIQUE KEY `PHONEBOOK_ID_uindex` (`ID`)
);



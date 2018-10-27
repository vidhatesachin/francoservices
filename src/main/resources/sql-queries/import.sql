   
CREATE DATABASE francodb;
use `francodb`;

CREATE TABLE `userrole` (
    `id` bigint(3) NOT NULL AUTO_INCREMENT,
    `role` varchar(45) NOT NULL,
    `description` varchar(100) DEFAULT NULL,
    `status` char(1) DEFAULT 'A',
    PRIMARY KEY (`id`)                                    
  ) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  `roleId` bigint(3) DEFAULT NULL, 
  `createdDateTime` datetime DEFAULT NULL,
  `imageIds` varchar(255) DEFAULT NULL,
  `status` char(1) DEFAULT 'A',
  PRIMARY KEY (`id`),                                                                  
  KEY `FK_userhasrole` (`roleId`),
  CONSTRAINT `userhasrole_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `Userrole` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


 
insert into `userrole` (`id`,`role`,`description`,`status`) values ( '1','Administrator','Administrator','A');
insert into `userrole` (`id`,`role`,`description`,`status`) values ( '2','BranchManager','BrandManager','A');
 
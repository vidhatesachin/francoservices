/*
SQLyog - Free MySQL GUI v5.14
Host - 5.6.10 : Database - francodb
*********************************************************************
Server version : 5.6.10
*/

SET NAMES utf8;

SET SQL_MODE='';

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `branch` */

CREATE TABLE `branch` (
  `branchcode` varchar(11) NOT NULL,
  `branchname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phonenumber` varchar(255) DEFAULT NULL,
  `branchadress` varchar(255) DEFAULT NULL,
  `id` bigint(255) NOT NULL,
  `status` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `branch` */

insert into `branch` (`branchcode`,`branchname`,`email`,`password`,`phonenumber`,`branchadress`,`id`,`status`) values ('a-1','abc','shirolrashmi23@gmail.com','1234','6327835681','xyz',1,'A'),('b-2','cde','vidhatesachin@gmail.com','5678','38192361948179','pqr',2,'A');

/*Table structure for table `user` */

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
  `branchid` bigint(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_userhasrole` (`roleId`),
  KEY `FK_user` (`branchid`),
  CONSTRAINT `userhasrole_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `userrole` (`id`),
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`branchid`) REFERENCES `branch` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert into `user` (`id`,`name`,`email`,`password`,`phonenumber`,`roleId`,`createdDateTime`,`imageIds`,`status`,`branchid`) values (1,'Sachin','vidhatesachin@gmail.com','password','9049472157',1,'2018-12-12 12:12:12',NULL,'A',NULL);

/*Table structure for table `userrole` */

CREATE TABLE `userrole` (
  `id` bigint(3) NOT NULL AUTO_INCREMENT,
  `role` varchar(45) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `status` char(1) DEFAULT 'A',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `userrole` */

insert into `userrole` (`id`,`role`,`description`,`status`) values (1,'Administrator','Administrator','A'),(2,'BranchManager','BrandManager','A');

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

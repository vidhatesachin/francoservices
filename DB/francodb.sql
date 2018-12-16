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
  `id` bigint(255) NOT NULL AUTO_INCREMENT,
  `status` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

/*Data for the table `branch` */

insert into `branch` (`branchcode`,`branchname`,`email`,`password`,`phonenumber`,`branchadress`,`id`,`status`) values ('v-1','vvvv','fgdhf@gmail.com','1234','53454565465','sdfsdfdsf',1,'I'),('b-2','cde','vidhatesachin@gmail.com','5678','38192361948179','pqr',2,'I'),('c-3','efg','efg@gmail.com','9123','27846472846648','rty',3,'I'),('d-4','hij','hij@gmail.com','3456','37826382731','rewt',4,'I'),('e-5','klm','klm@gmail.com','1245','242424234','eqweqwe',5,'I'),('fhdh','gjghj','khgkhjk',NULL,'jhkhjk','hjkjhgk',6,'I'),('fdgfg','ytuyu','uyiuku',NULL,'kjkmuj','fhgfhgj',7,'I'),('dfdgdfg','gdsfgdsfg','ddfdg',NULL,'sdfgfg','dfggg',8,'I'),('fdgdsg','sfdsfs','vidhatesachin@gmail.com',NULL,'234345354546','dfgfdgfdg',9,'I'),('dfdgdfg','fgfdgfd','vidhatesachin@gmail.com',NULL,'9158824299','hkhjkhjk',10,'I'),('bhhjkj','hlkjkjj','hfghfghgfj',NULL,'9158824299','jhgjghjkjhk',11,'I'),('sadad','fgfdgfd','vidhatesachin@gmail.com',NULL,'9158824299','fdhfghfgh',12,'I'),('nghnhgn','gnghnhn','vidhatesachin@gmail.com',NULL,'9158824299','hthtyhyhy',13,'I'),('dfdgdfg','gdsfgdsfg','yjghjhjh',NULL,'hhghgjgjgj','gjgjgjj',14,'I'),('dfdgdfg','okjkjljkl','rashmi.luckystar@gmail.com',NULL,'23243453546','khkhkhkh',15,'I'),('ddvfdgvfgf','fgfhbgh','rohitshirol2000@gmail.com',NULL,'32434354665','hghgjghjj',16,'I'),('BR-1','Laxmi road branch','vidhatesachin@gmail.com','123','9374356772','Laxmi road,Pune',17,'A'),('BR-2','Tilak road branch','pravin123@gmail.com','234','9856743921','Tilak road Pune',18,'A'),('BR-3','Pimpri branch','Nikhil123@gmail.com','234','9754682341','Pimpri,Pune',19,'A'),('BR-4','Chinchwad branch','praneet@gmail.com','323','9845672384','Chinchwad,Pune',20,'A'),('BR-5','SB Road branch','aruns@gmail.com','234','9674583672','SB Road Pune',21,'A'),('BR-6','Katraj branch','shishir12@gmail.com',NULL,'7896547329','Katraj,Pune',22,'A'),('BR-7','Baner branch','suresh144@gmail.com',NULL,'8764593562','Baner,Pune',23,'A'),('Br-8','FC road branch','ramesh684@gmail.com',NULL,'8957546783','FC road ,Pune',24,'A'),('BR-9','swargate branch','vivekg@gmail.com',NULL,'7974653786','swargate,Pune',25,'A'),('BR-10','Nigdi Branch','ng@gmail.com',NULL,'8765946723','Nigdi,Pune',26,'A');

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
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`branchid`) REFERENCES `branch` (`id`),
  CONSTRAINT `userhasrole_ibfk_1` FOREIGN KEY (`roleId`) REFERENCES `userrole` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert into `user` (`id`,`name`,`email`,`password`,`phonenumber`,`roleId`,`createdDateTime`,`imageIds`,`status`,`branchid`) values (1,'Sachin','vidhatesachin@gmail.com',NULL,'9049472157',1,'2018-12-15 14:19:45',NULL,'I',NULL),(2,NULL,'ghgjgj',NULL,'gjgjghg',NULL,'2018-12-11 11:30:32',NULL,'I',NULL),(3,NULL,'gjngnjghnj',NULL,'fgjjjghjhgj',NULL,'2018-12-11 11:30:57',NULL,'I',NULL),(4,NULL,'pqr',NULL,'21423434343',NULL,'2018-12-11 11:31:28',NULL,'I',NULL),(5,'rash','cbgvbgvgb',NULL,'gbvgbgb',NULL,'2018-12-11 11:32:05',NULL,'I',NULL),(6,'gff','fgfhfh',NULL,'dfghhgh',NULL,'2018-12-11 12:41:11',NULL,'I',NULL),(7,'jtyhjy','ythjtyujyuj',NULL,'yjuyjutjk',NULL,'2018-12-11 12:43:18',NULL,'I',NULL),(8,'hfgfj','fjhfjhj',NULL,'4535436456',NULL,'2018-12-12 15:19:32',NULL,'I',NULL),(9,'gfjnfghjnhn','gfhjfhjnghjn',NULL,'ghjygjhgju',NULL,'2018-12-11 15:18:01',NULL,'I',NULL),(10,'rash','r@gmail.com',NULL,'2423432435',NULL,'2018-12-12 15:20:09',NULL,'I',NULL),(11,'ghgngj','ghjghjh',NULL,'vc vbnbgbnbh',NULL,'2018-12-11 15:32:11',NULL,'I',NULL),(12,'ghfgh','rashmi.luckystar@gmail.com',NULL,'hgktjkhjk',NULL,'2018-12-11 15:37:52',NULL,'I',NULL),(13,'dfgdgghgh','rohitshirol2000@gmail.com',NULL,'9158824299',NULL,'2018-12-11 15:43:24',NULL,'I',NULL),(14,'sdfdsfdsf','a@b.com',NULL,'2324324344534',NULL,'2018-12-12 11:57:51',NULL,'I',NULL),(15,'Sachin','sachin12@gmail.com',NULL,'9863475543',NULL,'2018-12-16 19:25:02',NULL,'A',NULL),(16,'shihshir','shihshir@gmail.com',NULL,'9845677345',NULL,'2018-12-16 19:29:08',NULL,'A',NULL),(17,'Suresh','suresh144@gmail.com',NULL,'78456347934',NULL,'2018-12-16 19:30:11',NULL,'A',NULL),(18,'vivek','vivekg@gmail.com',NULL,'7846537892',NULL,'2018-12-16 19:30:49',NULL,'A',NULL),(19,'pravin','pravin123@gmail.com',NULL,'78645367213',NULL,'2018-12-16 19:31:11',NULL,'A',NULL),(20,'Mahesh','mahesh123@gmail.com',NULL,'7453875463',NULL,'2018-12-16 19:31:40',NULL,'A',NULL),(21,'Arun','aruns@gmail.com',NULL,'7894673547',NULL,'2018-12-16 19:33:49',NULL,'A',NULL);

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

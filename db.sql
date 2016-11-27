/*
SQLyog - Free MySQL GUI v5.19
Host - 5.0.15-nt : Database - att_db
*********************************************************************
Server version : 5.0.15-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `att_db`;

USE `att_db`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `m_admin` */

DROP TABLE IF EXISTS `m_admin`;

CREATE TABLE `m_admin` (
  `m_id` int(5) NOT NULL auto_increment,
  `m_admin` varchar(50) default NULL,
  `m_pass` varchar(50) default NULL,
  PRIMARY KEY  (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_admin` */

insert into `m_admin` (`m_id`,`m_admin`,`m_pass`) values (1,'admin','admin');

/*Table structure for table `m_msg` */

DROP TABLE IF EXISTS `m_msg`;

CREATE TABLE `m_msg` (
  `m_id` int(5) NOT NULL auto_increment,
  `m_from` varchar(50) default NULL,
  `m_to` varchar(50) default NULL,
  `m_sub` varchar(50) default NULL,
  `m_msg` varchar(50) default NULL,
  `m_date` datetime default NULL,
  `s_delete` int(11) default '0',
  `i_delete` int(11) default '0',
  PRIMARY KEY  (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_msg` */

insert into `m_msg` (`m_id`,`m_from`,`m_to`,`m_sub`,`m_msg`,`m_date`,`s_delete`,`i_delete`) values (1,'user','bsp','hi','hello','2013-01-18 11:05:51',0,0);
insert into `m_msg` (`m_id`,`m_from`,`m_to`,`m_sub`,`m_msg`,`m_date`,`s_delete`,`i_delete`) values (2,'user','sasi','hi','Hello,there','2013-03-02 12:41:42',0,0);
insert into `m_msg` (`m_id`,`m_from`,`m_to`,`m_sub`,`m_msg`,`m_date`,`s_delete`,`i_delete`) values (3,'kumar','user','Hello To aLL','Hello','2013-04-16 18:59:46',0,0);

/*Table structure for table `m_track` */

DROP TABLE IF EXISTS `m_track`;

CREATE TABLE `m_track` (
  `m_id` int(5) NOT NULL auto_increment,
  `m_user` varchar(50) default NULL,
  `m_ip` varchar(50) default NULL,
  `count` int(10) default NULL,
  `date` date default NULL,
  PRIMARY KEY  (`m_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_track` */

insert into `m_track` (`m_id`,`m_user`,`m_ip`,`count`,`date`) values (1,'user','127.0.0.1',4,'2013-02-22');
insert into `m_track` (`m_id`,`m_user`,`m_ip`,`count`,`date`) values (2,'sasi','192.168.1.4',2,'2013-03-02');
insert into `m_track` (`m_id`,`m_user`,`m_ip`,`count`,`date`) values (3,'kumar','127.0.0.1',1,'2013-04-10');
insert into `m_track` (`m_id`,`m_user`,`m_ip`,`count`,`date`) values (4,'kumar','192.168.1.16',1,'2013-04-10');

/*Table structure for table `m_user` */

DROP TABLE IF EXISTS `m_user`;

CREATE TABLE `m_user` (
  `u_id` int(10) NOT NULL auto_increment,
  `u_user` varchar(50) default NULL,
  `u_pass` varchar(50) default NULL,
  `u_name` varchar(50) default NULL,
  `u_city` varchar(50) default NULL,
  `u_state` varchar(50) default NULL,
  `u_email` varchar(50) default NULL,
  PRIMARY KEY  (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_user` */

insert into `m_user` (`u_id`,`u_user`,`u_pass`,`u_name`,`u_city`,`u_state`,`u_email`) values (53,'user','user','User','Bangalore','Karnataka','testmycvsprojects@gmail.com');
insert into `m_user` (`u_id`,`u_user`,`u_pass`,`u_name`,`u_city`,`u_state`,`u_email`) values (54,'sasi','sasi','ShasiKala','Bangalore','Karnataka','testmycvsprojects@gmail.com');
insert into `m_user` (`u_id`,`u_user`,`u_pass`,`u_name`,`u_city`,`u_state`,`u_email`) values (55,'kumar','kumar','Munna Kumar Singh','Bangalore','Karanatka','testmycvsprojects@gmail.com');

/*Table structure for table `table_fs` */

DROP TABLE IF EXISTS `table_fs`;

CREATE TABLE `table_fs` (
  `id` int(10) NOT NULL auto_increment,
  `ip_address` varchar(100) NOT NULL,
  `username` varchar(150) NOT NULL,
  `failed_attempt` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `table_fs` */

insert into `table_fs` (`id`,`ip_address`,`username`,`failed_attempt`) values (1,'127.0.0.1','kumar',5);

/*Table structure for table `table_ft` */

DROP TABLE IF EXISTS `table_ft`;

CREATE TABLE `table_ft` (
  `id` int(10) NOT NULL auto_increment,
  `username` varchar(150) NOT NULL,
  `failed_attempt` int(10) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `table_ft` */

insert into `table_ft` (`id`,`username`,`failed_attempt`) values (1,'kumar',3);

/*Table structure for table `table_w` */

DROP TABLE IF EXISTS `table_w`;

CREATE TABLE `table_w` (
  `id` int(10) NOT NULL auto_increment,
  `ip_address` varchar(100) NOT NULL,
  `username` varchar(200) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `table_w` */

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

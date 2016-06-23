--liquibase formatted sql

--changeset jeric:1
--comment: create user table
CREATE TABLE `user` (
	`id` bigint(20) NOT NULL AUTO_INCREMENT,
	`username` varchar(45) NOT NULL,
	`password_hash` varchar(100) NOT NULL,
	`email` varchar(45) NOT NULL,
	`given_name` varchar(45) NOT NULL,
	`last_name` varchar(45) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--changeset jeric:2
--comment: user dump
INSERT INTO `user` VALUES
	(1,'admin','$2a$10$3SWajhRszyFVQoD/xx4upemwTg4Yjwl.z2Yf7dgDP.Gh3Uxw98fAq','jeric@jericbryledy.com','Jeric Bryle','Dy');


--changeset jeric:3
--comment: create role table
CREATE TABLE `role` (
	`id` int(11) NOT NULL AUTO_INCREMENT,
	`label` varchar(45) NOT NULL,
	PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--changeset jeric:4
--comment: role dump
INSERT INTO `role` VALUES
	(1,'ROLE_ADMIN'),
	(2,'ROLE_USER');


--changeset jeric:5
--comment: create user role table
CREATE TABLE `user_role` (
	`user_id` bigint(20) NOT NULL,
	`role_id` int(11) NOT NULL,
	PRIMARY KEY (`user_id`,`role_id`),
	KEY `fk_user_role__role_idx` (`role_id`),
	CONSTRAINT `fk_user_role__role` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
	CONSTRAINT `fk_user_role__user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--changeset jeric:6
--comment: user roles dump
INSERT INTO `user_role` VALUES
	(1,1);


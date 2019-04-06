CREATE TABLE `account`
(
  `userName` varchar(255) UNIQUE PRIMARY KEY NOT NULL,
  `pwd` varchar(255) NOT NULL
);

CREATE TABLE `note`
(
  `noteID` int PRIMARY KEY NOT NULL AUTO_INCREMENT,
  `title` varchar(255),
  `content` varchar(255),
  `date` varchar(255),
  `userName` varchar(255) NOT NULL
);

ALTER TABLE `note` ADD FOREIGN KEY (`date`) REFERENCES `account` (`userName`);

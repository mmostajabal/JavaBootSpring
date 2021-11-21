-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 21, 2021 at 09:25 AM
-- Server version: 10.1.38-MariaDB
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `furgefuge`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `findActivitesOnName` (IN `activityname` VARCHAR(100) CHARSET utf8mb4)  NO SQL
SELECT * from `activites`  where `activites`.`name` LIKE CONCAT('%', activityname , '%')$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findGardenOnName` (IN `gardenname` VARCHAR(100) CHARSET utf8mb4)  NO SQL
SELECT * from `garden` where `garden`.`name` like CONCAT('%', gardenname, '%')$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findopenWorks` (IN `usercodeIn` INT(11))  NO SQL
select `openwork`.*, `users`.`firstname`, `users`.`lastname`, `garden`.`name`
from `openwork`INNER JOIN `users` on `openwork`.`usercode` = `users`.`userid` 
left JOIN `garden` ON `openwork`.`gardencode` = `garden`.`gardencode`
WHERE `openwork`.`usercode` = usercodeIn$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `finduserbyidentitycard` (IN `identitycardIn` VARCHAR(20) CHARSET utf8mb4)  NO SQL
select * from `users` WHERE `users`.`identitycard` = identitycardIn$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `findusersonname` (IN `firstnamein` VARCHAR(100) CHARSET utf8mb4, IN `lastnamein` VARCHAR(100) CHARSET utf8mb4)  NO SQL
select * from `users` where `users`.`firstname`like Concat('%', firstnamein, '%') or `users`.`lastname` like Concat('%', lastnamein, '%')$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `userInsert` (IN `userIdIn` INT(11), IN `IdentityCardIn` VARCHAR(20), IN `firstNameIn` VARCHAR(30), IN `lastNameIn` VARCHAR(30), IN `emailIn` VARCHAR(50), IN `phoneNumberIn` VARCHAR(13), IN `hourlyWagesIn` DOUBLE, IN `passwordIn` VARCHAR(30), IN `genderIn` VARCHAR(10), IN `UserTypeIn` VARCHAR(9), IN `companyCodeIn` INT(11), IN `isActiveIn` BOOLEAN, IN `dateOfLastChangesIn` DATE, IN `modifierCodeIn` INT(11))  NO SQL
INSERT INTO `users`(`users`.`userId`, `users`.`IdentityCard`, `users`.`firstName`, `users`.`lastName`, `users`.`email`, `users`.`phoneNumber`, `users`.`hourlyWages`, `users`.`password`, `users`.`gender`, `users`.`UserType`, `users`.`companyCode`, `users`.`isActive`, `users`.`dateOfLastChanges`, `users`.`modifierCode`) VALUES (userIdIn, IdentityCardIn, firstNameIn, lastNameIn, emailIn, phoneNumberIn, hourlyWagesIn, passwordIn, genderIn, UserTypeIn, companyCodeIn, isActiveIn, dateOfLastChangesIn, modifierCodeIn)$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `userSelect` ()  NO SQL
SELECT * FROM users$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `userUpdate` (IN `IdentityCardIn` VARCHAR(20), IN `firstNameIn` VARCHAR(30), IN `lastNameIn` VARCHAR(30), IN `emailIn` VARCHAR(50), IN `phoneNumberIn` VARCHAR(13), IN `hourlyWagesIn` DOUBLE, IN `passwordIn` VARCHAR(30), IN `genderIn` VARCHAR(10), IN `UserTypeIn` VARCHAR(9), IN `companyCodeIn` INT(11), IN `isActiveIn` BOOLEAN, IN `dateOfLastChangesIn` DATE, IN `modifierCodeIn` INT(11), IN `userIdIn` INT(11))  NO SQL
UPDATE `users` set `users`.`IdentityCard` = IdentityCardIn, `users`.`firstName` = firstNameIn, `users`.`lastName` = lastNameIn, `users`.`email` = emailIn, `users`.`phoneNumber` = phoneNumberIn, `users`.`hourlyWages` = hourlyWagesIn, `users`.`password` = passwordIn, `users`.`gender` = genderIn, `users`.`UserType` = UserTypeIn, `users`.`companyCode` = companyCodeIn, `users`.`isActive` = isActiveIn, `users`.`dateOfLastChanges` = dateOfLastChangesIn, `users`.`modifierCode` = modifierCodeIn WHERE `users`.`userId` = userIdIn$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `activites`
--

CREATE TABLE `activites` (
  `name` varchar(50) NOT NULL,
  `id` int(11) NOT NULL,
  `activitycode` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `activites`
--

INSERT INTO `activites` (`name`, `id`, `activitycode`) VALUES
('Mohammad ', 1, 11),
('mohhammd3', 3, 3),
('mohhammd4', 4, 4),
('mohhammd5', 5, 5);

-- --------------------------------------------------------

--
-- Table structure for table `garden`
--

CREATE TABLE `garden` (
  `gardencode` int(11) NOT NULL,
  `name` varchar(30) NOT NULL,
  `address` varchar(200) NOT NULL,
  `description` varchar(500) DEFAULT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `garden`
--

INSERT INTO `garden` (`gardencode`, `name`, `address`, `description`, `id`) VALUES
(1, 'garden name1', 'garden Address', 'garden Desc 1', 1),
(3, 'garden3', 'address3', 'garden3desc', 3),
(4, 'garden4', 'address4', 'garden4desc', 4),
(4, 'garden4', 'address4', 'garden4desc', 5),
(5, 'garden5', 'address5', 'garden5desc', 6);

-- --------------------------------------------------------

--
-- Table structure for table `openwork`
--

CREATE TABLE `openwork` (
  `code` int(11) NOT NULL,
  `usercode` int(11) NOT NULL,
  `gardencode` int(11) NOT NULL,
  `activitycode` int(11) NOT NULL,
  `opendescription` varchar(500) DEFAULT NULL,
  `startdate` date NOT NULL,
  `starttime` time NOT NULL,
  `endtime` time NOT NULL,
  `numofbags` int(11) NOT NULL,
  `closedescription` varchar(500) DEFAULT NULL,
  `workpoint` varchar(500) DEFAULT NULL,
  `workscore` int(11) DEFAULT NULL,
  `behaviorscore` int(11) DEFAULT NULL,
  `enddate` date NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `openwork`
--

INSERT INTO `openwork` (`code`, `usercode`, `gardencode`, `activitycode`, `opendescription`, `startdate`, `starttime`, `endtime`, `numofbags`, `closedescription`, `workpoint`, `workscore`, `behaviorscore`, `enddate`, `id`) VALUES
(1, 1, 1, 1, 'test open', '2021-11-19', '23:31:46', '23:31:46', 5, 'openwork desc', 'workpoint 1', 1, 1, '2021-11-19', 1),
(3, 1, 3, 3, 'test open3', '2021-11-19', '23:31:46', '23:31:46', 3, 'openwork desc3', 'workpoint 3', 3, 3, '2021-11-19', 3),
(4, 1, 4, 4, 'test open4', '2021-11-19', '23:31:46', '23:31:46', 4, 'openwork desc4', 'workpoint 4', 4, 4, '2021-11-19', 4),
(5, 5, 5, 5, 'test open5', '2021-11-19', '23:31:46', '23:31:46', 5, 'openwork desc5', 'workpoint 5', 5, 5, '2021-11-19', 5);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userid` int(11) NOT NULL,
  `identitycard` varchar(20) DEFAULT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `email` varchar(50) NOT NULL,
  `phonenumber` varchar(13) NOT NULL,
  `hourlywages` double NOT NULL,
  `password` varchar(30) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `usertype` varchar(9) NOT NULL,
  `companycode` int(11) DEFAULT NULL,
  `isactive` int(1) NOT NULL,
  `dateoflastchanges` date NOT NULL,
  `modifiercode` int(11) NOT NULL,
  `id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userid`, `identitycard`, `firstname`, `lastname`, `email`, `phonenumber`, `hourlywages`, `password`, `gender`, `usertype`, `companycode`, `isactive`, `dateoflastchanges`, `modifiercode`, `id`) VALUES
(1, '1', 'testn1', 'lastname1', 'i@com', '1', 1100, '1', 'male', '1', 1, 1, '2021-11-20', 0, 1),
(2, '2', 'testn2', 'lastname2', 'i@com', '2', 1200, '2', 'male', '2', 2, 1, '2021-11-20', 0, 2),
(3, '3', 'testn3', 'lastname3', 'i@com', '3', 1300, '3', 'male', '3', 3, 1, '2021-11-20', 0, 3),
(4, '4', 'testn4', 'lastname4', 'i@com', '4', 1400, '4', 'male', '4', 4, 1, '2021-11-20', 0, 4),
(5, '5', 'testn5', 'lastname4', 'i@com', '5', 1500, '5', 'male', '5', 5, 1, '2021-11-20', 0, 5);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `activites`
--
ALTER TABLE `activites`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `garden`
--
ALTER TABLE `garden`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `openwork`
--
ALTER TABLE `openwork`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `activites`
--
ALTER TABLE `activites`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `garden`
--
ALTER TABLE `garden`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `openwork`
--
ALTER TABLE `openwork`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

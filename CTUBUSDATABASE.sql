-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 01, 2017 at 12:59 AM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `CTUBUSDATABASE`
--

-- --------------------------------------------------------

--
-- Table structure for table `Admin`
--

CREATE TABLE `Admin` (
  `uname` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `Admin`
--

INSERT INTO `Admin` (`uname`, `password`) VALUES
('debanik', 'moto'),
('lipi', 'silver'),
('kanchan', 'bronze'),
('ashok', 'yellow'),
('kulwinder', 'firey'),
('prabhjot', 'SPICs'),
('harman', 'bingo'),
('nidhi', 'emotions'),
('danvir', 'string'),
('navpreet', 'tweety'),
('komal', 'dragon'),
('spic', 'spic');

-- --------------------------------------------------------

--
-- Table structure for table `allotbus`
--

CREATE TABLE `allotbus` (
  `allotid` int(11) NOT NULL,
  `busno` varchar(11) DEFAULT NULL,
  `routeid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `allotbus`
--

INSERT INTO `allotbus` (`allotid`, `busno`, `routeid`) VALUES
(1, '101', 1),
(2, '102', 2),
(3, '103', 3),
(4, '104', 4),
(5, '105', 5),
(6, '106', 6),
(7, '107', 7),
(8, '108', 8),
(9, '109', 9),
(10, '110', 10);

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `fid` int(11) NOT NULL,
  `name` tinytext,
  `email` text,
  `phone` tinytext,
  `feedback` varchar(1000) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `feedback`
--

INSERT INTO `feedback` (`fid`, `name`, `email`, `phone`, `feedback`) VALUES
(1, 'Debanik', 'debanikonline@gmail.com', '8194946794', 'Properly tested.'),
(2, 'Ashok Kashav', 'ashok.kashav@gmail.com', '7890234560', 'Very Good Debanik');

-- --------------------------------------------------------

--
-- Table structure for table `route_master`
--

CREATE TABLE `route_master` (
  `routeid` int(11) NOT NULL,
  `routename` varchar(100) DEFAULT NULL,
  `startname` varchar(100) DEFAULT NULL,
  `endname` varchar(100) DEFAULT NULL,
  `starttime` varchar(11) DEFAULT NULL,
  `stoptime` varchar(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `route_master`
--

INSERT INTO `route_master` (`routeid`, `routename`, `startname`, `endname`, `starttime`, `stoptime`) VALUES
(1, 'Sec12 PGI to Sec20 Pkl', 'Sector 12 PGI', 'Sector 20 Panchkula', '6:15AM', '8:40PM'),
(2, 'Sec12 PGI to MouliJagran', 'Sector 12 PGI', 'Mouli Jagran', '8:00AM', '5:00PM'),
(3, 'Sec12 PGI to Sec65 mkt', 'Sector 12 PGI', 'Sector 65 Market', '6:00AM', '8:30PM'),
(4, 'ISBT 43 to Mansa Devi', 'ISBT 43', 'Mansa Devi', '6:00AM', '8:30PM'),
(5, 'ISBT 17  to Mansa Devi', 'ISBT 17', 'Mansa Devi', '6:00AM', '8:30PM'),
(6, 'ISBT 43 to Kaimbwala', 'ISBT 43', 'Kaimbwala', '6:00AM', '8:00PM'),
(7, 'ISBT 43 to HighCourt', 'ISBT 43', 'High Court', '6:00AM', '5:30PM'),
(8, 'ISBT 43 to IT PARK Chd via Railway Station', 'ISBT 43', 'IT Park Chandigarh', '6:00AM', '7:30PM'),
(9, 'ISBT 43 to IT PARK chd\r\nvia Madhya Marg', 'ISBT 43', 'IT Park Chandigarh', '6:00AM', '7:30PM'),
(10, 'Sec12 PGI to ISBT 43', 'Sector 12 PGI', 'ISBT 43', '6:00AM', '8:00PM');

-- --------------------------------------------------------

--
-- Table structure for table `stopage_detail`
--

CREATE TABLE `stopage_detail` (
  `stopid` int(11) NOT NULL,
  `stopname` varchar(100) DEFAULT NULL,
  `stoptime` varchar(20) DEFAULT NULL,
  `routeid` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `stopage_detail`
--

INSERT INTO `stopage_detail` (`stopid`, `stopname`, `stoptime`, `routeid`) VALUES
(1, 'PGI OPD', '6:15AM', 1),
(2, 'Sector 10', '7:00AM', 1),
(3, 'ISBT 17', '7:15AM', 1),
(4, 'Sector 8/Sector 18', '7:30AM', 1),
(5, 'Sector 7/Sector 19', '7:15AM', 1),
(6, 'Grain Market Sector 26', '8:00AM', 1),
(7, 'Industrial Area Ph-1', '8:30AM', 1),
(8, 'Railway Station', '8:45AM', 1),
(9, 'Housing Board', '9:00AM', 1),
(10, 'Sector 9', '9:15AM', 1),
(11, 'Sector 10', '9:30AM', 1),
(12, 'Sector 4 Panchkula', '9:45AM', 1),
(13, 'Sector 21 Panchkula', '10:00AM', 1),
(14, 'Sector 20 Panchkula', '10:15AM', 1),
(15, 'PGI OPD', '8:15AM', 2),
(16, 'Sector 10/Sector 16', '8:30AM', 2),
(17, 'ISBT 17', '8:45AM', 2),
(18, 'Sector 8/Sector 18', '9:00AM', 2),
(19, 'Sector 7/Sector 19', '9:15AM', 2),
(20, 'Grain Market Sector 26', '9:30AM', 2),
(21, 'Industrial Area Ph-1', '9:45AM', 2),
(22, 'Railway Station', '10:00AM', 2),
(23, 'Railway Crossing', '10:15AM', 2),
(24, 'Housing Board', '10:30AM', 2),
(25, 'Mouli Jagran', '10:35AM', 2),
(26, 'Sector 12 PGI', '6:00AM', 3),
(27, 'PGI OPD', '6:15AM', 3),
(28, 'Sector 10', '6:30:AM', 3),
(29, 'ISBT 17', '6:45AM', 3),
(30, 'Aroma Sector 22', '7:00AM', 3),
(31, 'Sector 34', '7:10AM', 3),
(32, 'Sector 43', '7:15AM', 3),
(33, 'ISBT 43', '7:20AM', 3),
(34, 'Sector 44', '7:45AM', 3),
(35, 'Sector 45', '7:50AM', 3),
(36, 'Sector 46', '8:00AM', 3),
(37, 'Sector 47', '8:10AM', 3),
(38, 'Sector 48', '8:15AM', 3),
(39, 'Sector 65', '8:20AM', 3),
(40, 'ISBT 43', '6:00AM', 4),
(41, 'Sector 44', '6:15AM', 4),
(42, 'Sector 45', '6:30:AM', 4),
(43, 'Sector 46', '6:45AM', 4),
(44, 'Sector 47', '7:00AM', 4),
(45, 'Ram Darbar', '7:10AM', 4),
(46, 'Tribune Chowk', '7:15AM', 4),
(47, 'Paultry Farm', '7:20AM', 4),
(48, 'Industrial Area Ph-1', '7:45AM', 4),
(49, 'Railway Station', '7:50AM', 4),
(50, 'Railway Crossing', '8:00AM', 4),
(51, 'Housing Board', '8:10AM', 4),
(52, 'Mani Majra', '8:15AM', 4),
(53, 'Mansa Devi', '8:20AM', 4),
(54, 'ISBT 17', '6:00AM', 5),
(55, 'Sector 44', '6:15AM', 5),
(56, 'Sector 45', '6:30:AM', 5),
(57, 'Sector 47', '6:45AM', 5),
(58, 'Tribune Chowk', '7:00AM', 5),
(59, 'Industrial Area Ph-1', '7:10AM', 5),
(60, 'Railway Crossing', '7:15AM', 5),
(61, 'Housing Board', '7:20AM', 5),
(62, 'Fun Republic', '7:45AM', 5),
(63, 'Mani Majra', '7:50AM', 5),
(64, 'Mansa Devi', '8:00AM', 5),
(65, 'ISBT 43', '6:00AM', 6),
(66, 'Sector 42', '6:15AM', 6),
(67, 'Sector 36', '6:30:AM', 6),
(68, 'Sector 23', '6:45AM', 6),
(69, 'ISBT 17', '7:00AM', 6),
(70, 'Sector 9', '7:10AM', 6),
(71, 'Sector 3', '7:15AM', 6),
(72, 'Punjab Secretriat', '7:20AM', 6),
(73, 'High Court', '7:45AM', 6),
(74, 'Sukhna Lake', '7:50AM', 6),
(75, 'Kaimbwala', '8:00AM', 6),
(76, 'ISBT 43', '6:00AM', 7),
(77, 'Sector 42', '6:15AM', 7),
(78, 'Sector 37', '6:30:AM', 7),
(79, 'Sector 24', '6:45AM', 7),
(80, 'Sector 23', '6:45AM', 7),
(81, 'ISBT 17', '7:00AM', 7),
(82, 'Sector 9', '7:10AM', 7),
(83, 'Sector 3', '7:15AM', 7),
(84, 'High Court', '7:45AM', 7),
(85, 'ISBT 43', '6:00AM', 8),
(86, 'Sector 43', '6:15AM', 8),
(87, 'Sector 36', '6:30:AM', 8),
(88, 'Sector 23', '6:45AM', 8),
(89, 'ISBT 17', '7:00AM', 8),
(90, 'Sector 18', '7:10AM', 8),
(91, 'Sector 19', '7:15AM', 8),
(92, 'Sector 27', '7:20AM', 8),
(93, 'Sector 28', '7:40AM', 8),
(94, 'Industrial Area ph-1', '7:50AM', 8),
(95, 'Railway Station', '8:00AM', 8),
(96, 'Railway Crossing', '8:10AM', 8),
(97, 'Housing Board', '8:15AM', 8),
(98, 'Mani Majra', '8:20AM', 8),
(99, 'Indra Colony', '8:30AM', 8),
(100, 'Kishangarh', '8:35AM', 8),
(101, 'IT PARK chd', '8:50AM', 8),
(102, 'ISBT 43', '6:00AM', 9),
(103, 'Sector 42', '6:15AM', 9),
(104, 'Sector 36', '6:30:AM', 9),
(105, 'Sector 23', '6:45AM', 9),
(106, 'ISBT 17', '7:00AM', 9),
(107, 'Sector 8', '7:10AM', 9),
(108, 'Sector 7', '7:15AM', 9),
(109, 'Grain Market Sector 26', '7:20AM', 9),
(110, 'Railway Crossing', '7:30AM', 9),
(111, 'Housing Board', '7:45AM', 9),
(112, 'Mani Majra', '8:00AM', 9),
(113, 'Indra Colony', '8:10AM', 9),
(114, 'Kishangarh', '8:15AM', 9),
(115, 'IT PARK chd', '8:20AM', 9),
(116, 'Sector 12 PGI', '6:00AM', 10),
(117, 'Sector 11', '6:05AM', 10),
(118, 'Sector 30', '6:10:AM', 10),
(119, 'Sector 17', '6:15AM', 10),
(120, 'ISBT 17', '6:20AM', 10),
(121, 'Aroma 22', '6:25AM', 10),
(122, 'Sector 34', '6:30AM', 10),
(123, 'Sector 44', '6:35AM', 10),
(124, 'ISBT 43', '6:40AM', 10);

-- --------------------------------------------------------

--
-- Table structure for table `UserDetails`
--

CREATE TABLE `UserDetails` (
  `cid` int(50) NOT NULL,
  `cname` varchar(50) DEFAULT NULL,
  `cmail` varchar(50) DEFAULT NULL,
  `cphone` int(20) DEFAULT NULL,
  `canswer` tinytext,
  `cpassword` varchar(100) DEFAULT NULL,
  `securityquestion` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `UserDetails`
--

INSERT INTO `UserDetails` (`cid`, `cname`, `cmail`, `cphone`, `canswer`, `cpassword`, `securityquestion`) VALUES
(1, 'spic', 'spic@spic.com', 2147483647, 'spic', 'spic', 'Name of first school');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `allotbus`
--
ALTER TABLE `allotbus`
  ADD PRIMARY KEY (`allotid`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`fid`);

--
-- Indexes for table `route_master`
--
ALTER TABLE `route_master`
  ADD PRIMARY KEY (`routeid`);

--
-- Indexes for table `stopage_detail`
--
ALTER TABLE `stopage_detail`
  ADD PRIMARY KEY (`stopid`);

--
-- Indexes for table `UserDetails`
--
ALTER TABLE `UserDetails`
  ADD PRIMARY KEY (`cid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `allotbus`
--
ALTER TABLE `allotbus`
  MODIFY `allotid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `fid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `route_master`
--
ALTER TABLE `route_master`
  MODIFY `routeid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `stopage_detail`
--
ALTER TABLE `stopage_detail`
  MODIFY `stopid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=127;
--
-- AUTO_INCREMENT for table `UserDetails`
--
ALTER TABLE `UserDetails`
  MODIFY `cid` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

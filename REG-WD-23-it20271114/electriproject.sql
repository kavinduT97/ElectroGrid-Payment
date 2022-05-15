-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 24, 2022 at 09:49 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `electriproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `billingm`
--

CREATE TABLE IF NOT EXISTS `billingm` (
  `billID` int(6) NOT NULL AUTO_INCREMENT,
  `billCName` varchar(100) NOT NULL,
  `billAccNO` varchar(20) NOT NULL,
  `billDate` varchar(20) NOT NULL,
  `billUnits` varchar(40) NOT NULL,
  `billAmount` varchar(30) NOT NULL,
  PRIMARY KEY (`billID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `customerm`
--

CREATE TABLE IF NOT EXISTS `customerm` (
  `cID` int(6) NOT NULL AUTO_INCREMENT,
  `customerName` varchar(50) NOT NULL,
  `customerAddress` varchar(200) NOT NULL,
  `customerNIC` varchar(20) NOT NULL,
  `customerEmail` varchar(100) NOT NULL,
  `customerPNO` varchar(10) NOT NULL,
  PRIMARY KEY (`cID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `employeem`
--

CREATE TABLE IF NOT EXISTS `employeem` (
  `employeeID` int(6) NOT NULL AUTO_INCREMENT,
  `employeeName` int(100) NOT NULL,
  `employeeAddress` varchar(50) NOT NULL,
  `employeeEmail` varchar(50) NOT NULL,
  `employeeMobile` varchar(10) NOT NULL,
  PRIMARY KEY (`employeeID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `paymentm`
--

CREATE TABLE IF NOT EXISTS `paymentm` (
  `Payment_ID` int(6) NOT NULL AUTO_INCREMENT,
  `Payment_Account` varchar(30) NOT NULL,
  `Customer_Name` varchar(50) NOT NULL,
  `Payment_Date` varchar(20) NOT NULL,
  `Payment_Amount` varchar(20) NOT NULL,
  PRIMARY KEY (`Payment_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `powercutm`
--

CREATE TABLE IF NOT EXISTS `powercutm` (
  `PowerCutID` int(6) NOT NULL AUTO_INCREMENT,
  `PowerCutProvince` varchar(50) NOT NULL,
  `PowerCutCity` varchar(50) NOT NULL,
  `PowerCutDate` varchar(50) NOT NULL,
  `PowerCutTime` varchar(20) NOT NULL,
  PRIMARY KEY (`PowerCutID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

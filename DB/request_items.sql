-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 22, 2021 at 11:45 AM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `test`
--

-- --------------------------------------------------------

--
-- Table structure for table `request_items`
--

CREATE TABLE `request_items` (
  `id` int(11) NOT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `parameter` varchar(50) CHARACTER SET utf8mb4 NOT NULL,
  `comment` varchar(255) CHARACTER SET utf8mb4 NOT NULL,
  `time_stamp` timestamp NOT NULL DEFAULT current_timestamp(),
  `status` varchar(50) CHARACTER SET utf8mb4 NOT NULL DEFAULT 'Unapproved'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `request_items`
--

INSERT INTO `request_items` (`id`, `name`, `parameter`, `comment`, `time_stamp`, `status`) VALUES
(10, 'Core i7', '6', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum at nulla vitae mauris maximus consequat et et quam. Fusce euismod ligula vel tortor fermentum viverra. Curabitur sodales turpis quis tempus fermentum. Praesent lobortis, magnasdfsfwf', '2021-01-22 08:30:34', 'Approved'),
(11, 'Core i3', '2', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum at nulla vitae mauris maximus consequat et et quam. Fusce euismod ligula vel tortor fermentum viverra. Curabitur sodales turpis quis tempus fermentum. Praesent lobortis, quis tempus ferme', '2021-01-22 08:44:52', 'Declined'),
(14, 'Core i5', '6', 'Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum at nulla vitae mauris maximus consequat et et quam. Fusce euismod ligula vel tortor fermentum viverra', '2021-01-22 10:32:55', 'Unapproved');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `request_items`
--
ALTER TABLE `request_items`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `request_items`
--
ALTER TABLE `request_items`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

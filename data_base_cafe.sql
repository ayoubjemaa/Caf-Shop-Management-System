-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : sam. 03 mai 2025 à 23:19
-- Version du serveur : 10.4.32-MariaDB
-- Version de PHP : 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `cafe`
--

-- --------------------------------------------------------

--
-- Structure de la table `customer`
--

CREATE TABLE `customer` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `product_id` varchar(100) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `quantity` int(11) NOT NULL,
  `price` double NOT NULL,
  `date` date DEFAULT NULL,
  `image` varchar(500) NOT NULL,
  `employee_username` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `customer`
--

INSERT INTO `customer` (`id`, `customer_id`, `product_id`, `product_name`, `type`, `quantity`, `price`, `date`, `image`, `employee_username`) VALUES
(1, 1, 'PROD-001', 'Burger', 'Meals', 2, 50, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(2, 1, 'PROD-004', 'Fried Chicken', 'Meals', 2, 20, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Fried Chicken.jpg', 'admin'),
(3, 2, 'PROD-002', 'Pizza', 'Meals', 1, 15, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(4, 3, 'PROD-005', 'Coke', 'Drinks', 2, 4, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'admin'),
(5, 4, 'PROD-007', 'Tea', 'Drinks', 2, 4, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Tea.jpg', 'admin'),
(6, 4, 'PROD-001', 'Burger', 'Meals', 2, 50, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(7, 4, 'PROD-005', 'Coke', 'Drinks', 2, 4, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'admin'),
(8, 5, 'PROD-004', 'Fried Chicken', 'Meals', 2, 20, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Fried Chicken.jpg', 'admin'),
(9, 5, 'PROD-007', 'Tea', 'Drinks', 2, 4, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Tea.jpg', 'admin'),
(10, 6, 'PROD-004', 'Fried Chicken', 'Meals', 2, 20, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Fried Chicken.jpg', 'admin'),
(11, 7, 'PROD-001', 'Burger', 'Meals', 2, 50, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(12, 7, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(13, 8, 'PROD-004', 'Fried Chicken', 'Meals', 1, 10, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Fried Chicken.jpg', 'admin'),
(14, 8, 'PROD-005', 'Coke', 'Drinks', 1, 2, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'admin'),
(15, 8, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(16, 8, 'PROD-001', 'Burger', 'Meals', 2, 50, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(17, 8, 'PROD-007', 'Tea', 'Drinks', 5, 10, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Tea.jpg', 'admin'),
(18, 8, 'PROD-008', 'Chocolate Cake', 'Meals', 2, 20, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Chocolate Cake.jpg', 'admin'),
(19, 8, 'PROD-006', 'Expresso', 'Drinks', 2, 6, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\expressp.jpg', 'admin'),
(20, 9, 'PROD-004', 'Fried Chicken', 'Meals', 2, 20, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Fried Chicken.jpg', 'admin'),
(21, 9, 'PROD-001', 'Burger', 'Meals', 2, 50, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(22, 9, 'PROD-002', 'Pizza', 'Meals', 3, 45, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(23, 10, 'PROD-001', 'Burger', 'Meals', 1, 25, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(24, 11, 'PROD-001', 'Burger', 'Meals', 3, 75, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(25, 11, 'PROD-005', 'Coke', 'Drinks', 2, 4, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'admin'),
(26, 12, 'PROD-001', 'Burger', 'Meals', 1, 25, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(27, 13, 'PROD-004', 'Fried Chicken', 'Meals', 2, 20, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Fried Chicken.jpg', 'admin'),
(28, 14, 'PROD-005', 'Coke', 'Drinks', 1, 2, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'admin'),
(29, 15, 'PROD-001', 'Burger', 'Meals', 1, 25, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(30, 15, 'PROD-005', 'Coke', 'Drinks', 1, 2, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'admin'),
(31, 16, 'PROD-004', 'Fried Chicken', 'Meals', 2, 20, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Fried Chicken.jpg', 'admin'),
(32, 16, 'PROD-001', 'Burger', 'Meals', 2, 50, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(33, 17, 'PROD-001', 'Burger', 'Meals', 2, 50, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(34, 17, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(35, 17, 'PROD-005', 'Coke', 'Drinks', 2, 4, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'admin'),
(38, 18, 'PROD-001', 'Burger', 'Meals', 2, 50, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(39, 19, 'PROD-001', 'Burger', 'Meals', 1, 25, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(40, 20, 'PROD-005', 'Coke', 'Drinks', 1, 2, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'admin'),
(41, 21, 'PROD-002', 'Pizza', 'Meals', 1, 15, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(42, 21, 'PROD-001', 'Burger', 'Meals', 2, 50, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(44, 22, 'PROD-001', 'Burger', 'Meals', 1, 25, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(45, 22, 'PROD-002', 'Pizza', 'Meals', 1, 15, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(48, 23, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(49, 23, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2024-12-04', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(58, 24, 'PROD-001', 'Burger', 'Meals', 2, 50, '2024-12-05', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(59, 24, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2024-12-05', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(60, 25, 'PROD-005', 'Coke', 'Drinks', 2, 4, '2024-12-05', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'admin'),
(64, 26, 'PROD-001', 'Burger', 'Meals', 10, 250, '2024-12-05', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(65, 26, 'PROD-002', 'Pizza', 'Meals', 10, 150, '2024-12-05', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(66, 27, 'PROD-001', 'Burger', 'Meals', 2, 50, '2024-12-06', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(67, 27, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2024-12-06', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(68, 27, 'PROD-004', 'Fried Chicken', 'Meals', 2, 20, '2024-12-06', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Fried Chicken.jpg', 'admin'),
(69, 27, 'PROD-005', 'Coke', 'Drinks', 2, 4, '2024-12-06', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'admin'),
(70, 27, 'PROD-001', 'Burger', 'Meals', 8, 200, '2024-12-06', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(71, 28, 'PROD-001', 'Burger', 'Meals', 2, 50, '2024-12-06', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(72, 28, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2024-12-06', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(73, 28, 'PROD-004', 'Fried Chicken', 'Meals', 2, 20, '2024-12-06', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Fried Chicken.jpg', 'admin'),
(74, 28, 'PROD-007', 'Tea', 'Drinks', 2, 4, '2024-12-06', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Tea.jpg', 'admin'),
(75, 29, 'PROD-009', 'Chichaaa', 'Drinks', 1, 3.5, '2024-12-06', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Chicha.jpg', 'admin'),
(76, 30, 'PROD-009', 'Chichaaa', 'Drinks', 1, 3.5, '2024-12-06', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Chicha.jpg', 'admin'),
(77, 30, 'PROD-006', 'Expresso', 'Drinks', 1, 3, '2024-12-06', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\expressp.jpg', 'admin'),
(78, 31, 'PROD-004', 'Fried Chicken', 'Meals', 2, 20, '2024-12-07', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Fried Chicken.jpg', 'admin'),
(79, 31, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2024-12-07', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(80, 31, 'PROD-005', 'Coke', 'Drinks', 2, 4, '2024-12-07', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'admin'),
(82, 32, 'PROD-005', 'Coke', 'Drinks', 2, 4, '2024-12-07', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'admin'),
(85, 33, 'PROD-001', 'Burger', 'Meals', 20, 500, '2024-12-07', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(86, 34, 'PROD-004', 'Fried Chicken', 'Meals', 10, 100, '2024-12-07', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Fried Chicken.jpg', 'admin'),
(88, 35, 'PROD-010', 'MALFOUF', 'Meals', 1, 0.5, '2024-12-07', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\malfouf.jpg', 'admin'),
(89, 36, 'PROD-001', 'Burger', 'Meals', 2, 50, '2024-12-07', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'Ayoub Jemaa'),
(90, 36, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2024-12-07', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'Ayoub Jemaa'),
(91, 36, 'PROD-005', 'Coke', 'Drinks', 2, 4, '2024-12-07', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'Ayoub Jemaa'),
(92, 36, 'PROD-004', 'Fried Chicken', 'Meals', 2, 20, '2024-12-07', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Fried Chicken.jpg', 'Ayoub Jemaa'),
(93, 37, 'PROD-005', 'Coke', 'Drinks', 2, 4, '2024-12-07', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'admin'),
(94, 37, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2024-12-07', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(95, 38, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2024-12-07', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(96, 38, 'PROD-001', 'Burger', 'Meals', 2, 50, '2024-12-07', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(97, 38, 'PROD-005', 'Coke', 'Drinks', 2, 4, '2024-12-07', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'admin'),
(98, 38, 'PROD-008', 'Chocolate Cake', 'Meals', 2, 20, '2024-12-07', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Chocolate Cake.jpg', 'admin'),
(102, 39, 'PROD-007', 'Tea', 'Drinks', 1, 2, '2024-12-08', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Tea.jpg', 'admin'),
(103, 39, 'PROD-009', 'Chichaaa', 'Drinks', 1, 3.5, '2024-12-08', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Chicha.jpg', 'admin'),
(104, 39, 'PROD-003', 'Ice-Tea', 'Drinks', 1, 3, '2024-12-08', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Ice-Tea.jpg', 'admin'),
(106, 39, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2024-12-08', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(107, 40, 'PROD-008', 'Chocolate Cake', 'Meals', 2, 20, '2024-12-10', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Chocolate Cake.jpg', 'admin'),
(108, 40, 'PROD-005', 'Coke', 'Drinks', 2, 4, '2024-12-10', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'admin'),
(109, 41, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2024-12-18', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(110, 41, 'PROD-001', 'Burger', 'Meals', 2, 50, '2024-12-18', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(111, 42, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2024-12-18', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(112, 42, 'PROD-003', 'Ice-Tea', 'Drinks', 1, 3, '2024-12-18', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Ice-Tea.jpg', 'admin'),
(113, 43, 'PROD-001', 'Burger', 'Meals', 1, 25, '2024-12-19', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(114, 43, 'PROD-002', 'Pizza', 'Meals', 1, 15, '2024-12-19', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(116, 44, 'PROD-001', 'Burger', 'Meals', 2, 50, '2024-12-19', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(117, 44, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2024-12-19', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(120, 45, 'PROD-001', 'Burger', 'Meals', 2, 50, '2024-12-19', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(121, 45, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2024-12-19', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(124, 46, 'PROD-009', 'Chichaaa', 'Drinks', 4, 14, '2024-12-19', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Chicha.jpg', 'admin'),
(125, 47, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2024-12-19', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(126, 47, 'PROD-006', 'Expresso', 'Drinks', 2, 6, '2024-12-19', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\expressp.jpg', 'admin'),
(127, 48, 'PROD011', 'Cheese Cake Lotus', 'Meals', 1, 25, '2024-12-19', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\cheesecake.jpg', 'admin'),
(129, 48, 'PROD-006', 'Expresso', 'Drinks', 1, 3, '2024-12-19', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\expressp.jpg', 'admin'),
(139, 49, 'PROD-005', 'Coke', 'Drinks', 2, 4, '2025-01-20', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'admin'),
(140, 49, 'PROD-005', 'Coke', 'Drinks', 2, 4, '2025-01-20', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'admin'),
(161, 50, 'PROD-001', 'Burger', 'Meals', 2, 50, '2025-01-20', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(164, 51, 'PROD-001', 'Burger', 'Meals', 2, 50, '2025-01-20', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(165, 51, 'PROD-005', 'Coke', 'Drinks', 2, 4, '2025-01-20', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'admin'),
(166, 52, 'PROD-011', 'Cheese Cake Lotus', 'Meals', 2, 20, '2025-01-20', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\cheesecake.jpg', 'admin'),
(167, 52, 'PROD-007', 'Tea', 'Drinks', 2, 4, '2025-01-20', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Tea.jpg', 'admin'),
(168, 52, 'PROD-010', 'makloub', 'Meals', 2, 20, '2025-01-20', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Makloub.jpg', 'admin'),
(170, 53, 'PROD-009', 'Chichaaa', 'Drinks', 1, 3.5, '2025-01-22', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Chicha.jpg', 'Farah'),
(186, 54, 'PROD-002', 'Pizza', 'Meals', 1, 15, '2025-01-22', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'admin'),
(187, 55, 'PROD-001', 'Burger', 'Meals', 2, 50, '2025-01-22', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'admin'),
(243, 56, 'PROD-001', 'Burger', 'Meals', 2, 50, '2025-01-23', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'Farah'),
(244, 56, 'PROD-002', 'Pizza', 'Meals', 2, 30, '2025-01-23', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'Farah'),
(245, 57, 'PROD-001', 'Burger', 'Meals', 3, 75, '2025-01-23', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'Farah'),
(246, 57, 'PROD-002', 'Pizza', 'Meals', 3, 45, '2025-01-23', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', 'Farah'),
(247, 57, 'PROD-001', 'Burger', 'Meals', 2, 50, '2025-01-23', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'Farah'),
(248, 58, 'PROD-001', 'Burger', 'Meals', 6, 150, '2025-01-23', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', 'Farah'),
(251, 59, 'PROD-013', 'Lasagne', 'Meals', 1, 20, '2025-01-23', 'C:\\Users\\PRO BOOK\\Downloads\\lazania.jpg', 'Farah'),
(252, 59, 'PROD-005', 'Coke', 'Drinks', 1, 2, '2025-01-23', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', 'Farah');

-- --------------------------------------------------------

--
-- Structure de la table `employee`
--

CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `question` varchar(100) NOT NULL,
  `answer` varchar(100) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `employee`
--

INSERT INTO `employee` (`id`, `username`, `password`, `question`, `answer`, `date`) VALUES
(1, 'admin', '12345', 'What is your favourite color ?', 'Blue', NULL),
(2, 'Ayoub Jemaa', 'rania2005', 'What is your birthdate?', '13/09/2004', '2024-11-29'),
(3, 'admin01', '00000', 'What is your favourite food?', 'pizza', '2024-11-29'),
(4, 'admin02', 'amen2004', 'What is your favourite color ?', 'Black', '2024-11-30'),
(5, 'Farah', 'Rouetbi', 'What is your birthdate?', '07-09-2004', '2025-01-20'),
(6, 'faraah', 'farah', 'What is your favourite food?', 'lasagna', '2025-01-23'),
(7, 'TZZT', 'Clubistee', 'What is your birthdate?', '10-10-2004', '2025-01-23');

-- --------------------------------------------------------

--
-- Structure de la table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `product_id` varchar(100) NOT NULL,
  `product_name` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `stock` int(100) NOT NULL,
  `price` double NOT NULL,
  `status` varchar(100) NOT NULL,
  `image` varchar(500) NOT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `product`
--

INSERT INTO `product` (`id`, `product_id`, `product_name`, `type`, `stock`, `price`, `status`, `image`, `date`) VALUES
(2, 'PROD-001', 'Burger', 'Meals', 70, 25, 'Available', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\burger.jpg', '2024-12-01'),
(3, 'PROD-002', 'Pizza', 'Meals', 494, 15, 'Available', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\pizza.jpg', '2024-12-02'),
(4, 'PROD-003', 'Ice-Tea', 'Drinks', 1000, 3, 'Available', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Ice-Tea.jpg', '2024-12-02'),
(6, 'PROD-004', 'Fried Chicken', 'Meals', 500, 10, 'Available', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Fried Chicken.jpg', '2024-12-03'),
(7, 'PROD-005', 'Coke', 'Drinks', 999, 2, 'Available', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\coke.jpg', '2024-12-04'),
(8, 'PROD-006', 'Expresso', 'Drinks', 500, 3, 'Available', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\expressp.jpg', '2024-12-04'),
(9, 'PROD-007', 'Tea', 'Drinks', 1000, 2, 'Available', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Tea.jpg', '2024-12-04'),
(10, 'PROD-008', 'Chocolate Cake', 'Meals', 500, 10, 'Available', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Chocolate Cake.jpg', '2024-12-04'),
(15, 'PROD-010', 'makloub', 'Meals', 500, 10, 'Available', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\Makloub.jpg', '2024-12-19'),
(16, 'PROD-011', 'Cheese Cake Lotus', 'Meals', 1000, 10, 'Available', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\cheesecake.jpg', '2024-12-19'),
(18, 'PROD-013', 'Lasagne', 'Meals', 999, 20, 'Available', 'C:\\Users\\PRO BOOK\\Downloads\\lazania.jpg', '2025-01-20'),
(19, 'PROD-014', 'Konefaa', 'Meals', 500, 5, 'Available', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\konefa.jpg', '2025-01-22'),
(20, 'PROD-015', 'Lablebi', 'Meals', 1000, 5, 'Available', 'C:\\\\Users\\\\PRO BOOK\\\\Downloads\\\\lablebi.jpg', '2025-01-23');

-- --------------------------------------------------------

--
-- Structure de la table `receipt`
--

CREATE TABLE `receipt` (
  `id` int(11) NOT NULL,
  `customer_id` int(11) NOT NULL,
  `total` double NOT NULL,
  `date` date DEFAULT NULL,
  `employee_username` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Déchargement des données de la table `receipt`
--

INSERT INTO `receipt` (`id`, `customer_id`, `total`, `date`, `employee_username`) VALUES
(1, 1, 70, '2024-12-04', 'admin'),
(2, 2, 15, '2024-12-04', 'admin'),
(3, 3, 4, '2024-12-04', 'admin'),
(4, 4, 58, '2024-12-04', 'admin'),
(5, 5, 24, '2024-12-04', 'admin'),
(6, 6, 20, '2024-12-04', 'admin'),
(7, 7, 80, '2024-12-04', 'admin'),
(8, 8, 128, '2024-12-04', 'admin'),
(9, 9, 115, '2024-12-04', 'admin'),
(10, 10, 25, '2024-12-04', 'admin'),
(11, 11, 79, '2024-12-04', 'admin'),
(12, 12, 25, '2024-12-04', 'admin'),
(13, 13, 20, '2024-12-04', 'admin'),
(14, 14, 2, '2024-12-04', 'admin'),
(15, 15, 25, '2024-12-04', 'admin'),
(16, 16, 20, '2024-12-04', 'admin'),
(17, 17, 84, '2024-12-04', 'admin'),
(18, 18, 50, '2024-12-04', 'admin'),
(19, 19, 25, '2024-12-04', 'admin'),
(20, 20, 2, '2024-12-04', 'admin'),
(21, 21, 65, '2024-12-04', 'admin'),
(22, 22, 40, '2024-12-04', 'admin'),
(23, 23, 60, '2024-12-04', 'admin'),
(24, 24, 80, '2024-12-05', 'admin'),
(25, 25, 4, '2024-12-05', 'admin'),
(26, 26, 400, '2024-12-05', 'admin'),
(27, 27, 304, '2024-12-06', 'admin'),
(28, 28, 104, '2024-12-06', 'admin'),
(29, 29, 3.5, '2024-12-06', 'admin'),
(30, 30, 6.5, '2024-12-06', 'admin'),
(31, 31, 54, '2024-12-07', 'admin'),
(32, 32, 4, '2024-12-07', 'admin'),
(33, 33, 500, '2024-12-07', 'admin'),
(34, 34, 100, '2024-12-07', 'admin'),
(35, 35, 0.5, '2024-12-07', 'admin'),
(36, 36, 104, '2024-12-07', 'Ayoub Jemaa'),
(37, 37, 34, '2024-12-07', 'admin'),
(38, 38, 104, '2024-12-07', 'admin'),
(39, 39, 38.5, '2024-12-08', 'admin'),
(40, 40, 24, '2024-12-10', 'admin'),
(41, 41, 80, '2024-12-18', 'admin'),
(42, 42, 33, '2024-12-18', 'admin'),
(43, 43, 40, '2024-12-19', 'admin'),
(44, 44, 80, '2024-12-19', 'admin'),
(45, 45, 80, '2024-12-19', 'admin'),
(46, 46, 14, '2024-12-19', 'admin'),
(47, 47, 36, '2024-12-19', 'admin'),
(48, 48, 28, '2024-12-19', 'admin'),
(49, 49, 8, '2025-01-20', 'admin'),
(55, 50, 50, '2025-01-20', 'admin'),
(56, 51, 54, '2025-01-20', 'admin'),
(57, 52, 44, '2025-01-20', 'admin'),
(58, 53, 3.5, '2025-01-22', 'Farah'),
(59, 54, 15, '2025-01-22', 'admin'),
(60, 55, 50, '2025-01-22', 'admin'),
(61, 56, 80, '2025-01-23', 'Farah'),
(62, 57, 170, '2025-01-23', 'Farah'),
(63, 58, 150, '2025-01-23', 'Farah'),
(64, 59, 22, '2025-01-23', 'Farah');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `receipt`
--
ALTER TABLE `receipt`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=253;

--
-- AUTO_INCREMENT pour la table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- AUTO_INCREMENT pour la table `receipt`
--
ALTER TABLE `receipt`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=65;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

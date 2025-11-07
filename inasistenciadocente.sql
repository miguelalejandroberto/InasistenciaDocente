-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-11-2025 a las 03:32:54
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `miguel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inasistenciadocente`
--

CREATE TABLE `inasistenciadocente` (
  `ci` varchar(9) NOT NULL,
  `fecha_in` varchar(10) NOT NULL,
  `fecha_fin` varchar(10) NOT NULL,
  `motivo` varchar(45) NOT NULL,
  `turno` varchar(45) NOT NULL,
  `grupo` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inasistenciadocente`
--

INSERT INTO `inasistenciadocente` (`ci`, `fecha_in`, `fecha_fin`, `motivo`, `turno`, `grupo`) VALUES
('87654', 'nbvc', 'jbvc', 'mnbvc', 'mnbvc', 'KMNB'),
('345678', 'rftyui', 'vbnm', 'vbnj', 'cvbn', 'cvbn'),
('48773615', '12/09/2025', '14/11/2025', 'medico', 'matutino', '2ma');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

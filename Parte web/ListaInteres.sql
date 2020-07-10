-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 10-07-2020 a las 14:39:26
-- Versión del servidor: 5.7.30-0ubuntu0.18.04.1
-- Versión de PHP: 7.2.24-0ubuntu0.18.04.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `ListaInteres`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugares`
--

CREATE TABLE `lugares` (
  `id` int(11) NOT NULL,
  `nombre` text NOT NULL,
  `longlat` text NOT NULL,
  `estado` text NOT NULL,
  `cantidad` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Volcado de datos para la tabla `lugares`
--

INSERT INTO `lugares` (`id`, `nombre`, `longlat`, `estado`, `cantidad`) VALUES
(14, 'Mercado ArgÃ¼elles', '23.7353524,-99.1476081', 'Activo', 20),
(15, 'Parque Bicentenario', '23.75224,-99.1003844', 'Activo', 50),
(16, 'Paseo MÃ©ndez', '23.7311517,-99.1422371', 'Activo', 60),
(17, 'TAMUX', '23.7273214,-99.1245747', 'Activo', 10),
(18, 'Hotel Las Fuentes', '23.7580937,-99.1968984', 'Inactivo', 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `lugaresSujeridos`
--

CREATE TABLE `lugaresSujeridos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(256) NOT NULL,
  `longlat` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `lugares`
--
ALTER TABLE `lugares`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `lugaresSujeridos`
--
ALTER TABLE `lugaresSujeridos`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `lugares`
--
ALTER TABLE `lugares`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT de la tabla `lugaresSujeridos`
--
ALTER TABLE `lugaresSujeridos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

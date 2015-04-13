-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 10-04-2015 a las 16:52:39
-- Versión del servidor: 5.6.21
-- Versión de PHP: 5.5.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `simcard`
--
CREATE DATABASE IF NOT EXISTS `simcard` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `simcard`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE IF NOT EXISTS `cliente` (
  `cedula` varchar(15) NOT NULL,
  `nombres` varchar(20) NOT NULL,
  `apellidos` varchar(20) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `direccion` varchar(20) NOT NULL,
  `ciudad` varchar(20) NOT NULL,
  `barrio` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`cedula`, `nombres`, `apellidos`, `telefono`, `direccion`, `ciudad`, `barrio`) VALUES
('1065622719', 'elsy maria ', 'gomez gomez', '423422', 'calle falsa 123', 'valledupar', 'esperanza'),
('1234', 'fabio', 'rojas', '44555', 'calle falsa 123', 'valledupar', 'esperanza');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `datos`
--

CREATE TABLE IF NOT EXISTS `datos` (
  `numero` varchar(50) NOT NULL,
  `codigo_sim` varchar(25) NOT NULL,
  `valor` double NOT NULL,
  `Gb_Mb` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `datos`
--

INSERT INTO `datos` (`numero`, `codigo_sim`, `valor`, `Gb_Mb`) VALUES
('3004061405', '3477488857748883993', 10000, '5 gb'),
('315929948838', '98938377773732772737', 10000, '1 gb');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE IF NOT EXISTS `factura` (
`id` bigint(20) NOT NULL,
  `id_cliente` varchar(15) NOT NULL,
  `fecha` date NOT NULL,
  `total` double NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`id`, `id_cliente`, `fecha`, `total`) VALUES
(21, '1065622719', '2015-04-08', 15000),
(22, '1065622719', '2015-04-07', 3000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE IF NOT EXISTS `pedido` (
`id` bigint(20) NOT NULL,
  `id_sim` bigint(20) NOT NULL,
  `id_factura` bigint(20) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id`, `id_sim`, `id_factura`) VALUES
(29, 2, 21),
(30, 4, 21),
(31, 1, 22);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prepago`
--

CREATE TABLE IF NOT EXISTS `prepago` (
  `numero` varchar(50) NOT NULL,
  `codigo_sim` varchar(25) NOT NULL,
  `valor` double NOT NULL,
  `num_minutos` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `prepago`
--

INSERT INTO `prepago` (`numero`, `codigo_sim`, `valor`, `num_minutos`) VALUES
('3013848949484', '12939949458853929394', 3000, '1 gb'),
('3156994074', '847627748848848838', 5000, '40 min');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sim`
--

CREATE TABLE IF NOT EXISTS `sim` (
`id` bigint(20) NOT NULL,
  `codigo_sim_pre` varchar(25) DEFAULT NULL,
  `codigo_sim_dato` varchar(25) DEFAULT NULL,
  `estado` varchar(15) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `sim`
--

INSERT INTO `sim` (`id`, `codigo_sim_pre`, `codigo_sim_dato`, `estado`) VALUES
(1, '12939949458853929394', NULL, 'vendido'),
(2, NULL, '3477488857748883993', 'vendido'),
(4, '847627748848848838', NULL, 'vendido'),
(6, NULL, '98938377773732772737', 'sin vender');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `usuario` varchar(13) NOT NULL,
  `contrasena` varchar(20) NOT NULL,
  `nombres` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`usuario`, `contrasena`, `nombres`) VALUES
('1065622719', 'elsy', 'Fabio Andres Rojas');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
 ADD PRIMARY KEY (`cedula`);

--
-- Indices de la tabla `datos`
--
ALTER TABLE `datos`
 ADD PRIMARY KEY (`codigo_sim`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
 ADD PRIMARY KEY (`id`), ADD KEY `id_cliente` (`id_cliente`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
 ADD PRIMARY KEY (`id`), ADD KEY `id_sim` (`id_sim`), ADD KEY `id_factura` (`id_factura`);

--
-- Indices de la tabla `prepago`
--
ALTER TABLE `prepago`
 ADD PRIMARY KEY (`codigo_sim`);

--
-- Indices de la tabla `sim`
--
ALTER TABLE `sim`
 ADD PRIMARY KEY (`id`), ADD KEY `codigo_pre` (`codigo_sim_pre`), ADD KEY `codigo_dato` (`codigo_sim_dato`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
 ADD PRIMARY KEY (`contrasena`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=23;
--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=32;
--
-- AUTO_INCREMENT de la tabla `sim`
--
ALTER TABLE `sim`
MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=7;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`cedula`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`id_sim`) REFERENCES `sim` (`id`) ON UPDATE CASCADE,
ADD CONSTRAINT `pedido_ibfk_2` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id`) ON UPDATE CASCADE;

--
-- Filtros para la tabla `sim`
--
ALTER TABLE `sim`
ADD CONSTRAINT `sim_ibfk_1` FOREIGN KEY (`codigo_sim_pre`) REFERENCES `prepago` (`codigo_sim`) ON UPDATE CASCADE,
ADD CONSTRAINT `sim_ibfk_2` FOREIGN KEY (`codigo_sim_dato`) REFERENCES `datos` (`codigo_sim`) ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

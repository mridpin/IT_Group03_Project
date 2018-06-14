-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-06-2018 a las 06:02:19
-- Versión del servidor: 10.1.21-MariaDB
-- Versión de PHP: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_it`
--
CREATE DATABASE IF NOT EXISTS `proyecto_it` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci;
USE `proyecto_it`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `actividades`
--

CREATE TABLE `actividades` (
  `fechaFin` date NOT NULL,
  `actividadId` int(11) NOT NULL,
  `tipo` varchar(56) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `notaMax` double NOT NULL,
  `nombre` varchar(256) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `profesorId` int(11) NOT NULL,
  `asignaturaId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `actividades`
--

INSERT INTO `actividades` (`fechaFin`, `actividadId`, `tipo`, `notaMax`, `nombre`, `profesorId`, `asignaturaId`) VALUES
('2018-06-16', 1, 'Proyecto', 5, 'Proyecto Final IT', 2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE `administradores` (
  `idUsuario` int(11) NOT NULL,
  `username` varchar(52) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `password` varchar(256) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`idUsuario`, `username`, `password`) VALUES
(2, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `idUsuario` int(11) NOT NULL,
  `username` varchar(52) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombre` varchar(32) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `apellidos` varchar(32) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `foto` varchar(256) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `password` varchar(256) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`idUsuario`, `username`, `nombre`, `apellidos`, `foto`, `password`) VALUES
(1, 'alu_vamarrod', 'Victor', 'Martinelli', 'files/images/fotos/usuarios/pic1.png', 'password'),
(2, 'alu_mridpin', 'Manuel', 'Ridao', 'files/images/fotos/usuarios/pic2.png', 'mridpin');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno_asignatura`
--

CREATE TABLE `alumno_asignatura` (
  `alumnoId` int(11) NOT NULL,
  `asignaturaId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `alumno_asignatura`
--

INSERT INTO `alumno_asignatura` (`alumnoId`, `asignaturaId`) VALUES
(1, 2),
(2, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignaturas`
--

CREATE TABLE `asignaturas` (
  `asignaturaId` int(11) NOT NULL,
  `notaMinima` double NOT NULL,
  `nAlumnos` int(11) NOT NULL,
  `semestre` varchar(56) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombre` varchar(256) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `curso` int(1) NOT NULL,
  `profesorId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `asignaturas`
--

INSERT INTO `asignaturas` (`asignaturaId`, `notaMinima`, `nAlumnos`, `semestre`, `nombre`, `curso`, `profesorId`) VALUES
(2, 5, 2, '1', 'Integración de Tecnologías', 1, 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aulas`
--

CREATE TABLE `aulas` (
  `aulaId` int(11) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `localizacion` varchar(256) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `asignaturaId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrega`
--

CREATE TABLE `entrega` (
  `alumnoId` int(11) NOT NULL,
  `actividadId` int(11) NOT NULL,
  `nota` double NOT NULL,
  `rutaArchivo` varchar(256) CHARACTER SET utf8 COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `material`
--

CREATE TABLE `material` (
  `materialId` int(11) NOT NULL,
  `rutaArchivo` varchar(256) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombre` varchar(256) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `asignaturaId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `material`
--

INSERT INTO `material` (`materialId`, `rutaArchivo`, `nombre`, `asignaturaId`) VALUES
(1, 'files\\asignaturas\\Integracion de Tecnologias\\epd\\CondicionesDeProyectos_IT_17_18.pdf', 'Condiciones de Proyectos Finales', 2),
(2, 'files\\asignaturas\\Integracion de Tecnologias\\eb\\tema1-1.pdf', 'Tema 1', 2);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensajes`
--

CREATE TABLE `mensajes` (
  `idMensaje` int(11) NOT NULL,
  `contenido` text COLLATE utf8mb4_spanish2_ci NOT NULL,
  `fecha` date NOT NULL,
  `remitenteId` int(11) NOT NULL,
  `destinatarioId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesores`
--

CREATE TABLE `profesores` (
  `idUsuario` int(11) NOT NULL,
  `username` varchar(52) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `horaTutoria` varchar(11) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `password` varchar(256) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombre` varchar(32) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `apellidos` varchar(124) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `foto` varchar(256) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

--
-- Volcado de datos para la tabla `profesores`
--

INSERT INTO `profesores` (`idUsuario`, `username`, `horaTutoria`, `password`, `nombre`, `apellidos`, `foto`) VALUES
(2, 'prof_ricardo', '08:50', 'password', 'Ricardo', 'Talavera', 'files/images/fotos/usuarios/pic4.png');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `actividades`
--
ALTER TABLE `actividades`
  ADD PRIMARY KEY (`actividadId`),
  ADD KEY `profesorId` (`profesorId`),
  ADD KEY `asignaturaId` (`asignaturaId`);

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indices de la tabla `alumno_asignatura`
--
ALTER TABLE `alumno_asignatura`
  ADD PRIMARY KEY (`alumnoId`,`asignaturaId`),
  ADD KEY `alumnoId` (`alumnoId`),
  ADD KEY `asignaturaId` (`asignaturaId`);

--
-- Indices de la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  ADD PRIMARY KEY (`asignaturaId`),
  ADD KEY `profesorId` (`profesorId`);

--
-- Indices de la tabla `aulas`
--
ALTER TABLE `aulas`
  ADD PRIMARY KEY (`aulaId`),
  ADD KEY `asignaturaId` (`asignaturaId`);

--
-- Indices de la tabla `entrega`
--
ALTER TABLE `entrega`
  ADD PRIMARY KEY (`alumnoId`,`actividadId`),
  ADD KEY `actividadId` (`actividadId`),
  ADD KEY `alumnoId` (`alumnoId`);

--
-- Indices de la tabla `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`materialId`),
  ADD KEY `asignaturaId` (`asignaturaId`);

--
-- Indices de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD PRIMARY KEY (`idMensaje`),
  ADD KEY `remitenteId` (`remitenteId`),
  ADD KEY `destinatarioId` (`destinatarioId`);

--
-- Indices de la tabla `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `actividades`
--
ALTER TABLE `actividades`
  MODIFY `actividadId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `administradores`
--
ALTER TABLE `administradores`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  MODIFY `asignaturaId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `aulas`
--
ALTER TABLE `aulas`
  MODIFY `aulaId` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `material`
--
ALTER TABLE `material`
  MODIFY `materialId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  MODIFY `idMensaje` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `profesores`
--
ALTER TABLE `profesores`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `actividades`
--
ALTER TABLE `actividades`
  ADD CONSTRAINT `actividades_ibfk_1` FOREIGN KEY (`profesorId`) REFERENCES `profesores` (`idUsuario`),
  ADD CONSTRAINT `actividades_ibfk_2` FOREIGN KEY (`asignaturaId`) REFERENCES `asignaturas` (`asignaturaId`);

--
-- Filtros para la tabla `alumno_asignatura`
--
ALTER TABLE `alumno_asignatura`
  ADD CONSTRAINT `alumno_asignatura_ibfk_1` FOREIGN KEY (`alumnoId`) REFERENCES `alumnos` (`idUsuario`),
  ADD CONSTRAINT `alumno_asignatura_ibfk_2` FOREIGN KEY (`asignaturaId`) REFERENCES `asignaturas` (`asignaturaId`);

--
-- Filtros para la tabla `asignaturas`
--
ALTER TABLE `asignaturas`
  ADD CONSTRAINT `asignaturas_ibfk_1` FOREIGN KEY (`profesorId`) REFERENCES `profesores` (`idUsuario`);

--
-- Filtros para la tabla `aulas`
--
ALTER TABLE `aulas`
  ADD CONSTRAINT `aulas_ibfk_1` FOREIGN KEY (`asignaturaId`) REFERENCES `asignaturas` (`asignaturaId`);

--
-- Filtros para la tabla `entrega`
--
ALTER TABLE `entrega`
  ADD CONSTRAINT `entrega_ibfk_1` FOREIGN KEY (`actividadId`) REFERENCES `actividades` (`actividadId`),
  ADD CONSTRAINT `entrega_ibfk_2` FOREIGN KEY (`alumnoId`) REFERENCES `alumnos` (`idUsuario`);

--
-- Filtros para la tabla `material`
--
ALTER TABLE `material`
  ADD CONSTRAINT `material_ibfk_1` FOREIGN KEY (`asignaturaId`) REFERENCES `asignaturas` (`asignaturaId`);

--
-- Filtros para la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD CONSTRAINT `mensajes_ibfk_1` FOREIGN KEY (`remitenteId`) REFERENCES `alumnos` (`idUsuario`),
  ADD CONSTRAINT `mensajes_ibfk_3` FOREIGN KEY (`destinatarioId`) REFERENCES `alumnos` (`idUsuario`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

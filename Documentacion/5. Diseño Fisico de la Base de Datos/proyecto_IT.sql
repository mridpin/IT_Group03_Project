-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2018 at 07:56 PM
-- Server version: 10.1.30-MariaDB
-- PHP Version: 7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `proyecto_it`
--
CREATE DATABASE IF NOT EXISTS `proyecto_it` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish2_ci;
USE `proyecto_it`;

-- --------------------------------------------------------

--
-- Table structure for table `actividades`
--

CREATE TABLE `actividades` (
  `fechaFin` date NOT NULL,
  `actividadId` int(11) NOT NULL,
  `tipo` varchar(56) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `notaMax` double NOT NULL,
  `nombre` varchar(256) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `profesorId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Table structure for table `actividad_alumno`
--

CREATE TABLE `actividad_alumno` (
  `alumnoId` int(11) NOT NULL,
  `actividadId` int(11) NOT NULL,
  `nota` double NOT NULL,
  `rutaArchivo` varchar(256) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Table structure for table `administradores`
--

CREATE TABLE `administradores` (
  `idUsuario` int(11) NOT NULL,
  `username` varchar(52) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `password` varchar(256) COLLATE utf8mb4_spanish2_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Table structure for table `alumnos`
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
-- Dumping data for table `alumnos`
--

INSERT INTO `alumnos` (`idUsuario`, `username`, `nombre`, `apellidos`, `foto`, `password`) VALUES
(1, 'test', 'test', 'test', '', 'D8E8FCA2DC0F896FD7CB4CB0031BA249');

-- --------------------------------------------------------

--
-- Table structure for table `alumno_asignatura`
--

CREATE TABLE `alumno_asignatura` (
  `alumnoId` int(11) NOT NULL,
  `asignaturaId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Table structure for table `asignaturas`
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
-- Dumping data for table `asignaturas`
--

INSERT INTO `asignaturas` (`asignaturaId`, `notaMinima`, `nAlumnos`, `semestre`, `nombre`, `curso`, `profesorId`) VALUES
(2, 5, 2, '1', 'Programación C', 1, 2);

-- --------------------------------------------------------

--
-- Table structure for table `aulas`
--

CREATE TABLE `aulas` (
  `aulaId` int(11) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `localizacion` varchar(256) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `asignaturaId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Table structure for table `material`
--

CREATE TABLE `material` (
  `materialId` int(11) NOT NULL,
  `rutaArchivo` varchar(256) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `nombre` varchar(256) COLLATE utf8mb4_spanish2_ci NOT NULL,
  `asignaturaId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish2_ci;

-- --------------------------------------------------------

--
-- Table structure for table `mensajes`
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
-- Table structure for table `profesores`
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
-- Dumping data for table `profesores`
--

INSERT INTO `profesores` (`idUsuario`, `username`, `horaTutoria`, `password`, `nombre`, `apellidos`, `foto`) VALUES
(2, 'MKHN', '08:50', 'A393BAE49DC6094B3E1AA1CEA969AB63', 'Mike', 'Hunt', '');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `actividades`
--
ALTER TABLE `actividades`
  ADD PRIMARY KEY (`actividadId`),
  ADD KEY `profesorId` (`profesorId`);

--
-- Indexes for table `actividad_alumno`
--
ALTER TABLE `actividad_alumno`
  ADD PRIMARY KEY (`alumnoId`,`actividadId`),
  ADD KEY `actividadId` (`actividadId`),
  ADD KEY `alumnoId` (`alumnoId`);

--
-- Indexes for table `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indexes for table `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`idUsuario`);

--
-- Indexes for table `alumno_asignatura`
--
ALTER TABLE `alumno_asignatura`
  ADD PRIMARY KEY (`alumnoId`,`asignaturaId`),
  ADD KEY `alumnoId` (`alumnoId`),
  ADD KEY `asignaturaId` (`asignaturaId`);

--
-- Indexes for table `asignaturas`
--
ALTER TABLE `asignaturas`
  ADD PRIMARY KEY (`asignaturaId`),
  ADD KEY `profesorId` (`profesorId`);

--
-- Indexes for table `aulas`
--
ALTER TABLE `aulas`
  ADD PRIMARY KEY (`aulaId`),
  ADD KEY `asignaturaId` (`asignaturaId`);

--
-- Indexes for table `material`
--
ALTER TABLE `material`
  ADD PRIMARY KEY (`materialId`),
  ADD KEY `asignaturaId` (`asignaturaId`);

--
-- Indexes for table `mensajes`
--
ALTER TABLE `mensajes`
  ADD PRIMARY KEY (`idMensaje`),
  ADD KEY `remitenteId` (`remitenteId`),
  ADD KEY `destinatarioId` (`destinatarioId`);

--
-- Indexes for table `profesores`
--
ALTER TABLE `profesores`
  ADD PRIMARY KEY (`idUsuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `actividades`
--
ALTER TABLE `actividades`
  MODIFY `actividadId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `administradores`
--
ALTER TABLE `administradores`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `asignaturas`
--
ALTER TABLE `asignaturas`
  MODIFY `asignaturaId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `aulas`
--
ALTER TABLE `aulas`
  MODIFY `aulaId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `material`
--
ALTER TABLE `material`
  MODIFY `materialId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `mensajes`
--
ALTER TABLE `mensajes`
  MODIFY `idMensaje` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `profesores`
--
ALTER TABLE `profesores`
  MODIFY `idUsuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `actividades`
--
ALTER TABLE `actividades`
  ADD CONSTRAINT `actividades_ibfk_1` FOREIGN KEY (`profesorId`) REFERENCES `profesores` (`idUsuario`);

--
-- Constraints for table `actividad_alumno`
--
ALTER TABLE `actividad_alumno`
  ADD CONSTRAINT `actividad_alumno_ibfk_1` FOREIGN KEY (`actividadId`) REFERENCES `actividades` (`actividadId`),
  ADD CONSTRAINT `actividad_alumno_ibfk_2` FOREIGN KEY (`alumnoId`) REFERENCES `alumnos` (`idUsuario`);

--
-- Constraints for table `alumno_asignatura`
--
ALTER TABLE `alumno_asignatura`
  ADD CONSTRAINT `alumno_asignatura_ibfk_1` FOREIGN KEY (`alumnoId`) REFERENCES `alumnos` (`idUsuario`),
  ADD CONSTRAINT `alumno_asignatura_ibfk_2` FOREIGN KEY (`asignaturaId`) REFERENCES `asignaturas` (`asignaturaId`);

--
-- Constraints for table `asignaturas`
--
ALTER TABLE `asignaturas`
  ADD CONSTRAINT `asignaturas_ibfk_1` FOREIGN KEY (`profesorId`) REFERENCES `profesores` (`idUsuario`);

--
-- Constraints for table `aulas`
--
ALTER TABLE `aulas`
  ADD CONSTRAINT `aulas_ibfk_1` FOREIGN KEY (`asignaturaId`) REFERENCES `asignaturas` (`asignaturaId`);

--
-- Constraints for table `material`
--
ALTER TABLE `material`
  ADD CONSTRAINT `material_ibfk_1` FOREIGN KEY (`asignaturaId`) REFERENCES `asignaturas` (`asignaturaId`);

--
-- Constraints for table `mensajes`
--
ALTER TABLE `mensajes`
  ADD CONSTRAINT `mensajes_ibfk_1` FOREIGN KEY (`remitenteId`) REFERENCES `alumnos` (`idUsuario`),
  ADD CONSTRAINT `mensajes_ibfk_3` FOREIGN KEY (`destinatarioId`) REFERENCES `alumnos` (`idUsuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

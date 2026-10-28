-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-10-2026 a las 03:04:31
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `cursos_bd`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `matricula` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `correo` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `alumnos`
--

INSERT INTO `alumnos` (`matricula`, `nombre`, `correo`) VALUES
(20230059, 'Benilde Mendez', '20230059@uthh.edu.mx'),
(20243132, 'Leon Larregui', '20243132@uthh.edu.mx'),
(20250994, 'Oswaldo Flores', '20250994@uthh.edu.mx'),
(20251030, 'Ariadna Mendez', '20251030@uthh.edu.mx'),
(20251031, 'Ayanami Meza', '20251031@uthh.edu.mx'),
(20251111, 'Alelhi Mendez Hernandez', '20251111@uthh.edu.mx'),
(20253010, 'Rindou Haitani', '20253010@uthh.edu.mx'),
(20262011, 'Mireles Mendez', '20262011@uthh.edu.mx');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrera`
--

CREATE TABLE `carrera` (
  `id_carrera` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `imagen_url` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `carrera`
--

INSERT INTO `carrera` (`id_carrera`, `nombre`, `imagen_url`) VALUES
(1, 'Desarrollo de Software Multiplataforma', 'https://barocomputacion.com.ar/sobre_nosotros.jpg'),
(2, 'Mecatronica', 'https://media.istockphoto.com/id/1439352646/es/vector/fabricaci%C3%B3n-y-rob%C3%B3tica.jpg?s=612x612&w=0&k=20&c=T1hMAF9_LbyuWatNi9ReF16LTy0YTxpENArgl7BBA3k='),
(3, 'Procesos Alimentarios', 'https://img.magnific.com/vector-gratis/ilustracion-fabricacion-alimentos-diseno-plano_23-2149486456.jpg?semt=ais_hybrid&w=740&q=80'),
(4, 'Agrobiotecnologia', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS6vKNGtIOaSzFOaJOIWknQx_Y5aMpgYLIDgUbJWBWLCxeX9buZ_ciYsweX&s=10'),
(5, 'Metal Mecanica', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQCslqWe434j47khIQLPqy0oHZyHo2Wr_uY8fJ37aBI2w&s=10'),
(6, 'Civil', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTBQtgvkLcihSyq9dzkP-DlfBJoWBnZScKVzHzgij4Wiw&s=10'),
(7, 'Mercadotecnia', 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVTrro1HIfHNw1FBBcQkGnZYMzRLA9KYT5hnkfZLl-eA&s=10');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cursos`
--

CREATE TABLE `cursos` (
  `id_cursos` int(11) NOT NULL,
  `nombre` varchar(100) NOT NULL,
  `descripcion` text DEFAULT NULL,
  `espacio` varchar(100) DEFAULT NULL,
  `horas` int(11) DEFAULT NULL,
  `dias` varchar(100) DEFAULT NULL,
  `cupo` int(11) DEFAULT NULL,
  `imagen_url` varchar(500) DEFAULT NULL,
  `id_carrera` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cursos`
--

INSERT INTO `cursos` (`id_cursos`, `nombre`, `descripcion`, `espacio`, `horas`, `dias`, `cupo`, `imagen_url`, `id_carrera`) VALUES
(1, 'Programacion Avanzada', 'El objetivo principal es transicionar de escribir código funcional a construir sistemas robustos, mantenibles y eficientes. A lo largo del programa, se abordan patrones de diseño, optimización de algoritmos, programación concurrente, testing avanzado y prácticas de entrega continua (CI/CD).', 'Edificio C', 80, 'Lunes,Miercoles y Viernes', 50, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReS2pNaGkFc4zW9xJiRvAIOZfFn7MJWC-FR0nRLglleYSGql7vXGpo_-oH&s=10', 1),
(2, 'Bases De datos', 'El objetivo principal es transicionar del uso básico de consultas SQL a la gestión estratégica del almacenamiento, rendimiento y escalabilidad de datos. A lo largo del programa, se abordan desde la optimización interna del motor y la gestión de concurrencia, hasta la implementación de almacenes de datos (Data Warehouses) y sistemas distribuidos.', 'Salon A-102', 30, 'Martes y Jueves', 50, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTrrTv2mzsdkq_DU5-OnRDUMqeLlxNHX_KblhNoe6vl5Q&s=10', 1),
(7, 'Desarrollo Web Full Stack', 'El objetivo principal es aprender a desarrollar aplicaciones web modernas de principio a fin usando frameworks actuales.', 'Laboratorio de Cómputo 1', 60, 'Lunes y Miércoles', 30, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR4Y0UkGf6R_nya8X2p5_sttb079G0OgpZSxY0uy2en5Q&s=10', 1),
(8, 'Programación Móvil Multiplataforma', 'El objetivo principal es crear aplicaciones para Android e iOS compartiendo una misma base de código.', 'Laboratorio de Cómputo 2', 50, 'Martes y Jueves', 25, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS154-OJP6ki8lDQeVSBkM6sp2IJJUwk8nhqTaPx8jAvQ&s=10', 1),
(9, 'Arquitectura de Software y Patrones', 'El objetivo principal es diseñar sistemas escalables aplicando patrones de diseño y buenas prácticas.', 'Edificio C', 40, 'Viernes', 35, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSgbCkD2Ug74cVklLGycfZlzuL71H5HJcuhS--9AsTyVg&s=10', 1),
(10, 'Seguridad en Aplicaciones Web', 'El objetivo principal es identificar y corregir vulnerabilidades comunes en el desarrollo de software.', 'Salon A-102', 30, 'Sábado', 30, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcThB9ybPKxoRsQvMCFBYUF6YinklhxToUZdC-9OB49y4w&s=10', 1),
(11, 'Sistemas Neumáticos e Hidráulicos', 'El objetivo principal es diseñar y mantener sistemas de automatización industrial mediante fluidos.', 'Taller de Mecatrónica', 45, 'Lunes, Miércoles y Viernes', 20, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQYHabJAr8kEsE5JGQXXVT2DTlG7JigJWQ7GpoqbNIy2Q&s=10', 2),
(12, 'Programación de PLCs', 'El objetivo principal es programar controladores lógicos programables para líneas de producción automatizadas.', 'Laboratorio de Automatización', 60, 'Martes y Jueves', 20, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTts87F5S6hSWLsfn644eKiLhzNf18RO3NbIu_AvbZMaQ&s=10', 2),
(13, 'Robótica Industrial y Manipuladores', 'El objetivo principal es configurar y programar brazos robóticos para tareas de ensamblaje.', 'Taller Pesado 1', 50, 'Lunes y Miércoles', 15, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRcVTOp37_drUTqZVaLbVP9ysjtBZ8Wyv-URsZKIMC4yQ&s=10', 2),
(14, 'Diseño y Simulación CAD/CAM', 'El objetivo principal es modelar piezas mecánicas y simular su fabricación en maquinaria CNC.', 'Laboratorio de Cómputo 3', 40, 'Viernes', 25, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSqKlawaCVCRPhd32EbXlkrSUOUhQN_Y0BbI7xxCIAE1Q&s=10', 2),
(15, 'Microbiología e Higiene de Alimentos', 'El objetivo principal es garantizar la inocuidad alimentaria aplicando normas de higiene y control microbiológico.', 'Laboratorio de Biología', 40, 'Lunes y Miércoles', 20, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcReb6kO9U1VOQrarJgDwT-iSd0t1jjKj78yXeMTK2r_vQ&s=10', 3),
(16, 'Tecnología de Conservación de Alimentos', 'El objetivo principal es aplicar técnicas térmicas y no térmicas para prolongar la vida útil de los productos.', 'Planta Piloto 1', 50, 'Martes y Jueves', 20, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQrY3w22hGb408uUCeYiOYEg6mUSbVhUC-XhKECYHSDnA&s=10', 3),
(17, 'Control de Calidad Alimentaria', 'El objetivo principal es evaluar parámetros fisioquímicos y organolépticos en productos procesados.', 'Laboratorio de Química', 30, 'Viernes', 25, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSO2SnUyn_CtYhKx3-v2p9FdGEUTdrK-1M9KcMGgtmYag&s=10', 3),
(18, 'Desarrollo e Innovación de Nuevos Productos', 'El objetivo principal es diseñar formulaciones alimentarias respondiendo a las tendencias del mercado.', 'Planta Piloto 2', 45, 'Sábado', 15, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQyHTg1LdRqv_wjUayS2JW47yISy-zFOnHfB6fjfzPiFQ&s=10', 3),
(19, 'Cultivo de Tejidos Vegetales', 'El objetivo principal es multiplicar plantas in vitro bajo condiciones de esterilidad y control de nutrientes.', 'Laboratorio de Biotecnología', 50, 'Lunes, Miércoles y Viernes', 15, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRoOg-l7uM57mlwSX7JZJBIgIwBWXbv3DxfFVaR_R0aBw&s=10', 4),
(20, 'Técnicas de Biología Molecular Vegetal', 'El objetivo principal es analizar ADN vegetal para la identificación de rasgos genéticos de interés.', 'Laboratorio de Genética', 60, 'Martes y Jueves', 15, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7cyT_uka-uJQr53FCa9YjHTUYgf52DEMxaHDoGzeDVA&s=10', 4),
(21, 'Manejo Biorregional de Plagas y Enfermedades', 'El objetivo principal es implementar bioinsumos y control biológico en cultivos agrícolas.', 'Invernadero 1', 40, 'Lunes y Miércoles', 25, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR0L4B5rzcsFhEygJKfI_De1Kj4fENoPW0qGIuVuD--7A&s=10', 4),
(22, 'Producción de Biofertilizantes y Compostaje', 'El objetivo principal es formular fertilizantes orgánicos a partir de residuos agropecuarios.', 'Campo Experimental', 35, 'Sábado', 30, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQseNPQ912G7WUh2tVasLFfUKU8U8-UYxNowgXgpV9opQ&s=10', 4),
(23, 'Mecanizado por Control Numérico (CNC)', 'El objetivo principal es operar tornos y fresadoras CNC mediante programación de código G.', 'Taller de Maquinados', 60, 'Lunes, Miércoles y Viernes', 15, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQFIRpC2ZtKb_ZmHVKCQHAKGXUHIr2diPFrss1UqpiJOQ&s=10', 5),
(24, 'Procesos de Soldadura Avanzada', 'El objetivo principal es dominar técnicas de soldadura TIG, MIG y MAG según normas internacionales.', 'Taller de Soldadura', 50, 'Martes y Jueves', 20, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQtCJ6PZLpy6WEH3smFHXACqo7QkPvTnA76yCRV7BhwhQ&s=10', 5),
(25, 'Metrología Dimensional y Ensayos', 'El objetivo principal es utilizar instrumentos de precisión para el control dimensional de piezas metálicas.', 'Laboratorio de Metrología', 30, 'Viernes', 25, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcShSK10qca4uMQvMMP8D0aWNoF5DWKfs3EnG5hmxORCXQ&s=10', 5),
(26, 'Ensayos No Destructivos (END)', 'El objetivo principal es detectar defectos internos y superficiales en materiales metálicos.', 'Taller Pesado 2', 40, 'Sábado', 20, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQybjlLBpPeoNAx-0YThECFR729GVUjI0zHg8yUprdhWw&s=10', 5),
(27, 'Topografía y Fotogrametría con Drones', 'El objetivo principal es realizar levantamientos topográficos y modelos digitales del terreno.', 'Campo Abierto / Lab 4', 50, 'Lunes y Miércoles', 25, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSbpt1BFMNV_InyrQQbiPR0Q1mhWKBGXaEndN0Cq0iIkA&s=10', 6),
(28, 'Diseño y Análisis Estructural', 'El objetivo principal es calcular y modelar estructuras de concreto y acero para edificaciones.', 'Laboratorio de Cómputo 2', 60, 'Martes y Jueves', 30, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRvRcsxteV812CiTRR66549TeLJ-luLR8ouIIKjI0rZzQ&s=10', 6),
(29, 'Mecánica de Suelos y Cimentaciones', 'El objetivo principal es determinar las propiedades físicas y mecánicas del suelo para soporte de cargas.', 'Laboratorio de Suelos', 45, 'Viernes', 20, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSrHTKreIhbcCDW198KxCQAuz3N9oLpJlhFgN57UFC8yw&s=10', 6),
(30, 'Administración y Estimación de Obras', 'El objetivo principal es elaborar presupuestos, programar trabajos y gestionar costos de construcción.', 'Edificio B', 40, 'Sábado', 35, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS0JuX-VOi9wjQztIi7la-Vhw1FAylwIza8TZvJ6pXNCA&s=10', 6),
(31, 'Marketing Digital y SEO/SEM', 'El objetivo principal es diseñar estrategias de posicionamiento web y gestión de campañas publicitarias.', 'Laboratorio de Cómputo 1', 40, 'Lunes y Miércoles', 30, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSig9gxh20dVspjVXGKOCMHMM2jnFZZS3oXbb4_YA7idg&s=10', 7),
(32, 'Investigación de Mercados y Métricas', 'El objetivo principal es recolectar y analizar datos del consumidor para la toma de decisiones.', 'Edificio A', 50, 'Martes y Jueves', 35, 'https://www.hubspot.com/hubfs/media/investigacionmercado.jpeg', 7),
(33, 'Estrategias de Branding y Posicionamiento', 'El objetivo principal es construir e impulsar la identidad de una marca en entornos competitivos.', 'Salon B-103', 35, 'Viernes', 40, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT8lSmrb4K3LMxaXx7MQ6a_91XJ3RfUnkAZusELRnBGPw&s=10', 7),
(34, 'Gestión de Redes Sociales y Content Marketing', 'El objetivo principal es planificar y crear contenido relevante para atraer y fidelizar audiencias.', 'Laboratorio de Cómputo 3', 30, 'Sábado', 30, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRQYgKkMarHjGDKhWDwaYxH7MVFeghWUul2nHdko83_0g&s=10', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `inscripcion`
--

CREATE TABLE `inscripcion` (
  `id_inscripcion` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `matricula` int(11) NOT NULL,
  `id_cursos` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `inscripcion`
--

INSERT INTO `inscripcion` (`id_inscripcion`, `fecha`, `matricula`, `id_cursos`) VALUES
(5, '2026-10-22', 20251030, 1),
(6, '2025-10-15', 20230059, 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`matricula`);

--
-- Indices de la tabla `carrera`
--
ALTER TABLE `carrera`
  ADD PRIMARY KEY (`id_carrera`);

--
-- Indices de la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD PRIMARY KEY (`id_cursos`),
  ADD KEY `id_carrera` (`id_carrera`);

--
-- Indices de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD PRIMARY KEY (`id_inscripcion`),
  ADD KEY `matricula` (`matricula`),
  ADD KEY `id_cursos` (`id_cursos`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  MODIFY `matricula` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20262012;

--
-- AUTO_INCREMENT de la tabla `carrera`
--
ALTER TABLE `carrera`
  MODIFY `id_carrera` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `cursos`
--
ALTER TABLE `cursos`
  MODIFY `id_cursos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

--
-- AUTO_INCREMENT de la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  MODIFY `id_inscripcion` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cursos`
--
ALTER TABLE `cursos`
  ADD CONSTRAINT `cursos_ibfk_1` FOREIGN KEY (`id_carrera`) REFERENCES `carrera` (`id_carrera`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Filtros para la tabla `inscripcion`
--
ALTER TABLE `inscripcion`
  ADD CONSTRAINT `inscripcion_ibfk_1` FOREIGN KEY (`matricula`) REFERENCES `alumnos` (`matricula`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `inscripcion_ibfk_2` FOREIGN KEY (`id_cursos`) REFERENCES `cursos` (`id_cursos`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

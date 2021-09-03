-- CREATE DB
CREATE DATABASE IF NOT EXISTS procesos_ingenieria;
-- CREATE DATABASE IF NOT EXISTS PROCESOS_INGENIERIA;
USE procesos_ingenieria;

--
-- Table structure for table `tipo_solicitud`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE IF NOT EXISTS `tipo_solicitud` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_solicitud`
--

LOCK TABLES `tipo_solicitud` WRITE;
/*!40000 ALTER TABLE `tipo_solicitud` DISABLE KEYS */;
/*!40000 ALTER TABLE `tipo_solicitud` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `etapa_solicitud`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE IF NOT EXISTS `etapa_solicitud` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `tipo_solicitud_fk` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ETAPA_SOLICITUD_id_IDX` (`id`) USING BTREE,
  KEY `ETAPA_TIPO_SOLICITUD_FK` (`tipo_solicitud_fk`),
  CONSTRAINT `ETAPA_TIPO_SOLICITUD_FK` FOREIGN KEY (`tipo_solicitud_fk`) REFERENCES `tipo_solicitud` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `etapa_solicitud`
--

LOCK TABLES `etapa_solicitud` WRITE;
/*!40000 ALTER TABLE `etapa_solicitud` DISABLE KEYS */;
/*!40000 ALTER TABLE `etapa_solicitud` ENABLE KEYS */;
UNLOCK TABLES;


--
-- Table structure for table `acta_complemento`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE IF NOT EXISTS `acta_complemento` (
  `id` int NOT NULL AUTO_INCREMENT,
  `estudiante_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `docente_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `secretaria_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `coordinador_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `etapa_solicitud_fk` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `ACTA_COMPLEMENTO_FK` (`etapa_solicitud_fk`),
  CONSTRAINT `ACTA_COMPLEMENTO_FK` FOREIGN KEY (`etapa_solicitud_fk`) REFERENCES `etapa_solicitud` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `acta_complemento`
--

LOCK TABLES `acta_complemento` WRITE;
/*!40000 ALTER TABLE `acta_complemento` DISABLE KEYS */;
/*!40000 ALTER TABLE `acta_complemento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cuarta_oportunidad`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE IF NOT EXISTS `cuarta_oportunidad` (
  `id` int NOT NULL AUTO_INCREMENT,
  `estudiante_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `curso_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `secretaria_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `coordinador_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `etapa_solicitud_fk` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `CUARTA_OPORTUNIDAD_FK` (`etapa_solicitud_fk`),
  CONSTRAINT `CUARTA_OPORTUNIDAD_FK` FOREIGN KEY (`etapa_solicitud_fk`) REFERENCES `etapa_solicitud` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cuarta_oportunidad`
--

LOCK TABLES `cuarta_oportunidad` WRITE;
/*!40000 ALTER TABLE `cuarta_oportunidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `cuarta_oportunidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `desasignacion`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE IF NOT EXISTS `desasignacion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha_inicio` date NOT NULL,
  `estado` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `estudiante_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `curso_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `docente_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `secretaria_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `coordinador_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `etapa_solicitud_fk` FOREIGN KEY (`id`) REFERENCES `etapa_solicitud` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `desasignacion`
--

LOCK TABLES `desasignacion` WRITE;
/*!40000 ALTER TABLE `desasignacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `desasignacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dictamen_cierre`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE IF NOT EXISTS `dictamen_cierre` (
  `id` int NOT NULL AUTO_INCREMENT,
  `estudiante_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `coordinador_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `secretaria_id` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nota` double DEFAULT NULL,
  `etapa_solicitud_fk` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `DICTAMEN_CIERRE_FK` (`etapa_solicitud_fk`),
  CONSTRAINT `DICTAMEN_CIERRE_FK` FOREIGN KEY (`etapa_solicitud_fk`) REFERENCES `etapa_solicitud` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dictamen_cierre`
--

LOCK TABLES `dictamen_cierre` WRITE;
/*!40000 ALTER TABLE `dictamen_cierre` DISABLE KEYS */;
/*!40000 ALTER TABLE `dictamen_cierre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dictamen_equivalencia`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE IF NOT EXISTS `dictamen_equivalencia` (
  `id` int NOT NULL AUTO_INCREMENT,
  `estudiante_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `docente_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `secretaria_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `coordinador_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nota` double NOT NULL,
  `etapa_solicitud_fk` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `DICTAMEN_EQUIVALENCIA_FK` (`etapa_solicitud_fk`),
  CONSTRAINT `DICTAMEN_EQUIVALENCIA_FK` FOREIGN KEY (`etapa_solicitud_fk`) REFERENCES `etapa_solicitud` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dictamen_equivalencia`
--

LOCK TABLES `dictamen_equivalencia` WRITE;
/*!40000 ALTER TABLE `dictamen_equivalencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `dictamen_equivalencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documento_acta`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE IF NOT EXISTS `documento_acta` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id_acta_fk` int NOT NULL,
  `link` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `DOCUMENTO_ACTA_FK` (`id_acta_fk`),
  CONSTRAINT `DOCUMENTO_ACTA_FK` FOREIGN KEY (`id_acta_fk`) REFERENCES `acta_complemento` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento_acta`
--

LOCK TABLES `documento_acta` WRITE;
/*!40000 ALTER TABLE `documento_acta` DISABLE KEYS */;
/*!40000 ALTER TABLE `documento_acta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documento_cierre`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE IF NOT EXISTS `documento_cierre` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `link_doc` varchar(100) NOT NULL,
  `id_cierre_fk` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `DOCUMENTO_CIERRE_FK` (`id_cierre_fk`),
  CONSTRAINT `DOCUMENTO_CIERRE_FK` FOREIGN KEY (`id_cierre_fk`) REFERENCES `dictamen_cierre` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento_cierre`
--

LOCK TABLES `documento_cierre` WRITE;
/*!40000 ALTER TABLE `documento_cierre` DISABLE KEYS */;
/*!40000 ALTER TABLE `documento_cierre` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documento_cuarta_oportunidad`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE IF NOT EXISTS `documento_cuarta_oportunidad` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `link` varchar(100) NOT NULL,
  `id_cuarta_oportunidad_fk` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `DOCUMENTO_CUARTA_OPORTUNIDAD_FK` (`id_cuarta_oportunidad_fk`),
  CONSTRAINT `DOCUMENTO_CUARTA_OPORTUNIDAD_FK` FOREIGN KEY (`id_cuarta_oportunidad_fk`) REFERENCES `cuarta_oportunidad` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento_cuarta_oportunidad`
--

LOCK TABLES `documento_cuarta_oportunidad` WRITE;
/*!40000 ALTER TABLE `documento_cuarta_oportunidad` DISABLE KEYS */;
/*!40000 ALTER TABLE `documento_cuarta_oportunidad` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `documento_equivalencia`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE IF NOT EXISTS `documento_equivalencia` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `id_equivalencia_fk` int NOT NULL,
  `link_documento` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `DOCUMENTO_EQUIVALENCIA_FK` (`id_equivalencia_fk`),
  CONSTRAINT `DOCUMENTO_EQUIVALENCIA_FK` FOREIGN KEY (`id_equivalencia_fk`) REFERENCES `dictamen_equivalencia` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `documento_equivalencia`
--

LOCK TABLES `documento_equivalencia` WRITE;
/*!40000 ALTER TABLE `documento_equivalencia` DISABLE KEYS */;
/*!40000 ALTER TABLE `documento_equivalencia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `extraordinario`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE IF NOT EXISTS `extraordinario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `fecha_inicio` date NOT NULL,
  `estado` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `estudiante_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `docente_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `secretaria_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `coordinador_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `etapa_solicitud_fk` int NOT NULL,
  `curso_id` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `EXTRAORDINARIO_FK` (`etapa_solicitud_fk`),
  CONSTRAINT `EXTRAORDINARIO_FK` FOREIGN KEY (`etapa_solicitud_fk`) REFERENCES `etapa_solicitud` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `extraordinario`
--

LOCK TABLES `extraordinario` WRITE;
/*!40000 ALTER TABLE `extraordinario` DISABLE KEYS */;
/*!40000 ALTER TABLE `extraordinario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `notificacion`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE IF NOT EXISTS `notificacion` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` int NOT NULL,
  `fecha` date NOT NULL,
  `leido` tinyint NOT NULL,
  `informacion` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `enlace` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `notificacion`
--

LOCK TABLES `notificacion` WRITE;
/*!40000 ALTER TABLE `notificacion` DISABLE KEYS */;
/*!40000 ALTER TABLE `notificacion` ENABLE KEYS */;
UNLOCK TABLES;



--
-- Table structure for table `variable_global`
--

/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE IF NOT EXISTS `variable_global` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `valor_num` double DEFAULT NULL,
  `valor_txt` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `variable_global`
--

LOCK TABLES `variable_global` WRITE;
/*!40000 ALTER TABLE `variable_global` DISABLE KEYS */;
/*!40000 ALTER TABLE `variable_global` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'PROCESOS_INGENIERIA'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-08-26 18:21:39

-- MySQL dump 10.13  Distrib 5.7.18, for Win64 (x86_64)
--
-- Host: localhost    Database: board
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `board_movie`
--

DROP TABLE IF EXISTS `board_movie`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board_movie` (
  `bno` int(11) NOT NULL AUTO_INCREMENT,
  `movie` varchar(20) NOT NULL,
  `subject` varchar(100) NOT NULL,
  `content` text NOT NULL,
  `writer` varchar(50) NOT NULL,
  `reg_date` datetime NOT NULL,
  `hit` int(11) DEFAULT NULL,
  `recommand` int(11) DEFAULT NULL,
  `thumbnail` text NOT NULL,
  PRIMARY KEY (`bno`)
) ENGINE=InnoDB AUTO_INCREMENT=99 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board_movie`
--

LOCK TABLES `board_movie` WRITE;
/*!40000 ALTER TABLE `board_movie` DISABLE KEYS */;
INSERT INTO `board_movie` VALUES (75,'레옹','신기하네여','ㅇㅇ','탈','2017-06-16 02:39:56',67,31,'http://t1.search.daumcdn.net/thumb/R438x0.q85/?fname=http%3A%2F%2Fcfile16.uf.daum.net%2Fimage%2F163C224D51497169173CB1'),(91,'안녕','안녕','안녕못해요','강석원','2017-06-16 12:58:22',3,0,'http://t1.search.daumcdn.net/thumb/R438x0.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F0bf028a32e03fb766980271a737efe09205936d2'),(92,'다크 나이트','닼닼','닼크템플러','강석원','2017-06-16 12:58:40',9,3,'http://t1.search.daumcdn.net/thumb/R438x0.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F035e869913ccc58745ef993114994f3ae86c22f3'),(93,'카','자동차','자동차아아아','강석원','2017-06-16 12:59:19',11,8,'http://t1.search.daumcdn.net/thumb/R438x0.q85/?fname=http%3A%2F%2Fcfile89.uf.daum.net%2Fimage%2F11110210A8FC9EC6E53FAF'),(94,'바이','바이바이바이','안녕','이익전','2017-06-16 13:04:33',0,0,'http://t1.search.daumcdn.net/thumb/R438x0.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F22761a66d00b6d88caa96454c9b5991d3a7b9f0f'),(95,'미이라','으악 미이라다','도망가자','이익전','2017-06-16 13:04:50',11,9,'http://t1.search.daumcdn.net/thumb/R438x0.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fmovie%2F0b2fe18aac7f509bac2fa8c43552e2548634eb74'),(96,'디 엣지','엣지있네요','엣지!','강석원','2017-06-16 13:22:59',4,0,'http://t1.search.daumcdn.net/thumb/R438x0.q85/?fname=http%3A%2F%2Ft1.daumcdn.net%2Fmovie%2Fe7bc0890b570fab07b0806b0237db799eafb7afa'),(97,'투모로우','추워라','춥다!','이익전','2017-06-16 15:04:02',31,2,'http://t1.search.daumcdn.net/thumb/R438x0.q85/?fname=http%3A%2F%2Fcfile89.uf.daum.net%2Fimage%2F15110210A908CC0F663E87');
/*!40000 ALTER TABLE `board_movie` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `board_pro`
--

DROP TABLE IF EXISTS `board_pro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `board_pro` (
  `bno` int(11) NOT NULL AUTO_INCREMENT,
  `subject` varchar(50) NOT NULL,
  `content` text NOT NULL,
  `writer` varchar(50) NOT NULL,
  `reg_date` datetime NOT NULL,
  `hit` int(11) DEFAULT NULL,
  PRIMARY KEY (`bno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `board_pro`
--

LOCK TABLES `board_pro` WRITE;
/*!40000 ALTER TABLE `board_pro` DISABLE KEYS */;
INSERT INTO `board_pro` VALUES (2,'두번째','ㅎㅇ','강석원입니다','2017-06-12 00:36:46',7),(3,'ㅁㄴㅇ','ㅁㄴㅇ','ㅁㄴㅇ','2017-06-12 00:47:09',3);
/*!40000 ALTER TABLE `board_pro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reply` (
  `bno` int(11) NOT NULL AUTO_INCREMENT,
  `board_bno` int(11) NOT NULL,
  `content` text NOT NULL,
  `writer` varchar(50) NOT NULL,
  `reg_date` datetime NOT NULL,
  PRIMARY KEY (`bno`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES (21,75,'그래 이게 컨텐츠고','이게 작성자지','2017-06-16 03:17:45'),(25,97,'개추웡','이익전','2017-06-16 15:07:16');
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `userId` varchar(10) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES ('강석원','1234','강석원'),('김재현','1234','rlawogus'),('이익전','1234','이익전');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-19 17:34:15

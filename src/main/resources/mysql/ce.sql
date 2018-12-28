-- MySQL dump 10.13  Distrib 5.5.60, for Win64 (AMD64)
--
-- Host: localhost    Database: db_supermarket
-- ------------------------------------------------------
-- Server version	5.5.60-log

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
-- Table structure for table `t_admin`
--

DROP TABLE IF EXISTS `t_admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_admin` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `job_id` bigint(20) DEFAULT NULL COMMENT '工号',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `name` varchar(45) DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(1000) DEFAULT NULL COMMENT '头像',
  `address` varchar(500) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_admin`
--

LOCK TABLES `t_admin` WRITE;
/*!40000 ALTER TABLE `t_admin` DISABLE KEYS */;
INSERT INTO `t_admin` VALUES (1,10001036,'aaa111','亢悦欣','https://upload.jianshu.io/users/upload_avatars/6305091/dc5b863a-26fc-47df-af32-18177f6cc9ff.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/180/h/180','山西'),(2,10001174,'bbb222','刘恋','https://upload.jianshu.io/users/upload_avatars/6305091/dc5b863a-26fc-47df-af32-18177f6cc9ff.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/180/h/180','贵州'),(3,10001245,'ccc333','姚思佳','https://upload.jianshu.io/users/upload_avatars/7663825/7c28763e-002b-4e89-8dea-5b8da210ef2c.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/180/h/180','浙江'),(4,111,'222','郭瑞昌','https://upload.jianshu.io/users/upload_avatars/7416466/fc1a1a0d-e3c7-4bca-9720-028c5c9914f3.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/180/h/180','山西'),(5,10001495,'eee555','王龙傲','https://upload.jianshu.io/users/upload_avatars/607979/314ec609-a72c-43e7-bf49-7dcc83917cf9.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/180/h/180','江苏');
/*!40000 ALTER TABLE `t_admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_detail`
--

DROP TABLE IF EXISTS `t_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_detail` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `receiptId` bigint(100) DEFAULT NULL COMMENT '小票id',
  `barcode` bigint(100) DEFAULT NULL COMMENT '条码',
  `amount` int(11) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_detail`
--

LOCK TABLES `t_detail` WRITE;
/*!40000 ALTER TABLE `t_detail` DISABLE KEYS */;
INSERT INTO `t_detail` VALUES (1,201501,1003257403,8),(2,201704,1003257417,15),(3,201805,1006432704,21),(4,201704,1006432707,18);
/*!40000 ALTER TABLE `t_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_goods`
--

DROP TABLE IF EXISTS `t_goods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_goods` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type_id` bigint(20) DEFAULT NULL COMMENT '所属类别编号',
  `barcode` bigint(100) DEFAULT NULL COMMENT '条码',
  `name` varchar(500) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `price` double DEFAULT NULL COMMENT '价格',
  `vip` double DEFAULT NULL COMMENT '会员价',
  `description` varchar(1000) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `picture` varchar(500) DEFAULT NULL COMMENT '图片',
  `inventory` int(11) DEFAULT NULL COMMENT '库存',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=807 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_goods`
--

LOCK TABLES `t_goods` WRITE;
/*!40000 ALTER TABLE `t_goods` DISABLE KEYS */;
INSERT INTO `t_goods` VALUES (1,1,1003257401,'苹果',39.9,38.9,'烟台红富士苹果 12个 净重2.6kg以上 单果190-240g 一二级混装 自营水果','https://img11.360buyimg.com/n7/jfs/t23839/6/2329458134/547797/e0c3ca7d/5b7cb504Ne746d2e6.jpg',622),(2,1,1003257402,'柑橘',53.9,52.9,'四川眉山爱媛38号果冻橙柑橘 橘子 2.5kg装 单果110g以上 新鲜水果','https://img10.360buyimg.com/n7/jfs/t24661/95/2048368562/124719/5aaf482/5be7f676Nc6ee899e.jpg',523),(3,1,1003257403,'猕猴桃',42.9,41.9,'京东生鲜 陕西眉县 徐香绿心猕猴桃 22个板盒装 单果90-105g 新鲜水果','https://img13.360buyimg.com/n7/jfs/t23227/304/2115400247/139827/ca0ef0f6/5b7518c9N1ee4b506.jpg',214),(4,1,1003257404,'柚子',29.8,28.8,'华润五丰 精品琯溪蜜柚 红心柚子2粒 1.8kg-2.5kg 新鲜水果','https://img13.360buyimg.com/n7/jfs/t7612/257/4647780317/207471/cc4a9f4/59ff2358N51bdb6fc.jpg',357),(5,1,1003257405,'脐橙',97,96,'江西赣南脐橙 精品钻石大果 现摘橙子','https://img11.360buyimg.com/n7/jfs/t24739/234/1942483743/497442/3c6bf517/5bbf2f79N3c0becb1.jpg',415),(6,1,1003257406,'车厘子',66.9,65.9,'智利进口车厘子J级 1磅装 果径约26-28mm 新鲜水果','https://img11.360buyimg.com/n7/jfs/t1/23066/27/1942/408290/5c17425fE3521bcc3/ba50a344362d2af6.jpg',623),(7,1,1003257407,'甘蔗',41,40,'陶山甘蔗 青皮甘蔗 新鲜甘蔗水果绿皮果蔗1箱约6斤','https://img11.360buyimg.com/n7/jfs/t11593/187/337317923/328603/f360b770/59ed85cfN783bc36e.jpg',77),(8,1,1003257408,'牛油果',34.9,32.8,'进口 牛油果 6个装 单果重约130-180g 新鲜水果','https://img10.360buyimg.com/n7/jfs/t10945/175/2172045473/162582/5bf301ef/59f05afdN3c13f6ed.jpg',342),(9,1,1003257409,'火龙果',46.9,45.8,'越南进口红心火龙果 4个装 单果约330-420g 新鲜水果','https://img12.360buyimg.com/n7/jfs/t26575/223/1308050262/395693/66e2d658/5bc69bcfN8030a03e.jpg',252),(11,1,1003257411,'柿子',69,68,'什谷丰 平谷直发 甜软柿子 磨盘柿子 盖柿礼盒 12个装 香甜多汁','https://img12.360buyimg.com/n7/jfs/t26191/343/841626043/388463/af02a746/5bbacf62N4f01d337.jpg',351),(12,1,1003257412,'梨',14.9,13.9,'新疆库尔勒香梨 特级香梨 精选大果 6个装 约750g 新鲜水果','https://img12.360buyimg.com/n7/jfs/t21961/208/223754156/167683/d428e57c/5b053bf6N3e06d6bd.jpg',415),(13,1,1003257413,'提子',23.9,22.9,'国产红提 1kg装 新鲜水果','https://img12.360buyimg.com/n7/jfs/t22003/97/818334894/98541/82b771cd/5b191167N397d4ff5.jpg',665),(14,1,1003257414,'芒果',24.9,23.9,'广西高乐蜜芒果4个装 单果250g以上 新鲜水果','https://img11.360buyimg.com/n7/jfs/t1/6878/34/6606/205505/5be11742E8158179e/3c59fe8440c05e15.jpg',352),(15,1,1003257415,'木瓜',39.6,32.8,'DOLE都乐 菲律宾进口 非转基因木瓜2个装 (单果＞500g) 新鲜水果','https://img12.360buyimg.com/n2/jfs/t6046/199/8584378586/77178/88b484cd/598ad81aNa4dc9c3a.jpg',184),(16,1,1003257416,'石榴',29.8,28.9,'番石榴红心 红心芭乐 台湾新鲜芭乐 新鲜水果 孕妇水果红心芭乐5斤装','https://img12.360buyimg.com/n2/jfs/t26923/229/2278521880/129730/fb691af5/5bfea71aN28106a4b.jpg',124),(17,1,1003257417,'车厘茄',59.76,49.8,'Member\'s Mark 车厘茄1.5kg 新鲜蔬菜水果','https://img12.360buyimg.com/n2/jfs/t27517/79/2309688322/90183/6678804b/5bfcc17bNb828270c.jpg',424),(18,1,1003257418,'枇杷',49.9,49.9,'四川米易枇杷 新鲜水果 750g 中果 单果约20-30','https://img12.360buyimg.com/n2/jfs/t25762/115/2668922369/195308/115b6da1/5bed2329N51e464f8.jpg',523),(19,1,1003257419,'香蕉',11.88,9.9,'都乐(DOLE)菲律宾进口超甜蕉700g(约3-4根)盒装香蕉 新鲜直供 超长日照 口感香糯 新鲜水果','https://img13.360buyimg.com/n7/jfs/t16789/171/884393233/40175/4e4239bb/5ab0b232N4f8300f7.jpg',154),(20,2,1006432701,'红薯',22.9,21.9,'福建六鳌红薯 蜜薯 地瓜 2.5kg 红蜜薯 单果重约150g-500g 蔬菜礼盒 新鲜蔬菜','https://img11.360buyimg.com/n7/jfs/t22081/69/539975380/396180/50bb9d43/5b111ff9N250f9e54.jpg',57),(21,2,1006432702,'白菜',6.9,5.9,'绿鲜知 三宝白菜 约1kg 火锅食材 新鲜蔬菜','https://img11.360buyimg.com/n7/jfs/t4048/252/288662110/127744/931a566e/58462cd6N653980df.jpg',105),(22,2,1006432703,'山药',89.9,86.9,'优选100 焦作温县沙土铁棍山药礼盒装3kg （精选80公分） 蔬菜礼包','https://img14.360buyimg.com/n7/jfs/t15340/128/2416947111/249747/41424992/5a9f61f0Nc8a5d21d.jpg',97),(23,2,1006432704,'玉米',39.9,38.9,'玉米神 甜糯玉米棒黄黑白即食水果段东北新鲜非转基因粘黏真空包邮非速冻微波速食早餐苞米 黄糯10支','https://img14.360buyimg.com/n2/jfs/t1/28158/3/1807/63002/5c173270E2bd56b57/1c1f8fe4ac27878e.jpg',68),(24,2,1006432705,'板栗',49.9,48.9,'鲜东方 带壳新鲜生板栗 山东特产生油栗子5斤大果','https://img11.360buyimg.com/n2/jfs/t3241/118/4480658492/313446/300b0475/58480382N3af0d18e.jpg',241),(25,2,1006432706,'青菜',8.5,7.5,'绿鲜知 上海青 小油菜 小青菜 约400g 火锅食材 新鲜蔬菜','https://img14.360buyimg.com/n7/jfs/t4297/120/375562832/241785/c162c78b/58b3c779Na1ec50a0.jpg',153),(26,2,1006432707,'番茄',29.9,28.9,'凡谷归真 西红柿 番茄 约1.25kg 新鲜蔬菜','https://img10.360buyimg.com/n7/jfs/t9874/210/1782978702/421740/2c31a65e/59e5b33cN04c44aea.jpg',143),(27,2,1006432708,'菠菜',7.8,6.8,'绿鲜知 菠菜 约400g 火锅食材 新鲜蔬菜','https://img12.360buyimg.com/n7/jfs/t4141/69/351575720/323555/ccd9008/58b3c601Na4f13da4.jpg',78),(28,2,1006432709,'西兰花',9.5,8.5,'绿鲜知 西兰花 花椰菜 西蓝花 约300g 火锅食材 新鲜蔬菜','https://img13.360buyimg.com/n7/jfs/t3526/310/2014375487/500788/99978c40/583d31d0N4b3c83e0.jpg',106),(29,2,1006432710,'卷心菜',6.5,5.5,'绿鲜知 圆白菜 包菜 卷心菜 约500g 火锅食材 新鲜蔬菜','https://img11.360buyimg.com/n7/jfs/t3655/363/2056131123/73089/ff341da/5843da08N233e4886.jpg',46),(30,2,1006432711,'红萝卜',6.9,5.9,'绿鲜知 胡萝卜 红萝卜 甘荀 约700g 火锅食材 新鲜蔬菜','https://img12.360buyimg.com/n7/jfs/t3055/183/4211725261/121863/d26b473/58396f0eN95b41f90.jpg',125),(31,2,1006432712,'红洋葱',20.16,16.8,'Member\'s Mark 红洋葱 1.1kg 红皮圆葱葱头 新鲜蔬菜 时令生鲜','https://img14.360buyimg.com/n2/jfs/t28867/220/753017617/46967/9f42c5f6/5bfcd8c9N2f54ac02.jpg',45),(32,2,1006432713,'秋葵',21.36,17.8,'Member\'s Mark 黄秋葵500g 新鲜蔬菜','https://img13.360buyimg.com/n2/jfs/t26620/135/2226181743/105942/cef0f5a3/5bfcd4abN26dde47a.jpg',87),(33,2,1006432714,'罗马生菜',9.9,8.9,'绿鲜知 罗马生菜 约400g 火锅食材 新鲜蔬菜','https://img14.360buyimg.com/n7/jfs/t4708/239/2194549031/282261/9e2e7e70/58ef2381Nd959e3bf.jpg',54),(34,2,1006432715,'土豆',5.9,4.9,'绿鲜知 荷兰土豆 洋芋 约1kg 火锅食材 新鲜蔬菜','https://img10.360buyimg.com/n7/jfs/t3460/229/2260622301/57805/cdbdc052/58490b43N01fe973a.jpg',189),(35,2,1006432716,'南瓜',39.9,37.9,'家美舒达 贝贝南瓜 板栗小南瓜 约2.5kg','https://img12.360buyimg.com/n7/jfs/t25903/242/947443274/299629/38c34b9e/5b838cbfN766f991e.jpg',56),(36,2,1006432717,'葱',36.9,35.9,'正宗山东章丘大葱 大梧桐香葱非铁杆葱 2500g 新鲜蔬菜5斤','https://img10.360buyimg.com/n2/jfs/t1/798/1/10496/533037/5bca8fd8E3108b8c7/d03c63c28b6fb20e.png',285),(37,2,1006432718,'姜',23.76,19.8,'Member\'s Mark老姜 500g 生姜 新鲜蔬菜 块茎完整 老辣醇香','https://img10.360buyimg.com/n2/jfs/t26470/342/2269024781/81324/14b52c81/5bfcd561Nf3a41f6f.jpg',36),(38,2,1006432719,'蒜',32.6,26.8,'Member\'s Mark 独头蒜 500g 大蒜蒜头 新鲜蔬菜 干蒜新蒜','https://img12.360buyimg.com/n2/jfs/t27670/69/2292454329/65416/6557c1a7/5bfce00dN531a8bdf.jpg',68),(636,3,1003562501,'金龙鱼',39.9,38.9,'金龙鱼 食用油 葵花籽食用调和油5L','https://img13.360buyimg.com/n7/jfs/t3166/299/1429417536/44627/c583f950/57cd2cdfN536d176e.jpg',142),(637,3,1003562502,'鲁花',165.9,159.9,'鲁花 食用油 5S物理压榨 压榨一级 花生油 6.18L','https://img12.360buyimg.com/n7/jfs/t1/21008/20/1566/193064/5c136275Eb799ef5d/b1637c1ae6414188.jpg',231),(638,3,1003562503,'福临门',109,108,'福临门 食用油 压榨一级花生油（京东定制）6.18L 中粮出品','https://img12.360buyimg.com/n7/jfs/t1/6922/34/4866/241898/5bdac0d0E94de73b8/69fb1c1f061ba558.jpg',161),(639,3,1003562504,'多力',59.9,54.9,'多力葵花籽油4.5L 食用油 含维生素e','https://img10.360buyimg.com/n7/jfs/t18007/26/2596826146/459215/8147c8af/5afe9443N187ab2fc.jpg',242),(640,3,1003562505,'胡姬花',139.9,138.9,'胡姬花 食用油 压榨 特香型花生油 6.18L','https://img13.360buyimg.com/n7/jfs/t28240/269/88076495/105651/827a994d/5be6fe03Nf8ea5d9f.jpg',124),(641,3,1003562506,'长寿花',99.9,98.9,'长寿花 压榨一级 清香葵花籽油4L','https://img14.360buyimg.com/n7/jfs/t27082/326/1708766783/254507/e40bace0/5be92b62Na57209fb.jpg',253),(642,3,1003562507,'老榨坊',39.9,38.9,'老榨坊纯正菜籽油 非转基因 食用油5L','https://img12.360buyimg.com/n7/jfs/t1/5015/34/11093/224572/5bcd447dE007e40ba/328bf69fb239df43.jpg',214),(643,3,1003562508,'Member\'s Mark',70.8,59.9,'Member\'s Mark 非转基因一级压榨玉米油5LX1 食用油','https://img10.360buyimg.com/n7/jfs/t29416/175/481176708/42270/bdadd80e/5bf4fda4N903c4214.jpg',185),(644,3,1003562509,'庄品建大米',31.9,30.9,'庄品健大米 状元油粘米 荆楚好粮油绿色食品5KG 湖北天门特产 厂家直销','https://img10.360buyimg.com/n7/jfs/t19066/269/764598151/396047/41bfdfdf/5aa373d8N9a0facab.jpg',243),(645,3,1003562510,'严选大米',128,127,'网易严选 五常有机稻花香米 东北大米粳米粥米新米粮油调味 5千克','https://img12.360buyimg.com/n7/jfs/t1/20619/1/1887/533193/5c1769a8E50e9aa1f/8c7180db8c284600.png',123),(646,3,1003562511,'金龙鱼大米',29.9,20.9,'金龙鱼 寒地东北大米 4kg（新老包装随机发货）','https://img12.360buyimg.com/n7/jfs/t6016/236/3985036821/270018/c7fb576c/595c7186N825aa033.jpg',342),(647,3,1003562512,'福临门大米',49.5,49.5,'优质东北大米5kg/10斤 袋 米 东北 粮油中粮出品','https://img10.360buyimg.com/n7/jfs/t18796/33/1270497398/107016/13747749/5ac36597N708da87e.jpg',102),(648,3,1003562513,'北大荒大米',29.5,28.5,'北大荒 百年寒地 长粒香米 东北大米 长粒香 5kg','https://img10.360buyimg.com/n7/jfs/t4837/247/640457120/274970/9fe1ce67/58e5c389N4ee3e42a.jpg',133),(649,3,1003562514,'金龙鱼面粉',31.8,29.8,'金龙鱼 家用 中筋面粉 多用途麦芯小麦粉5kg 包子饺子馒头饼手擀面','https://img12.360buyimg.com/n7/jfs/t1/4257/17/9325/193099/5bac503fE74f8e159/89ffd7c9546df200.jpg',189),(650,3,1003562515,'黄土之恋面粉',59.9,58.9,'黄土之恋 荞麦面粉5kg精粉荞麦陕北特产粗粮面粉低筋面粉杂粮米面粮油家用面粉 5kg 荞麦面精粉5kg','https://img10.360buyimg.com/n7/jfs/t21520/293/1699618972/237094/2790fc0a/5b32eec4N9fd3a472.jpg',132),(651,3,1003562516,'望香面粉',172.12,171.12,'望乡（Wheatsun） 厂家面粉面粉雪花粉25kg包子馒头用小麦粉粮油 25kg/袋','https://img11.360buyimg.com/n7/jfs/t1/23821/2/311/144529/5c08ded1Ec9b2363d/99ac62dc6aad2c8d.jpg',89),(652,3,1003562517,'香满园面粉',18.19,17.19,'香满园 家用 中筋面粉 美味富强小麦粉5kg 包子饺子馒头饼手擀面（新老包装随机发货）','https://img14.360buyimg.com/n7/jfs/t27550/344/881254104/156138/74c46c10/5bbc0f8aN3ab05bb4.jpg',102),(653,3,1003562518,'香雪面粉',19.9,18.6,'香雪 美味富强粉 面粉 中粮出品5kg （新老包材随机发货','https://img13.360buyimg.com/n7/jfs/t25003/157/647953041/131917/450c0939/5b7684daN88664160.jpg',134),(654,3,1003562519,'金沙河面粉',23.9,22.9,'金沙河面粉 富强高筋小麦粉 馒头粉饺子粉 高筋烘焙原料面粉 5KG','https://img12.360buyimg.com/n7/jfs/t25576/325/90131783/190680/62baf884/5b644428N15c59a61.jpg',79),(667,4,1002453801,'麻辣牛肉干',59.9,30,'四川特色小吃麻辣牛肉干55克冷吃牛肉粒零食休闲特色小吃零食贴牌','https://cbu01.alicdn.com/img/ibank/2018/104/361/9489163401_622781687.220x220.jpg',342),(668,4,1002453802,'辣子鸡零食',44,33.3,'八代传人油泼川卤 四川特产零食辣子鸡 抖音零食麻辣美食批发加工','https://cbu01.alicdn.com/img/ibank/2018/995/984/9465489599_622781687.220x220.jpg',122),(669,4,1002453803,'薯片',120,99.6,'薯片小吃散装整箱8斤 抖音休闲零食大礼包 膨化食品 特产年货批发','https://cbu01.alicdn.com/img/ibank/2018/022/480/9832084220_1507631151.220x220.jpg',321),(670,4,1002453804,'虾片',2.5,1.5,'鲜虾味 厂家直销150g鲜虾味休闲膨化小零食 美味干虾片食品','https://cbu01.alicdn.com/img/ibank/2018/302/557/9153755203_71180370.220x220.jpg',232),(671,4,1002453805,'巧克力棒',8.2,7,'巧力美138g手指蘑菇巧克力多种口味盒装儿童休闲零食厂家批发','https://cbu01.alicdn.com/img/ibank/2018/487/628/9424826784_514703803.220x220.jpg',341),(672,4,1002453806,'糖果',3,2.61,'圣诞节糖果平安夜圣诞礼物棒棒糖无糖木糖醇创意手工节庆食品','https://cbu01.alicdn.com/img/ibank/2018/457/901/9563109754_1363395830.220x220.jpg',251),(673,4,1002453807,'瓜子',7,3,'老闫家南瓜子原味98g闫小萌 炒货零食批发','https://cbu01.alicdn.com/img/ibank/2018/899/020/9389020998_1349784048.220x220.jpg',561),(674,4,1002453808,'糕点',5.1,4.4,'手工爆浆麻薯180g一包 喜糖送礼 食品点心 传统糕点 年货批发零食','https://cbu01.alicdn.com/img/ibank/2018/503/056/10120650305_1507631151.220x220.jpg',189),(675,4,1002453809,'小麻花',5.5,4.9,'朱爹地麻辣味手工小麻花膨化零食品休闲类小吃厂家一件代发可代工','https://cbu01.alicdn.com/img/ibank/2018/127/429/8909924721_1232152051.220x220.jpg',527),(676,4,1002453810,'牛角酥',12,8.3,'网红零食批发休闲食品牛角酥妙脆角办公室零食小吃油炸型膨化食品','https://cbu01.alicdn.com/img/ibank/2018/645/257/9623752546_1927724115.220x220.jpg',263),(677,4,1002453811,'零食大礼包',38.5,28.5,'猪饲料零食大礼包组合混装一整箱休闲礼盒网红创意生日礼物送女友','https://cbu01.alicdn.com/img/ibank/2018/990/418/10127814099_1388443524.220x220.jpg',327),(678,4,1002453812,'薄荷糖',19,11,'金多宝有个圈的薄荷糖 压片糖果20斤箱装 酒店4S店用品 厂家货源','https://cbu01.alicdn.com/img/ibank/2017/602/784/4517487206_333732880.220x220.jpg',349),(679,4,1002453813,'小麻花',6.02,3.4,'斗嘴食间手工香酥小麻花散装批发定制膨化零食小吃可代发贴牌加工','https://cbu01.alicdn.com/img/ibank/2018/706/400/9436004607_287128846.220x220.jpg',487),(680,4,1002453814,'爆米花',20,15,'爆口福美式球形爆米花 球型玉米花焦糖味奶油味桶装杯装108g','https://cbu01.alicdn.com/img/ibank/2017/609/069/4421960906_268964225.220x220.jpg',267),(681,4,1002453815,'红糖果',5.2,4,'脱普网红糖果 北欧小调清口味水果糖学生超市咖啡烘培店零食批发','https://cbu01.alicdn.com/img/ibank/2018/139/897/9168798931_438650295.220x220.jpg',623),(682,4,1002453816,'紫薯干',70,50,'紫薯干 香脆紫薯片10斤散装 香酥紫片连城地瓜干 厂家批发地瓜坊','https://cbu01.alicdn.com/img/ibank/2016/097/389/3647983790_2038101807.220x220.jpg',423),(683,4,1002453817,'麻辣',20,15,'八代传人油泼川卤 麻辣冷吃兔55g四川特产零食 抖音零食小吃贴牌','https://cbu01.alicdn.com/img/ibank/2018/029/839/9579938920_622781687.220x220.jpg',342),(684,4,1002453818,'虾片',5,4,'500g大包装经济实惠版鲜虾味休闲零食白色虾片','https://cbu01.alicdn.com/img/ibank/2014/899/531/1570135998_71180370.220x220.jpg',543),(685,4,1002453819,'金梅片',28,25,'百旺原味金梅片68g压片糖硬糖润喉消食含片休闲零食批发混批散装','https://cbu01.alicdn.com/img/ibank/2018/934/886/9293688439_71840081.220x220.jpg',525),(686,4,1002453820,'金桔',40,37,'椰味桔子干 袋装 办公室休闲零食 果脯蜜饯批发 商超供货一件代发','https://cbu01.alicdn.com/img/ibank/2017/406/641/4565146604_671134536.220x220.jpg',472),(687,4,1002453821,'燕麦棒',20,15,'厂家直销蛋黄燕麦棒 休闲零食糕点 手工制作食品OEM代工','https://cbu01.alicdn.com/img/ibank/2018/559/552/8653255955_1889980840.220x220.jpg',325),(688,4,1002453822,'话梅',20,17,'古早话梅散装500g 酸甜青梅原味孕妇零食蜜饯厂家直销可代贴牌oem','https://cbu01.alicdn.com/img/ibank/2018/904/936/9470639409_1344733981.220x220.jpg',426),(689,4,1002453823,'坚果',36,32,'沃隆175克每日坚果混合坚果仁礼盒零食成人儿童款干果组合批发','https://cbu01.alicdn.com/img/ibank/2018/796/023/9109320697_1696008360.220x220.jpg',244),(690,4,1002453824,'牛板筋',50,47,'牛板筋500g内蒙特产塔拉九牛散装牛板筋一手货源麻辣零食一件代发','https://cbu01.alicdn.com/img/ibank/2018/200/591/9550195002_1845535097.220x220.jpg',325),(691,4,1002453825,'蓝莓干',28,25,'散装无添加蓝莓干 精选大颗粒原味蓝莓干 休闲零食蜜饯批发','https://cbu01.alicdn.com/img/ibank/2018/621/101/10102101126_599699758.220x220.jpg',176),(698,5,1006467801,'娃哈哈AD钙',48,45,'娃哈哈 AD钙奶 含乳饮料 220g*24瓶 整箱装 （新老包装随机发货','https://img13.360buyimg.com/n7/jfs/t26638/76/842506700/267883/4b95fa87/5bbb0584N9e18b608.jpg',425),(699,5,1006467802,'可口可乐',55.8,50,'可口可乐 Coca-Cola 汽水 碳酸饮料 330ml*24罐 整箱装 可口可乐公司出品 新老包装随机发货','https://img11.360buyimg.com/n7/jfs/t27088/97/2143835044/219979/f7c5d3b4/5bfb6fd1Nd0be2159.jpg',245),(700,5,1006467803,'水蜜桃果汁',59,55,'盼盼 水蜜桃 果汁饮料 250ml*24盒 整箱装','https://img11.360buyimg.com/n7/jfs/t12577/67/1142848632/167443/7df57406/5a1bcefeN140ef64f.jpg',452),(701,5,1006467804,'六个核桃',66,55,'养元六个核桃易智优＋核桃乳植物蛋白饮料 240ml*20罐 整箱装','https://img14.360buyimg.com/n7/jfs/t30226/123/169089826/282382/ab2ffe26/5bea3b44Naee028fa.jpg',245),(702,5,1006467805,'加多宝',36.9,30,'加多宝 凉茶植物饮料 茶饮料 310ml*15罐 整箱装','https://img14.360buyimg.com/n7/jfs/t16144/106/2484891868/179359/6759343c/5ab4b23dN83b9b0fc.jpg',345),(703,5,1006467806,'雀巢',15.6,12,'雀巢(Nestle) 丝滑拿铁口味 即饮雀巢咖啡饮料 268ml*3瓶 3联包','https://img13.360buyimg.com/n7/jfs/t5929/146/4076756261/3729402/77cdad21/595c9c0aN81b87c9b.jpg',134),(704,5,1006467807,'苏打水',88,80,'屈臣氏（Watsons）苏打汽水330ml*24罐 整箱装 苏打水汽水饮料','https://img10.360buyimg.com/n7/jfs/t29533/131/735857141/115417/78bab8d1/5bfcc6b9N62622d9b.jpg',146),(705,5,1006467808,'百事可乐',40.5,39,'百事可乐 Pepsi 碳酸饮料 330ml*24听 (新老包装随机发货)','https://img10.360buyimg.com/n7/jfs/t24673/6/2312932226/260021/eb40d98b/5be3acbaN8ea6cf7d.jpg',124),(706,5,1006467809,'王老吉',69,60,'王老吉凉茶310ml*24罐整箱装 草本凉茶植物清凉饮料 中华老字号','https://img12.360buyimg.com/n7/jfs/t27076/245/453194414/472964/793abc43/5b90f2ceNb6be8947.jpg',164),(707,5,1006467810,'脉动',39.8,32,'脉动（Mizone）青柠口味 维生素饮料 400ml*15瓶 整箱装','https://img11.360buyimg.com/n7/jfs/t18760/10/2370900697/169233/fb6671bb/5af02a97Ne3ce6949.jpg',178),(708,5,1006467811,'红牛',31.9,25,'红牛 维生素功能饮料 250ml*6罐 组合装','https://img10.360buyimg.com/n7/jfs/t211/331/2123897792/103201/91fc453f/5406edb9Na74e481f.jpg',169),(709,5,1006467812,'冰红茶',19.9,12,'盼盼 冰红茶 柠檬味果汁饮料 250ml*24盒 整箱装','https://img14.360buyimg.com/n7/jfs/t2839/109/2791484957/423158/2f27f9b7/577489c4Na01f48b8.jpg',193),(710,5,1006467813,'达利园青梅绿茶',19.9,12,'达利园 青梅绿茶 饮料 500ml*15瓶 整箱装','https://img11.360buyimg.com/n7/jfs/t19675/202/1014368634/213812/ba002e2c/5ab4bcd2Ne18c54d6.jpg',321),(711,5,1006467814,'乌龙茶',39.9,32,'三得利（Suntory）三得利 无糖乌龙茶饮料500ML*15瓶 整箱','https://img14.360buyimg.com/n7/jfs/t4690/1/1491585427/214704/6dc764af/58df5fc6N547ffa0d.jpg',356),(712,5,1006467815,'椰汁',98,90,'椰树 椰汁正宗椰树牌椰子汁 植物蛋白饮料 245ml*24罐 整箱 新老包装随机发货','https://img14.360buyimg.com/n7/jfs/t3841/166/1980717795/398579/1fcbf00f/58491705N29978aca.jpg',267),(713,5,1006467816,'统一阿萨姆奶茶',49.9,41,'统一 阿萨姆奶茶 原味奶茶 500ml*15瓶 整箱 精选喜马拉雅山麓红茶','https://img12.360buyimg.com/n7/jfs/t11278/30/392755639/112423/3313880b/59eefa1fNa84f0726.jpg',193),(714,5,1006467817,'雪碧',48,42,'雪碧 Sprite 柠檬味 汽水 碳酸饮料 330ml*24罐 整箱装 可口可乐公司出品','https://img14.360buyimg.com/n7/jfs/t24451/322/1049613623/453043/f03c5f1/5b4ede9eNd7f39bd1.jpg',371),(715,5,1006467818,'荔枝味苏打水',48,42,'珍珍 荔枝味 碳酸饮料 330ml*24听 整箱装 (新老包装随机发货)','https://img14.360buyimg.com/n7/jfs/t1/3950/30/9658/498999/5bad9d60E8eddaeee/b350bee3f35eb2f4.jpg',231),(716,5,1006467819,'统一鲜橙多',28.8,21,'统一 鲜橙多 250ml*24盒/箱 整箱装 橙汁饮料 （新老包装随机发货）','https://img11.360buyimg.com/n7/jfs/t1330/320/1108808910/95000/9d8178f9/55b7334eNe0c41f45.jpg',175),(717,5,1006467820,'桂花酸梅汤',48,42,'信远斋 桂花酸梅汤饮料 300ml*12瓶 整箱装','https://img13.360buyimg.com/n7/jfs/t5470/187/813799820/404565/e00414f1/5907dc85N6743e74e.jpg',153),(718,5,1006467821,'无糖零卡汽水',79.9,70,'怡泉 Schweppes 调酒汽水无糖零卡 苏打水 330ml*24罐 整箱装 可口可乐出品 新老包装随机发货','https://img11.360buyimg.com/n1/s190x190_jfs/t1/4657/12/2264/99340/5b961661E2991abcd/11646e5ed6e3e582.jpg',189),(719,5,1006467822,'姜汁饮料',58,49,'广氏 够姜 姜汁饮料 250ml*12罐 含气型植物饮料 生姜汽水','https://img12.360buyimg.com/n7/jfs/t30223/174/483487989/407851/4f6cddb8/5bf4f334Nebf88a36.jpg',246),(720,5,1006467823,'克东天然苏打水',208,199,'舒达源 克东天然苏打水 400ml*24瓶/箱 弱碱性饮用矿泉水非饮料 一箱','https://img13.360buyimg.com/n2/jfs/t1/23279/33/2014/231426/5c18b37cE7bd8ca13/0d726d821cb002f5.jpg',274),(760,6,1003266301,'高露洁牙膏',11.4,9.9,'光感劲白牙膏120g 专业美白 去除牙渍清新口气','https://chaoshi.detail.tmall.com/item.htm?spm=a220m.1000858.1000725.147.33cc7315FKaG3Y&id=20596712537&skuId=62386849795&areaId=320100&user_id=725677994&cat_id=2&is_b=1&rn=bfbefa6be504af6389e8b744530e4d20#',211),(761,6,1003266302,'舒适达牙膏',28.8,27.9,'舒适达劲速护理抗敏感牙膏120g快速缓解牙齿酸痛疼痛','https://chaoshi.detail.tmall.com/item.htm?spm=a220m.1000858.1000725.100.33cc7315FKaG3Y&id=533925626491&skuId=3185402588052&areaId=320100&user_id=725677994&cat_id=2&is_b=1&rn=bfbefa6be504af6389e8b744530e4d20#',324),(762,6,1003266303,'云南白药牙膏',29.4,28.3,'留兰香型180g减轻牙龈出血去牙渍去口臭口气清新','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.336122584SSfjE&id=15872507686#',364),(763,6,1003266304,'佳洁士牙膏',46.2,45.9,'3D钻亮炫白热感美白进口牙膏口气清新去黄去牙渍去口臭套装','https://chaoshi.detail.tmall.com/item.htm?spm=a220m.1000858.1000725.43.33cc7315FKaG3Y&id=525600949412&areaId=320100&user_id=725677994&cat_id=2&is_b=1&rn=bfbefa6be504af6389e8b744530e4d20#',289),(764,6,1003266305,'舒客牙膏',13.9,12.5,'2支美白去黄口气清新去口臭牙刷漱口水正品套装','https://chaoshi.detail.tmall.com/item.htm?spm=a220m.1000858.1000725.63.33cc7315FKaG3Y&id=43537060980&areaId=320100&user_id=725677994&cat_id=2&is_b=1&rn=bfbefa6be504af6389e8b744530e4d20#',342),(765,6,1003266306,'汰渍洗衣液',64.9,64.2,'量贩组合套装洁净去渍清香型3kg*2机洗瓶装','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.619c2258eq5Oml&id=520553024247&rewcatid=50518004#',275),(766,6,1003266307,'汰渍洗衣粉',35.9,34.5,'持久清洁净白去渍专用柠檬清新型5kg袋装','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.619c2258eq5Oml&id=18037078376&rewcatid=50518004#',278),(767,6,1003266308,'超能透明皂',25,24.6,'柠檬草香260g*6清新祛味洗衣皂椰油肥皂天然椰油生产','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.619c2258eq5Oml&id=571735437518&rewcatid=50518004#',304),(768,6,1003266309,'碧浪洗衣液',81.3,79.9,'机洗手洗自然清新3kg*2瓶家庭装量贩组合套装持久留香','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.619c2258eq5Oml&id=534958129769&rewcatid=50518004#',289),(769,6,1003266310,'维达有芯卷纸',22.3,21.9,'4层140克10卷卫生纸巾纸品','https://chaoshi.detail.tmall.com/item.htm?spm=a220o.7406545.1998025129.1.49b84f25jeXg0e&pos=1&acm=03227.1003.1.2290751&id=15699803229&scm=1003.1.03227.ITEM_15699803229_2290751&uuid=null#',329),(770,6,1003266311,'心相印卷纸',33.7,32.9,'厨房专用卫生纸75节8粒吸油家用纸巾','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.336122584SSfjE&id=533971548851&rewcatid=50516008#',179),(771,6,1003266312,'维达婴儿手口可用湿巾',41.3,39.9,'婴儿手口可用湿巾80抽×3包，天然温和呵护宝宝稚嫩肌肤','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.336122584SSfjE&id=562674596108&rewcatid=50516008#',135),(772,6,1003266313,'维达绵柔手帕纸',3.8,3.5,'3层8张10包卫生纸巾 可湿水面巾纸','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.2aa322585homZS&id=17609832853&rewcatid=50516008#',264),(773,6,1003266314,'妙洁抹布',7.2,6.5,'吸水加厚洗碗百洁布厨房家务清洁巾洗碗巾','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.29ac2258JZkOy9&id=15128348011&rewcatid=50496012&skuId=64627095639#',278),(774,6,1003266315,'妙洁棉拖把',41.6,39.9,'免手洗家用卡槽加强型碳钢杆 送海绵替换头','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.29ac2258JZkOy9&id=520131343948&rewcatid=50496012#',227),(775,6,1003266316,'妙洁家务手套',8.4,7.9,'防水乳胶灵巧型厨房耐用洗衣洗碗橡胶手套','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.29ac2258JZkOy9&id=14095683246&rewcatid=50496012&skuId=76381520239#',246),(776,6,1003266317,'飞达三和垃圾桶',10,9.9,'5L家用卫生间客厅卧室厨房压圈手提垃圾桶收纳桶','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.29ac2258JZkOy9&id=40019799557&rewcatid=50496012&skuId=62221859313#',264),(777,6,1003266318,'妙洁尘扫把簸箕',41.2,49,'妙洁尘必净耐用 家用软毛扫帚笤帚畚斗清洁工具','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.29ac2258JZkOy9&id=549795504543&rewcatid=50496012#',173),(778,6,1003266319,'妙然加厚脸盆',12,10.9,'妙然加厚脸盆大号带把加深耐摔手家用37cm深形泡脚塑料盆','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.51c422583CHHWA&id=44825485500&rewcatid=50496012#',134),(791,7,1003442701,'九阳电热水壶',159,149,'K17-F67电热水壶家用烧水壶自动断电保温开水壶','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.73053745WuRZ7U&id=571036573818&rewcatid=50514008&skuId=3859903771183#',56),(792,7,1003442702,'美的电饭煲',112,109,'Midea迷你电饭煲家用电饭锅2-4人电饭煲电饭煲3升','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.73053745WuRZ7U&id=522077267046&rewcatid=50514008#',52),(793,7,1003442703,'美的烧水壶',143,139,'Midea烧水壶电热水壶家用自动断电玻璃开水壶透明','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.73053745WuRZ7U&id=564947051959&rewcatid=50514008&skuId=3737939334433#',42),(794,7,1003442704,'美的TGS40W电炖锅',712,699,'Midea电炖锅家用多功能煲汤燕窝隔水盅','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.73053745WuRZ7U&id=557035588716&rewcatid=50514008#',54),(795,7,1003442705,'先锋取暖炉',145,139,'先锋小太阳取暖器暗光不伤眼远红外烤火炉办公室家用台式小型家用','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.69653745EGZ12J&id=578563522492&rewcatid=50514008&skuId=3831727496230#',74),(796,7,1003442706,'小狗吸尘器',425,399,'小狗吸尘器家用干湿吹大功率超静音小型机D-807','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.69653745EGZ12J&id=578114505395&rewcatid=50514008&skuId=3825702824719#',96),(797,7,1003442706,'九阳电烤箱',224,219,'Joyoung KX-30J601多功能家用厨房工具电烤箱烘焙大烤箱30升','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.69653745EGZ12J&id=522863349833&rewcatid=50514008#',53),(798,7,1003442707,'九阳净水器',172,169,'Joyoung家用厨房水龙头过滤器自来水净化器直饮净水机','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.69653745EGZ12J&id=566659114659&rewcatid=50514008#',75),(799,7,1003442708,'爱贝斯电热毯',71.8,69,'单人女美容床家用沙发暖身毯除螨控温低辐射舒适面料','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.69653745EGZ12J&id=19580964167&rewcatid=50514008&skuId=77509836782#',78),(800,7,1003442709,'利仁电饼铛',207,199,'LR-D3066悬浮双面加热烙饼锅煎饼机自动断电家用','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.69653745EGZ12J&id=546723172873&rewcatid=50514008#',56),(801,7,1003442710,'美的搅拌果汁机',613,599,'MJ-BL80Y21破壁机家用全自动多功能榨料理搅拌果汁机','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.69653745EGZ12J&id=565389113231&rewcatid=50514008&skuId=3580229556055#',96),(802,7,1003442711,'九阳米酒酸奶机',103,99,'Joyoung SN10L03A米酒酸奶机家用全自动304不锈钢内胆','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.69653745EGZ12J&id=42300731805&rewcatid=50514008&skuId=71012261241#',73),(803,7,1003442712,'利仁烧烤盘',163,159,'利仁KL-J4500家用电烧烤炉不粘无烟烤肉机电烤盘铁板烧室内烧烤盘','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.7bc43745AQR0Kq&id=525485426433&rewcatid=50514008#',78),(804,7,1003442712,'小熊酸奶机',108,99,'Bear/小熊 SNJ-B10K1酸奶机自制米酒机家用全自动不锈钢','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.7bc43745AQR0Kq&id=546942929731&rewcatid=50514008&skuId=3473409391910#',79),(805,7,1003442713,'智能音箱',426,399,'精灵魔盒语音智能网络家用电视机顶盒子高清播放器智能音箱','https://chaoshi.detail.tmall.com/item.htm?spm=a3204.7933263.0.0.7bc43745AQR0Kq&id=575155186686&rewcatid=50514008&sku_properties=5919063:6536025#',84);
/*!40000 ALTER TABLE `t_goods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_members`
--

DROP TABLE IF EXISTS `t_members`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_members` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `number` bigint(20) DEFAULT NULL COMMENT '会员号',
  `name` varchar(500) CHARACTER SET utf8 NOT NULL,
  `address` varchar(500) CHARACTER SET utf8 NOT NULL,
  `phone` varchar(11) DEFAULT NULL COMMENT '电话',
  `integral` bigint(20) DEFAULT NULL COMMENT '积分',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_members`
--

LOCK TABLES `t_members` WRITE;
/*!40000 ALTER TABLE `t_members` DISABLE KEYS */;
INSERT INTO `t_members` VALUES (1,2016001,'张明','江苏省南通市','18847743684',45),(2,2015002,'王宏','江苏省南京市','18804646733',70),(3,2018003,'李丽','江苏省常州市','15905774524',15),(4,2015004,'刘琳','江苏省苏州市','13587538769',120),(5,2017005,'卢秀','江苏省无锡市','13625886566',40),(6,2018006,'黄伟','江苏省南京市','18803453822',50);
/*!40000 ALTER TABLE `t_members` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_seller`
--

DROP TABLE IF EXISTS `t_seller`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_seller` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `work_id` bigint(20) DEFAULT NULL COMMENT '收银员工号',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `name` varchar(45) DEFAULT NULL COMMENT '姓名',
  `avatar` varchar(1000) DEFAULT NULL COMMENT '头像',
  `address` varchar(500) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_seller`
--

LOCK TABLES `t_seller` WRITE;
/*!40000 ALTER TABLE `t_seller` DISABLE KEYS */;
INSERT INTO `t_seller` VALUES (1,201501,'Aaa111','王丽','https://upload.jianshu.io/users/upload_avatars/8972166/027bf05a-67fa-459e-b61c-c73ce267367c.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/180/h/180','南京'),(2,201802,'Bbb222','刘梅','https://upload.jianshu.io/users/upload_avatars/2998364/9f8351c3734b.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/180/h/180','苏州'),(3,201703,'Ccc333','张凯文','https://upload.jianshu.io/users/upload_avatars/6539412/824c3d2f-b0d2-43a6-885a-d2acd37fd364.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/180/h/180','南通');
/*!40000 ALTER TABLE `t_seller` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_ticket`
--

DROP TABLE IF EXISTS `t_ticket`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_ticket` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type_id` bigint(20) DEFAULT NULL COMMENT '收银员id',
  `vip_id` bigint(20) DEFAULT NULL COMMENT '会员id',
  `time` datetime DEFAULT NULL COMMENT '收银时间',
  `amount` double DEFAULT NULL COMMENT '总金额',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_ticket`
--

LOCK TABLES `t_ticket` WRITE;
/*!40000 ALTER TABLE `t_ticket` DISABLE KEYS */;
INSERT INTO `t_ticket` VALUES (1,201501,2015004,'2017-05-17 12:41:08',150),(2,201704,2018006,'2018-03-07 11:03:56',100),(3,201704,2018003,'2018-12-12 20:00:00',210),(4,201805,2018006,'2018-12-20 16:37:16',280),(5,201704,2015004,'2018-12-29 17:02:02',160);
/*!40000 ALTER TABLE `t_ticket` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_type`
--

DROP TABLE IF EXISTS `t_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(45) NOT NULL COMMENT '商品类别名称',
  `cover` varchar(500) CHARACTER SET latin1 DEFAULT NULL COMMENT '封面图',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_type`
--

LOCK TABLES `t_type` WRITE;
/*!40000 ALTER TABLE `t_type` DISABLE KEYS */;
INSERT INTO `t_type` VALUES (1,'水果','https://img10.360buyimg.com/n7/jfs/t8482/165/1971168783/113656/919a97c3/59c21b9cN01db4dbc.jpg'),(2,'蔬菜','https://img10.360buyimg.com/n7/jfs/t1/5338/34/1660/140527/5b94b73fE267adfd6/172c276f68e1aeb6.jpg'),(3,'粮油','https://img10.360buyimg.com/n2/jfs/t1/16479/34/62/344262/5c068f5aEb58660c9/1f3605fc9386cbee.jpg'),(4,'零食','https://img14.360buyimg.com/n2/jfs/t1/7965/24/3560/849892/5bd7c3bfE59835aa6/d3dfc2021dd9f836.jpg'),(5,'饮品','https://img11.360buyimg.com/n7/jfs/t30256/83/845348333/255460/8820e616/5bff5690Nd558f600.jpg'),(6,'护理','https://img13.360buyimg.com/n2/jfs/t30265/347/1060258035/332770/4967b498/5c0629baN55ca7b29.jpg');
/*!40000 ALTER TABLE `t_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `account` varchar(10) NOT NULL COMMENT '账号',
  `password` varchar(20) NOT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'admin','soft1841');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2018-12-28 12:22:49

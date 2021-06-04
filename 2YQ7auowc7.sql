-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jun 03, 2021 at 03:38 PM
-- Server version: 8.0.13-4
-- PHP Version: 7.2.24-0ubuntu0.18.04.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `2YQ7auowc7`
--

-- --------------------------------------------------------

--
-- Table structure for table `billing`
--

CREATE TABLE `billing` (
  `billing_id` int(10) NOT NULL,
  `billing_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `billing_price` varchar(12) COLLATE utf8_unicode_ci NOT NULL,
  `billing_period` int(11) NOT NULL DEFAULT '0',
  `billing_status` enum('ACTIVE','INACTIVE') COLLATE utf8_unicode_ci NOT NULL DEFAULT 'ACTIVE',
  `functionalities` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `billing`
--

INSERT INTO `billing` (`billing_id`, `billing_name`, `billing_price`, `billing_period`, `billing_status`, `functionalities`) VALUES
(1, 'Basic', '0', 0, 'ACTIVE', 'SEARCH,LOGIN,COMMENT'),
(2, 'Premium', '10000', 10, 'ACTIVE', 'SPOT_MANAGEMENT,LOCATION_MANAGEMENT');

-- --------------------------------------------------------

--
-- Table structure for table `comments`
--

CREATE TABLE `comments` (
  `comment_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `spot_id` int(255) NOT NULL,
  `user_id` int(10) NOT NULL,
  `reply_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `content` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL,
  `status` enum('ACTIVE','INACTIVE') COLLATE utf8_unicode_ci NOT NULL DEFAULT 'ACTIVE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `comments`
--

INSERT INTO `comments` (`comment_id`, `spot_id`, `user_id`, `reply_id`, `content`, `created_at`, `updated_at`, `status`) VALUES
('0399ca2d-290a-419c-87b5-e6b95fa7c15b', 18, 3, NULL, 'spot comment', '2021-02-23 21:05:10.000000', '2021-02-23 21:05:10.000000', 'ACTIVE'),
('03a1e527-f2db-442f-91d6-ddac501fff9a', 1, 3, NULL, 'Create Users eleeeh', '2021-02-04 15:30:00.000000', '2021-02-04 15:59:59.000000', 'INACTIVE'),
('04d2552d-8582-4d01-bed8-986f24068a4a', 5, 3, NULL, 'bet', '2021-03-04 20:05:38.000000', '2021-03-04 20:05:38.000000', 'ACTIVE'),
('1', 1, 3, NULL, 'Updated my comment is registered now', '2021-02-04 22:07:12.000000', '2021-02-04 22:29:17.000000', 'ACTIVE'),
('10', 1, 3, '1', 'my comment is registered now', '2021-02-04 22:30:43.000000', '2021-02-04 22:30:43.000000', 'ACTIVE'),
('132794ba-5eb6-433e-a70c-52d851d40080', 26, 3, NULL, 'xxxxxxxxxxx', '2021-03-05 08:55:01.000000', '2021-03-05 08:55:01.000000', 'ACTIVE'),
('19', 1, 3, '1', 'my reply on comment is registered now', '2021-02-04 22:31:59.000000', '2021-02-04 22:54:26.000000', 'INACTIVE'),
('1ce9c573-2ec6-4299-b607-1c1b856e78dd', 1, 3, NULL, 'Update User', '2021-02-04 15:45:00.000000', '2021-02-04 15:45:00.000000', 'ACTIVE'),
('1e317f31-c5ee-4520-9f23-fff8189de85d', 3, 3, NULL, 'hey', '2021-03-11 11:46:37.000000', '2021-03-11 11:46:37.000000', 'ACTIVE'),
('1f955122-9e0b-473f-aece-504c1e69b853', 3, 3, NULL, 'this is interesting', '2021-02-24 21:59:02.000000', '2021-02-24 21:59:02.000000', 'ACTIVE'),
('2b408448-374c-4be3-9fde-fd165007d4c0', 7, 3, NULL, 'Wow great PCs', '2021-03-10 07:54:28.000000', '2021-03-10 07:54:28.000000', 'ACTIVE'),
('32fa0f31-e207-4af8-88d2-f6be896b4b7c', 26, 3, NULL, 'mbega byiza weeeeee', '2021-03-05 10:00:07.000000', '2021-03-05 10:00:07.000000', 'ACTIVE'),
('43d35d22-f890-4da7-a28d-9a189f2f21b5', 3, 3, NULL, 'sdf', '2021-03-04 21:24:46.000000', '2021-03-04 21:24:46.000000', 'ACTIVE'),
('4dcefa74-1e75-40c3-8ed9-4d2578c06298', 3, 3, NULL, 'ndabikunze koko', '2021-02-09 11:47:59.000000', '2021-02-09 11:47:59.000000', 'ACTIVE'),
('4ddb269c-0170-42d3-b830-b2bdb130b986', 15, 3, NULL, 'Hotels are very good', '2021-02-26 14:02:23.000000', '2021-02-26 14:02:23.000000', 'ACTIVE'),
('5012ed32-d13f-422b-8d29-81a2ede4298c', 16, 3, NULL, 'nice book', '2021-03-02 07:18:23.000000', '2021-03-02 07:18:23.000000', 'ACTIVE'),
('5844387b-c743-4b36-a243-bf9024dd58bb', 4, 3, NULL, 'asdfghjk', '2021-02-08 19:07:00.000000', '2021-02-08 19:07:00.000000', 'ACTIVE'),
('58c2dc48-ed1a-4e61-b16f-db16bff98f38', 1, 3, NULL, 'nice spot', '2021-02-25 14:24:47.000000', '2021-02-25 14:24:47.000000', 'ACTIVE'),
('5ca92672-dc4a-4b9d-b481-2ee9474a83d9', 3, 3, NULL, 'Nice fish', '2021-03-04 18:08:33.000000', '2021-03-04 18:08:33.000000', 'ACTIVE'),
('63881e49-b7e6-4005-b19a-a8d899bd9004', 3, 3, NULL, 'kbsaaaaa', '2021-03-10 07:58:48.000000', '2021-03-10 07:58:48.000000', 'ACTIVE'),
('6fd94f32-05f9-4bf4-ad84-cb06c6f71322', 6, 3, NULL, 'hiiiiiiiiiiiiiiiiiiii', '2021-02-09 11:34:01.000000', '2021-02-09 11:34:01.000000', 'ACTIVE'),
('704f7a06-c18c-4720-b8d5-e6a77a969fff', 16, 3, NULL, 'good choice', '2021-03-11 08:28:01.000000', '2021-03-11 08:28:01.000000', 'ACTIVE'),
('76b9d834-2fe2-42f2-97e5-e49e26792ac0', 16, 3, NULL, 'great', '2021-03-03 20:54:25.000000', '2021-03-03 20:54:25.000000', 'ACTIVE'),
('7b3c402c-e819-4c29-ad7c-82a9525bbc44', 6, 3, NULL, 'fIRST COMMENT HERE.', '2021-02-08 19:03:50.000000', '2021-02-08 19:03:50.000000', 'ACTIVE'),
('7eb6dcc3-a3b8-4bd4-b19e-d8f2f32a2aaa', 1, 3, NULL, 'impresive', '2021-02-26 11:00:17.000000', '2021-02-26 11:00:17.000000', 'ACTIVE'),
('8f418417-c70f-44de-a290-7b7542e8bc6c', 7, 3, NULL, 'ncie computer', '2021-03-05 14:32:15.000000', '2021-03-05 14:32:15.000000', 'ACTIVE'),
('937a1fdf-ae7a-4012-9000-55e6f4ed4fba', 3, 3, NULL, 'you have commented on this spot', '2021-03-03 11:25:43.000000', '2021-03-03 11:25:43.000000', 'ACTIVE'),
('a7a4d288-e03f-4739-ac0c-f22bf3d3d5fa', 25, 3, NULL, 'awesome mask! how much is it ', '2021-03-02 17:55:46.000000', '2021-03-02 17:55:46.000000', 'ACTIVE'),
('a9add0a1-eacd-4c70-b5d0-f418c2027386', 16, 3, NULL, 'ni nziza koko', '2021-03-02 05:22:49.000000', '2021-03-02 05:22:49.000000', 'ACTIVE'),
('bb015468-3c3e-490c-9647-4a7fafa4ab01', 1, 3, NULL, 'interesting', '2021-02-19 18:57:49.000000', '2021-02-19 18:57:49.000000', 'ACTIVE'),
('beb05ad6-5723-4db6-82a0-a18c6577646a', 16, 3, NULL, 'nice book', '2021-03-11 11:55:50.000000', '2021-03-11 11:55:50.000000', 'ACTIVE'),
('cb3b0344-56da-4e4e-b93e-ce72763387f0', 2, 3, NULL, 'awesome fish', '2021-02-24 07:53:24.000000', '2021-02-24 07:53:24.000000', 'ACTIVE'),
('ceefb12a-05b0-4818-b074-86eb65111093', 16, 3, NULL, 'my comment', '2021-03-05 07:13:17.000000', '2021-03-05 07:13:17.000000', 'ACTIVE'),
('db1b4393-4500-43e0-808a-87768b90d218', 3, 3, NULL, 'ark ibi bintu numuti kbx', '2021-03-05 08:51:57.000000', '2021-03-05 08:51:57.000000', 'ACTIVE'),
('e8777988-a3dc-48d4-984f-11308807fc77', 16, 3, NULL, 'it is good', '2021-03-10 20:02:04.000000', '2021-03-10 20:02:04.000000', 'ACTIVE'),
('ea391df3-6ee4-41bf-8694-ed553d1a9323', 2, 3, NULL, 'hey', '2021-03-04 20:08:44.000000', '2021-03-04 20:08:44.000000', 'ACTIVE'),
('eb61d017-ee34-44a6-b4dc-e5f7167c4f92', 1, 3, '03a1e527-f2db-442f-91d6-ddac501fff9a', 'Toka shishi niki niki', '2021-02-04 16:02:19.000000', '2021-02-04 16:02:19.000000', 'ACTIVE'),
('ef9a86f6-19b6-4627-aac4-b664804eb364', 5, 3, NULL, 'I loved this spot', '2021-03-10 08:17:31.000000', '2021-03-10 08:17:31.000000', 'ACTIVE'),
('f859985b-4b66-4a63-a03d-9250bed5cf1a', 6, 3, NULL, 'dfghytrsrtsrrrrrrgrdrd', '2021-02-08 19:12:16.000000', '2021-02-08 19:12:16.000000', 'ACTIVE'),
('fe5884e4-f1e2-4ac5-a243-f56568342b54', 3, 3, NULL, 'awesome fish fo real', '2021-02-11 17:44:16.000000', '2021-02-11 17:44:16.000000', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `comment_reactions`
--

CREATE TABLE `comment_reactions` (
  `comment_reaction_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `comment_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `user_id` int(10) NOT NULL,
  `liked` tinyint(1) NOT NULL,
  `created_at` datetime(6) NOT NULL,
  `updated_at` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `comment_reactions`
--

INSERT INTO `comment_reactions` (`comment_reaction_id`, `comment_id`, `user_id`, `liked`, `created_at`, `updated_at`) VALUES
('2', '19', 3, 0, '2021-02-04 23:16:20.000000', '2021-02-04 23:16:20.000000'),
('f6ba093f-f0ec-43e9-ab84-fa1e7ecc2e40', '03a1e527-f2db-442f-91d6-ddac501fff9a', 3, 0, '2021-02-04 16:23:17.000000', '2021-02-04 16:25:50.000000');

-- --------------------------------------------------------

--
-- Table structure for table `locations`
--

CREATE TABLE `locations` (
  `location_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `level_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `parent_id` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `location_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `location_GPS` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` text COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL DEFAULT 'Active'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `locations`
--

INSERT INTO `locations` (`location_id`, `level_id`, `parent_id`, `location_name`, `location_GPS`, `description`, `status`) VALUES
('6c9652ec-ce3a-449d-ae0b-7f88e2722d8e', 'd10f8349-bbe4-4846-9ab1-e2ffdf039591', '6e08fb8f-9a60-467a-8658-2033c2605535', 'xyz', '12', 'district', 'Active'),
('6e08fb8f-9a60-467a-8658-2033c2605535', '6e52b30f-4eeb-49c9-9e41-6e76ddf92665', 'af95f097-008e-4774-a67a-3ca6d42c3d55', 'Southern Province', '2.5547° S, 29.6035° E', 'this is the province where their main activity is agriculture', 'active'),
('af95f097-008e-4774-a67a-3ca6d42c3d55', '6f4e56c6-a173-42a3-b458-a7ead5905ad0', 'LOC001CONT', 'Rwanda', '1.9403° S, 29.8739° E', 'Rwanda, officially the Republic of Rwanda, is a landlocked country in the Great Rift Valley, where the African Great Lakes region and East Africa converge. One of the smallest countries on the African mainland, its capital city is Kigali.', 'active'),
('bd36b6ba-19cb-426d-8f63-7f8705bb7934', 'd10f8349-bbe4-4846-9ab1-e2ffdf039591', '6e08fb8f-9a60-467a-8658-2033c2605535', 'Gicumbi', '1234', 'the district in gicumbi', 'Active'),
('cell1', 'eca3e2f7-20a7-4163-b67b-fd701dce5793', 's1', 'Kitabi', 'kitabi 233', 'Kitabi', 'Active'),
('de4a41f1-e001-4266-9290-31f6192c0657', '6e52b30f-4eeb-49c9-9e41-6e76ddf92665', 'af95f097-008e-4774-a67a-3ca6d42c3d55', 'Kigali', '1.9441° S, 30.0619° E', 'Kigali is the capital city of Rwanda, roughly in the center of the country. It sprawls across numerous hills, ridges and valleys, and has a vibrant restaurant and nightlife scene. The Kigali Genocide Memorial documents the 1994 mass killings in Rwanda, associated with the country’s civil war. The city’s Caplaki Crafts Village has stalls selling traditional handicrafts, including woodcarvings and woven baskets', 'active'),
('LOC001CONT', '84fc4a8d-9720-406e-9b7b-2c020277f725', NULL, 'Africa', '8.7832° S, 34.5085° E\r\n', 'Africa is the world\'s second-largest and second-most populous continent, after Asia in both cases.', 'Active'),
('LOC001HQT', '6e52b30f-4eeb-49c9-9e41-6e76ddf92666', 'LOC004CONT', 'United States', '37.0902° N, 95.7129° W', 'Africa is the world\'s second-largest and second-most populous continent, after Asia in both cases. At about 30.3 million km² including adjacent islands, it covers 6% of Earth\'s total surface area and 20% of its land area. With 1.3 billion people as of 2018, it accounts for about 16% of the world\'s human population.', 'active'),
('LOC002CONT', '84fc4a8d-9720-406e-9b7b-2c020277f725', NULL, 'Europe', '54.5260° N, 15.2551° E\r\n', 'Europe is a continent located entirely in the Northern Hemisphere and mostly in the Eastern Hemisphere.', 'inactive'),
('LOC003CONT', '84fc4a8d-9720-406e-9b7b-2c020277f725', NULL, 'South America', '8.7832° S, 55.4915° W', 'South America is a continent entirely in the Western Hemisphere and mostly in the Southern Hemisphere, with a relatively small portion in the Northern Hemisphere. It can also be described as a southern subcontinent of the Americas.', 'Active'),
('LOC004CONT', '84fc4a8d-9720-406e-9b7b-2c020277f725', NULL, 'North America', '54.5260° N, 105.2551° W\r\n', 'North America is a continent entirely within the Northern Hemisphere and almost all within the Western Hemisphere. It can also be described as the northern subcontinent of the Americas.', 'Active'),
('LOC005CONT', '84fc4a8d-9720-406e-9b7b-2c020277f725', NULL, 'Antarctica', '82.8628° S, 135.0000° E', 'Antarctica, the southernmost continent and site of the South Pole, is a virtually uninhabited, ice-covered landmass. Most cruises to the continent visit the Antarctic Peninsula, which stretches toward South America. It’s known for the Lemaire Channel and Paradise Harbor, striking, iceberg-flanked passageways, and Port Lockroy, a former British research station turned museum. The peninsula’s isolated terrain also shelters rich wildlife, including many penguins. ', 'Active'),
('LOC006CONT', '84fc4a8d-9720-406e-9b7b-2c020277f725', NULL, 'Oceania', '22.7359° S, 140.0188° E', 'Oceania is a geographic region that includes Australasia, Melanesia, Micronesia and Polynesia. Spanning the Eastern and Western Hemispheres, Oceania has a land area of 8,525,989 square kilometres and a population of over 41 million.', 'active'),
('LOC007CONT', '84fc4a8d-9720-406e-9b7b-2c020277f725', NULL, 'Asia', '34.0479° N, 100.6197° E', 'Asia is Earth\'s largest and most populous continent, located primarily in the Eastern and Northern Hemispheres. It shares the continental landmass of Eurasia with the continent of Europe and the continental landmass of Afro-Eurasia with both Europe and Africa.', 'Active'),
('nya1', 'd10f8349-bbe4-4846-9ab1-e2ffdf039591', '6e08fb8f-9a60-467a-8658-2033c2605535', 'Nyanza', '984848S', 'Updated successfully', 'Active'),
('s1', '464c1562-4431-486c-88b6-caf56f3682d9', 'nya1', 'Nyamagabe se', 'het73', 'nys', 'Active');

-- --------------------------------------------------------

--
-- Table structure for table `location_levels`
--

CREATE TABLE `location_levels` (
  `level_id` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `level_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `description` text CHARACTER SET utf8 COLLATE utf8_unicode_ci
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `location_levels`
--

INSERT INTO `location_levels` (`level_id`, `level_name`, `description`) VALUES
('1191a734-896e-46cf-84b2-7db8db78ff93', 'street', NULL),
('1535a84a-d96b-430f-b0a2-ddb1d887c921', 'village', ''),
('1ac588ad-e2d5-4564-8fb5-3f1207e0c0e7', 'level 1', 'level 1 description'),
('464c1562-4431-486c-88b6-caf56f3682d9', 'sector', ''),
('4e6e1b80-52e3-48a3-90ea-339c975343a8', 'dggdggd', 'hfdhfhdhfdshfdhhfdhfdhfdhhfdhfdh'),
('6d3f7f22-290f-4033-b730-8aa2f340c469', 'efdfhhf', 'eryyryeyery'),
('6e52b30f-4eeb-49c9-9e41-6e76ddf92665', 'province', ''),
('6e52b30f-4eeb-49c9-9e41-6e76ddf92666', 'State', ''),
('6f4e56c6-a173-42a3-b458-a7ead5905ad0', 'country', ''),
('84fc4a8d-9720-406e-9b7b-2c020277f725', 'continent', ''),
('d10f8349-bbe4-4846-9ab1-e2ffdf039591', 'district', ''),
('eca3e2f7-20a7-4163-b67b-fd701dce5793', 'cell', '');

-- --------------------------------------------------------

--
-- Table structure for table `searchHistory`
--

CREATE TABLE `searchHistory` (
  `history_id` int(10) NOT NULL,
  `searched_query` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `user_id` int(10) NOT NULL,
  `search_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `searchHistory`
--

INSERT INTO `searchHistory` (`history_id`, `searched_query`, `user_id`, `search_date`) VALUES
(1, 'hotels in Rwanda', 1, '2020-01-26'),
(2, 'hotels in Rwanda', 48, '2020-01-29'),
(4, 'hotels in Rwanda', 30, '2020-01-30'),
(9, 'the best bar', 33, '2020-01-26'),
(11, 'what schhools in nyabihu', 1, '2020-01-26'),
(12, 'stadium in musanze', 41, '2020-02-26'),
(14, 'best house for meeting in kigali', 1, '2020-01-26'),
(15, 'when was ARENA built', 33, '2020-02-26'),
(18, 'is there house for sale?', 41, '2021-01-26'),
(19, 'Rwanda best hotels', 1, '2021-02-26'),
(20, 'airports in bugesera', 30, '2021-01-26'),
(22, 'basket ball playgrounds', 1, '2021-02-26'),
(23, 'spot', 33, '2020-02-26'),
(24, 'spots', 30, NULL),
(30, 'Rwanda', 30, NULL),
(31, 'Sawa Sawa hotel\r\n', 41, NULL),
(32, 'Five stars', 33, '2021-03-04'),
(33, 'lake Kivu ', 1, '2021-03-04'),
(34, 'fish', 41, '2021-03-05'),
(35, 'traversy', 41, '2021-03-05'),
(36, 's', 41, '2021-03-05'),
(37, 'fish', 41, '2021-03-05'),
(38, 's', 41, '2021-03-05'),
(39, 'fish', 41, '2021-03-06'),
(40, 'fish', 41, NULL),
(41, 'fish', 41, NULL),
(42, 'fish', 41, NULL),
(43, 'fish', 41, NULL),
(44, 's', 41, NULL),
(45, 'comment', 41, NULL),
(46, 'comment', 41, NULL),
(47, 'fish', 30, NULL),
(48, 'book', 30, NULL),
(50, 'boo', 30, NULL),
(51, 'sp', 30, NULL),
(52, 'Five stars', 45, NULL),
(53, 'b', 30, NULL),
(54, 'fish', 48, NULL),
(55, 'fish', 48, NULL),
(56, 'fish', 48, NULL),
(57, 'fish', 48, NULL),
(58, 'g', 30, NULL),
(59, 's', 30, NULL),
(60, 'socks', 48, NULL),
(61, 'socks', 48, NULL),
(62, 's', 30, NULL),
(63, 'American meal', 48, '2021-03-05'),
(64, 'Touristic attraction in America', 48, '2021-03-05'),
(65, 'American meal', 48, '2021-03-05'),
(66, 'river Akagera', 33, '2021-03-05'),
(67, 'hotels (American meals)', 30, '2021-03-05'),
(68, 'best beach in miami', 48, '2021-03-05'),
(69, 's', 30, NULL),
(70, 'fish', 30, NULL),
(71, 's', 30, NULL),
(72, 's', 30, NULL),
(73, 'Computer', 48, NULL),
(74, 'Computer', 48, NULL),
(75, 's', 30, NULL),
(76, 'Computer', 48, NULL),
(77, 'Computer', 48, NULL),
(78, 'river Akagera', 33, NULL),
(80, 'Computer', 48, NULL),
(81, 'sockx', 48, NULL),
(82, 'socks', 48, NULL),
(83, 's', 30, NULL),
(84, 's', 30, NULL),
(85, 'spot', 27, NULL),
(86, 'socks', 30, NULL),
(87, 'o', 30, NULL),
(88, 'o', 30, NULL),
(90, 'spot', 27, NULL),
(91, 's', 27, NULL),
(92, 'hotels in Rwanda', 33, NULL),
(93, 's', 27, NULL),
(94, 's', 27, NULL),
(95, 'fish', 33, NULL),
(96, 'socks', 33, NULL),
(97, 's', 27, NULL),
(98, 's', 27, NULL),
(99, 'socks', 27, NULL),
(100, 's', 27, NULL),
(101, 'Computer', 48, NULL),
(102, 'hotelB', 48, NULL),
(103, 'book', 48, NULL),
(104, 'computer', 48, NULL),
(105, 'comp', 48, NULL),
(106, 'comp', 48, NULL),
(107, 'Comp', 48, NULL),
(108, 'comp', 48, NULL),
(109, 'nearby', 48, '2021-03-10'),
(110, 'near', 48, '2021-03-10'),
(111, 'comp', 48, NULL),
(112, 'comp', 48, NULL),
(113, 'b', 30, NULL),
(114, 'me', 30, NULL),
(115, 'comp', 48, NULL),
(116, 'comp', 48, NULL),
(117, 'comp', 48, NULL),
(118, 'Comp', 48, NULL),
(119, 'Comp', 48, NULL),
(120, 'fish', 45, NULL),
(121, 'fish', 45, NULL),
(122, 'house', 30, '2021-03-10'),
(123, 's', 33, NULL),
(125, 'straw', 30, '2021-03-10'),
(126, 'big', 30, '2021-03-10'),
(127, 'berry', 30, '2021-03-10'),
(128, 'partying', 30, '2021-03-10'),
(129, 'buk', 30, '2021-03-10'),
(130, 'baldi', 30, '2021-03-10'),
(131, 'ball', 30, '2021-03-11'),
(137, 'book', 48, NULL),
(138, 'book', 48, NULL),
(139, 'book', 48, NULL),
(140, 'book', 48, NULL),
(141, 'book', 48, NULL),
(142, 'book', 48, NULL),
(143, 'book', 48, NULL),
(144, 'book', 48, NULL),
(145, 'book', 48, NULL),
(146, 'book', 48, NULL),
(147, 'book', 48, NULL),
(148, 'fish', 33, NULL),
(149, 'book', 33, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `spot_category`
--

CREATE TABLE `spot_category` (
  `category_id` int(20) NOT NULL,
  `user_id` int(20) NOT NULL,
  `category_name` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `Description` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `status` varchar(255) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `spot_category`
--

INSERT INTO `spot_category` (`category_id`, `user_id`, `category_name`, `Description`, `status`) VALUES
(1, 3, 'Rwanda Coding Academy', 'rwanda coding academy is a school located in Nyabihu district', 'active'),
(3, 8, 'Food', 'Nyirangarama products', 'active'),
(6, 3, 'Gender Balance in Rwanda', 'gender is the concept that is still not understable in Rwanda due to our culture', 'active'),
(7, 1, 'Balanced diet', 'balanced diet is on good level in Rwanda compared to few years ago', 'nonactive'),
(8, 1, 'Books in libraries', 'nowadays students are able to find books in libraries for free', 'active'),
(9, 1, 'Fish', 'Tilapi', 'active'),
(10, 1, 'Schools', 'All working schools all over the world', 'active'),
(11, 1, 'Students', 'Nyabihu students', 'active'),
(13, 1, 'Amafi', 'Amafi yamize Yonasi', 'active'),
(14, 1, 'desk', 'sddff', 'active'),
(15, 1, 'Huye waterfall', 'huye waterfall provide huye water for people', 'nonactive'),
(16, 1, 'Stree Foods in Kigali City', 'street foods are restricted in kigali city due to health issues', 'active'),
(17, 1, 'Health Centers in Rwanda', 'health centers in rwanda is where you can get health services easily before going to main hospital', 'active'),
(18, 1, 'School projects in RCA', 'Rca has got talented young software geeks with different projects', 'active'),
(19, 1, 'RCA girls', 'rca gilrs have different projects to show rwandans ', 'nonactive'),
(20, 30, 'Rwanda Coding Academy', 'School located in Nyabihu district', 'active'),
(21, 30, 'schools in Rwamagana', 'rwamagana has many schools including primary and secondary', 'active'),
(22, 30, 'rwanda coding acdadey', 'located in Nyabihu', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `spot_ratings`
--

CREATE TABLE `spot_ratings` (
  `rating_id` int(11) NOT NULL,
  `user_id` int(10) NOT NULL,
  `spot_id` int(11) NOT NULL,
  `rating` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `spot_ratings`
--

INSERT INTO `spot_ratings` (`rating_id`, `user_id`, `spot_id`, `rating`) VALUES
(9, 48, 5, 5),
(11, 48, 16, 5),
(12, 48, 16, 4),
(13, 48, 16, 5),
(14, 48, 16, 3),
(15, 48, 30, 5);

-- --------------------------------------------------------

--
-- Table structure for table `Spot_table`
--

CREATE TABLE `Spot_table` (
  `spot_id` int(11) NOT NULL,
  `user_id` int(10) NOT NULL,
  `category_id` int(20) NOT NULL,
  `location_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `spot_name` varchar(11) COLLATE utf8_unicode_ci NOT NULL,
  `spot_description` varchar(200) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `views` int(11) DEFAULT NULL,
  `viewers` int(11) DEFAULT NULL,
  `rates` int(11) DEFAULT '0',
  `registration_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `status` int(100) DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `Spot_table`
--

INSERT INTO `Spot_table` (`spot_id`, `user_id`, `category_id`, `location_id`, `spot_name`, `spot_description`, `views`, `viewers`, `rates`, `status`) VALUES
(1, 57, 1, '1', 'mouse', 'mouse in class a', 22, 456, NULL, 1),
(2, 30, 2, '2', '', 'food', 23, 345, 24, 1),
(3, 3, 1, 'LOC001HQT', 'fish', 'spo3description', 23, 345, 24, 1),
(4, 3, 1, 'LOC001HQT', 'fish', 'spo4description', 23, 345, 24, 1),
(5, 3, 1, '1', 'Computer', 'spo5description', 22, 56, 67, 1),
(6, 3, 1, '2', 'Table', 'spo6description', 22, 67, NULL, 1),
(7, 3, 1, '3', 'Computer', 'spo7description', 22, NULL, NULL, 1),
(8, 1, 1, '1', '', 'updated one', NULL, NULL, NULL, 0),
(12, 1, 45, '5655', 'jacket', 'Black and brown mouse found in class A', NULL, NULL, NULL, 1),
(13, 1, 1, '1', '', 'sinzi', NULL, NULL, NULL, 0),
(14, 1, 45, '5655', 'Updated', 'Balck and brown table found in Ouuaagaadouuguuu', NULL, NULL, NULL, 0),
(15, 30, 1, '1', 'hotels', 'hotel description', NULL, NULL, NULL, 1),
(16, 33, 1, '1', 'book', 'school material', NULL, NULL, NULL, 1),
(18, 35, 1, '1', 'spot', 'spot description', NULL, NULL, NULL, 1),
(19, 1, 1, '1', '1', '1', NULL, NULL, NULL, 1),
(20, 1, 1, '1', 'Ubushera', 'ubushera bwokeje ', NULL, NULL, NULL, 1),
(21, 1, 1, '1', '1', '1', NULL, NULL, NULL, 1),
(23, 1, 1, '1', 'coding', 'heehehehe', NULL, NULL, NULL, 1),
(24, 1, 1, '1', 'Ndakureba', 'ku mugoroba', NULL, NULL, NULL, 1),
(25, 30, 3, '2', 'face mask', 'basic material that helps to prevent covid-19', NULL, NULL, NULL, 1),
(26, 1, 1, '1', 'Socks', 'amasogisi', NULL, NULL, NULL, 1),
(27, 1, 1, '1', 'Gourde', 'Isa n\'ibara ry\'umukara', NULL, NULL, NULL, 1),
(28, 1, 1, '1', 'Monitor', 'Dell\'s monitor', NULL, NULL, NULL, 1),
(29, 30, 2, '1', 'ghetto', 'ghte', NULL, NULL, NULL, 1),
(30, 30, 43, '2', 'Book', 'books in class c', NULL, NULL, NULL, 1),
(31, 30, 44, '2', '2', 'dfsd', NULL, NULL, NULL, 1),
(32, 57, 111, '23', 'fod', 'food in nyabihu', NULL, NULL, NULL, 1),
(33, 57, 555, '1', '1', 'fish', NULL, NULL, NULL, 1),
(34, 57, 90, '1', '1', '1', NULL, NULL, NULL, 1),
(35, 57, 1, '1', 'keyboard', 'in class a', NULL, NULL, NULL, 1),
(36, 57, 1, '1', 'Keyboard', 'keyboard in class 1', NULL, NULL, NULL, 1),
(37, 57, 1, '1', '1', 'food', NULL, NULL, NULL, 1),
(38, 57, 1, '1', 'food', 'food in a', NULL, NULL, NULL, 1);

-- --------------------------------------------------------

--
-- Table structure for table `test_tb`
--

CREATE TABLE `test_tb` (
  `id` int(11) NOT NULL,
  `username` varchar(110) COLLATE utf8_unicode_ci NOT NULL,
  `description` varchar(110) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `test_tb`
--

INSERT INTO `test_tb` (`id`, `username`, `description`) VALUES
(1, 'ntwari egide', 'The Scrum Master is accountable for the Scrum Team\'s effectiveness. They do this by enabling the Scrum Team to'),
(2, 'Cedric Izabayo', 'A project manager is a person who has the overall responsibility for the');

-- --------------------------------------------------------

--
-- Table structure for table `users_billing`
--

CREATE TABLE `users_billing` (
  `id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `billing_id` int(10) NOT NULL,
  `start_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `end_date` date NOT NULL,
  `status` enum('ACTIVE','EXPIRED') COLLATE utf8_unicode_ci NOT NULL DEFAULT 'ACTIVE'
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users_billing`
--

INSERT INTO `users_billing` (`id`, `user_id`, `billing_id`, `end_date`, `status`) VALUES
(1, 1, 2, '2021-03-04', 'ACTIVE'),
(2, 56, 1, '2021-03-01', 'ACTIVE'),
(3, 30, 2, '2021-03-05', 'ACTIVE'),
(4, 56, 2, '2022-01-05', 'ACTIVE'),
(5, 57, 2, '2022-01-05', 'ACTIVE'),
(6, 27, 2, '2021-08-27', 'ACTIVE'),
(7, 1, 1, '2021-03-10', 'ACTIVE');

-- --------------------------------------------------------

--
-- Table structure for table `users_categories`
--

CREATE TABLE `users_categories` (
  `category_id` int(11) NOT NULL,
  `user_category` varchar(50) NOT NULL,
  `category_status` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'active'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users_categories`
--

INSERT INTO `users_categories` (`category_id`, `user_category`, `category_status`) VALUES
(1, 'NORMAL_USER', 'active'),
(2, 'ADMIN', ''),
(3, 'SUPER_ADMIN', 'active');

-- --------------------------------------------------------

--
-- Table structure for table `users_session`
--

CREATE TABLE `users_session` (
  `user_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `users_session`
--

INSERT INTO `users_session` (`user_id`) VALUES
(30),
(30),
(30),
(30),
(30),
(30),
(30);

-- --------------------------------------------------------

--
-- Table structure for table `users_table`
--

CREATE TABLE `users_table` (
  `user_id` int(10) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `user_name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `gender` varchar(10) NOT NULL,
  `birth_date` date NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_category` int(11) NOT NULL,
  `location` varchar(30) NOT NULL,
  `user_status` varchar(100) NOT NULL,
  `registration_date` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Dumping data for table `users_table`
--

INSERT INTO `users_table` (`user_id`, `first_name`, `last_name`, `user_name`, `email`, `gender`, `birth_date`, `password`, `user_category`, `location`, `user_status`) VALUES
(1, 'egide', 'ntwali', 'test', '@gmail.com', 'male', '2004-03-04', 'munedidier', 2, 'musanze', 'disabled'),
(3, 'Lento', 'Gersh', 'gersh', 'gersh@gmail.com', 'male', '2003-04-08', '$2a$12$F8zyts0Q9.jy5WlMeEwkrek8dcVMxYnpJaF0P0.6RP1...', 2, 'locatio1', 'active'),
(4, 'anselme', 'hhhh', 'ansufati', 'fggf@gmail.com', 'Male', '2021-02-02', 'dfhggf', 1, 'rgfhj', 'disabled'),
(8, 'tuyizere', 'paul', 'coulomb', 'test@gmail.com', 'male', '2020-12-10', '1234', 1, 'nyabihuu', 'inactive'),
(23, 'mutoni', 'denyse', 'denyse', '.mutoni@gmail.com', 'female', '2004-05-06', '$2a$12$R7My5M3xYTy.msbThJ1CNuldSFKeFPOTF87YtRhF36ohxlTv.YMhG', 2, 'nyabihu', 'inactive'),
(24, 'kerie', 'kellia', 'mutoni', 'mutonidenyse@gmail.com', 'femlae', '2004-04-05', '$2a$12$yxyCVhpLmCxy4qmtmVqumeKl3sp7R/dbp7fRS6hOrkxhYWQfkAr0y', 1, 'nyabihu', 'inactive'),
(25, 'kerie', 'uwonkunda', 'izere', '.izere@gmail.com', 'female', '2005-04-05', '$2a$12$1ShK6bzauJVVXkOhs4qG3./vlBcJtuMeV8GyNDRhU3PDYKk8GSXUW', 1, 'nyabihu', 'inactive'),
(26, 'mutoni', 'denyse', 'denysemu', 'denysemutoniu@gmail.com', 'femlae', '2004-03-04', '$2a$12$MXpOj2XAYdg4uutv0YC7ruLV9B8NctS6XO3ceNJRjeHOIaz3.AxGa', 1, 'nyabihu', 'active'),
(27, 'Oreste', 'Abizera', 'Cod', 'oresteabizera11@gmail.com', 'male', '2017-06-05', '$2a$12$86w9zI7zkuuqBCfppSnUoOye.JlqMdhAB2kpVctjSp.ttJi.wsrva', 1, 'Mukamira', 'active'),
(28, 'Anna', 'belle', 'anana', 'ana@gmail.com', 'female', '2003-03-23', '$2a$12$KSCveW2kmaxJTrsajFMEhecfgytO0GTl83wW.ADOAfNqFnzGEhxkS', 1, 'nyabihu', 'inactive'),
(29, 'mahani', 'jent', 'ertghy', 'werewrw@gmail.com', 'male', '2009-10-20', '$2a$12$N8.jEHWWbBxdCazmCZKqSujx8are5V8wv4Heu2v5EW0ijSd2VYG7a', 1, 'nyaabs', 'inactive'),
(30, 'ntwari', 'egide', 'default', 'default@gmail.com', 'male', '2020-12-09', '$2a$12$F8zyts0Q9.jy5WlMeEwkrek8dcVMxYnpJaF0P0.6RP1LCed7bLQL.', 2, 'kayonza', 'inactive'),
(31, 'hello', 'world', 'hello', 'hello@gmail.com', 'male', '0200-09-08', '$2a$12$7IDO57Yh5l0LpZ4qWzr9.u5i0Z3NUWB/lnBIeKmmoaJJjswPWFBPK', 1, 'world', 'inactive'),
(33, 'verie', 'best', 'verie', 'verie@gmail.com', 'f', '2005-06-20', '$2a$12$86w9zI7zkuuqBCfppSnUoOye.JlqMdhAB2kpVctjSp.ttJi.wsrva', 2, 'huye', 'active'),
(34, 'best', 'der', 'best', 'best@gmail.com', 'f', '2003-05-20', '$2a$12$NrXfKq.KK0O3Bt667WqLW.bFTrp5jbzut3SNhw0B8DZSo4/M3oQaa', 1, 'Rwanda', 'inactive'),
(35, 'erneste', 'ntezirizaza', 'erneste', 'tbg@gmail.com', 'male', '1999-02-20', '$2a$12$WJUcXoETJ1kkKe0XwngG6uwlivy1t87Cr13FlmOuKjiUImFCcZFfy', 1, 'kayonza', 'inactive'),
(36, 'MANZI', 'Mike', 'Mike', 'mike@gmail.com', 'male', '2001-01-01', '$2a$12$CqJuwLzubk7GCYKPuS2gGebGArh0In6YoWbgXpeuVr1SE8Yur0aeC', 1, 'Nyabihu', 'inactive'),
(38, 'Coder', 'Tauras', 'tauras', 'coderspace@tauras.com', 'male', '2015-07-08', '$2a$12$QC7zUEa38gaGIbSOEIk0RuL672orl.gGMhD65zO.VxIw86Tld0/Da', 1, 'AXA', 'inactive'),
(39, 'rubyogo', 'sokuru', 'rubyogo', 'rubyogo@gmail.com', 'male', '2012-03-20', '$2a$12$VMyXemMp.Edj0FtrkFVP0uAlH8NBKrKXbqKHmx7hZZt5bDBp/9oIu', 1, 'Bihu', 'inactive'),
(41, 'mutoni', 'denyse', 'mdenyse', 'mdenyse32443@gmail.com', 'female', '2000-03-04', '$2a$12$v93WNNoK0HMReV3K7loz4O9LaLZVrXuo1qo6IoF6lXXDYjp1C3DSu', 1, '1', 'inactive'),
(42, 'ange', 'constance', 'coco', 'coco@gmail.com', 'female', '2003-04-06', '$2a$12$2oeDoDm2vWCxDfskKVYGweStsR.Nse9Bl4Pct4EsDMstVyfT1EBsq', 1, 'nyabihu', 'inactive'),
(43, 'divine', 'ikirezi', 'iikirezi', 'ikirezi@gmail.com', 'female', '2000-01-01', '$2a$12$XckDymmyJ6eSacsfgE2X3OgJNcHbpc0OUMIMmfp4Ccuhy12GkB5Oy', 1, 'Rwanda', 'inactive'),
(44, 'Anne', 'Akimana', 'gafotozi', 'gafotozi@gmail.com', 'female', '2021-06-20', '$2a$12$GMHOG/kphAYZMt5Lyw/ydOdC/KQVHP45Z1zK3ZVDFoSA9kVMCWTDW', 1, 'Rwanda', 'inactive'),
(45, 'kerie', 'izere', 'kerie', 'izere@gmail.com', 'female', '2003-01-01', '$2a$12$zYtNTxLgEinTMurGiA1TjOPPdsstronWSp/AN4J/c1/WfIJcNoQrG', 1, 'nyabihu', 'inactive'),
(46, 'gersho', 'lapaix', 'gershom', 'gershom33@gmail.com', 'male', '2003-12-02', '$2a$12$O9PoK9LzVPswoXLsbHNsiO3Fo/uNF.xLSd67/UWeBN3PBZlKexaki', 1, 'kayonza', 'inactive'),
(47, 'boaz', 'cyubahiro', 'boazcyubahiro', 'boaz@gmail.com', 'male', '2015-11-21', '$2a$12$i4Su.XpvKyxmpR1JxqZpKuV6GHhhI1KwuA5n85J4lRonpOTVE2cDi', 1, 'kayonza', 'inactive'),
(48, 'Testing user', 'user', 'testing', 'defaultuser@gmail.com', 'male', '2020-02-03', '$2a$12$P8ixMvZQJmzsIT/DkD01q..RqX5PSHzcRGBF/I0zdERbMyjiVFsty', 1, 'Mukamira', 'inactive'),
(49, 'Twizeyimana', 'Elissa', 'Edisor', 'twizelissa@gmail.com', 'male', '1997-10-20', '$2a$12$hS34DqvRsUJUrtLSMiLx1enSWM.MXNjMpRib3/iHW477yjTl6Stci', 1, 'Gicumbi', 'inactive'),
(50, 'ntwari', 'egide', 'scrum master', 'ntwariegide2@gmail.com', 'male', '2021-02-03', '$2a$12$zoEAqeJYVE6VnDPrqgF3DOW5ZxmFfmxJ9FCpofDSY5GB4/YzgiUEe', 1, 'Mukamira', 'inactive'),
(51, 'Kiyoni', 'Kagoma', 'kagoma', 'kagoma@gmail.com', 'male', '2012-12-12', '$2a$12$JaNidAqalNFjQLOERYCRxOvZ.pFFutAvD9KIKr8qIE6bcepEkS3h2', 1, 'Gitagata', 'inactive'),
(53, 'muhodari', 'muhodari', 'muhodari', 'sagemuho@gmail.com', 'male', '2020-12-12', '$2a$12$VSloThTnrVbUAKoS2KvNYu/2at9a5F16behsEhiJlyRMjmo9oBteW', 1, 'Rwanda', 'inactive'),
(54, 'MUGISHA', 'ISAAC', 'iMugisha', 'iMugisha@gmail.com', 'Male', '2021-01-01', '$2a$12$0al/MBCyfT9xKHVmVIM6ieklui2qySGsgbFiyusk309z/xg.Nigji', 1, 'Nyabihu', 'inactive'),
(55, 'phelix', 'phelix', 'phelix', 'phelix@gmail.com', 'male', '2005-01-02', '$2a$12$7mB1xLAck43rKqlrCMyPaOR0rTbRY2HUXJ9u8pIlnnGZCbTRD6Ndm', 1, 'Rwanda', 'inactive'),
(56, 'mutoni', 'denyse', 'mutoniiii', 'mutoni2222@gmail.com', 'female', '2004-04-03', '$2a$12$m96.ylh88yIkEV9KiLI4IelO.ya7JA4TL6284IE8m1FSxbb9Jsg1e', 1, 'nyabihu', 'inactive'),
(57, 'donatien', 'masengesho', 'masengesho', 'mashodot@gmail.com', 'male', '2003-03-03', '$2a$12$ipyKEKzzPklurOJNdBBsNefMLsnf2/4MvycyDAUUyDmJJHsuAG1d2', 1, 'nyabihu', 'inactive'),
(58, 'erneste', 'ntezi', 'ernene', 'erneste.lorenzo@gmail.com', 'male', '2003-03-03', '$2a$12$ZNlL9yTtjUr9JWggubnJG.rsCJXpeiTCU0y6bbXLCdMHdrAcRmrMW', 1, 'kayonza', 'inactive'),
(60, 'Twizeyimana', 'Elissa', 'Mengo', 'tzyelissa90@gmail.com', 'male', '1997-10-20', '$2a$12$C76LCQ0lmy2xysWRHRSzw.d.lxg7Sar7tGN0pybFICDMJQPrT/7.2', 1, 'Gicumbi', 'inactive'),
(61, 'Fiston', 'File', 'Fiston', 'fistonfle04@gmail.com', 'male', '1992-10-20', '$2a$12$nY4oc7/0Xltre.DYEoPWmeXvS90.Qbe.cJ9mSc1ZUy1DpsN8ca1zq', 1, 'Gicumbi', 'inactive');

-- --------------------------------------------------------

--
-- Table structure for table `user_logs`
--

CREATE TABLE `user_logs` (
  `id` int(255) NOT NULL,
  `user_id` int(10) NOT NULL,
  `date_Time_logged_In` timestamp NOT NULL,
  `Action` varchar(21000) COLLATE utf8_unicode_ci NOT NULL,
  `date_Time_logged_Out` date DEFAULT NULL,
  `Total_In` int(100) NOT NULL,
  `Total_out` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Dumping data for table `user_logs`
--

INSERT INTO `user_logs` (`id`, `user_id`, `date_Time_logged_In`, `Action`, `date_Time_logged_Out`, `Total_In`, `Total_out`) VALUES
(1, 33, '2021-02-11 00:00:00', 'logIn', NULL, 1, 0),
(2, 33, '2021-02-11 00:00:00', 'searching', NULL, 1, 0),
(3, 30, '2021-02-11 00:00:00', 'logIn', NULL, 2, 0),
(4, 30, '2021-02-11 00:00:00', 'created spot', NULL, 2, 0),
(5, 30, '2021-02-10 00:00:00', 'created spot', NULL, 2, 0),
(6, 30, '2021-02-10 00:00:00', 'searching', NULL, 2, 0),
(7, 30, '2021-02-10 00:00:00', 'searching', NULL, 2, 0),
(8, 35, '2021-02-10 00:00:00', 'searching', NULL, 2, 0),
(9, 35, '2021-02-10 00:00:00', 'logIn', NULL, 3, 0),
(10, 35, '2021-02-10 00:00:00', 'searching', NULL, 3, 0),
(11, 35, '2021-02-10 00:00:00', 'logIn', NULL, 4, 0),
(12, 35, '2021-02-10 00:00:00', 'logIn', NULL, 5, 0),
(13, 35, '2021-02-10 00:00:00', 'created spot', NULL, 5, 0),
(14, 35, '2021-02-10 00:00:00', 'searching', NULL, 5, 0),
(15, 35, '2021-02-10 00:00:00', 'logIn', NULL, 6, 0),
(16, 35, '2021-02-10 00:00:00', 'searching', NULL, 6, 0),
(17, 30, '2021-02-23 00:00:00', 'logIn', NULL, 7, 0),
(18, 30, '2021-02-23 00:00:00', 'searching', NULL, 7, 0),
(19, 35, '2021-02-10 00:00:00', 'logIn', NULL, 8, 0),
(20, 35, '2021-02-10 00:00:00', 'searching', NULL, 8, 0),
(21, 35, '2021-02-23 00:00:00', 'logIn', NULL, 9, 0),
(22, 35, '2021-02-23 00:00:00', 'searching', NULL, 9, 0),
(23, 33, '2021-02-23 00:00:00', 'logIn', NULL, 10, 0),
(24, 33, '2021-02-23 00:00:00', 'searching', NULL, 10, 0),
(25, 35, '2021-02-23 00:00:00', 'searching', NULL, 10, 0),
(26, 36, '2021-02-10 00:00:00', 'logIn', NULL, 11, 0),
(27, 33, '2021-02-10 00:00:00', 'searching', NULL, 11, 0),
(28, 36, '2021-02-10 00:00:00', 'logIn', NULL, 12, 0),
(29, 37, '2021-02-24 00:00:00', 'logIn', NULL, 13, 0),
(30, 30, '2021-02-10 00:00:00', 'searching', NULL, 13, 0),
(31, 33, '2021-02-25 00:00:00', 'logIn', NULL, 14, 0),
(32, 33, '2021-02-25 00:00:00', 'searching', NULL, 14, 0),
(33, 30, '2021-02-25 00:00:00', 'searching', NULL, 14, 0),
(34, 30, '2021-02-25 00:00:00', 'searching', NULL, 14, 0),
(35, 30, '2021-02-25 00:00:00', 'searching', NULL, 14, 0),
(36, 30, '2021-02-25 00:00:00', 'searching', NULL, 14, 0),
(37, 30, '2021-02-25 00:00:00', 'searching', NULL, 14, 0),
(38, 30, '2021-02-25 00:00:00', 'searching', NULL, 14, 0),
(39, 38, '2021-02-26 00:00:00', 'logIn', NULL, 15, 0),
(40, 38, '2021-02-26 00:00:00', 'logIn', NULL, 16, 0),
(41, 38, '2021-02-26 00:00:00', 'searching', NULL, 16, 0),
(42, 38, '2021-02-26 00:00:00', 'searching', NULL, 16, 0),
(43, 38, '2021-02-26 00:00:00', 'searching', NULL, 16, 0),
(44, 39, '2021-02-28 00:00:00', 'logIn', NULL, 17, 0),
(45, 39, '2021-02-28 00:00:00', 'logIn', NULL, 18, 0),
(46, 39, '2021-02-28 00:00:00', 'searching', NULL, 18, 0),
(47, 39, '2021-02-28 00:00:00', 'logIn', NULL, 19, 0),
(48, 39, '2021-02-28 00:00:00', 'logIn', NULL, 20, 0),
(49, 39, '2021-02-28 00:00:00', 'created spot', NULL, 20, 0),
(50, 30, '2021-02-28 00:00:00', 'searching', NULL, 20, 0),
(51, 39, '2021-03-01 00:00:00', 'logIn', NULL, 21, 0),
(52, 39, '2021-03-01 00:00:00', 'created spot', NULL, 21, 0),
(53, 30, '2021-03-01 00:00:00', 'logIn', NULL, 22, 0),
(54, 30, '2021-03-01 00:00:00', 'created spot', NULL, 22, 0),
(55, 30, '2021-03-01 00:00:00', 'created spot', NULL, 22, 0),
(56, 30, '2021-03-01 00:00:00', 'searching', NULL, 22, 0),
(57, 30, '2021-03-01 00:00:00', 'searching', NULL, 22, 0),
(58, 30, '2021-03-01 00:00:00', 'searching', NULL, 22, 0),
(59, 30, '2021-03-01 00:00:00', 'searching', NULL, 22, 0),
(60, 30, '2021-03-01 00:00:00', 'searching', NULL, 22, 0),
(61, 30, '2021-03-01 00:00:00', 'searching', NULL, 22, 0),
(62, 39, '2021-03-02 00:00:00', 'logIn', NULL, 23, 0),
(63, 30, '2021-03-02 00:00:00', 'searching', NULL, 23, 0),
(64, 30, '2021-02-10 00:00:00', 'logIn', NULL, 24, 0),
(65, 30, '2021-02-10 00:00:00', 'searching', NULL, 24, 0),
(66, 41, '2021-03-02 00:00:00', 'logIn', NULL, 25, 0),
(67, 30, '2021-03-02 00:00:00', 'logIn', NULL, 26, 0),
(68, 30, '2021-03-02 00:00:00', 'created spot', NULL, 26, 0),
(69, 30, '2021-03-02 00:00:00', 'searching', NULL, 26, 0),
(70, 33, '2021-03-02 00:00:00', 'logIn', NULL, 27, 0),
(71, 33, '2021-03-02 00:00:00', 'searching', NULL, 27, 0),
(72, 3, '2021-03-02 00:00:00', 'created Spot', NULL, 27, 0),
(73, 39, '2021-03-02 00:00:00', 'logIn', NULL, 28, 0),
(74, 39, '2021-03-02 00:00:00', 'logIn', NULL, 29, 0),
(75, 39, '2021-03-02 00:00:00', 'logIn', NULL, 30, 0),
(76, 33, '2021-03-02 00:00:00', 'created spot', NULL, 30, 0),
(77, 33, '2021-03-02 00:00:00', 'searching', NULL, 30, 0),
(78, 33, '2021-03-02 00:00:00', 'searching', NULL, 30, 0),
(79, 33, '2021-03-02 00:00:00', 'searching', NULL, 30, 0),
(80, 33, '2021-03-02 00:00:00', 'searching', NULL, 30, 0),
(81, 30, '2021-02-10 00:00:00', 'logIn', NULL, 31, 0),
(82, 30, '2021-03-02 00:00:00', 'logIn', NULL, 32, 0),
(83, 30, '2021-03-02 00:00:00', 'logIn', NULL, 33, 0),
(84, 39, '2021-03-02 00:00:00', 'logIn', NULL, 34, 0),
(85, 0, '2021-03-02 00:00:00', 'searching', NULL, 34, 0),
(86, 33, '2021-03-02 00:00:00', 'logIn', NULL, 35, 0),
(87, 33, '2021-03-02 00:00:00', 'searching', NULL, 35, 0),
(88, 33, '2021-03-02 00:00:00', 'searching', NULL, 35, 0),
(89, 33, '2021-03-02 00:00:00', 'logIn', NULL, 36, 0),
(90, 33, '2021-03-02 00:00:00', 'searching', NULL, 36, 0),
(91, 42, '2021-03-02 00:00:00', 'logIn', NULL, 37, 0),
(92, 43, '2021-03-02 00:00:00', 'logIn', NULL, 38, 0),
(93, 30, '2021-03-02 00:00:00', 'logIn', NULL, 39, 0),
(94, 39, '2021-03-02 00:00:00', 'logIn', NULL, 40, 0),
(95, 33, '2021-03-02 00:00:00', 'logIn', NULL, 41, 0),
(96, 39, '2021-03-02 00:00:00', 'created spot', NULL, 41, 0),
(97, 30, '2021-03-02 00:00:00', 'searching', NULL, 41, 0),
(98, 30, '2021-03-02 00:00:00', 'searching', NULL, 41, 0),
(99, 30, '2021-03-02 00:00:00', 'searching', NULL, 41, 0),
(100, 33, '2021-03-02 00:00:00', 'logIn', NULL, 42, 0),
(101, 33, '2021-03-02 00:00:00', 'searching', NULL, 42, 0),
(102, 33, '2021-03-02 00:00:00', 'searching', NULL, 42, 0),
(103, 39, '2021-03-02 00:00:00', 'logIn', NULL, 43, 0),
(104, 30, '2021-03-02 00:00:00', 'searching', NULL, 43, 0),
(105, 30, '2021-03-02 00:00:00', 'searching', NULL, 43, 0),
(106, 30, '2021-03-02 00:00:00', 'searching', NULL, 43, 0),
(107, 30, '2021-03-02 00:00:00', 'searching', NULL, 43, 0),
(108, 30, '2021-03-02 00:00:00', 'searching', NULL, 43, 0),
(109, 30, '2021-03-02 00:00:00', 'searching', NULL, 43, 0),
(110, 30, '2021-03-02 00:00:00', 'searching', NULL, 43, 0),
(111, 30, '2021-03-02 00:00:00', 'searching', NULL, 43, 0),
(112, 30, '2021-03-02 00:00:00', 'searching', NULL, 43, 0),
(113, 30, '2021-03-02 00:00:00', 'searching', NULL, 43, 0),
(114, 30, '2021-03-03 00:00:00', 'logIn', NULL, 44, 0),
(115, 30, '2021-03-03 00:00:00', 'logIn', NULL, 45, 0),
(116, 33, '2021-03-03 00:00:00', 'logIn', NULL, 46, 0),
(117, 33, '2021-03-03 00:00:00', 'searching', NULL, 46, 0),
(118, 30, '2021-03-03 00:00:00', 'logIn', NULL, 47, 0),
(119, 30, '2021-03-03 00:00:00', 'searching', NULL, 47, 0),
(120, 30, '2021-02-10 00:00:00', 'logIn', NULL, 48, 0),
(121, 30, '2021-02-10 00:00:00', 'logIn', NULL, 49, 0),
(122, 33, '2021-02-10 00:00:00', 'searching', NULL, 49, 0),
(123, 30, '2021-02-10 00:00:00', 'searching', NULL, 49, 0),
(124, 33, '2021-02-10 00:00:00', 'searching', NULL, 49, 0),
(125, 33, '2021-02-10 00:00:00', 'searching', NULL, 49, 0),
(126, 30, '2021-02-10 00:00:00', 'logIn', NULL, 50, 0),
(127, 33, '2021-02-10 00:00:00', 'searching', NULL, 50, 0),
(128, 33, '2021-02-10 00:00:00', 'searching', NULL, 50, 0),
(129, 30, '2021-02-10 00:00:00', 'searching', NULL, 50, 0),
(130, 33, '2021-02-10 00:00:00', 'searching', NULL, 50, 0),
(131, 39, '2021-03-03 00:00:00', 'logIn', NULL, 51, 0),
(132, 39, '2021-03-03 00:00:00', 'created spot', NULL, 51, 0),
(133, 30, '2021-03-03 00:00:00', 'logIn', NULL, 52, 0),
(134, 33, '2021-03-03 00:00:00', 'searching', NULL, 52, 0),
(135, 33, '2021-03-03 00:00:00', 'searching', NULL, 52, 0),
(136, 39, '2021-03-03 00:00:00', 'logIn', NULL, 53, 0),
(137, 30, '2021-03-03 00:00:00', 'searching', NULL, 53, 0),
(138, 44, '2021-03-03 00:00:00', 'logIn', NULL, 54, 0),
(139, 44, '2021-03-03 00:00:00', 'created spot', NULL, 54, 0),
(140, 33, '2021-03-03 00:00:00', 'searching', NULL, 54, 0),
(141, 33, '2021-03-03 00:00:00', 'searching', NULL, 54, 0),
(142, 30, '2021-03-03 00:00:00', 'logIn', NULL, 55, 0),
(143, 30, '2021-03-03 00:00:00', 'searching', NULL, 55, 0),
(144, 30, '2021-03-03 00:00:00', 'logIn', NULL, 56, 0),
(145, 30, '2021-03-03 00:00:00', 'logIn', NULL, 57, 0),
(146, 41, '2021-03-03 00:00:00', 'logIn', NULL, 58, 0),
(147, 45, '2021-03-03 00:00:00', 'logIn', NULL, 59, 0),
(148, 45, '2021-03-03 00:00:00', 'searching', NULL, 59, 0),
(149, 46, '2021-03-03 00:00:00', 'logIn', NULL, 60, 0),
(150, 45, '2021-03-03 00:00:00', 'searching', NULL, 60, 0),
(151, 30, '2021-03-03 00:00:00', 'logIn', NULL, 61, 0),
(152, 3, '2021-03-03 00:00:00', 'created Spot', NULL, 61, 0),
(153, 46, '2021-03-03 00:00:00', 'searching', NULL, 61, 0),
(154, 30, '2021-03-03 00:00:00', 'logIn', NULL, 62, 0),
(155, 30, '2021-03-03 00:00:00', 'logIn', NULL, 63, 0),
(156, 41, '2021-03-03 00:00:00', 'searching', NULL, 63, 0),
(157, 41, '2021-03-03 00:00:00', 'searching', NULL, 63, 0),
(158, 30, '2021-03-03 00:00:00', 'searching', NULL, 63, 0),
(159, 30, '2021-03-03 00:00:00', 'searching', NULL, 63, 0),
(160, 30, '2021-03-03 00:00:00', 'logIn', NULL, 64, 0),
(161, 30, '2021-03-03 00:00:00', 'logIn', NULL, 65, 0),
(162, 43, '2021-03-03 00:00:00', 'logIn', NULL, 66, 0),
(163, 43, '2021-03-03 00:00:00', 'logIn', NULL, 67, 0),
(164, 30, '2021-03-03 00:00:00', 'searching', NULL, 67, 0),
(165, 30, '2021-03-03 00:00:00', 'logIn', NULL, 68, 0),
(166, 41, '2021-03-03 00:00:00', 'searching', NULL, 68, 0),
(167, 30, '2021-03-03 00:00:00', 'searching', NULL, 68, 0),
(168, 45, '2021-03-04 00:00:00', 'logIn', NULL, 69, 0),
(169, 45, '2021-03-04 00:00:00', 'searching', NULL, 69, 0),
(170, 45, '2021-03-04 00:00:00', 'searching', NULL, 69, 0),
(171, 30, '2021-03-04 00:00:00', 'logIn', NULL, 70, 0),
(172, 33, '2021-03-04 00:00:00', 'logIn', NULL, 71, 0),
(173, 33, '2021-03-04 00:00:00', 'searching', NULL, 71, 0),
(174, 41, '2021-03-04 00:00:00', 'searching', NULL, 71, 0),
(175, 41, '2021-03-04 00:00:00', 'searching', NULL, 71, 0),
(176, 41, '2021-03-04 00:00:00', 'searching', NULL, 71, 0),
(177, 41, '2021-03-04 00:00:00', 'searching', NULL, 71, 0),
(178, 41, '2021-03-04 00:00:00', 'searching', NULL, 71, 0),
(179, 41, '2021-03-04 00:00:00', 'searching', NULL, 71, 0),
(180, 41, '2021-03-04 00:00:00', 'searching', NULL, 71, 0),
(181, 30, '2021-03-04 00:00:00', 'logIn', NULL, 72, 0),
(182, 30, '2021-03-04 00:00:00', 'logIn', NULL, 73, 0),
(183, 30, '2021-03-04 00:00:00', 'searching', NULL, 73, 0),
(184, 35, '2021-03-04 00:00:00', 'logIn', NULL, 74, 0),
(185, 30, '2021-03-04 00:00:00', 'logIn', NULL, 75, 0),
(186, 30, '2021-03-04 00:00:00', 'searching', NULL, 75, 0),
(187, 33, '2021-03-04 00:00:00', 'logIn', NULL, 76, 0),
(188, 35, '2021-03-04 00:00:00', 'logIn', NULL, 77, 0),
(189, 41, '2021-03-04 00:00:00', 'searching', NULL, 77, 0),
(190, 33, '2021-03-04 00:00:00', 'searching', NULL, 77, 0),
(191, 30, '2021-03-04 00:00:00', 'logIn', NULL, 78, 0),
(192, 30, '2021-03-04 00:00:00', 'logIn', NULL, 79, 0),
(193, 30, '2021-03-04 00:00:00', 'searching', NULL, 79, 0),
(194, 33, '2021-03-04 00:00:00', 'searching', NULL, 79, 0),
(195, 42, '2021-03-04 00:00:00', 'logIn', NULL, 80, 0),
(196, 41, '2021-03-04 00:00:00', 'searching', NULL, 80, 0),
(197, 48, '2021-03-04 00:00:00', 'logIn', NULL, 81, 0),
(198, 41, '2021-03-04 00:00:00', 'searching', NULL, 81, 0),
(199, 41, '2021-03-04 00:00:00', 'searching', NULL, 81, 0),
(200, 41, '2021-03-04 00:00:00', 'searching', NULL, 81, 0),
(201, 41, '2021-03-04 00:00:00', 'searching', NULL, 81, 0),
(202, 41, '2021-03-04 00:00:00', 'searching', NULL, 81, 0),
(203, 49, '2021-03-04 00:00:00', 'logIn', NULL, 82, 0),
(204, 39, '2021-03-04 00:00:00', 'logIn', NULL, 83, 0),
(205, 30, '2021-03-04 00:00:00', 'logIn', NULL, 84, 0),
(206, 42, '2021-03-04 00:00:00', 'logIn', NULL, 85, 0),
(207, 39, '2021-03-04 00:00:00', 'logIn', NULL, 86, 0),
(208, 39, '2021-03-04 00:00:00', 'logIn', NULL, 87, 0),
(209, 33, '2021-03-04 00:00:00', 'viewed reports', NULL, 87, 0),
(210, 33, '2021-03-04 00:00:00', 'Explored spots ', NULL, 87, 0),
(211, 51, '2021-03-04 00:00:00', 'logIn', NULL, 88, 0),
(212, 41, '2021-03-04 00:00:00', 'searching', NULL, 88, 0),
(213, 30, '2021-03-04 00:00:00', 'logIn', NULL, 89, 0),
(214, 41, '2021-03-04 00:00:00', 'searching', NULL, 89, 0),
(215, 33, '2021-03-04 00:00:00', 'Explored spots ', NULL, 89, 0),
(216, 41, '2021-03-04 00:00:00', 'searching', NULL, 89, 0),
(217, 41, '2021-03-04 00:00:00', 'searching', NULL, 89, 0),
(218, 33, '2021-03-04 00:00:00', 'Joined Spiral (register) ', NULL, 89, 0),
(219, 33, '2021-03-04 00:00:00', 'registered a location', NULL, 89, 0),
(220, 41, '2021-03-04 00:00:00', 'searching', NULL, 89, 0),
(221, 51, '2021-03-04 00:00:00', 'logIn', NULL, 90, 0),
(222, 33, '2021-03-04 00:00:00', 'Deleted a location', NULL, 90, 0),
(223, 0, '2021-03-04 00:00:00', 'logIn', NULL, 91, 0),
(224, 0, '2021-03-04 00:00:00', 'searching', NULL, 91, 0),
(225, 30, '2021-03-04 00:00:00', 'logIn', NULL, 92, 0),
(226, 30, '2021-03-04 00:00:00', 'logIn', NULL, 93, 0),
(227, 33, '2021-03-04 00:00:00', 'Searched 1', NULL, 93, 0),
(228, 33, '2021-03-04 00:00:00', 'Searched egg', NULL, 93, 0),
(229, 52, '2021-03-04 00:00:00', 'logIn', NULL, 94, 0),
(230, 33, '2021-03-04 00:00:00', 'viewed recent searches ', NULL, 94, 0),
(231, 33, '2021-03-04 00:00:00', 'Searched popular Computer', NULL, 94, 0),
(232, 33, '2021-03-04 00:00:00', 'Searched popular Computer', NULL, 94, 0),
(233, 33, '2021-03-04 00:00:00', 'Searched bles', NULL, 94, 0),
(234, 33, '2021-03-04 00:00:00', 'commented on spot', NULL, 94, 0),
(235, 33, '2021-03-04 00:00:00', 'Searched fish', NULL, 94, 0),
(236, 51, '2021-03-04 00:00:00', 'logIn', NULL, 95, 0),
(237, 33, '2021-03-04 00:00:00', 'recovered a location', NULL, 95, 0),
(238, 41, '2021-03-04 00:00:00', 'searching', NULL, 95, 0),
(239, 48, '2021-03-04 00:00:00', 'searching', NULL, 95, 0),
(240, 30, '2021-03-04 00:00:00', 'logIn', NULL, 96, 0),
(241, 53, '2021-03-04 00:00:00', 'logIn', NULL, 97, 0),
(242, 53, '2021-03-04 00:00:00', 'logIn', NULL, 98, 0),
(243, 53, '2021-03-04 00:00:00', 'logIn', NULL, 99, 0),
(244, 53, '2021-03-04 00:00:00', 'logIn', NULL, 100, 0),
(245, 33, '2021-03-04 00:00:00', 'logIn', NULL, 101, 0),
(246, 53, '2021-03-04 00:00:00', 'logIn', NULL, 102, 0),
(247, 0, '2021-03-04 00:00:00', 'searching book', NULL, 102, 0),
(248, 0, '2021-03-04 00:00:00', 'Searched book', NULL, 102, 0),
(249, 53, '2021-03-04 00:00:00', 'searching', NULL, 102, 0),
(250, 30, '2021-03-04 00:00:00', 'logIn', NULL, 103, 0),
(251, 54, '2021-03-04 00:00:00', 'logIn', NULL, 104, 0),
(252, 53, '2021-03-04 00:00:00', 'searching', NULL, 104, 0),
(253, 33, '2021-03-04 00:00:00', 'logIn', NULL, 105, 0),
(254, 53, '2021-03-04 00:00:00', 'logIn', NULL, 106, 0),
(255, 30, '2021-03-04 00:00:00', 'searching B', NULL, 106, 0),
(256, 49, '2021-03-04 00:00:00', 'logIn', NULL, 107, 0),
(257, 54, '2021-03-04 00:00:00', 'searching sp', NULL, 107, 0),
(258, 54, '2021-03-04 00:00:00', 'searching', NULL, 107, 0),
(259, 54, '2021-03-04 00:00:00', 'searching s', NULL, 107, 0),
(260, 54, '2021-03-04 00:00:00', 'searching', NULL, 107, 0),
(261, 54, '2021-03-04 00:00:00', 'searching fish', NULL, 107, 0),
(262, 54, '2021-03-04 00:00:00', 'commented on spot', NULL, 107, 0),
(263, 54, '2021-03-04 00:00:00', 'Searched fish', NULL, 107, 0),
(264, 54, '2021-03-04 00:00:00', 'searching sp', NULL, 107, 0),
(265, 33, '2021-03-04 00:00:00', 'logIn', NULL, 108, 0),
(266, 30, '2021-03-04 00:00:00', 'Created spots ', NULL, 108, 0),
(267, 30, '2021-03-04 00:00:00', 'searching s', NULL, 108, 0),
(268, 33, '2021-03-04 00:00:00', 'logIn', NULL, 109, 0),
(269, 33, '2021-03-04 00:00:00', 'logOut', '2021-03-04', 108, 1),
(270, 30, '2021-03-04 00:00:00', 'logIn', NULL, 109, 1),
(271, 33, '2021-03-04 00:00:00', 'logIn', NULL, 110, 1),
(272, 30, '2021-03-04 00:00:00', 'logIn', NULL, 111, 1),
(273, 30, '2021-03-04 00:00:00', 'searching b', NULL, 111, 1),
(274, 33, '2021-03-04 00:00:00', 'logIn', NULL, 112, 1),
(275, 30, '2021-03-04 00:00:00', 'logIn', NULL, 113, 1),
(276, 30, '2021-03-04 00:00:00', 'viewed user settings', NULL, 113, 1),
(277, 49, '2021-03-04 00:00:00', 'logIn', NULL, 114, 1),
(278, 33, '2021-03-04 00:00:00', 'logIn', NULL, 115, 1),
(279, 33, '2021-03-04 00:00:00', 'viewed reports', NULL, 115, 1),
(280, 33, '2021-03-04 00:00:00', 'viewed reports', NULL, 115, 1),
(281, 33, '2021-03-04 00:00:00', 'logIn', NULL, 116, 1),
(282, 33, '2021-03-04 00:00:00', 'viewed reports', NULL, 116, 1),
(283, 30, '2021-03-04 00:00:00', 'updated user settings', NULL, 116, 1),
(284, 33, '2021-03-04 00:00:00', 'logIn', NULL, 117, 1),
(285, 33, '2021-03-04 00:00:00', 'viewed reports', NULL, 117, 1),
(286, 52, '2021-03-04 00:00:00', 'Searched popular spot', NULL, 117, 1),
(287, 52, '2021-03-04 00:00:00', 'Searched popular fish', NULL, 117, 1),
(288, 52, '2021-03-04 00:00:00', 'Searched popular fish', NULL, 117, 1),
(289, 52, '2021-03-04 00:00:00', 'Searched popular fish', NULL, 117, 1),
(290, 52, '2021-03-04 00:00:00', 'Searched popular Table', NULL, 117, 1),
(291, 52, '2021-03-04 00:00:00', 'Searched popular Computer', NULL, 117, 1),
(292, 52, '2021-03-04 00:00:00', 'Searched popular Computer', NULL, 117, 1),
(293, 53, '2021-03-05 00:00:00', 'logIn', NULL, 118, 1),
(294, 53, '2021-03-05 00:00:00', 'logIn', NULL, 119, 1),
(295, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 118, 2),
(296, 0, '2021-03-05 00:00:00', 'searching s', NULL, 118, 2),
(297, 30, '2021-03-05 00:00:00', 'logIn', NULL, 119, 2),
(298, 0, '2021-03-05 00:00:00', 'searching s', NULL, 119, 2),
(299, 0, '2021-03-05 00:00:00', 'searching s', NULL, 119, 2),
(300, 0, '2021-03-05 00:00:00', 'searching s', NULL, 119, 2),
(301, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 118, 3),
(302, 0, '2021-03-05 00:00:00', 'searching fish', NULL, 118, 3),
(303, 0, '2021-03-05 00:00:00', 'searching fish', NULL, 118, 3),
(304, 0, '2021-03-05 00:00:00', 'searching fish', NULL, 118, 3),
(305, 0, '2021-03-05 00:00:00', 'searching fish', NULL, 118, 3),
(306, 0, '2021-03-05 00:00:00', 'searching fish', NULL, 118, 3),
(307, 30, '2021-03-05 00:00:00', 'logIn', NULL, 119, 3),
(308, 0, '2021-03-05 00:00:00', 'searching fish', NULL, 119, 3),
(309, 0, '2021-03-05 00:00:00', 'searching fish', NULL, 119, 3),
(310, 0, '2021-03-05 00:00:00', 'searching fish', NULL, 119, 3),
(311, 0, '2021-03-05 00:00:00', 'searching fish', NULL, 119, 3),
(312, 0, '2021-03-05 00:00:00', 'searching fish', NULL, 119, 3),
(313, 30, '2021-03-05 00:00:00', 'logIn', NULL, 120, 3),
(314, 30, '2021-03-05 00:00:00', 'searching fish', NULL, 120, 3),
(315, 30, '2021-03-05 00:00:00', 'searching book', NULL, 120, 3),
(316, 30, '2021-03-05 00:00:00', 'searching book', NULL, 120, 3),
(317, 30, '2021-03-05 00:00:00', 'commented on spot', NULL, 120, 3),
(318, 30, '2021-03-05 00:00:00', 'searching boo', NULL, 120, 3),
(319, 30, '2021-03-05 00:00:00', 'searching sp', NULL, 120, 3),
(320, 30, '2021-03-05 00:00:00', 'viewed reports', NULL, 120, 3),
(321, 30, '2021-03-05 00:00:00', 'viewed reports', NULL, 120, 3),
(322, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 119, 4),
(323, 0, '2021-03-05 00:00:00', 'logIn', NULL, 120, 4),
(324, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 119, 5),
(325, 0, '2021-03-05 00:00:00', 'searching fish', NULL, 119, 5),
(326, 30, '2021-03-05 00:00:00', 'logIn', NULL, 120, 5),
(327, 0, '2021-03-05 00:00:00', 'searching b', NULL, 120, 5),
(328, 0, '2021-03-05 00:00:00', 'Searched keri', NULL, 120, 5),
(329, 45, '2021-03-05 00:00:00', 'logIn', NULL, 121, 5),
(330, 0, '2021-03-05 00:00:00', 'searching s', NULL, 121, 5),
(331, 0, '2021-03-05 00:00:00', 'Searched popular Computer', NULL, 121, 5),
(332, 0, '2021-03-05 00:00:00', 'searching desc', NULL, 121, 5),
(333, 49, '2021-03-05 00:00:00', 'logIn', NULL, 122, 5),
(334, 30, '2021-03-05 00:00:00', 'logIn', NULL, 123, 5),
(335, 0, '2021-03-05 00:00:00', 'searching f', NULL, 123, 5),
(336, 30, '2021-03-05 00:00:00', 'searching', NULL, 123, 5),
(337, 0, '2021-03-05 00:00:00', 'viewed recent searches ', NULL, 123, 5),
(338, 30, '2021-03-05 00:00:00', 'searching', NULL, 123, 5),
(339, 49, '2021-03-05 00:00:00', 'viewed user settings', NULL, 123, 5),
(340, 27, '2021-03-05 00:00:00', 'logIn', NULL, 124, 5),
(341, 30, '2021-03-05 00:00:00', 'viewed user settings', NULL, 124, 5),
(342, 53, '2021-03-05 00:00:00', 'logIn', NULL, 125, 5),
(343, 0, '2021-03-05 00:00:00', 'logIn', NULL, 126, 5),
(344, 30, '2021-03-05 00:00:00', 'Reseted password', NULL, 126, 5),
(345, 30, '2021-03-05 00:00:00', 'logIn', NULL, 127, 5),
(346, 0, '2021-03-05 00:00:00', 'searching d', NULL, 127, 5),
(347, 30, '2021-03-05 00:00:00', 'Created user category ', NULL, 127, 5),
(348, 0, '2021-03-05 00:00:00', 'searching d', NULL, 127, 5),
(349, 33, '2021-03-05 00:00:00', 'logIn', NULL, 128, 5),
(350, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 127, 6),
(351, 0, '2021-03-05 00:00:00', 'viewed recent searches ', NULL, 127, 6),
(352, 0, '2021-03-05 00:00:00', 'searching refefe', NULL, 127, 6),
(353, 0, '2021-03-05 00:00:00', 'searching d', NULL, 127, 6),
(354, 0, '2021-03-05 00:00:00', 'searching computer', NULL, 127, 6),
(355, 0, '2021-03-05 00:00:00', 'viewed recent searches ', NULL, 127, 6),
(356, 0, '2021-03-05 00:00:00', 'searching re', NULL, 127, 6),
(357, 49, '2021-03-05 00:00:00', 'updated user settings', NULL, 127, 6),
(358, 0, '2021-03-05 00:00:00', 'logIn', NULL, 128, 6),
(359, 0, '2021-03-05 00:00:00', 'logIn', NULL, 129, 6),
(360, 30, '2021-03-05 00:00:00', 'searching b', NULL, 129, 6),
(361, 0, '2021-03-05 00:00:00', 'logIn', NULL, 130, 6),
(362, 33, '2021-03-05 00:00:00', 'logIn', NULL, 131, 6),
(363, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 131, 6),
(364, 33, '2021-03-05 00:00:00', 'logIn', NULL, 132, 6),
(365, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 132, 6),
(366, 33, '2021-03-05 00:00:00', 'searching', NULL, 132, 6),
(367, 0, '2021-03-05 00:00:00', 'searching d', NULL, 132, 6),
(368, 33, '2021-03-05 00:00:00', 'logIn', NULL, 133, 6),
(369, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 133, 6),
(370, 30, '2021-03-05 00:00:00', 'logIn', NULL, 134, 6),
(371, 30, '2021-03-05 00:00:00', 'searching socks', NULL, 134, 6),
(372, 30, '2021-03-05 00:00:00', 'logIn', NULL, 135, 6),
(373, 33, '2021-03-05 00:00:00', 'logIn', NULL, 136, 6),
(374, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 136, 6),
(375, 30, '2021-03-05 00:00:00', 'Reseted password', NULL, 136, 6),
(376, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 135, 7),
(377, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 134, 8),
(378, 30, '2021-03-05 00:00:00', 'logIn', NULL, 135, 8),
(379, 0, '2021-03-05 00:00:00', 'Searched a', NULL, 135, 8),
(380, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 135, 8),
(381, 30, '2021-03-05 00:00:00', 'logIn', NULL, 136, 8),
(382, 0, '2021-03-05 00:00:00', 'logIn', NULL, 137, 8),
(383, 0, '2021-03-05 00:00:00', 'logIn', NULL, 138, 8),
(384, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 137, 9),
(385, 30, '2021-03-05 00:00:00', 'logIn', NULL, 138, 9),
(386, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 138, 9),
(387, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 137, 10),
(388, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 137, 10),
(389, 30, '2021-03-05 00:00:00', 'logIn', NULL, 138, 10),
(390, 53, '2021-03-05 00:00:00', 'searching', NULL, 138, 10),
(391, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 138, 10),
(392, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 138, 10),
(393, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 138, 10),
(394, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 138, 10),
(395, 30, '2021-03-05 00:00:00', 'Joined Spiral (register) ', NULL, 138, 10),
(396, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 138, 10),
(397, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 137, 11),
(398, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 137, 11),
(399, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 137, 11),
(400, 30, '2021-03-05 00:00:00', 'logIn', NULL, 138, 11),
(401, 30, '2021-03-05 00:00:00', 'Joined Spiral (register) ', NULL, 138, 11),
(402, 30, '2021-03-05 00:00:00', 'viewed user settings', NULL, 138, 11),
(403, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 138, 11),
(404, 30, '2021-03-05 00:00:00', 'logIn', NULL, 139, 11),
(405, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 138, 12),
(406, 0, '2021-03-05 00:00:00', 'logIn', NULL, 139, 12),
(407, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 138, 13),
(408, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 138, 13),
(409, 30, '2021-03-05 00:00:00', 'logIn', NULL, 139, 13),
(410, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 139, 13),
(411, 0, '2021-03-05 00:00:00', 'logIn', NULL, 140, 13),
(412, 0, '2021-03-05 00:00:00', 'logIn', NULL, 141, 13),
(413, 0, '2021-03-05 00:00:00', 'Searched eg', NULL, 141, 13),
(414, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 141, 13),
(415, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 141, 13),
(416, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 141, 13),
(417, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 141, 13),
(418, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 140, 14),
(419, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 140, 14),
(420, 0, '2021-03-05 00:00:00', 'searching socks', NULL, 140, 14),
(421, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 139, 15),
(422, 56, '2021-03-05 00:00:00', 'logIn', NULL, 140, 15),
(423, 48, '2021-03-05 00:00:00', 'logIn', NULL, 141, 15),
(424, 48, '2021-03-05 00:00:00', 'searching fish', NULL, 141, 15),
(425, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 141, 15),
(426, 48, '2021-03-05 00:00:00', 'searching fish', NULL, 141, 15),
(427, 48, '2021-03-05 00:00:00', 'commented on spot', NULL, 141, 15),
(428, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 141, 15),
(429, 48, '2021-03-05 00:00:00', 'searching fish', NULL, 141, 15),
(430, 48, '2021-03-05 00:00:00', 'searching fish', NULL, 141, 15),
(431, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 141, 15),
(432, 48, '2021-03-05 00:00:00', 'searching fish', NULL, 141, 15),
(433, 0, '2021-03-05 00:00:00', 'searching socks', NULL, 141, 15),
(434, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 141, 15),
(435, 0, '2021-03-05 00:00:00', 'commented on spot', NULL, 141, 15),
(436, 0, '2021-03-05 00:00:00', 'searching socks', NULL, 141, 15),
(437, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 140, 16),
(438, 0, '2021-03-05 00:00:00', 'searching 1', NULL, 140, 16),
(439, 30, '2021-03-05 00:00:00', 'logIn', NULL, 141, 16),
(440, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 141, 16),
(441, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 141, 16),
(442, 0, '2021-03-05 00:00:00', 'searching socks', NULL, 141, 16),
(443, 33, '2021-03-05 00:00:00', 'searching', NULL, 141, 16),
(444, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 141, 16),
(445, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 141, 16),
(446, 30, '2021-03-05 00:00:00', 'searching g', NULL, 141, 16),
(447, 30, '2021-03-05 00:00:00', 'logIn', NULL, 142, 16),
(448, 30, '2021-03-05 00:00:00', 'logIn', NULL, 143, 16),
(449, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 143, 16),
(450, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 143, 16),
(451, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 143, 16),
(452, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 142, 17),
(453, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 141, 18),
(454, 56, '2021-03-05 00:00:00', 'logIn', NULL, 142, 18),
(455, 0, '2021-03-05 00:00:00', 'logIn', NULL, 143, 18),
(456, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 143, 18),
(457, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 143, 18),
(458, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 142, 19),
(459, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 142, 19),
(460, 55, '2021-03-05 00:00:00', 'logIn', NULL, 143, 19),
(461, 33, '2021-03-05 00:00:00', 'logIn', NULL, 144, 19),
(462, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 144, 19),
(463, 56, '2021-03-05 00:00:00', 'logIn', NULL, 145, 19),
(464, 49, '2021-03-05 00:00:00', 'logIn', NULL, 146, 19),
(465, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 145, 20),
(466, 30, '2021-03-05 00:00:00', 'logIn', NULL, 146, 20),
(467, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 146, 20),
(468, 55, '2021-03-05 00:00:00', 'logIn', NULL, 147, 20),
(469, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 147, 20),
(470, 56, '2021-03-05 00:00:00', 'logIn', NULL, 148, 20),
(471, 30, '2021-03-05 00:00:00', 'logIn', NULL, 149, 20),
(472, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 149, 20),
(473, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 148, 21),
(474, 30, '2021-03-05 00:00:00', 'searching s', NULL, 148, 21),
(475, 30, '2021-03-05 00:00:00', 'rated spot ', NULL, 148, 21),
(476, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 147, 22),
(477, 57, '2021-03-05 00:00:00', 'logIn', NULL, 148, 22),
(478, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 147, 23),
(479, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 147, 23),
(480, 57, '2021-03-05 00:00:00', 'logIn', NULL, 148, 23),
(481, 49, '2021-03-05 00:00:00', 'viewed user settings', NULL, 148, 23),
(482, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 148, 23),
(483, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 148, 23),
(484, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 148, 23),
(485, 30, '2021-03-05 00:00:00', 'logIn', NULL, 149, 23),
(486, 48, '2021-03-05 00:00:00', 'searching socks', NULL, 149, 23),
(487, 48, '2021-03-05 00:00:00', 'commented on spot', NULL, 149, 23),
(488, 48, '2021-03-05 00:00:00', 'searching socks', NULL, 149, 23),
(489, 33, '2021-03-05 00:00:00', 'logIn', NULL, 150, 23),
(490, 33, '2021-03-05 00:00:00', 'searching', NULL, 150, 23),
(491, 35, '2021-03-05 00:00:00', 'logIn', NULL, 151, 23),
(492, 30, '2021-03-05 00:00:00', 'searching s', NULL, 151, 23),
(493, 30, '2021-03-05 00:00:00', 'Updated a location', NULL, 151, 23),
(494, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 151, 23),
(495, 30, '2021-03-05 00:00:00', 'logIn', NULL, 152, 23),
(496, 30, '2021-03-05 00:00:00', 'viewed user settings', NULL, 152, 23),
(497, 30, '2021-03-05 00:00:00', 'searching s', NULL, 152, 23),
(498, 30, '2021-03-05 00:00:00', 'Created spots ', NULL, 152, 23),
(499, 30, '2021-03-05 00:00:00', 'logIn', NULL, 153, 23),
(500, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 152, 24),
(501, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 151, 25),
(502, 30, '2021-03-05 00:00:00', 'searching s', NULL, 151, 25),
(503, 30, '2021-03-05 00:00:00', 'searching s', NULL, 151, 25),
(504, 48, '2021-03-05 00:00:00', 'searching fish', NULL, 151, 25),
(505, 33, '2021-03-05 00:00:00', 'searching', NULL, 151, 25),
(506, 48, '2021-03-05 00:00:00', 'searching Computer', NULL, 151, 25),
(507, 0, '2021-03-05 00:00:00', 'searching com', NULL, 151, 25),
(508, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 150, 26),
(509, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 150, 26),
(510, 30, '2021-03-05 00:00:00', 'logIn', NULL, 151, 26),
(511, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 151, 26),
(512, 30, '2021-03-05 00:00:00', 'logIn', NULL, 152, 26),
(513, 30, '2021-03-05 00:00:00', 'logIn', NULL, 153, 26),
(514, 49, '2021-03-05 00:00:00', 'logIn', NULL, 154, 26),
(515, 30, '2021-03-05 00:00:00', 'logIn', NULL, 155, 26),
(516, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 155, 26),
(517, 49, '2021-03-05 00:00:00', 'logIn', NULL, 156, 26),
(518, 30, '2021-03-05 00:00:00', 'searching s', NULL, 156, 26),
(519, 30, '2021-03-05 00:00:00', 'Created spots ', NULL, 156, 26),
(520, 30, '2021-03-05 00:00:00', 'logIn', NULL, 157, 26),
(521, 30, '2021-03-05 00:00:00', 'viewed user settings', NULL, 157, 26),
(522, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 156, 27),
(523, 49, '2021-03-05 00:00:00', 'logIn', NULL, 157, 27),
(524, 33, '2021-03-05 00:00:00', 'logIn', NULL, 158, 27),
(525, 49, '2021-03-05 00:00:00', 'viewed user settings', NULL, 158, 27),
(526, 57, '2021-03-05 00:00:00', 'logIn', NULL, 159, 27),
(527, 30, '2021-03-05 00:00:00', 'viewed user settings', NULL, 159, 27),
(528, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 158, 28),
(529, 48, '2021-03-05 00:00:00', 'searching Computer', NULL, 158, 28),
(530, 33, '2021-03-05 00:00:00', 'logIn', NULL, 159, 28),
(531, 33, '2021-03-05 00:00:00', 'logIn', NULL, 160, 28),
(532, 48, '2021-03-05 00:00:00', 'searching Computer', NULL, 160, 28),
(533, 33, '2021-03-05 00:00:00', 'logIn', NULL, 161, 28),
(534, 49, '2021-03-05 00:00:00', 'Reseted password', NULL, 161, 28),
(535, 48, '2021-03-05 00:00:00', 'searching Computer', NULL, 161, 28),
(536, 30, '2021-03-05 00:00:00', 'logIn', NULL, 162, 28),
(537, 30, '2021-03-05 00:00:00', 'logIn', NULL, 163, 28),
(538, 45, '2021-03-05 00:00:00', 'logIn', NULL, 164, 28),
(539, 30, '2021-03-05 00:00:00', 'logIn', NULL, 165, 28),
(540, 30, '2021-03-05 00:00:00', 'logIn', NULL, 166, 28),
(541, 30, '2021-03-05 00:00:00', 'viewed user settings', NULL, 166, 28),
(542, 48, '2021-03-05 00:00:00', 'searching sockx', NULL, 166, 28),
(543, 48, '2021-03-05 00:00:00', 'searching socks', NULL, 166, 28),
(544, 35, '2021-03-05 00:00:00', 'logIn', NULL, 167, 28),
(545, 30, '2021-03-05 00:00:00', 'searching s', NULL, 167, 28),
(546, 30, '2021-03-05 00:00:00', 'searching s', NULL, 167, 28),
(547, 30, '2021-03-05 00:00:00', 'rated spot ', NULL, 167, 28),
(548, 30, '2021-03-05 00:00:00', 'viewed recent searches ', NULL, 167, 28),
(549, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 167, 28),
(550, 27, '2021-03-05 00:00:00', 'logIn', NULL, 168, 28),
(551, 27, '2021-03-05 00:00:00', 'searching spot', NULL, 168, 28),
(552, 27, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 167, 29),
(553, 30, '2021-03-05 00:00:00', 'searching socks', NULL, 167, 29),
(554, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 166, 30),
(555, 30, '2021-03-05 00:00:00', 'logIn', NULL, 167, 30),
(556, 30, '2021-03-05 00:00:00', 'searching o', NULL, 167, 30),
(557, 30, '2021-03-05 00:00:00', 'rated spot ', NULL, 167, 30),
(558, 30, '2021-03-05 00:00:00', 'searching o', NULL, 167, 30),
(559, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 166, 31),
(560, 33, '2021-03-05 00:00:00', 'logIn', NULL, 167, 31),
(561, 33, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 166, 32),
(562, 33, '2021-03-05 00:00:00', 'logIn', NULL, 167, 32),
(563, 33, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 166, 33),
(564, 33, '2021-03-05 00:00:00', 'logIn', NULL, 167, 33),
(565, 30, '2021-03-05 00:00:00', 'viewed reports', NULL, 167, 33),
(566, 30, '2021-03-05 00:00:00', 'viewed reports', NULL, 167, 33),
(567, 33, '2021-03-05 00:00:00', 'Searched s', NULL, 167, 33),
(568, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 166, 34),
(569, 33, '2021-03-05 00:00:00', 'logIn', NULL, 167, 34),
(570, 0, '2021-03-05 00:00:00', 'Created user category ', NULL, 167, 34),
(571, 33, '2021-03-05 00:00:00', 'viewed recent searches ', NULL, 167, 34),
(572, 33, '2021-03-05 00:00:00', 'logIn', NULL, 168, 34),
(573, 33, '2021-03-05 00:00:00', 'logIn', NULL, 169, 34),
(574, 33, '2021-03-05 00:00:00', 'Created user category ', NULL, 169, 34),
(575, 33, '2021-03-05 00:00:00', 'logIn', NULL, 170, 34),
(576, 33, '2021-03-05 00:00:00', 'logIn', NULL, 171, 34),
(577, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 170, 35),
(578, 0, '2021-03-05 00:00:00', 'logIn', NULL, 171, 35),
(579, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 171, 35),
(580, 33, '2021-03-05 00:00:00', 'viewed reports', NULL, 171, 35),
(581, 0, '2021-03-05 00:00:00', 'searching s', NULL, 171, 35),
(582, 0, '2021-03-05 00:00:00', 'commented on spot', NULL, 171, 35),
(583, 27, '2021-03-05 00:00:00', 'logIn', NULL, 172, 35),
(584, 27, '2021-03-05 00:00:00', 'logIn', NULL, 173, 35),
(585, 27, '2021-03-05 00:00:00', 'searching s', NULL, 173, 35),
(586, 33, '2021-03-05 00:00:00', 'viewed user settings', NULL, 173, 35),
(587, 33, '2021-03-05 00:00:00', 'logOut', '2021-03-05', 172, 36),
(588, 0, '2021-03-05 00:00:00', 'logOut', '2021-03-07', 171, 37),
(589, 49, '2021-03-07 00:00:00', 'logIn', NULL, 172, 37),
(590, 49, '2021-03-07 00:00:00', 'Reseted password', NULL, 172, 37),
(591, 0, '2021-03-07 00:00:00', 'logOut', '2021-03-07', 171, 38),
(592, 49, '2021-03-07 00:00:00', 'logIn', NULL, 172, 38),
(593, 49, '2021-03-07 00:00:00', 'Reseted password', NULL, 172, 38),
(594, 49, '2021-03-07 00:00:00', 'Reseted password', NULL, 172, 38),
(595, 49, '2021-03-07 00:00:00', 'Reseted password', NULL, 172, 38),
(596, 49, '2021-03-07 00:00:00', 'Reseted password', NULL, 172, 38),
(597, 0, '2021-03-07 00:00:00', 'logOut', '2021-03-07', 171, 39),
(598, 49, '2021-03-07 00:00:00', 'logIn', NULL, 172, 39),
(599, 49, '2021-03-07 00:00:00', 'Reseted password', NULL, 172, 39),
(600, 49, '2021-03-07 00:00:00', 'Reseted password', NULL, 172, 39),
(601, 49, '2021-03-07 00:00:00', 'viewed user settings', NULL, 172, 39),
(602, 49, '2021-03-07 00:00:00', 'updated user settings', NULL, 172, 39),
(603, 0, '2021-03-07 00:00:00', 'logOut', '2021-03-07', 171, 40),
(604, 0, '2021-03-07 00:00:00', 'logIn', NULL, 172, 40),
(605, 0, '2021-03-07 00:00:00', 'logIn', NULL, 173, 40),
(606, 0, '2021-03-07 00:00:00', 'logIn', NULL, 174, 40),
(607, 30, '2021-03-07 00:00:00', 'logIn', NULL, 175, 40),
(608, 30, '2021-03-07 00:00:00', 'Reseted password', NULL, 175, 40),
(609, 30, '2021-03-07 00:00:00', 'Joined Spiral (register) ', NULL, 175, 40),
(610, 30, '2021-03-07 00:00:00', 'Registered a user', NULL, 175, 40),
(611, 30, '2021-03-07 00:00:00', 'viewed user settings', NULL, 175, 40),
(612, 0, '2021-03-07 00:00:00', 'logOut', '2021-03-07', 174, 41),
(613, 0, '2021-03-07 00:00:00', 'logIn', NULL, 175, 41),
(614, 30, '2021-03-07 00:00:00', 'logIn', NULL, 176, 41),
(615, 30, '2021-03-07 00:00:00', 'Joined Spiral (register) ', NULL, 176, 41),
(616, 30, '2021-03-07 00:00:00', 'Registered a user', NULL, 176, 41),
(617, 0, '2021-03-07 00:00:00', 'logOut', '2021-03-07', 175, 42),
(618, 30, '2021-03-09 00:00:00', 'logIn', NULL, 176, 42),
(619, 0, '2021-03-09 00:00:00', 'logOut', '2021-03-09', 175, 43),
(620, 0, '2021-03-09 00:00:00', 'logIn', NULL, 176, 43),
(621, 30, '2021-03-09 00:00:00', 'logIn', NULL, 177, 43),
(622, 0, '2021-03-09 00:00:00', 'logOut', '2021-03-09', 176, 44),
(623, 0, '2021-03-09 00:00:00', 'logIn', NULL, 177, 44),
(624, 0, '2021-03-09 00:00:00', 'logIn', NULL, 178, 44),
(625, 30, '2021-03-09 00:00:00', 'logIn', NULL, 179, 44),
(626, 0, '2021-03-09 00:00:00', 'logOut', '2021-03-10', 178, 45),
(627, 33, '2021-03-10 00:00:00', 'logIn', NULL, 179, 45),
(628, 0, '2021-03-10 00:00:00', 'logOut', '2021-03-10', 178, 46),
(629, 33, '2021-03-10 00:00:00', 'logIn', NULL, 179, 46),
(630, 33, '2021-03-10 00:00:00', 'viewed reports', NULL, 179, 46),
(631, 0, '2021-03-10 00:00:00', 'logOut', '2021-03-10', 178, 47),
(632, 30, '2021-03-10 00:00:00', 'logIn', NULL, 179, 47),
(633, 27, '2021-03-10 00:00:00', 'searching s', NULL, 179, 47),
(634, 27, '2021-03-10 00:00:00', 'searching s', NULL, 179, 47),
(635, 30, '2021-03-10 00:00:00', 'logIn', NULL, 180, 47),
(636, 27, '2021-03-10 00:00:00', 'commented on spot', NULL, 180, 47),
(637, 33, '2021-03-10 00:00:00', 'logIn', NULL, 181, 47),
(638, 0, '2021-03-10 00:00:00', 'logOut', '2021-03-10', 180, 48),
(639, 33, '2021-03-10 00:00:00', 'searching fish', NULL, 180, 48),
(640, 30, '2021-03-10 00:00:00', 'logIn', NULL, 181, 48),
(641, 33, '2021-03-10 00:00:00', 'commented on spot', NULL, 181, 48),
(642, 33, '2021-03-10 00:00:00', 'viewed reports', NULL, 181, 48),
(643, 27, '2021-03-10 00:00:00', 'logIn', NULL, 182, 48),
(644, 27, '2021-03-10 00:00:00', 'searching s', NULL, 182, 48),
(645, 30, '2021-03-10 00:00:00', 'Updated a location', NULL, 182, 48),
(646, 30, '2021-03-10 00:00:00', 'recovered a location', NULL, 182, 48),
(647, 27, '2021-03-10 00:00:00', 'searching s', NULL, 182, 48),
(648, 27, '2021-03-10 00:00:00', 'searching socks', NULL, 182, 48),
(649, 27, '2021-03-10 00:00:00', 'searching s', NULL, 182, 48),
(650, 27, '2021-03-10 00:00:00', 'commented on spot', NULL, 182, 48),
(651, 27, '2021-03-10 00:00:00', 'Updated a location', NULL, 182, 48),
(652, 33, '2021-03-10 00:00:00', 'logIn', NULL, 183, 48),
(653, 33, '2021-03-10 00:00:00', 'viewed reports', NULL, 183, 48),
(654, 0, '2021-03-10 00:00:00', 'logOut', '2021-03-10', 182, 49),
(655, 27, '2021-03-10 00:00:00', 'registered a location', NULL, 182, 49),
(656, 27, '2021-03-10 00:00:00', 'registered a location', NULL, 182, 49),
(657, 0, '2021-03-10 00:00:00', 'logOut', '2021-03-10', 181, 50),
(658, 33, '2021-03-10 00:00:00', 'logOut', '2021-03-10', 180, 51),
(659, 33, '2021-03-10 00:00:00', 'logIn', NULL, 181, 51),
(660, 33, '2021-03-10 00:00:00', 'viewed reports', NULL, 181, 51),
(661, 33, '2021-03-10 00:00:00', 'logIn', NULL, 182, 51),
(662, 33, '2021-03-10 00:00:00', 'viewed reports', NULL, 182, 51),
(663, 0, '2021-03-10 00:00:00', 'logOut', '2021-03-10', 181, 52),
(664, 0, '2021-03-10 00:00:00', 'logOut', '2021-03-10', 180, 53),
(665, 30, '2021-03-10 00:00:00', 'logIn', NULL, 181, 53),
(666, 0, '2021-03-10 00:00:00', 'logOut', '2021-03-10', 180, 54),
(667, 57, '2021-03-10 00:00:00', 'logIn', NULL, 181, 54),
(668, 57, '2021-03-10 00:00:00', 'Created spots ', NULL, 181, 54),
(669, 0, '2021-03-10 00:00:00', 'logOut', '2021-03-10', 180, 55),
(670, 35, '2021-03-10 00:00:00', 'logIn', NULL, 181, 55),
(671, 33, '2021-03-10 00:00:00', 'logIn', NULL, 182, 55),
(672, 33, '2021-03-10 00:00:00', 'viewed reports', NULL, 182, 55),
(673, 30, '2021-03-10 00:00:00', 'viewed reports', NULL, 182, 55),
(674, 0, '2021-03-10 00:00:00', 'searching Computer', NULL, 182, 55),
(675, 48, '2021-03-10 00:00:00', 'logIn', NULL, 183, 55),
(676, 48, '2021-03-10 00:00:00', 'logIn', NULL, 184, 55),
(677, 48, '2021-03-10 00:00:00', 'searching Computer', NULL, 184, 55),
(678, 48, '2021-03-10 00:00:00', 'searching hotelB', NULL, 184, 55),
(679, 48, '2021-03-10 00:00:00', 'searching book', NULL, 184, 55),
(680, 48, '2021-03-10 00:00:00', 'commented on spot', NULL, 184, 55),
(681, 33, '2021-03-10 00:00:00', 'viewed reports', NULL, 184, 55),
(682, 0, '2021-03-10 00:00:00', 'logOut', '2021-03-10', 183, 56),
(683, 48, '2021-03-10 00:00:00', 'searching computer', NULL, 183, 56),
(684, 48, '2021-03-10 00:00:00', 'searching comp', NULL, 183, 56),
(685, 48, '2021-03-10 00:00:00', 'rated spot ', NULL, 183, 56),
(686, 48, '2021-03-10 00:00:00', 'searching comp', NULL, 183, 56),
(687, 30, '2021-03-10 00:00:00', 'viewed reports', NULL, 183, 56),
(688, 0, '2021-03-10 00:00:00', 'logOut', '2021-03-10', 182, 57),
(689, 30, '2021-03-10 00:00:00', 'viewed reports', NULL, 182, 57),
(690, 0, '2021-03-10 00:00:00', 'logOut', '2021-03-10', 181, 58),
(691, 48, '2021-03-10 00:00:00', 'logIn', NULL, 182, 58),
(692, 48, '2021-03-10 00:00:00', 'searching Comp', NULL, 182, 58),
(693, 57, '2021-03-10 00:00:00', 'logIn', NULL, 183, 58),
(694, 30, '2021-03-10 00:00:00', 'viewed reports', NULL, 183, 58),
(695, 48, '2021-03-10 00:00:00', 'rated spot ', NULL, 183, 58),
(696, 48, '2021-03-10 00:00:00', 'searching comp', NULL, 183, 58),
(697, 30, '2021-03-10 00:00:00', 'viewed reports', NULL, 183, 58),
(698, 0, '2021-03-10 00:00:00', 'logOut', '2021-03-10', 182, 59),
(699, 30, '2021-03-10 00:00:00', 'logIn', NULL, 183, 59),
(700, 30, '2021-03-10 00:00:00', 'viewed reports', NULL, 183, 59),
(701, 48, '2021-03-10 00:00:00', 'searching nearby', NULL, 183, 59),
(702, 30, '2021-03-10 00:00:00', 'viewed reports', NULL, 183, 59),
(703, 48, '2021-03-10 00:00:00', 'searching near', NULL, 183, 59),
(704, 35, '2021-03-10 00:00:00', 'logIn', NULL, 184, 59),
(705, 48, '2021-03-10 00:00:00', 'searching comp', NULL, 184, 59),
(706, 33, '2021-03-10 00:00:00', 'logIn', NULL, 185, 59),
(707, 48, '2021-03-10 00:00:00', 'searching comp', NULL, 185, 59),
(708, 48, '2021-03-10 00:00:00', 'rated spot ', NULL, 185, 59),
(709, 33, '2021-03-10 00:00:00', 'viewed user settings', NULL, 185, 59),
(710, 0, '2021-03-10 00:00:00', 'logOut', '2021-03-10', 184, 60),
(711, 30, '2021-03-10 00:00:00', 'searching b', NULL, 184, 60),
(712, 30, '2021-03-10 00:00:00', 'viewed reports', NULL, 184, 60),
(713, 30, '2021-03-10 00:00:00', 'searching me', NULL, 184, 60),
(714, 30, '2021-03-10 00:00:00', 'viewed reports', NULL, 184, 60),
(715, 48, '2021-03-10 00:00:00', 'searching comp', NULL, 184, 60),
(716, 48, '2021-03-10 00:00:00', 'searching comp', NULL, 184, 60),
(717, 30, '2021-03-10 00:00:00', 'viewed reports', NULL, 184, 60),
(718, 48, '2021-03-10 00:00:00', 'rated spot ', NULL, 184, 60),
(719, 30, '2021-03-10 00:00:00', 'viewed reports', NULL, 184, 60),
(720, 48, '2021-03-10 00:00:00', 'searching comp', NULL, 184, 60),
(721, 48, '2021-03-10 00:00:00', 'searching Comp', NULL, 184, 60),
(722, 48, '2021-03-10 00:00:00', 'searching Comp', NULL, 184, 60),
(723, 57, '2021-03-10 00:00:00', 'Created spots ', NULL, 184, 60),
(724, 0, '2021-03-10 19:02:14', 'logIn', NULL, 185, 60),
(725, 30, '2021-03-10 19:07:50', 'logIn', NULL, 186, 60),
(726, 30, '2021-03-10 19:07:50', 'viewed reports', NULL, 186, 60),
(727, 30, '2021-03-10 19:07:50', 'viewed reports', NULL, 186, 60),
(728, 0, '2021-03-10 19:07:50', 'logOut', '2021-03-10', 185, 61),
(729, 30, '2021-03-10 19:07:50', 'viewed reports', NULL, 185, 61),
(730, 30, '2021-03-10 19:28:13', 'logIn', NULL, 186, 61),
(731, 30, '2021-03-10 19:28:13', 'viewed user settings', NULL, 186, 61),
(732, 30, '2021-03-10 19:28:13', 'viewed reports', NULL, 186, 61),
(733, 30, '2021-03-10 19:28:13', 'updated user settings', NULL, 186, 61),
(734, 30, '2021-03-10 19:28:13', 'viewed reports', NULL, 186, 61),
(735, 30, '2021-03-10 19:28:13', 'Joined Spiral (register) ', NULL, 186, 61),
(736, 30, '2021-03-10 19:28:13', 'Joined Spiral (register) ', NULL, 186, 61),
(737, 30, '2021-03-10 19:43:15', 'logIn', NULL, 187, 61),
(738, 0, '2021-03-10 19:43:15', 'logOut', '2021-03-10', 186, 62),
(739, 30, '2021-03-10 19:43:15', 'viewed reports', NULL, 186, 62),
(740, 0, '2021-03-10 19:43:15', 'logOut', '2021-03-10', 185, 63),
(741, 33, '2021-03-10 20:06:49', 'logIn', NULL, 186, 63),
(742, 33, '2021-03-10 20:06:49', 'viewed reports', NULL, 186, 63),
(743, 33, '2021-03-10 20:06:49', 'logOut', '2021-03-10', 185, 64),
(744, 33, '2021-03-10 20:13:55', 'logIn', NULL, 186, 64),
(745, 33, '2021-03-10 20:13:55', 'viewed reports', NULL, 186, 64),
(746, 33, '2021-03-10 20:13:55', 'viewed reports', NULL, 186, 64),
(747, 33, '2021-03-10 21:47:55', 'logIn', NULL, 187, 64),
(748, 33, '2021-03-10 21:47:55', 'viewed reports', NULL, 187, 64),
(749, 33, '2021-03-10 21:47:55', 'viewed reports', NULL, 187, 64),
(750, 45, '2021-03-11 05:09:38', 'logIn', NULL, 188, 64),
(751, 33, '2021-03-11 05:09:38', 'viewed user settings', NULL, 188, 64),
(752, 0, '2021-03-11 05:09:38', 'logOut', '2021-03-11', 187, 65),
(753, 35, '2021-03-11 05:15:03', 'logIn', NULL, 188, 65),
(754, 56, '2021-03-11 05:15:03', 'viewed user settings', NULL, 188, 65),
(755, 30, '2021-03-11 05:15:03', 'Joined Spiral (register) ', NULL, 188, 65),
(756, 33, '2021-03-11 05:21:02', 'logIn', NULL, 189, 65),
(757, 33, '2021-03-11 05:21:02', 'viewed reports', NULL, 189, 65),
(758, 33, '2021-03-11 05:21:02', 'viewed reports', NULL, 189, 65),
(759, 0, '2021-03-11 05:21:02', 'logOut', '2021-03-11', 188, 66),
(760, 0, '2021-03-11 05:21:02', 'logOut', '2021-03-11', 187, 67),
(761, 0, '2021-03-11 05:21:02', 'logOut', '2021-03-11', 186, 68),
(762, 57, '2021-03-11 05:21:02', 'Created spots ', NULL, 186, 68),
(763, 0, '2021-03-11 05:21:02', 'logOut', '2021-03-11', 185, 69),
(764, 30, '2021-03-11 05:28:20', 'logIn', NULL, 186, 69),
(765, 45, '2021-03-11 05:28:25', 'logIn', NULL, 187, 69),
(766, 30, '2021-03-11 05:28:25', 'searching house', NULL, 187, 69),
(767, 30, '2021-03-11 05:29:46', 'logIn', NULL, 188, 69),
(768, 35, '2021-03-11 05:30:02', 'logIn', NULL, 189, 69),
(769, 33, '2021-03-11 05:30:39', 'logIn', NULL, 190, 69),
(770, 33, '2021-03-11 05:30:39', 'searching s', NULL, 190, 69),
(771, 33, '2021-03-11 05:30:39', 'viewed reports', NULL, 190, 69),
(772, 48, '2021-03-11 05:30:39', 'searching Comp', NULL, 190, 69),
(773, 57, '2021-03-11 05:30:39', 'Joined Spiral (register) ', NULL, 190, 69),
(774, 30, '2021-03-11 05:30:39', 'viewed reports', NULL, 190, 69),
(775, 30, '2021-03-11 06:03:27', 'logIn', NULL, 191, 69),
(776, 0, '2021-03-11 06:03:27', 'logOut', '2021-03-11', 190, 70),
(777, 0, '2021-03-11 06:03:27', 'logOut', '2021-03-11', 189, 71),
(778, 0, '2021-03-11 06:05:04', 'logIn', NULL, 190, 71),
(779, 43, '2021-03-11 06:05:52', 'logIn', NULL, 191, 71),
(780, 0, '2021-03-11 06:05:52', 'logOut', '2021-03-11', 190, 72),
(781, 48, '2021-03-11 06:06:42', 'logIn', NULL, 191, 72),
(782, 48, '2021-03-11 06:18:04', 'logIn', NULL, 192, 72),
(783, 0, '2021-03-11 06:18:04', 'logOut', '2021-03-11', 191, 73),
(784, 30, '2021-03-11 06:18:47', 'logIn', NULL, 192, 73),
(785, 0, '2021-03-11 06:18:47', 'searching d', NULL, 192, 73),
(786, 30, '2021-03-11 06:20:56', 'logIn', NULL, 193, 73),
(787, 30, '2021-03-11 06:20:56', 'searching book', NULL, 193, 73),
(788, 30, '2021-03-11 06:25:28', 'logIn', NULL, 194, 73),
(789, 30, '2021-03-11 06:25:28', 'searching big', NULL, 194, 73),
(790, 30, '2021-03-11 06:25:28', 'updated user settings', NULL, 194, 73),
(791, 30, '2021-03-11 06:25:28', 'commented on spot', NULL, 194, 73),
(792, 0, '2021-03-11 06:25:28', 'logOut', '2021-03-11', 193, 74),
(793, 30, '2021-03-11 06:25:28', 'searching partying', NULL, 193, 74),
(794, 30, '2021-03-11 06:41:23', 'logIn', NULL, 194, 74),
(795, 30, '2021-03-11 06:41:23', 'searching baldi', NULL, 194, 74),
(796, 30, '2021-03-11 06:45:53', 'logIn', NULL, 195, 74),
(797, 30, '2021-03-11 06:45:53', 'searching ball', NULL, 195, 74),
(798, 48, '2021-03-11 06:45:53', 'searching school', NULL, 195, 74),
(799, 0, '2021-03-11 06:45:53', 'searching nyab', NULL, 195, 74),
(800, 48, '2021-03-11 06:45:53', 'searching book', NULL, 195, 74),
(801, 48, '2021-03-11 06:45:53', 'searching book', NULL, 195, 74),
(802, 48, '2021-03-11 06:45:53', 'searching book', NULL, 195, 74),
(803, 48, '2021-03-11 06:45:53', 'searching book', NULL, 195, 74),
(804, 30, '2021-03-11 06:45:53', 'viewed user category ', NULL, 195, 74),
(805, 0, '2021-03-11 06:45:53', 'Searched denyse', NULL, 195, 74),
(806, 0, '2021-03-11 06:45:53', 'logOut', '2021-03-11', 194, 75),
(807, 30, '2021-03-11 07:28:02', 'logIn', NULL, 195, 75),
(808, 57, '2021-03-11 07:28:02', 'Created spots ', NULL, 195, 75),
(809, 0, '2021-03-11 07:28:02', 'logOut', '2021-03-11', 194, 76),
(810, 30, '2021-03-11 07:30:50', 'logIn', NULL, 195, 76),
(811, 57, '2021-03-11 07:30:50', 'Created spots ', NULL, 195, 76),
(812, 48, '2021-03-11 07:30:50', 'searching book', NULL, 195, 76),
(813, 0, '2021-03-11 07:30:50', 'logOut', '2021-03-11', 194, 77),
(814, 57, '2021-03-11 07:32:37', 'logIn', NULL, 195, 77),
(815, 48, '2021-03-11 07:32:37', 'searching book', NULL, 195, 77),
(816, 48, '2021-03-11 07:32:37', 'searching book', NULL, 195, 77),
(817, 48, '2021-03-11 07:32:37', 'rated spot ', NULL, 195, 77),
(818, 48, '2021-03-11 07:32:37', 'searching book', NULL, 195, 77),
(819, 57, '2021-03-11 07:32:37', 'Deleted a location', NULL, 195, 77),
(820, 0, '2021-03-11 07:32:37', 'logOut', '2021-03-11', 194, 78),
(821, 30, '2021-03-11 07:41:44', 'logIn', NULL, 195, 78),
(822, 0, '2021-03-11 07:41:44', 'logOut', '2021-03-11', 194, 79);
INSERT INTO `user_logs` (`id`, `user_id`, `date_Time_logged_In`, `Action`, `date_Time_logged_Out`, `Total_In`, `Total_out`) VALUES
(823, 57, '2021-03-11 07:43:36', 'logIn', NULL, 195, 79),
(824, 57, '2021-03-11 07:43:36', 'Deleted a location', NULL, 195, 79),
(825, 48, '2021-03-11 07:43:36', 'searching book', NULL, 195, 79),
(826, 48, '2021-03-11 07:43:36', 'searching book', NULL, 195, 79),
(827, 48, '2021-03-11 07:43:36', 'searching book', NULL, 195, 79),
(828, 48, '2021-03-11 07:43:36', 'searching book', NULL, 195, 79),
(829, 57, '2021-03-11 07:43:36', 'Created spots ', NULL, 195, 79),
(830, 48, '2021-03-11 07:43:36', 'searching book', NULL, 195, 79),
(831, 57, '2021-03-11 07:43:36', 'Created spots ', NULL, 195, 79),
(832, 33, '2021-03-11 07:57:25', 'logIn', NULL, 196, 79),
(833, 33, '2021-03-11 07:57:25', 'viewed reports', NULL, 196, 79),
(834, 48, '2021-03-11 07:57:25', 'searching book', NULL, 196, 79),
(835, 0, '2021-03-11 07:57:25', 'logOut', '2021-03-11', 195, 80),
(836, 48, '2021-03-11 08:07:00', 'logIn', NULL, 196, 80),
(837, 48, '2021-03-11 08:07:00', 'searching book', NULL, 196, 80),
(838, 48, '2021-03-11 08:07:00', 'searching book', NULL, 196, 80),
(839, 48, '2021-03-11 08:07:00', 'rated spot ', NULL, 196, 80),
(840, 48, '2021-03-11 08:07:00', 'searching book', NULL, 196, 80),
(841, 0, '2021-03-11 08:07:00', 'logOut', '2021-03-11', 195, 81),
(842, 33, '2021-03-11 09:43:48', 'logIn', NULL, 196, 81),
(843, 33, '2021-03-11 09:44:07', 'logIn', NULL, 197, 81),
(844, 33, '2021-03-11 09:44:07', 'viewed reports', NULL, 197, 81),
(845, 0, '2021-03-11 09:44:07', 'logOut', '2021-03-11', 196, 82),
(846, 33, '2021-03-11 09:44:07', 'searching fish', NULL, 196, 82),
(847, 33, '2021-03-11 09:44:07', 'commented on spot', NULL, 196, 82),
(848, 27, '2021-03-11 09:51:52', 'logIn', NULL, 197, 82),
(849, 33, '2021-03-11 09:52:30', 'logIn', NULL, 198, 82),
(850, 33, '2021-03-11 09:52:30', 'viewed reports', NULL, 198, 82),
(851, 33, '2021-03-11 09:52:30', 'searching book', NULL, 198, 82),
(852, 33, '2021-03-11 09:52:30', 'commented on spot', NULL, 198, 82),
(853, 33, '2021-03-11 09:52:30', 'viewed reports', NULL, 198, 82),
(854, 33, '2021-03-11 09:59:33', 'logIn', NULL, 199, 82),
(855, 0, '2021-03-11 09:59:33', 'logOut', '2021-03-11', 198, 83),
(856, 60, '2021-03-11 18:55:38', 'logIn', NULL, 199, 83),
(857, 60, '2021-03-11 18:55:38', 'viewed user settings', NULL, 199, 83),
(858, 60, '2021-03-11 18:55:38', 'Reseted password', NULL, 199, 83),
(859, 60, '2021-03-11 18:55:38', 'Reseted password', NULL, 199, 83),
(860, 60, '2021-03-11 18:55:38', 'Reseted password', NULL, 199, 83),
(861, 60, '2021-03-11 18:55:38', 'Reseted password', NULL, 199, 83),
(862, 0, '2021-03-11 18:55:38', 'logOut', '2021-03-11', 198, 84),
(863, 49, '2021-03-11 19:16:19', 'logIn', NULL, 199, 84),
(864, 49, '2021-03-11 19:16:19', 'Reseted password', NULL, 199, 84),
(865, 49, '2021-03-11 19:16:19', 'Reseted password', NULL, 199, 84),
(866, 49, '2021-03-11 19:16:19', 'Reseted password', NULL, 199, 84),
(867, 49, '2021-03-11 19:16:19', 'Reseted password', NULL, 199, 84),
(868, 60, '2021-03-25 15:49:47', 'logIn', NULL, 200, 84),
(869, 60, '2021-03-25 15:49:47', 'viewed user settings', NULL, 200, 84),
(870, 60, '2021-03-25 15:49:47', 'Reseted password', NULL, 200, 84),
(871, 60, '2021-03-25 15:49:47', 'Reseted password', NULL, 200, 84),
(872, 60, '2021-03-25 15:49:47', 'Reseted password', NULL, 200, 84),
(873, 60, '2021-03-25 15:49:47', 'Reseted password', NULL, 200, 84),
(874, 60, '2021-03-25 15:49:47', 'Reseted password', NULL, 200, 84);

-- --------------------------------------------------------

--
-- Table structure for table `user_notifications`
--

CREATE TABLE `user_notifications` (
  `notification_id` int(11) NOT NULL,
  `user_id` int(10) NOT NULL,
  `sender_id` int(10) NOT NULL,
  `receiver_id` int(10) NOT NULL,
  `logged_in` varchar(20) NOT NULL,
  `Created_at` date NOT NULL,
  `notification_status` varchar(50) NOT NULL,
  `message_header` varchar(50) NOT NULL,
  `message` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `billing`
--
ALTER TABLE `billing`
  ADD PRIMARY KEY (`billing_id`);

--
-- Indexes for table `comments`
--
ALTER TABLE `comments`
  ADD PRIMARY KEY (`comment_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `reply_id` (`reply_id`),
  ADD KEY `spot_id` (`spot_id`);

--
-- Indexes for table `comment_reactions`
--
ALTER TABLE `comment_reactions`
  ADD PRIMARY KEY (`comment_reaction_id`),
  ADD KEY `comment_id` (`comment_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `locations`
--
ALTER TABLE `locations`
  ADD PRIMARY KEY (`location_id`),
  ADD KEY `location_fk0` (`parent_id`),
  ADD KEY `location_fk1` (`level_id`);

--
-- Indexes for table `location_levels`
--
ALTER TABLE `location_levels`
  ADD PRIMARY KEY (`level_id`);

--
-- Indexes for table `searchHistory`
--
ALTER TABLE `searchHistory`
  ADD PRIMARY KEY (`history_id`),
  ADD UNIQUE KEY `history_id` (`history_id`);

--
-- Indexes for table `spot_category`
--
ALTER TABLE `spot_category`
  ADD PRIMARY KEY (`category_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `spot_ratings`
--
ALTER TABLE `spot_ratings`
  ADD PRIMARY KEY (`rating_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `spot_id` (`spot_id`);

--
-- Indexes for table `Spot_table`
--
ALTER TABLE `Spot_table`
  ADD PRIMARY KEY (`spot_id`),
  ADD KEY `location_id` (`location_id`),
  ADD KEY `category_id` (`category_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `test_tb`
--
ALTER TABLE `test_tb`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_billing`
--
ALTER TABLE `users_billing`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users_categories`
--
ALTER TABLE `users_categories`
  ADD PRIMARY KEY (`category_id`);

--
-- Indexes for table `users_session`
--
ALTER TABLE `users_session`
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `users_table`
--
ALTER TABLE `users_table`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD UNIQUE KEY `user_name` (`user_name`),
  ADD KEY `user_category` (`user_category`);

--
-- Indexes for table `user_logs`
--
ALTER TABLE `user_logs`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_notifications`
--
ALTER TABLE `user_notifications`
  ADD PRIMARY KEY (`notification_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `sender_id` (`sender_id`),
  ADD KEY `receiver_id` (`receiver_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `billing`
--
ALTER TABLE `billing`
  MODIFY `billing_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `searchHistory`
--
ALTER TABLE `searchHistory`
  MODIFY `history_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=150;

--
-- AUTO_INCREMENT for table `spot_category`
--
ALTER TABLE `spot_category`
  MODIFY `category_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `spot_ratings`
--
ALTER TABLE `spot_ratings`
  MODIFY `rating_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `Spot_table`
--
ALTER TABLE `Spot_table`
  MODIFY `spot_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT for table `test_tb`
--
ALTER TABLE `test_tb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users_billing`
--
ALTER TABLE `users_billing`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `users_categories`
--
ALTER TABLE `users_categories`
  MODIFY `category_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT for table `users_table`
--
ALTER TABLE `users_table`
  MODIFY `user_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=62;

--
-- AUTO_INCREMENT for table `user_logs`
--
ALTER TABLE `user_logs`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=875;

--
-- AUTO_INCREMENT for table `user_notifications`
--
ALTER TABLE `user_notifications`
  MODIFY `notification_id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `comments`
--
ALTER TABLE `comments`
  ADD CONSTRAINT `comments_ibfk_3` FOREIGN KEY (`reply_id`) REFERENCES `comments` (`comment_id`),
  ADD CONSTRAINT `comments_ibfk_4` FOREIGN KEY (`spot_id`) REFERENCES `Spot_table` (`spot_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `comment_reactions`
--
ALTER TABLE `comment_reactions`
  ADD CONSTRAINT `comment_reactions_ibfk_1` FOREIGN KEY (`comment_id`) REFERENCES `comments` (`comment_id`),
  ADD CONSTRAINT `comment_reactions_ibfk_2` FOREIGN KEY (`user_id`) REFERENCES `users_table` (`user_id`);

--
-- Constraints for table `locations`
--
ALTER TABLE `locations`
  ADD CONSTRAINT `location_fk0` FOREIGN KEY (`parent_id`) REFERENCES `locations` (`location_id`),
  ADD CONSTRAINT `location_fk1` FOREIGN KEY (`level_id`) REFERENCES `location_levels` (`level_id`);

--
-- Constraints for table `spot_category`
--
ALTER TABLE `spot_category`
  ADD CONSTRAINT `spot_category_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users_table` (`user_id`);

--
-- Constraints for table `spot_ratings`
--
ALTER TABLE `spot_ratings`
  ADD CONSTRAINT `spot_ratings_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users_table` (`user_id`),
  ADD CONSTRAINT `spot_ratings_ibfk_2` FOREIGN KEY (`spot_id`) REFERENCES `Spot_table` (`spot_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `Spot_table`
--
ALTER TABLE `Spot_table`
  ADD CONSTRAINT `Spot_table_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users_table` (`user_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `users_session`
--
ALTER TABLE `users_session`
  ADD CONSTRAINT `users_session_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users_table` (`user_id`);

--
-- Constraints for table `users_table`
--
ALTER TABLE `users_table`
  ADD CONSTRAINT `user_category` FOREIGN KEY (`user_category`) REFERENCES `users_categories` (`category_id`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Constraints for table `user_notifications`
--
ALTER TABLE `user_notifications`
  ADD CONSTRAINT `user_notifications_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users_table` (`user_id`),
  ADD CONSTRAINT `user_notifications_ibfk_2` FOREIGN KEY (`sender_id`) REFERENCES `users_table` (`user_id`),
  ADD CONSTRAINT `user_notifications_ibfk_3` FOREIGN KEY (`receiver_id`) REFERENCES `users_table` (`user_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

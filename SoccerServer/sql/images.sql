CREATE TABLE IF NOT EXISTS `images` (
  `id` char(128) CHARACTER SET utf8 COLLATE utf8_bin NOT NULL,
  `mime_type` char(32) CHARACTER SET ascii NOT NULL,
  `image` blob NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
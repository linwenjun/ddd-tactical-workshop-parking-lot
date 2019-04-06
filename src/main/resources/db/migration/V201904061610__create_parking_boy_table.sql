CREATE TABLE `parking_service`.`parking_boy`  (
  `paring_boy_id` char(30) NOT NULL,
  `name` nvarchar(100) NULL,
  PRIMARY KEY (`paring_boy_id`)
);

CREATE TABLE `parking_service`.`parking_lot`  (
  `paring_lot_id` bigint(0) NOT NULL AUTO_INCREMENT,
  `paring_boy_id` char(30),
  `capacity` int(10),
  PRIMARY KEY (`paring_lot_id`)
);

CREATE TABLE `parking_service`.`license_plate`  (
  `number` nvarchar(100),
  `paring_lot_id` char(30),
  PRIMARY KEY (`number`)
);
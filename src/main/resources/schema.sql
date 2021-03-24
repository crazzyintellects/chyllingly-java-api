CREATE TABLE restaurant(
  restaurantid BIGINT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  location VARCHAR(2000) NOT NULL

);

CREATE TABLE menu (
  menuid BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  description VARCHAR(2000) NOT NULL,
  restaurant_id BIGINT NOT NULL
);
ALTER TABLE menu ADD FOREIGN KEY (restaurant_id) REFERENCES restaurant(restaurantid);


CREATE TABLE menusection (
  menuSectionId BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  description VARCHAR(2000) NOT NULL,
  menu_id BIGINT NOT NULL
);

ALTER TABLE menusection ADD FOREIGN KEY (menu_id) REFERENCES menu(menuid);

CREATE TABLE menuitem (
  menuItemId BIGINT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(100) NOT NULL,
  description VARCHAR(2000) NOT NULL,
  price NUMBER NOT NULL,
  isAvailable BOOLEAN NOT NULL,
  menu_section_id BIGINT NOT NULL
);

ALTER TABLE menuitem ADD FOREIGN KEY (menu_section_id) REFERENCES menusection(menuSectionId);


CREATE DATABASE IF NOT EXISTS DB_COURSES;

USE DB_COURSES;

CREATE TABLE CAT_USER_ROLES (
  nrole_id INT AUTO_INCREMENT PRIMARY KEY,
  crole_code VARCHAR(50) NOT NULL,
  crole_name VARCHAR(100) NOT NULL,
  bhabilited BOOLEAN DEFAULT TRUE,
  dcreated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  dupdated_at DATETIME NULL ON UPDATE CURRENT_TIMESTAMP,
  ddeleted_at DATETIME NULL,
  UNIQUE KEY uq_role_code (crole_code),
  UNIQUE KEY uq_role_name (crole_name)
) ENGINE=InnoDB;

CREATE TABLE CAT_COURSE_STATUS (
  ncourse_status_id INT AUTO_INCREMENT PRIMARY KEY,
  cstatus_code VARCHAR(50) NOT NULL,
  cstatus_name VARCHAR(100) NOT NULL,
  bhabilited BOOLEAN DEFAULT TRUE,
  dcreated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  dupdated_at DATETIME NULL ON UPDATE CURRENT_TIMESTAMP,
  ddeleted_at DATETIME NULL,
  UNIQUE KEY uq_course_status_code (cstatus_code),
  UNIQUE KEY uq_course_status_name (cstatus_name)
) ENGINE=InnoDB;

CREATE TABLE CAT_ENROLLMENT_STATUS (
  nenrollment_status_id INT AUTO_INCREMENT PRIMARY KEY,
  cstatus_code VARCHAR(50) NOT NULL,
  cstatus_name VARCHAR(100) NOT NULL,
  bhabilited BOOLEAN DEFAULT TRUE,
  dcreated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  dupdated_at DATETIME NULL ON UPDATE CURRENT_TIMESTAMP,
  ddeleted_at DATETIME NULL,
  UNIQUE KEY uq_enr_status_code (cstatus_code),
  UNIQUE KEY uq_enr_status_name (cstatus_name)
) ENGINE=InnoDB;

CREATE TABLE CAT_PAYMENT_METHOD (
  npayment_method_id INT AUTO_INCREMENT PRIMARY KEY,
  cmethod_code VARCHAR(50) NOT NULL,
  cmethod_name VARCHAR(100) NOT NULL,
  bhabilited BOOLEAN DEFAULT TRUE,
  dcreated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  dupdated_at DATETIME NULL ON UPDATE CURRENT_TIMESTAMP,
  ddeleted_at DATETIME NULL,
  UNIQUE KEY uq_pay_method_code (cmethod_code),
  UNIQUE KEY uq_pay_method_name (cmethod_name)
) ENGINE=InnoDB;

CREATE TABLE CAT_PAYMENT_STATUS (
  npayment_status_id INT AUTO_INCREMENT PRIMARY KEY,
  cstatus_code VARCHAR(50) NOT NULL,
  cstatus_name VARCHAR(100) NOT NULL,
  bhabilited BOOLEAN DEFAULT TRUE,
  dcreated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  dupdated_at DATETIME NULL ON UPDATE CURRENT_TIMESTAMP,
  ddeleted_at DATETIME NULL,
  UNIQUE KEY uq_pay_status_code (cstatus_code),
  UNIQUE KEY uq_pay_status_name (cstatus_name)
) ENGINE=InnoDB;

CREATE TABLE CAT_CART_STATUS (
  ncart_status_id INT AUTO_INCREMENT PRIMARY KEY,
  cstatus_code VARCHAR(50) NOT NULL,
  cstatus_name VARCHAR(100) NOT NULL,
  bhabilited BOOLEAN DEFAULT TRUE,
  dcreated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  dupdated_at DATETIME NULL ON UPDATE CURRENT_TIMESTAMP,
  ddeleted_at DATETIME NULL,
  UNIQUE KEY uq_cart_status_code (cstatus_code),
  UNIQUE KEY uq_cart_status_name (cstatus_name)
) ENGINE=InnoDB;

CREATE TABLE TBL_USERS (
  nuser_id INT AUTO_INCREMENT PRIMARY KEY,
  cname VARCHAR(150) NOT NULL,
  cemail VARCHAR(150) NOT NULL,
  cpassword_hash VARCHAR(255) NOT NULL,
  nrole_id INT NOT NULL,
  bhabilited BOOLEAN DEFAULT TRUE,
  dcreated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  dupdated_at DATETIME NULL ON UPDATE CURRENT_TIMESTAMP,
  ddeleted_at DATETIME NULL,
  UNIQUE KEY uq_users_email (cemail),
  KEY idx_users_role (nrole_id),
  CONSTRAINT fk_users_role FOREIGN KEY (nrole_id) REFERENCES CAT_USER_ROLES(nrole_id)
) ENGINE=InnoDB;

CREATE TABLE TBL_COURSES (
  ncourse_id INT AUTO_INCREMENT PRIMARY KEY,
  ctitle VARCHAR(200) NOT NULL,
  cdescription TEXT,
  ninstructor_id INT NOT NULL,
  ncourse_status_id INT NOT NULL,
  bhabilited BOOLEAN DEFAULT TRUE,
  dcreated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  dupdated_at DATETIME NULL ON UPDATE CURRENT_TIMESTAMP,
  ddeleted_at DATETIME NULL/*,
  KEY idx_courses_instructor (ninstructor_id),
  KEY idx_courses_status (ncourse_status_id)
  CONSTRAINT fk_course_instructor FOREIGN KEY (ninstructor_id) REFERENCES TBL_USERS(nuser_id),
  CONSTRAINT fk_course_status FOREIGN KEY (ncourse_status_id) REFERENCES CAT_COURSE_STATUS(ncourse_status_id)*/
) ENGINE=InnoDB;

CREATE TABLE TBL_MODULES (
  nmodule_id INT AUTO_INCREMENT PRIMARY KEY,
  ncourse_id INT NOT NULL,
  ctitle VARCHAR(150) NOT NULL,
  nsort_order INT,
  KEY idx_modules_course (ncourse_id),
  CONSTRAINT fk_module_course FOREIGN KEY (ncourse_id) REFERENCES TBL_COURSES(ncourse_id)
) ENGINE=InnoDB;

CREATE TABLE TBL_LESSONS (
  nlesson_id INT AUTO_INCREMENT PRIMARY KEY,
  nmodule_id INT NOT NULL,
  ctitle VARCHAR(150) NOT NULL,
  ccontent_url VARCHAR(500),
  nduration_min INT,
  nsort_order INT,
  KEY idx_lessons_module (nmodule_id),
  CONSTRAINT fk_lesson_module FOREIGN KEY (nmodule_id) REFERENCES TBL_MODULES(nmodule_id) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE TBL_ENROLLMENTS (
  nenrollment_id INT AUTO_INCREMENT PRIMARY KEY,
  nuser_id INT NOT NULL,
  ncourse_id INT NOT NULL,
  nenrollment_status_id INT NOT NULL,
  denrolled_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  bhabilited BOOLEAN DEFAULT TRUE,
  dcreated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  dupdated_at DATETIME NULL ON UPDATE CURRENT_TIMESTAMP,
  ddeleted_at DATETIME NULL,
  UNIQUE KEY uq_user_course (nuser_id, ncourse_id),
  KEY idx_enrollment_user (nuser_id),
  KEY idx_enrollment_course (ncourse_id),
  KEY idx_enrollment_status (nenrollment_status_id),
  CONSTRAINT fk_enr_user FOREIGN KEY (nuser_id) REFERENCES TBL_USERS(nuser_id),
  CONSTRAINT fk_enr_course FOREIGN KEY (ncourse_id) REFERENCES TBL_COURSES(ncourse_id),
  CONSTRAINT fk_enr_status FOREIGN KEY (nenrollment_status_id) REFERENCES CAT_ENROLLMENT_STATUS(nenrollment_status_id)
) ENGINE=InnoDB;

CREATE TABLE TBL_LESSON_PROGRESS (
  nprogress_id INT AUTO_INCREMENT PRIMARY KEY,
  nenrollment_id INT NOT NULL,
  nlesson_id INT NOT NULL,
  bcompleted BOOLEAN DEFAULT FALSE,
  dcompleted_at DATETIME,
  UNIQUE KEY uq_progress (nenrollment_id, nlesson_id),
  KEY idx_progress_enrollment (nenrollment_id),
  CONSTRAINT fk_prog_enr FOREIGN KEY (nenrollment_id) REFERENCES TBL_ENROLLMENTS(nenrollment_id),
  CONSTRAINT fk_prog_lesson FOREIGN KEY (nlesson_id) REFERENCES TBL_LESSONS(nlesson_id)
) ENGINE=InnoDB;

CREATE TABLE TBL_PAYMENTS (
  npayment_id INT AUTO_INCREMENT PRIMARY KEY,
  nenrollment_id INT NOT NULL,
  mamount DECIMAL(10,2) NOT NULL,
  npayment_method_id INT NOT NULL,
  npayment_status_id INT NOT NULL,
  dpayment_date DATETIME DEFAULT CURRENT_TIMESTAMP,
  bhabilited BOOLEAN DEFAULT TRUE,
  dcreated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  dupdated_at DATETIME NULL ON UPDATE CURRENT_TIMESTAMP,
  ddeleted_at DATETIME NULL,
  KEY idx_pay_enrollment (nenrollment_id),
  KEY idx_pay_method (npayment_method_id),
  KEY idx_pay_status (npayment_status_id),
  CONSTRAINT fk_pay_enr FOREIGN KEY (nenrollment_id) REFERENCES TBL_ENROLLMENTS(nenrollment_id),
  CONSTRAINT fk_pay_method FOREIGN KEY (npayment_method_id) REFERENCES CAT_PAYMENT_METHOD(npayment_method_id),
  CONSTRAINT fk_pay_status FOREIGN KEY (npayment_status_id) REFERENCES CAT_PAYMENT_STATUS(npayment_status_id)
) ENGINE=InnoDB;

CREATE TABLE TBL_CART (
  ncart_id INT AUTO_INCREMENT PRIMARY KEY,
  nuser_id INT NOT NULL,
  ncart_status_id INT NOT NULL,
  KEY idx_cart_user (nuser_id),
  KEY idx_cart_status (ncart_status_id),
  CONSTRAINT fk_cart_user FOREIGN KEY (nuser_id) REFERENCES TBL_USERS(nuser_id),
  CONSTRAINT fk_cart_status FOREIGN KEY (ncart_status_id) REFERENCES CAT_CART_STATUS(ncart_status_id)
) ENGINE=InnoDB;

CREATE TABLE TBL_CART_ITEMS (
  ncart_id INT NOT NULL,
  ncourse_id INT NOT NULL,
  mprice DECIMAL(10,2) NOT NULL,
  PRIMARY KEY (ncart_id, ncourse_id),
  CONSTRAINT fk_ci_cart FOREIGN KEY (ncart_id) REFERENCES TBL_CART(ncart_id) ON DELETE CASCADE,
  CONSTRAINT fk_ci_course FOREIGN KEY (ncourse_id) REFERENCES TBL_COURSES(ncourse_id)
) ENGINE=InnoDB;

CREATE TABLE TBL_REVIEWS (
  nreview_id INT AUTO_INCREMENT PRIMARY KEY,
  nuser_id INT NOT NULL,
  ncourse_id INT NOT NULL,
  nrating TINYINT NOT NULL,
  ccomment TEXT,
  bhabilited BOOLEAN DEFAULT TRUE,
  dcreated_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  dupdated_at DATETIME NULL ON UPDATE CURRENT_TIMESTAMP,
  ddeleted_at DATETIME NULL,
  UNIQUE KEY uq_review (nuser_id, ncourse_id),
  CONSTRAINT fk_rev_user FOREIGN KEY (nuser_id) REFERENCES TBL_USERS(nuser_id),
  CONSTRAINT fk_rev_course FOREIGN KEY (ncourse_id) REFERENCES TBL_COURSES(ncourse_id),
  CHECK (nrating BETWEEN 1 AND 5)
) ENGINE=InnoDB;

CREATE TABLE TBL_CERTIFICATES (
  ncertificate_id INT AUTO_INCREMENT PRIMARY KEY,
  nenrollment_id INT NOT NULL,
  cvalidation_code VARCHAR(64) NOT NULL,
  dissued_at DATETIME DEFAULT CURRENT_TIMESTAMP,
  UNIQUE KEY uq_cert_validation (cvalidation_code),
  CONSTRAINT fk_cert_enr FOREIGN KEY (nenrollment_id) REFERENCES TBL_ENROLLMENTS(nenrollment_id)
) ENGINE=InnoDB;

/*
-- CREATE TABLES
CREATE TABLE Client (
	ClientID INT NOT NULL AUTO_INCREMENT,
	ClientName VARCHAR(100) NOT NULL,
	CreateDate DATETIME NULL DEFAULT NOW(),
    PRIMARY KEY(ClientID)
);

CREATE TABLE ClientContact(
	ClientContactID INT NOT NULL AUTO_INCREMENT,
	ClientID INT NOT NULL,
	EntityTypeID INT NOT NULL,
    PRIMARY KEY(ClientContactID)
);

CREATE TABLE Address(
	AddressID INT NOT NULL AUTO_INCREMENT,
	ClientID INT NULL,
	PersonID INT NULL,
	EntityTypeID INT NOT NULL,
	AddressNumber VARCHAR(10) NULL,
	Street VARCHAR(100) NULL,
	Street02 VARCHAR(100) NULL,
	City VARCHAR(100) NULL,
	StateID INT NULL,
	CountryID INT NULL,
	DateCreate DATETIME NULL,
    PRIMARY KEY(AddressID)
);

CREATE TABLE Employee(
	EmployeeID int NOT NULL AUTO_INCREMENT,
	Email varchar(50) NULL,
	HireDate datetime NULL,
	TermDate datetime NULL,
	BirthDate datetime NULL,
	PersonID int NOT NULL,
    PRIMARY KEY(EmployeeID)
);

CREATE TABLE EmployeeProject(
	EmployeeProjectID int NOT NULL AUTO_INCREMENT,
	ProjectID int NOT NULL,
	EmployeeID int NOT NULL,
	EntityTypeID int NOT NULL,
	VehicleID int NULL,
	StartDate datetime NULL,
	EndDate datetime NULL,
	Notes varchar(8000) NULL,
    PRIMARY KEY(EmployeeProjectID)
);

CREATE TABLE Entity(
	EntityID int NOT NULL AUTO_INCREMENT,
	EntityName varchar(50) NULL,
    PRIMARY KEY(EntityID)
);

CREATE TABLE EntityType(
	EntityTypeID int NOT NULL AUTO_INCREMENT,
	EntityID int NULL,
	EntityTypeName varchar(50) NULL,
	CreateDate datetime NULL,
    PRIMARY KEY(EntityTypeID)
);

*/



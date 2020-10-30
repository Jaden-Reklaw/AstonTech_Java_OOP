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
    PRIMARY KEY(ClientContactID),
	FOREIGN KEY (ClientID) REFERENCES Client(ClientID),
	FOREIGN KEY (EntityTypeID) REFERENCES EntityType(EntityTypeID)
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
    PRIMARY KEY(AddressID),
    FOREIGN KEY (ClientID) REFERENCES Client(ClientID),
    FOREIGN KEY (PersonID) REFERENCES Person(PersonID),
    FOREIGN KEY (EntityTypeID) REFERENCES EntityType(EntityTypeID)
);

CREATE TABLE Employee(
	EmployeeID int NOT NULL AUTO_INCREMENT,
	Email varchar(50) NULL,
	HireDate datetime NULL,
	TermDate datetime NULL,
	BirthDate datetime NULL,
	PersonID int NOT NULL,
    PRIMARY KEY(EmployeeID),
	FOREIGN KEY (PersonID) REFERENCES Person(PersonID)
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
    PRIMARY KEY(EmployeeProjectID),
    FOREIGN KEY (ProjectID) REFERENCES Project(ProjectID),
    FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID),
    FOREIGN KEY (EntityTypeID) REFERENCES EntityType(EntityTypeID),
    FOREIGN KEY (VehicleID) REFERENCES Vehicle(VehicleID)
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

-- ADD FOREIGN KEY CONSTRAINT FOR EntityID
ALTER TABLE EntityType
ADD FOREIGN KEY (EntityID) REFERENCES Entity(EntityID);

CREATE TABLE Phone(
	PhoneID INT NOT NULL AUTO_INCREMENT,
	EntityTypeID INT NOT NULL,
	ClientID INT NULL,
	PersonID INT NULL,
	AreaCode INT NULL,
	PhoneNumber INT NULL,
    PRIMARY KEY(PhoneID),
    FOREIGN KEY (EntityTypeID) REFERENCES EntityType(EntityTypeID),
    FOREIGN KEY (ClientID) REFERENCES Client(ClientID),
    FOREIGN KEY (PersonID) REFERENCES Person(PersonID)
);

CREATE TABLE Project(
	ProjectID INT NOT NULL AUTO_INCREMENT,
	ClientID INT NOT NULL,
	EntityTypeID INT NOT NULL,
	Rate INT NULL,
	StartDate DATETIME NULL,
	EndDate DATETIME NULL,
	ProjectName VARCHAR(50) NULL,
    PRIMARY KEY(ProjectID)
);

-- ADD FOREIGN KEY CONSTRAINTS ON BOTH ClientID and EntityTypeID
ALTER TABLE Project
ADD FOREIGN KEY (ClientID) REFERENCES Client(ClientID);

ALTER TABLE Project
ADD FOREIGN KEY (EntityTypeID) REFERENCES EntityType(EntityTypeID);

CREATE TABLE ProjectStatus(
	ProjectStatusID	INT NOT NULL AUTO_INCREMENT,
	ProjectID INT NOT NULL,
	EntityTypeID INT NOT NULL,
	Notes VARCHAR(8000) NULL,
	PercentComplete INT NULL,
	StartDate DATETIME NULL,
	EndDate DATETIME NULL,
    PRIMARY KEY(ProjectStatusID),
    FOREIGN KEY (ProjectID) REFERENCES Project(ProjectID),
    FOREIGN KEY (EntityTypeID) REFERENCES EntityType(EntityTypeID)
);

CREATE TABLE Review(
	ReviewID INT NOT NULL AUTO_INCREMENT,
	ReviewName VARCHAR(100) NOT NULL,
	ReviewDate DATETIME NULL,
	EmployeeID INT NOT NUll,
    PRIMARY KEY(ReviewID),
    FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
);

CREATE TABLE ReviewData(
	ReviewDataID INT NOT NULL AUTO_INCREMENT,
	ReviewID INT NOT NULL,
	EntityTypeID INT NOT NULL,
	ReviewDataValue VARCHAR(8000) NOT NULL,
	CreateDate DATETIME NULL,
    PRIMARY KEY(ReviewDataID),
    FOREIGN KEY (ReviewID) REFERENCES Review(ReviewID),
    FOREIGN KEY (EntityTypeID) REFERENCES EntityType(EntityTypeID)
);

CREATE TABLE Training(
	TrainingID INT NOT NULL AUTO_INCREMENT,
	EmployeeID INT NOT NULL,
	TrainingName VARCHAR(500) NOT NULL,
	CreateDate DATETIME NULL,
    PRIMARY KEY(TrainingID),
    FOREIGN KEY (EmployeeID) REFERENCES Employee(EmployeeID)
);

CREATE TABLE TrainingData(
	TrainingDataID INT NOT NULL AUTO_INCREMENT,
	TrainingID INT NOT NULL,
	EntityTypeID INT NOT NULL,
	TrainingDataValue VARCHAR(8000) NOT NULL,
	CreateDate DATETIME NULL,
    PRIMARY KEY(TrainingDataID),
    FOREIGN KEY (TrainingID) REFERENCES Training(TrainingID),
	FOREIGN KEY (EntityTypeID) REFERENCES EntityType(EntityTypeID)
);

CREATE TABLE Vehicle(
	VehicleID INT NOT NULL AUTO_INCREMENT,
	Year INT NULL,
	LicensePlate VARCHAR(10) NULL,
	VIN VARCHAR(20) NULL,
	Color VARCHAR(10) NULL,
	IsPurchase BIT NULL,
	PurchasePrice INT NULL,
	PurhaseDate INT NULL,
	VehicleModelID INT NOT NULL,
    PRIMARY KEY(VehicleID)
);

-- ADD FOREIGN KEY CONSTRAINT ON VehicleModelID
ALTER TABLE Vehicle
ADD FOREIGN KEY (VehicleModelID) REFERENCES VehicleModel(VehicleModelID);

CREATE TABLE VehicleModel(
	VehicleModelID INT NOT NULL AUTO_INCREMENT,
	VehicleModelName VARCHAR(50) NOT NULL,
	VehicleMakeID INT NOT NULL,
    PRIMARY KEY(VehicleModelID)
);

-- ADD FOREIGN KEY CONSTRAINT ON VehicleMakeID
ALTER TABLE VehicleModel
ADD FOREIGN KEY (VehicleMakeID) REFERENCES VehicleMake(VehicleMakeID);

CREATE TABLE VehicleMake(
	VehicleMakeID INT NOT NULL AUTO_INCREMENT,
	VehicleMakeName VARCHAR(50) NOT NULL,
	CreateDate DATETIME null,
    PRIMARY KEY(VehicleMakeID)
);

CREATE TABLE LoyaltyCompany(
	CompanyName varchar(100) NULL,
	MemberNumber varchar(50) NULL,
	LoyaltyCompanyType  varchar(50) NULL
);

CREATE TABLE Person(
	PersonID int NOT NULL AUTO_INCREMENT,
	Title varchar(5) NULL,
	FirstName varchar(50) NULL,
	LastName varchar(50) NULL,
	DisplayFirstName varchar(50) NULL,
	IsDeleted bit NOT NULL,
	Gender char(1) NULL,
	CreateDate datetime NULL,
    PRIMARY KEY(PersonID)
);

CREATE TABLE VehicleStatus(
	VehicleStatusID INT NOT NULL AUTO_INCREMENT,
	VehicleID INT NOT NULL,
	EntityTypeID INT NOT NULL,
	Notes VARCHAR(8000) NULL,
	CreateDate DATETIME NULL,
    PRIMARY KEY(VehicleStatusID),
    FOREIGN KEY (VehicleID) REFERENCES Vehicle(VehicleID),
    FOREIGN KEY (EntityTypeID) REFERENCES EntityType(EntityTypeID)
);
*/


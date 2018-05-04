create table UserProfile_Purchase (
	uuid_ VARCHAR(75) null,
	screenname VARCHAR(75) not null,
	hash VARCHAR(75) not null,
	date_time DATE null,
	curr_from VARCHAR(75) null,
	value_from VARCHAR(75) null,
	curr_to VARCHAR(75) null,
	value_to VARCHAR(75) null,
	status VARCHAR(75) null,
	ewallet VARCHAR(75) null,
	primary key (screenname, hash)
);

create table UserProfile_UserProfile (
	uuid_ VARCHAR(75) null,
	userId VARCHAR(75) not null primary key,
	anversoId VARCHAR(255) null,
	reversoId VARCHAR(255) null,
	selfie VARCHAR(255) null,
	proofAddress VARCHAR(255) null,
	idType VARCHAR(10) null,
	idNumber VARCHAR(20) null,
	country VARCHAR(25) null,
	prov VARCHAR(75) null,
	city VARCHAR(25) null,
	street1 VARCHAR(30) null,
	street2 VARCHAR(30) null,
	homeNumber VARCHAR(10) null,
	postalCode VARCHAR(10) null,
	approved BOOLEAN
);
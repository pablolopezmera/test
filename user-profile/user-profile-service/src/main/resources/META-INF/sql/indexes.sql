create index IX_2DB161F3 on UserProfile_Purchase (screenname[$COLUMN_LENGTH:75$]);
create index IX_162FB06C on UserProfile_Purchase (uuid_[$COLUMN_LENGTH:75$]);

create index IX_F497057D on UserProfile_UserProfile (userId[$COLUMN_LENGTH:75$]);
create index IX_454E4811 on UserProfile_UserProfile (uuid_[$COLUMN_LENGTH:75$]);
drop table todo if exists;

create table toDo (
	id INT,
	title TEXT,
	isDone VARCHAR(50),
	creationTimeStamp DATE
);
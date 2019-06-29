
/*
Database -> Collections -> Documents

use celumdb - create and use this db
db - shows current database
show dbs - shows all databases
db.createCollection("myCollection")
show collections - shows all collections within the database
db.myCollection.insert({"name" : "Max"}) - creates collection if not existing - inserts document to collection
db.myCollection.drop() - drops collection

db.dropDatabase()

MONGO CREATES UNIQUE ID BY ITSELF IF NO ID GIVEN

use school
db.students.insert({
    "id" : "myUUID",
    "fistName" : "Max",
    "lastName" : "Mustermann",
    "email" : "max.mustermann@school.at"
    "phone" : "06123456789"
})

QUERY DOCUMENTS:

db.students.find() - returns all entries
db.students.findOne() - returns first entry

db.students.find({ - returns specific entry
    "id" : "myUUID"
})

select by e.g. age: age > 17 - gt = greater than /// lt = less than /// ne = not equals
db.students.find({
    "Age" : {$gt : "17"}
})

select by e.g. age: age >= 20
db.students.find({
    "Age" : {$gte : "20"}
})

FIND RESULTS USING "or"
db.sutdents.find({
    $or : [
        {"firstName" : "Mark"},
        {"Age" : "15"}
    ]
})

STUDENT WITH NAME MARK AND AGE EQUALS 15 OR 16
db.sutdents.find({
    "firstName" : "Mark",
    $or : [
        {"Age" : "15"},
        {"Age" : "16"}
    ]
})


UPDATE DOCUMENT (entry) by ID
db.students.update(
    {"_id"} : ObjectId(="5ha45asg8a8gas56ag5as6g5as6g56")},
    {$set : {LastName : "Doe"}}
)

UPDATE MULTIPLE DOCUMENTS
db.students.update(
    {"Age" : "16"},
    {$set : {"LastName" : "Doe"}},
    {multi : true}
)

INSERT OR UPDATE - searches for id: if found UPDATE - else: INSERT
db.students.save(
    { "_id" : ObjectId("5a4g84ag64e3gasge47g898asg"), "StudentNo" : "1", "FirstName" : "John", "LastName" : "Doe", "Age" : "14" }
)

REMOVE DOCUMENT - removes all doucments
db.students.remove()

REMOVE SPECIFIC DOCUMENT
db.students.remove({
    "_id" : ObjectId("54asg5asg84gae86g4a643fed")
})

REMOVE ALL STUDENTS WITH AGE 16 - limit to 1
db.students.remove(
{
    "Age" : "16"
}, 1
)

SELECT SPECIFIC FIELDS FROM A DOCUMENT
db.students.find(
{},
{"FirstName" : 1} // 1 means show, 0 means don't show; id will always show, unless "_id" : 0 is used
)

LIMIT RESULTS TO 3
db.students.find(
{},
{"StudentNo" : 1, "FirstName" : 1, "_id" : 0}
).limit(3)


SKIPPING ENTRIES - skipping first two entries
b.students.find(
{},
{"StudentNo" : 1, "FirstName" : 1, "_id" : 0}
).skip(2)


SORTING
b.students.find(
{},
{"StudentNo" : 1, "FirstName" : 1, "_id" : 0}
).sort({"FirstName" : 1}) ----- use -1 for reverse sort

INDEXES
db.students.ensureIndex({"student_id" : 1}) - creates index for value - fast search - only for unique values
db.students.dropIndex({"student_id" : 1})

AGGREGATION, e.g. count male and female students
db.students.aggregate(
[
    {
        $group : { _id : "$Gender", MyResult : {$sum : 1} } // operations: sum, min, max, ...
    }
]
)

FINDING MAX AGE per group (e.g. male 40, female 17)
db.students.aggregate(
[
    {
        $group : { _id : "$Gender", MaxAge : {$max : "$Age"} } // operations: sum, min, max, ...
    }
]
)




*/

CREATE TABLE student (
    id UUID NOT NULL PRIMARY KEY,
    fistname VARCHAR(20),
    lastname VARCHAR (20),
    email VARCHAR (30),
    phone VARCHAR (20)
)
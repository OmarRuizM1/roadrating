
### Dependencies:
- mongodb server
- Java 17
## Run APP
- mvn clean install
- mvn spring-boot:run
### OpenApi
- http://localhost:8080/swagger-ui/index.html
### //TODO 
- Use Docker to build mongodb directly




### Tipical Queries of MongoDB to get statistics:
by assessment

db.rateLicenseDoc.aggregate([
{$group : {_id:{license:"$license", assessment:"NEGATIVE"}, count:{$sum:1}}},
{$sort : {count:-1}}
])


db.rateLicenseDoc.aggregate([
{$group : {_id:{license:"$license", assessment:"POSITIVE"}, count:{$sum:1}}},
{$sort : {count:-1}}
])



by tag

db.rateLicenseDoc.aggregate([
{$match : { tags:"Amable"}},
{$group : {_id:{ license:"$license"},count:{$sum:1}}},
{$sort : {count:-1}},
])

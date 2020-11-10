// to convert strings to dates
// db.people.find().forEach(function(p) { 
    // p.birth_date=new Date(p.birth_date);
    // db.people.save(p); 
    // })
// printjson(db.people.find({birth_date:{$gte:new ISODate("2000-01-01T00:00:01Z")}},{_id:0, first_name:1, last_name:1, "location.city":1}).toArray())

printjson(db.people.aggregate({$project:{_id:0, first_name:1, last_name:1,
"location.city":{
	$cond:{
    if:{
      $gte:["$birth_date", new ISODate("2000-01-01T00:00:00Z")]
    },
    then:"$location.city",
    else:"not born in XXI century"
  }}

}}).toArray())
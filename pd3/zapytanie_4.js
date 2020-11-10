//convert weight to int (1 time)
// db.people.find().forEach( function (p) {
	// p.weight= parseInt(p.weight);
	// db.people.save(p);
	// }
// );
printjson(db.people.find({"weight":{$gte:68.0, $lt:71.5}}).toArray())
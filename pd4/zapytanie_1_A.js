printjson(db.people.aggregate([
{
	$group:{
		_id: "$sex",
		average_weight:{$avg: "$height"},
		average_height:{$avg: "$weight"}
	}
},
{
	$sort:{_id:1}
}
]).toArray());
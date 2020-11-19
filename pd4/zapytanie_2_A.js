printjson(db.people.aggregate([
{
	$unwind:"$credit"
},
{
	$group:{
		_id: "$credit.currency",
		balance_sum:{$sum:"$credit.balance"}
		}
},
{
	$sort:{_id:1}
}
]).toArray());
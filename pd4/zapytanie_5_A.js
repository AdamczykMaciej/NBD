printjson(db.people.aggregate([
{
	$match: {
		nationality:"Poland",
		sex:"Female"
	}
},
{
	$unwind:"$credit"
},
{
    $group: {
		_id: "$credit.currency",
		Avg_balance:{$avg:"$credit.balance"},
		Sum_balance:{$sum:"$credit.balance"}
	}
},
{
	$sort:{_id:1}
}
]).toArray())
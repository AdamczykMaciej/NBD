printjson(db.people.aggregate([
{
	$project: {
		nationality:1,
		BMI:{$divide:["$weight",{$pow:["$height",2]}]},
		
	}
},
{
    $group: {
		_id: "$nationality",
		Avg_BMI:{$avg:"$BMI"},
		Max_BMI:{$max:"$BMI"},
		Min_BMI:{$min:"$BMI"},
	}
},
{
	$sort:{_id:1}
}
]).toArray())
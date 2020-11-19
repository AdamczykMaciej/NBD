var r = function(key, values) {
	var result = {count:0, sum:0, min:1000, max:0};
	
	values.forEach((v)=>{
		if(v.min < result.min)
			result.min = v.min;
		if(v.max > result.max)
			result.max = v.max;
		result.sum += v.sum;
		result.count+=v.count;
	});
	
	return result;
};

var m = function() {
	var bmi = this.weight/(this.height*this.height);
    emit(this.nationality, {count:1, sum:bmi, min:bmi, max:bmi}) // setting values
};

var f = function(key, reducedVal){
	reducedVal.avg = reducedVal.sum / reducedVal.count;
    return reducedVal;
};

db.people.mapReduce(m,r, {
     out: "task_4_mr",
	 finalize:f
}
);

printjson(db.task_4_mr.find().toArray())
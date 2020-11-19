// VERY IMPORTANT: input values and output values in the reducer have to have the same names. Otherwise it won't work.

var r = function(key, values) {
    
	var result={weight:0,count:0, height:0};

	for (var idx = 0; idx < values.length; idx++) {
		if(values[idx]!=null){
			result.weight += values[idx].weight;
			result.height += values[idx].height;
			result.count += values[idx].count;
		}
	}
	return result;
};

var m = function() {
	var key = this.sex;
	var value = {count:1, weight:this.weight, height:this.height};
	emit(key, value);
};

var f = function(key, reducedVal){
    if(reducedVal.count!==0)
        reducedVal.weight_avg = reducedVal.weight/reducedVal.count;
		reducedVal.height_avg = reducedVal.height/reducedVal.count;
    return reducedVal;
};

db.people.mapReduce(m, r, {
     out: "task_1_mr",
	 finalize: f

})

printjson(db.task_1_mr.find().toArray());



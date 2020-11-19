var r = function(key, values) {
	var result = {count:0, sum:0};
	
	values.forEach((v)=>{
		result.sum += v.sum;
		result.count+=v.count;
	});
	
	return result;
};

var m = function() {
	if(this.sex==="Female" && this.nationality==="Poland"){
		this.credit.forEach((v)=>{
			emit(v.currency, {count:1, sum:v.balance});
		});
	}
};

var f = function(key, reducedVal){
	reducedVal.avg = reducedVal.sum / reducedVal.count;
    return reducedVal;
};

db.people.mapReduce(m,r, {
     out: "task_5_mr",
	 finalize:f
}
);

printjson(db.task_5_mr.find().toArray())
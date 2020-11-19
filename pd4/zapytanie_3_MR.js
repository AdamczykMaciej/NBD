var r = function(key, values) {
	// nothing needed, it will get distinct values by grouping
};

var m = function() {
    emit(this.job, 1)
};

db.people.mapReduce(m,r, {
     out: "task_3_mr"
});

printjson(db.task_3_mr.find().toArray())
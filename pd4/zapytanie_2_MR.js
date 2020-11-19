var r = function(key, values) {
    
	return Array.sum(values);
};

var m = function() {
	for(i = 0; i < this.credit.length; i++) {
        emit(this.credit[i].currency, parseFloat(this.credit[i].balance))
    }

};

db.people.mapReduce(m, r, {
     out: "task_2_mr"
});

printjson(db.task_2_mr.find().toArray())
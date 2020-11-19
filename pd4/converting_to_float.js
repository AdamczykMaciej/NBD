db.people.find().forEach( function (x) {
x.height = parseFloat(x.height);
x.weight = parseFloat(x.weight);
x.credit.forEach((y) => {y.balance = parseFloat(y.balance);});
db.people.save(x);
});
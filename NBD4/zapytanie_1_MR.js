printjson(db.nbd.mapReduce(
        function() {
            emit(this.sex, { weight: parseFloat(this.weight), height: parseFloat(this.height) }); 
        },
        function(k, v) { 
        var w = v.map(l => l.weight);
        var h = v.map(l => l.height);    
        var avg = arr => arr.reduce((i, j) => i + j) / arr.length;
            
        return {
            weight: avg(w),
            height: avg(h)}; 
        },
        {out : { inline: 1 }}
));
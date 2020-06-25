printjson(db.nbd.mapReduce(
        function() {
           emit(this.job, null);
        },
        function(k, v) {
            return '';
        },
        { out: { inline: 1 } }
));
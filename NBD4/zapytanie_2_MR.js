printjson(db.nbd.mapReduce(
        function() {
            this.credit.forEach(c => emit(c.currency, parseFloat(c.balance)));
        },
        function(k, v) {
            return v.reduce((i, j) => i + j);
        },
        {out: { inline: 1 }}
    )
);
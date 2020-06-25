printjson(db.nbd.aggregate( 
        { 
            $group: {
                _id: "$sex",
                "avg weight": { $avg: { $toDecimal: "$weight" } },
                "avg height": { $avg: { $toDecimal: "$height" } }
            }
        }).toArray()
);
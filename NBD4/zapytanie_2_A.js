printjson(db.nbd.aggregate([
        {
            $unwind: "$credit"
        },
        {
            $group: {
                _id: "$credit.currency",
                "balance sum": { $sum: { $toDouble: "$credit.balance" } }
            }}
    ]).toArray()
);
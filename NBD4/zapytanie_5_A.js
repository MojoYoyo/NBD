printjson(db.nbd.aggregate([
        {
            $match: { sex: "Female" }
        },
        {
            $match: { nationality: "Poland" }
        },
        {
            $unwind: "$credit"
        },
        {
            $group: {
                _id: "$credit.currency",
                "Avarage credit balance": { $avg: { $toDouble: "$credit.balance" } },
                "Total credit balance": { $sum: { $toDouble: "$credit.balance" } },
            }
        }
    ]).toArray()
);


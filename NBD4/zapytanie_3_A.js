printjson(db.nbd.aggregate([
        {
            $group: {
                _id: "$job",
            }
        }
    ])
.toArray());
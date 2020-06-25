printjson(db.nbd.aggregate([
    {
        $group:
        {
            _id: '$nationality',
            'minimum BMI':
            {
                $min : { $divide: [{ $toDouble: '$weight' }, { $pow: [{ $divide: [{ $toDouble: '$height' }, 100] }, 2 ] }]}
            },
            'maximum BMI':
            {
                $max: { $divide: [{ $toDouble: '$weight' }, { $pow: [ { $divide: [{ $toDouble: '$height' }, 100] }, 2 ] }]}
            },
            'average BMI':
            {
                $avg: {$divide: [{ $toDouble: '$weight' }, { $pow: [ { $divide: [{ $toDouble: '$height' }, 100] }, 2 ] }]}
            }
        }
}]).toArray());
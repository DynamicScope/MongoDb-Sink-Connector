package org.radarcns.serialization;

import org.apache.kafka.connect.errors.DataException;
import org.apache.kafka.connect.sink.SinkRecord;
import org.bson.BsonDocument;
import org.bson.BsonValue;
import org.bson.Document;

import java.util.Collection;
import java.util.Collections;
import java.util.UUID;

public class EggbunRecordConverter implements RecordConverter {

    @Override
    public Collection<String> supportedSchemaNames() {
        return Collections.singleton(null);
    }

    @Override
    public Document convert(SinkRecord record) throws DataException {
        Document document;

        Object value = record.value();
        if (value != null) {
            document = new Document("_id", UUID.randomUUID().toString());

            BsonValue bson = JavaBsonType.objectToBson(value);
            if (bson instanceof BsonDocument) {
                document.putAll((BsonDocument) bson);
            } else {
                document.put("value", bson);
            }
        } else {
            document = new Document();
        }

        return document;
    }
}

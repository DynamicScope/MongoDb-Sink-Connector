package org.radarcns.serialization;

import org.apache.kafka.connect.sink.SinkRecord;

public class EggbunRecordConverterFactory extends RecordConverterFactory {

    @Override
    public RecordConverter getRecordConverter(SinkRecord record) {
        return new EggbunRecordConverter();
    }
}

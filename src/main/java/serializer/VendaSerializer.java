package serializer;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import model.Venda;

public class VendaSerializer implements Serializer<Venda> {
    @Override
    public byte[] serialize(String topic, Venda venda) {
        //Transformando a venda criada em bytes, pois o kafka só trabalha com bytes
        try {
            return new ObjectMapper().writeValueAsBytes(venda);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
